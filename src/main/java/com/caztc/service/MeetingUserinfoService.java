package com.caztc.service;

import java.util.List;

import com.caztc.domain.MeetingUserinfo;

/**
 * �μӻ�����Ա��ϵ�� ҵ���߼��ӿ�
 * @author Administrator
 *
 */
public interface MeetingUserinfoService {

	/**
	 * ���ݵ��۲�ѯ�μӻ�����Ա��Ϣ
	 * @param meetinguserinfo ��ѯ����
	 * @return
	 */
	public List<MeetingUserinfo> getAllMeetingUserinfo(MeetingUserinfo meetinguserinfo);
}
