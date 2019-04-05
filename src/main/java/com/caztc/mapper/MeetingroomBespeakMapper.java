package com.caztc.mapper;

import java.util.Date;
import java.util.List;

import com.caztc.domain.MeetingroomBespeak;

/**
 * ԤԼ���ݿ���ʽӿ�
 * @author Administrator
 *
 */
public interface MeetingroomBespeakMapper {
	
	/**
	 * ���ԤԼ��Ϣ
	 * @param bespeak ԤԼ��Ϣ
	 * @return ����Ӱ�������
	 */
	public  int addBespeak(MeetingroomBespeak bespeak );

	boolean delBespeak(String bespeakId);
	
	/**
	 * ����������ѯԤԼ��Ϣ
	 * @param bespeak ��ѯ����
	 * @return ���ض�����¼
	 */
	public List<MeetingroomBespeak> getAllMeetingroomBespeak(MeetingroomBespeak bespeak);


	/**
	 * ���ݱ�Ų�ѯԤԼ��������Ϣ
	 * @param bespeakId ԤԼ���
	 * @return ����ԤԼ����Ϣ
	 */
	public MeetingroomBespeak getMeetingroomBespeak(String bespeakId);

	public MeetingroomBespeak findById(String bespeakId);
	
	
	/**
	 * �޸�ԤԼ��Ϣ
	 * @param bespeak ԤԼ��Ϣ
	 * @return
	 */
	public  int updateBespeak(MeetingroomBespeak bespeak);

	/**
	 * ���� ��ʼʱ�䡢����ʱ�䡢������ id ��ѯԤԼ��������Ϣ
	 * @param startTime ԤԼ���
	 * @param endTime ����ʱ��
	 * @param roomId ������ id
	 * @return ����ԤԼ����Ϣ
	 */
	List<MeetingroomBespeak> findAllByStartTimeAfterAndEndTimeBeforeAndRoomId(Date startTime,
																			  Date endTime, Integer roomId);

}
