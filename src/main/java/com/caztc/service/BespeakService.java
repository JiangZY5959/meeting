package com.caztc.service;

import java.util.Date;
import java.util.List;

import com.caztc.domain.MeetingroomBespeak;

/**
 * ԤԼҵ���߼��ӿ�
 * @author Administrator
 *
 */
public interface BespeakService {

	public boolean delMeetingRoomBespeak(String bespeakId);

	public boolean sendMail(String bespeakId);

	/**
	 * ���ԤԼ��Ϣ
	 * @param meetbe ԤԼ��Ϣ
	 * @param userIds �μӻ�����Ա
	 * @return true �ɹ� falseΪʧ��
	 */
	public boolean addMeetingroomBespeak(MeetingroomBespeak  meetbe,String userIds);
	
	/**
	 * ��ѯԤԼ��������Ϣ
	 * @param meetbe ��ѯ����
	 * @return
	 */
	public List<MeetingroomBespeak> getAllMeetingroomBespeak(MeetingroomBespeak meetbe);
	
	/**
	 * ���ݱ�Ų�ѯԤԼ��Ϣ
	 * @param bespeakId
	 * @return
	 */
	public MeetingroomBespeak getMeetingroomBespeak(String bespeakId);
	
	/**
	 * �޸�ԤԼ��Ϣ
	 * @param meetbe ԤԼ��Ϣ
	 * @param userIds �μӻ�����Ա
	 * @return
	 */
	public boolean updateMeetingroomBespeak(MeetingroomBespeak  meetbe,String userIds);
	
	/**
	 * �޸�ԤԼ��Ϣ��ԤԼ��ˣ�
	 * @param meetbe �����Ϣ
	 * @return
	 */
	public boolean updateMeetingroomBespeak(MeetingroomBespeak  meetbe);

	/**
	 * ���� ��ʼʱ�䡢����ʱ�䡢������ id ��ѯԤԼ��������Ϣ
	 * @param startTime ԤԼ���
	 * @param endTime ����ʱ��
	 * @param roomId ������ id
	 * @return ����ԤԼ����Ϣ
	 */
	List<MeetingroomBespeak> findAllByStartTimeAfterAndEndTimeBeforeAndRoomId(Date startTime, Date endTime, Integer roomId);
}
