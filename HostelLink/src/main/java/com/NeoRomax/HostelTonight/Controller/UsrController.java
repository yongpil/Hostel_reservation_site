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
* 1. ������Ʈ�� : HostelTonight
* 2. ��Ű����(�Ǵ� ���丮 ���) : com.NeoRomax.HostelTonight.Controller
* 3. ���ϸ� : UsrController.java
* 4. �ۼ��� : 2016. 2. 1. ���� 2:00:23
* 5. �ۼ��� : Yang Jin Seung 
* 6. ���� : ����� ���� ����� ���� ��Ű�� ��Ʈ�ѷ�
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
	

	@RequestMapping("/loginForm")//�α����� ���� ������
	public String loginForm(Locale locale, Model model) {
		System.out.println("HomeController : loginForm.html");
		return "loginForm";
	}
	@RequestMapping("/joinForm")//ȸ������ ������
	public String joinForm() {
		System.out.println("HomeController : joinForm.html");
		return "joinForm";
	}
	@RequestMapping("/join")//ȸ������ ���
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
	
	@RequestMapping("/hostelAdmin") //ȣ���� ������ ������
	public String hostelAdmin(Model model){
		System.out.println("hostelAdmin");
		
		command = new HostelAdminCommand();
		command.execute(model);
		
		return "/Hostels/hostel_admin_page";
	}
	
	@RequestMapping("/lctSearch") //������ ������ ���� ������ ������ ����� ���� ���, ajax����� ���� json�������� location_rsv_history ���̺�� ���� �����͸� �����´�.
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
