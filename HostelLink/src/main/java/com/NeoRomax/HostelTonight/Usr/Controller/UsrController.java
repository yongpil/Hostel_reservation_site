package com.NeoRomax.HostelTonight.Usr.Controller;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Members Home Controller
 * @version 1.0
 * @author Yang Jin Seung 
 */

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.naming.directory.SearchResult;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.NeoRomax.HostelTonight.Usr.Dao.MembersDAO;
import com.NeoRomax.HostelTonight.Usr.Dao.SearchDAO;


/**
 * Handles requests for the application home page.
 */
@Controller
public class UsrController {
	
	private static final Logger logger = LoggerFactory.getLogger(UsrController.class);
	
	@Autowired
	private SqlSession sqlSession;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
/*	@RequestMapping(value = "/index.html", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}*/
	
	@RequestMapping("/login.html")
	public String login(Locale locale, Model model) {
		System.out.println("HomeController : login.html");
		return "redirect:index.html";
	}
	@RequestMapping("/loginForm.html")
	public String loginForm(Locale locale, Model model) {
		System.out.println("HomeController : loginForm.html");
		return "loginForm";
	}
	@RequestMapping("/joinForm.html")
	public String joinForm() {
		System.out.println("HomeController : joinForm.html");
		return "joinForm";
	}
	@RequestMapping("/join.html")
	public String join(HttpServletRequest request, Model model) {
		System.out.println("HomeController : join.html");
		MembersDAO dao = sqlSession.getMapper(MembersDAO.class);
		dao.joinDao
		(
				request.getParameter("id"), 
				request.getParameter("pwd"),
				request.getParameter("firstName"),
				request.getParameter("lastName"),
				request.getParameter("birth")
				);
		dao.joinAuthDao("ROLE_USER");
		return "redirect:index.html";
	}
	@RequestMapping(value="/autoComplete.html", method=RequestMethod.GET)
	public @ResponseBody ArrayList<SearchResult> autoComplete(@RequestParam("searchValue") String searchValue) throws Throwable{
		System.out.println("HomeController : autoComplete.html");
		Map<String, Object> jsonObject= new HashMap<String, Object>();
		ArrayList<SearchResult> searchResult = new ArrayList<SearchResult>();
		
		SearchDAO dao = sqlSession.getMapper(SearchDAO.class);
		searchResult.addAll(dao.autoCompleteDao(searchValue+'%'));
		/*System.out.println(searchResult);
		for(int i=0; i<searchResult.size(); i++)
		{
			jsonObject.put("data", searchResult.get(i));
			System.out.println(jsonObject.get("data"));
		}*/
		return searchResult;
	}
	
	@RequestMapping("/search.html")
	public String searchForm(){
		return "search";
	}
	
	@RequestMapping("/hostelAdmin.html")
	public String hostelAdmin(){
		return "hostel_admin_page";
	}
}
