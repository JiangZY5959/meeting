package com.caztc.mapper;

import java.util.List;

import com.caztc.domain.MeetingUserinfo;

/**
 * 参加会议人员
 * @author Administrator
 *
 */
public interface MeetingUserinfoMapper {

	/**
	 * 添加参加会议的人员信息
	 * @param meetinguserinfo 信息
	 * @return 翻译影响的行数
	 */
	public int addMeetingUserinfo(MeetingUserinfo meetinguserinfo);
	
	/**
	 * 根据条件查询参加会议人员信息
	 * @param meetinguserinfo 查询条件
	 * @return
	 */
	public List<MeetingUserinfo> getAllMeetingUserinfo(MeetingUserinfo meetinguserinfo);
}
