package com.caztc.mapper;

import java.util.List;

import com.caztc.domain.MeetingUserinfo;

/**
 * �μӻ�����Ա
 * @author Administrator
 *
 */
public interface MeetingUserinfoMapper {

	/**
	 * ��Ӳμӻ������Ա��Ϣ
	 * @param meetinguserinfo ��Ϣ
	 * @return ����Ӱ�������
	 */
	public int addMeetingUserinfo(MeetingUserinfo meetinguserinfo);
	
	/**
	 * ����������ѯ�μӻ�����Ա��Ϣ
	 * @param meetinguserinfo ��ѯ����
	 * @return
	 */
	public List<MeetingUserinfo> getAllMeetingUserinfo(MeetingUserinfo meetinguserinfo);
}
