package com.NeoRomax.HostelTonight.HostelList.Command;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.NeoRomax.HostelTonight.HostelList.Dao.HostelDao;
import com.NeoRomax.HostelTonight.HostelList.Dao.ImgDao;
import com.NeoRomax.HostelTonight.HostelList.Dto.ImgDto;
import com.NeoRomax.HostelTonight.HostelList.Dto.HostelsListDto;
import com.NeoRomax.HostelTonight.util.Constant;



/**
 * <PRE>
 * 1. FileName  : HostelListAddCommand.java
 * 2. Package  : com.NeoRomax.HostelTonight.HostelList.Command
 * 3. Comment  : 
 * 4. �ۼ���   : "Yong Pil Moon"
 * 5. �ۼ���   : 2015. 11. 20. ���� 3:33:13
 * </PRE>
 */ 


public class HostelListAddCommand implements HostelListCommand {
	SqlSession sqlSession = null;
	
	public HostelListAddCommand() {
		sqlSession = Constant.sqlSession;
	}
	
	@Override
	public void execute(Model model) {
		HostelDao hDao = sqlSession.getMapper(HostelDao.class);
		ImgDao hImgDao = sqlSession.getMapper(ImgDao.class);
		
		Map<String, Object> map = model.asMap();
		MultipartHttpServletRequest mRequest = (MultipartHttpServletRequest) map.get("mRequest");
		
  		/*ȣ���� ���� ����*/
  		hDao.addHostel(mRequest.getParameter("hostelsName"),mRequest.getParameter("hostelsNation"),mRequest.getParameter("hostelsCity"),
  				mRequest.getParameter("hostelsAddr"),mRequest.getParameter("hostelsInfo"),mRequest.getParameter("hostelsPhone"),
  				mRequest.getParameter("hostelsEmail"));
  		
		/*ȣ���� ���� ����*/		
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
