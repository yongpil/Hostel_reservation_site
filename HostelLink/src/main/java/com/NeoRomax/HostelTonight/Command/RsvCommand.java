package com.NeoRomax.HostelTonight.Command;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.NeoRomax.HostelTonight.Dao.RsvDao;
import com.NeoRomax.HostelTonight.Dto.RsvAddDto;
import com.NeoRomax.HostelTonight.Dto.RsvDaysAddDto;
import com.NeoRomax.HostelTonight.Dto.RsvRoomAddDto;
import com.NeoRomax.HostelTonight.Dto.RsvSessionDto;

import util.Constant;



/**
 * <PRE>
 * 1. FileName  : RsvCommand.java
 * 2. Package  : com.NeoRomax.HostelTonight.Rsv.Command
 * 3. Comment  : ȣ���� ������ �̷�� ���� Ŭ����. sessionDto�� �ִ� ȣ���� ���� ������ ���� DB�� �����Ѵ�.
 * 4. �ۼ���   : "Yong Pil Moon"
 * 5. �ۼ���   : 2015. 11. 20. ���� 3:45:25
 * </PRE>
 */ 


public class RsvCommand implements HCommand {
	SqlSession sqlSession = null;
	
	public RsvCommand() {
		sqlSession = Constant.sqlSession;
	}
	
	@Override
	public void execute(Model model) { 
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		RsvSessionDto sessionDto = (RsvSessionDto) map.get("sessionDto");

		RsvAddDto rsvAddDto = new RsvAddDto(sessionDto.getHostelDto().getHostelNum(),
				sessionDto.getUserId(),sessionDto.getTotalRate());
		
		RsvDao rsvDao = sqlSession.getMapper(RsvDao.class);
		
		rsvDao.rsvAdd(rsvAddDto); //reservation_list ���� 
		
		RsvRoomAddDto rsvRoomAddDto;
		RsvDaysAddDto rsvDaysAddDto;
		
		for(int i=0;i<sessionDto.getRsvDatesList().size();i++) //ȣ������ ���� ����ŭ �ݺ��ϸ鼭
		{
					if(!sessionDto.getRsvRatesList().get(i).isEmpty())//����� ��¥�� �ִ� ������ ã����
					{
						int eachRoomPrice = 0;
						for(int j=0;j<sessionDto.getRsvRatesList().get(i).size();j++)//���� ���� ������ ��¥�� ����� ���ϰ�
						{
							eachRoomPrice = eachRoomPrice + Integer.valueOf(sessionDto.getRsvRatesList().get(i).get(j));
						}
						rsvRoomAddDto = new RsvRoomAddDto(rsvAddDto.getRsvNum(),sessionDto.getRoomList().get(i).getRoomsNum(),eachRoomPrice);
						rsvDao.rsvRoomsAdd(rsvRoomAddDto);//reservation_rooms ���� �Ѵ�.
						
						String tempDate;
						for(int j=0;j<sessionDto.getRsvDatesList().get(i).size();j++)
						{
							tempDate = sessionDto.getRsvDatesList().get(i).get(j);
							SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
							Date parsed = null;
							try {
								parsed = transFormat.parse(tempDate);
							} catch (ParseException e) {
								e.printStackTrace();
							}
							java.sql.Date date = new java.sql.Date(parsed.getTime());

							rsvDaysAddDto = new RsvDaysAddDto(date,rsvRoomAddDto.getRsvRoomsNum(),sessionDto.getHostelDto().getHostelCity());
							rsvDao.rsvDaysAdd(rsvDaysAddDto);//reservation_days ����
							rsvDao.rsvAbleUpdate(sessionDto.getHostelDto().getHostelNum(),sessionDto.getRoomList().get(i).getRoomsNum(),date);
						}
					}
		}
		
		model.addAttribute("rsvAddDto",rsvAddDto);
	}

}
