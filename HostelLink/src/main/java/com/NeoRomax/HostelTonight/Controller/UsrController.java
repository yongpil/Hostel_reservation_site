package com.NeoRomax.HostelTonight.Controller;

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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.NeoRomax.HostelTonight.Command.HCommand;
import com.NeoRomax.HostelTonight.Command.HostelAdminCommand;
import com.NeoRomax.HostelTonight.Command.HostelListViewCommand;
import com.NeoRomax.HostelTonight.Dao.AdminDao;
import com.NeoRomax.HostelTonight.Dto.LocationRsvHistoryDto;
import com.NeoRomax.HostelTonight.Dto.SchLocationDto;
import com.NeoRomax.HostelTonight.Usr.Dao.MembersDAO;
import com.NeoRomax.HostelTonight.Usr.Dao.SearchDAO;
import com.NeoRomax.HostelTonight.Usr.Dto.membersDTO;



/**
* <pre>
* 1. 프로젝트명 : HostelTonight
* 2. 패키지명(또는 디렉토리 경로) : com.NeoRomax.HostelTonight.Controller
* 3. 파일명 : UsrController.java
* 4. 작성일 : 2016. 2. 1. 오후 2:00:23
* 5. 작성자 : Yang Jin Seung 
* 6. 설명 : 사용자 관련 기능을 수행 시키는 컨트롤러
* </pre>
*/
@Controller
public class UsrController {
	
	private static final Logger logger = LoggerFactory.getLogger(UsrController.class);
	
	@Autowired
	private SqlSession sqlSession;
	
	HCommand command = null;
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
	

	@RequestMapping("/loginForm")//로그인을 위한 페이지
	public String loginForm(Locale locale, Model model) {
		System.out.println("HomeController : loginForm.html");
		return "loginForm";
	}
	@RequestMapping("/joinForm")//회원가입 페이지
	public String joinForm() {
		System.out.println("HomeController : joinForm.html");
		return "joinForm";
	}
	@RequestMapping("/join")//회원가입 기능
	public String join(HttpServletRequest request, Model model) {
		System.out.println("HomeController : join.html");
		MembersDAO dao = sqlSession.getMapper(MembersDAO.class);
		membersDTO memberDto = new membersDTO(
				request.getParameter("id"),
				request.getParameter("pwd"),
				request.getParameter("confirmPwd"),
				request.getParameter("firstName"),
				request.getParameter("lastName")
				);
		dao.joinDao(memberDto);
		dao.joinAuthDao(memberDto.getUsrNum(),"ROLE_USER");
		return "redirect:index";
	}
	@RequestMapping(value="/autoComplete", method=RequestMethod.GET)
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
	
	@RequestMapping("/search")
	public String searchForm(){
		return "search";
	}
	
	@RequestMapping("/hostelAdmin") //호스텔 관리자 페이지
	public String hostelAdmin(Model model){
		System.out.println("hostelAdmin");
		
		command = new HostelAdminCommand();
		command.execute(model);
		
		return "/Hostels/hostel_admin_page";
	}
	
	@RequestMapping("/lctSearch") //관리자 페이지 에서 지역별 성수기 기능을 위해 사용, ajax통신을 위해 json형식으로 location_rsv_history 테이블로 부터 데이터를 가져온다.
	@ResponseBody
	public LocationRsvHistoryDto test(@RequestParam String location){
		System.out.println("LocationRsvHistoryDto");
		System.out.println(location);
		LocationRsvHistoryDto lctRsvHDto;
		AdminDao aDao = sqlSession.getMapper(AdminDao.class);
		lctRsvHDto = aDao.getLocationRsvHistoryDto(location);
		return lctRsvHDto;
	}
}
