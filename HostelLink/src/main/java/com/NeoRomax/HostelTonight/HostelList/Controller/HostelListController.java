package com.NeoRomax.HostelTonight.HostelList.Controller;



import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.NeoRomax.HostelTonight.HostelList.Command.HostelListAddCommand;
import com.NeoRomax.HostelTonight.HostelList.Command.HostelListCommand;
import com.NeoRomax.HostelTonight.HostelList.Command.HostelListDetailCommand;
import com.NeoRomax.HostelTonight.HostelList.Command.HostelListViewCommand;
import com.NeoRomax.HostelTonight.Rsv.Command.RsvConfirmCommand;
import com.NeoRomax.HostelTonight.Rsv.Command.RsvViewCommand;
import com.NeoRomax.HostelTonight.util.Constant;

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
public class HostelListController {

	HostelListCommand command = null;
	public SqlSession sqlSession;


	@Autowired
	public void setSqlSession(SqlSession sqlSession){
		this.sqlSession = sqlSession;
		Constant.sqlSession = this.sqlSession;
	}
	
	@RequestMapping("/search")
	public String search(Model model) {
		System.out.println("test()");
		return "search";
	}
	
	@RequestMapping("/login")
	public String login( Model model) {
		System.out.println("login()");
		
		return "/login/login";
	}
	
	@RequestMapping(value="/list", method={RequestMethod.POST,RequestMethod.GET})
	public String list(HttpServletRequest request,Model model) {
		System.out.println("list()");
		model.addAttribute("request",request);
		System.out.println("dayfrom:" + request.getParameter("dayfrom"));
		command = new HostelListViewCommand();
		command.execute(model);
		System.out.println(request.getRealPath("/"));
		return "/Hostels/hostel_list";	
	}
	
	@RequestMapping("/addHostel_view")
	public String addHostel_view(Model model) {
		System.out.println("addHostel_view()");
		return "/Hostels/hostel_add_view";
	}
	
	@RequestMapping("/addHostel")
	public String addHostel(MultipartHttpServletRequest mRequest, Model model) {
		System.out.println("addHostel()");
		model.addAttribute("mRequest", mRequest);
		command = new HostelListAddCommand();
		command.execute(model);
		return "redirect:list";
	}
	
	@RequestMapping("/hostel_detail")
	public String hostel_detail(HttpServletRequest request, Model model) {
		System.out.println("hostel_detail()");
		model.addAttribute("request",request);
		
		command = new HostelListDetailCommand();
		command.execute(model);
		return "/Hostels/hostel_detail";
	}
	
	@RequestMapping("/rsvView")
	public String rsvView(HttpServletRequest request, Model model) {
		System.out.println("rsvView()");
		model.addAttribute("request",request);
		
		command = new RsvViewCommand();
		command.execute(model);
		return "/Hostels/hostel_rsv_view";
	}
	
	@RequestMapping("/rsvConfirm")
	public String rsvConfirm(HttpServletRequest request, Model model) {
		System.out.println("rsvConfirm()");
		model.addAttribute("request",request);
		
		command = new RsvConfirmCommand();
		command.execute(model);
		return "/Hostels/hostel_rsv_confirm";
	}
}
