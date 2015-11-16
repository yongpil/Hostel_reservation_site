package com.spring.HostelLink.controller;



import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.spring.HostelLink.command.HCommand;
import com.spring.HostelLink.command.HDetailCommand;
import com.spring.HostelLink.command.HListCommand;
import com.spring.HostelLink.command.HaddCommand;
import com.spring.HostelLink.rsv.command.HRsvConfirmCommand;
import com.spring.HostelLink.rsv.command.HRsvViewCommand;
import com.spring.HostelLink.util.Constant;

@Controller
public class HController {

	HCommand command = null;
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
		command = new HListCommand();
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
		command = new HaddCommand();
		command.execute(model);
		return "redirect:list";
	}
	
	@RequestMapping("/hostel_detail")
	public String hostel_detail(HttpServletRequest request, Model model) {
		System.out.println("hostel_detail()");
		model.addAttribute("request",request);
		
		command = new HDetailCommand();
		command.execute(model);
		return "/Hostels/hostel_detail";
	}
	
	@RequestMapping("/rsvView")
	public String rsvView(HttpServletRequest request, Model model) {
		System.out.println("rsvView()");
		model.addAttribute("request",request);
		
		command = new HRsvViewCommand();
		command.execute(model);
		return "/Hostels/hostel_rsv_view";
	}
	
	@RequestMapping("/rsvConfirm")
	public String rsvConfirm(HttpServletRequest request, Model model) {
		System.out.println("rsvConfirm()");
		model.addAttribute("request",request);
		
		command = new HRsvConfirmCommand();
		command.execute(model);
		return "/Hostels/hostel_rsv_confirm";
	}
}
