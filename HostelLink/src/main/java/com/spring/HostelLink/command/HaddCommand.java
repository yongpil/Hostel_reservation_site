package com.spring.HostelLink.command;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.spring.HostelLink.dao.HDao;
import com.spring.HostelLink.dao.HImgDao;
import com.spring.HostelLink.dto.HostelImgDto;
import com.spring.HostelLink.dto.HostelsListDto;
import com.spring.HostelLink.util.Constant;

public class HaddCommand implements HCommand {
	SqlSession sqlSession = null;
	
	public HaddCommand() {
		sqlSession = Constant.sqlSession;
	}
	@Override
	public void execute(Model model) {
		HDao hDao = sqlSession.getMapper(HDao.class);
		HImgDao hImgDao = sqlSession.getMapper(HImgDao.class);
		
		Map<String, Object> map = model.asMap();
		MultipartHttpServletRequest mRequest = (MultipartHttpServletRequest) map.get("mRequest");
		
  		/*호스텔 정보 저장*/
  		hDao.addHostel(mRequest.getParameter("HOSTELS_NAME"),mRequest.getParameter("HOSTELS_NATION"),mRequest.getParameter("HOSTELS_CITY"),
  				mRequest.getParameter("HOSTELS_ADDR"),mRequest.getParameter("HOSTELS_INFO"),mRequest.getParameter("HOSTELS_PHONE"),
  				mRequest.getParameter("HOSTELS_EMAIL"));
  		
		/*호스텔 사진 저장*/		
   		int imgcount=0;
   		imgcount = Integer.valueOf((mRequest.getParameter("imgcount")));
   		
		String realFolder="";
   		String saveFolder="HostelsUpload/";
   		realFolder=mRequest.getRealPath("/") + saveFolder;
   		
  		
		int hstNum = hDao.getHstNumfromEmail(mRequest.getParameter("HOSTELS_EMAIL"));
		
  		for(int i=0;i<imgcount;i++)
   		{
   			CommonsMultipartFile mFile = (CommonsMultipartFile)mRequest.getFile("img"+(i+1));
   			String imgName = mFile.getOriginalFilename();
   			String newImgName = System.currentTimeMillis() + "_" + imgName ;
   			String path =realFolder+newImgName;
   			
   	   		try {
   				mFile.transferTo(new File(path));
   			} catch (IllegalStateException e) {
   				e.printStackTrace();
   			} catch (IOException e) {
   				e.printStackTrace();
   			}
   	   		
   	   		hImgDao.addHImg(hstNum, newImgName);
   	  		System.out.println(path);
   		}

  		

  	


	}

}
