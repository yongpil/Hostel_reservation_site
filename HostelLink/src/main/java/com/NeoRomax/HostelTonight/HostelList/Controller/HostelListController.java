package com.NeoRomax.HostelTonight.HostelList.Controller;



import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.hamcrest.core.IsNull;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.NeoRomax.HostelTonight.HostelList.Command.HostelListAddCommand;
import com.NeoRomax.HostelTonight.HostelList.Command.HCommand;
import com.NeoRomax.HostelTonight.HostelList.Command.HostelListDetailCommand;
import com.NeoRomax.HostelTonight.HostelList.Command.HostelListViewCommand;
import com.NeoRomax.HostelTonight.Rsv.Command.RsvCommand;
import com.NeoRomax.HostelTonight.Rsv.Command.RsvConfirmViewCommand;
import com.NeoRomax.HostelTonight.Rsv.Command.RsvViewCommand;
import com.NeoRomax.HostelTonight.Rsv.Dto.RsvAddDto;
import com.NeoRomax.HostelTonight.Rsv.Dto.RsvSessionDto;
import com.NeoRomax.HostelTonight.util.Constant;

import ch.qos.logback.classic.Logger;

/**
 * <PRE>
 * 1. FileName  : HostelListController.java
 * 2. Package  : com.NeoRomax.HostelTonight.HostelList.Controller
 * 3. Comment  : 
 * 4. 작성자   : "Yong Pil Moon"
 * 5. 작성일   : 2015. 11. 20. 오후 3:44:40
 * </PRE>
 */ 


@Controller
@SessionAttributes("sessionDto")
public class HostelListController {
	private static org.slf4j.Logger logger = LoggerFactory.getLogger(HostelListController.class);

    
	HCommand command = null;
	public SqlSession sqlSession;


	@Autowired
	public void setSqlSession(SqlSession sqlSession){
		this.sqlSession = sqlSession;
		Constant.sqlSession = this.sqlSession;
	}
	
	@RequestMapping(value="/index.html", method={RequestMethod.POST,RequestMethod.GET})
	public String list(@RequestParam(value="lctSearch", required=false, defaultValue="seoul") String lctSearch,
			@RequestParam(value="dayFrom", required=false, defaultValue="") String dayFrom,@RequestParam(value="dayTo", required=false, defaultValue="") String dayTo,Model model) {
		
		logger.info("index()");
		logger.info(lctSearch);
		if(dayFrom.equals("") && dayTo.equals(""))//만약 사용자에 의해 날짜가 입력되지 않으면 현재 날짜를 default로 넣어준다.
		{
			Date defaultDayFrom = new Date();
			SimpleDateFormat dayFormat = new SimpleDateFormat("yyyy-MM-dd");
			dayFrom = dayFormat.format(defaultDayFrom);
			Calendar cal = Calendar.getInstance(); //Calendar를 이용하여 3일 후 날짜 구하기
			cal.setTime ( defaultDayFrom );
			cal.add(Calendar.DATE, 3);
			dayTo = dayFormat.format(cal.getTime());
		}
		logger.info(dayFrom);
		logger.info(dayTo);
		model.addAttribute("lctSearch",lctSearch);
		model.addAttribute("dayFrom",dayFrom);
		model.addAttribute("dayTo",dayTo);
		command = new HostelListViewCommand();
		command.execute(model);
		return "/Hostels/hostel_index";	
	}
	
	@RequestMapping("/addHostel_view.html")
	public String addHostel_view(Model model) {
		logger.info("addHostel_view()");
		return "/Hostels/hostel_add_view";
	}
	
	@RequestMapping("/addHostel.html")
	public String addHostel(MultipartHttpServletRequest mRequest, Model model) {
		System.out.println("addHostel()");
		model.addAttribute("mRequest", mRequest);
		command = new HostelListAddCommand();
		command.execute(model);
		return "redirect:index.html";
	}
	
	@RequestMapping("/hostel_detail.html")
	public String hostel_detail(HttpServletRequest request, Model model) {
		System.out.println("hostel_detail()");
		model.addAttribute("request",request);
		
		command = new HostelListDetailCommand();
		command.execute(model);
		return "/Hostels/hostel_detail";
	}
	
	@RequestMapping("/rsvView.html")
	public String rsvView(HttpServletRequest request, Model model) {
		System.out.println("rsvView()");
		model.addAttribute("request",request);
		
		command = new RsvViewCommand();
		command.execute(model);
		System.out.println("rsvView() finished");
		return "/Hostels/hostel_rsv_view";
	}
	
	@RequestMapping("/rsvConfirm.html") 
	public String rsvConfirm(RedirectAttributes redirectAttributes, @ModelAttribute RsvSessionDto sessionDto, SessionStatus sessionStatus, HttpServletRequest request, Model model) {
		System.out.println("rsvConfirm()");
		model.addAttribute("request",request);
			command = new RsvCommand();
			command.execute(model);
			Map<String, Object> map = model.asMap();
			RsvAddDto rsvAddDto = (RsvAddDto) map.get("rsvAddDto");
			redirectAttributes.addAttribute("rsvNum",rsvAddDto.getRsvNum());
			return "redirect:rsvConfirmView.html";
	}
	
	@RequestMapping("/rsvConfirmView.html") //새로고침시 중복 예약을 방지하기 위해 redirect 시킨 후 db에서 예약된 내용을 다시 가져 온다.
	public String rsvConfirmView(@RequestParam("rsvNum") int rsvNum, @ModelAttribute RsvSessionDto sessionDto, SessionStatus sessionStatus, Model model) {
		System.out.println("rsvConfirmView()");
		model.addAttribute("rsvNum",rsvNum);
		
		command = new RsvConfirmViewCommand();
		command.execute(model);
		
		sessionStatus.setComplete();//세션 파기
			
			return "/Hostels/hostel_rsv_confirm";
	}
}
