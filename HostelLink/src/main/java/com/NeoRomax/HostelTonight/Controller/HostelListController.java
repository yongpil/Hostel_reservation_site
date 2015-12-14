package com.NeoRomax.HostelTonight.Controller;



import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.NeoRomax.HostelTonight.Command.HCommand;
import com.NeoRomax.HostelTonight.Command.HostelListAddCommand;
import com.NeoRomax.HostelTonight.Command.HostelListDetailCommand;
import com.NeoRomax.HostelTonight.Command.HostelListViewCommand;
import com.NeoRomax.HostelTonight.Command.RsvCommand;
import com.NeoRomax.HostelTonight.Command.RsvConfirmViewCommand;
import com.NeoRomax.HostelTonight.Command.RsvViewCommand;
import com.NeoRomax.HostelTonight.Dto.RsvAddDto;
import com.NeoRomax.HostelTonight.Dto.RsvSessionDto;
import com.NeoRomax.HostelTonight.Service.HostelService;

import util.Constant;

/**
 * <PRE>
 * 1. FileName  : HostelListController.java
 * 2. Package  : com.NeoRomax.HostelTonight.HostelList.Controller
 * 3. Comment  : 
 * 4. �ۼ���   : "Yong Pil Moon"
 * 5. �ۼ���   : 2015. 11. 20. ���� 3:44:40
 * </PRE>
 */ 


@Controller
@SessionAttributes("sessionDto")
public class HostelListController {
	private static org.slf4j.Logger logger = LoggerFactory.getLogger(HostelListController.class);

	@Resource(name="hostelService")
	private HostelService hostelService;
    
	
	HCommand command = null;
	public SqlSession sqlSession;


	@Autowired
	public void setSqlSession(SqlSession sqlSession){
		this.sqlSession = sqlSession;
		Constant.sqlSession = this.sqlSession;
	}

	
	@RequestMapping(value="/review.html")
	public ModelAndView review(@RequestParam("hstNum") int hstNum) throws Exception{
		ModelAndView mv = new ModelAndView("/Hostels/hostel_review");
		List<Map<String,Object>> reviewList = hostelService.selectReviewList(hstNum);
		mv.addObject("reviewList",reviewList);
		return mv;
	}
	
	@RequestMapping(value="/index.html", method={RequestMethod.POST,RequestMethod.GET})
	public String list(@RequestParam(value="lctSearch", required=false, defaultValue="seoul") String lctSearch,
			@RequestParam(value="dayFrom", required=false, defaultValue="") String dayFrom,@RequestParam(value="dayTo", required=false, defaultValue="") String dayTo,Model model) {
		
		logger.info("index()");
		logger.info(lctSearch);
		if(dayFrom.equals("") && dayTo.equals(""))//���� ����ڿ� ���� ��¥�� �Էµ��� ������ ���� ��¥�� default�� �־��ش�.
		{
			Date defaultDayFrom = new Date();
			SimpleDateFormat dayFormat = new SimpleDateFormat("yyyy-MM-dd");
			dayFrom = dayFormat.format(defaultDayFrom);
			Calendar cal = Calendar.getInstance(); //Calendar�� �̿��Ͽ� 3�� �� ��¥ ���ϱ�
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
	
	@RequestMapping("/rsvConfirmView.html") //���ΰ�ħ�� �ߺ� ������ �����ϱ� ���� redirect ��Ų �� db���� ����� ������ �ٽ� ���� �´�.
	public String rsvConfirmView(@RequestParam("rsvNum") int rsvNum, @ModelAttribute RsvSessionDto sessionDto, SessionStatus sessionStatus, Model model) {
		System.out.println("rsvConfirmView()");
		model.addAttribute("rsvNum",rsvNum);
		
		command = new RsvConfirmViewCommand();
		command.execute(model);
		
		sessionStatus.setComplete();//���� �ı�
			
			return "/Hostels/hostel_rsv_confirm";
	}
}
