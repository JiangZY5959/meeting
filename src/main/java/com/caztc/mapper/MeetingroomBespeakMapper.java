package com.caztc.mapper;

import java.util.Date;
import java.util.List;

import com.caztc.domain.MeetingroomBespeak;

/**
 * 预约数据库访问接口
 * @author Administrator
 *
 */
public interface MeetingroomBespeakMapper {
	
	/**
	 * 添加预约信息
	 * @param bespeak 预约信息
	 * @return 返回影响的行数
	 */
	public  int addBespeak(MeetingroomBespeak bespeak );

	boolean delBespeak(String bespeakId);
	
	/**
	 * 根据条件查询预约信息
	 * @param bespeak 查询条件
	 * @return 返回多条记录
	 */
	public List<MeetingroomBespeak> getAllMeetingroomBespeak(MeetingroomBespeak bespeak);


	/**
	 * 根据编号查询预约会议室信息
	 * @param bespeakId 预约编号
	 * @return 返回预约的信息
	 */
	public MeetingroomBespeak getMeetingroomBespeak(String bespeakId);

	public MeetingroomBespeak findById(String bespeakId);
	
	
	/**
	 * 修改预约信息
	 * @param bespeak 预约信息
	 * @return
	 */
	public  int updateBespeak(MeetingroomBespeak bespeak);

	/**
	 * 根据 起始时间、结束时间、会议室 id 查询预约会议室信息
	 * @param startTime 预约编号
	 * @param endTime 结束时间
	 * @param roomId 会议室 id
	 * @return 返回预约的信息
	 */
	List<MeetingroomBespeak> findAllByStartTimeAfterAndEndTimeBeforeAndRoomId(Date startTime,
																			  Date endTime, Integer roomId);

}
