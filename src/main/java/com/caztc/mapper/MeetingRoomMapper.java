package com.caztc.mapper;

import java.util.List;

import com.caztc.domain.MeetingRoom;

/**
 * �����ҵ����ݷ��ʽӿ�
 * @author Administrator
 *
 */
public interface MeetingRoomMapper {
	
	/**
	 * ��ѯ��������Ϣ
	 * @param meetroom ��ѯ����
	 * @return ������Ч�����ң������
	 */
	public List<MeetingRoom> getAllMeetingRoom(MeetingRoom meetroom);
	public List<MeetingRoom> getAllEnableMeetingRoom(MeetingRoom meetroom);

	/**
	 * ��ѯ��������Ϣ
	 * @return ������Ч�����ң������
	 */
	List<MeetingRoom> findAll();

	/**
	 * ��ӻ�������Ϣ
	 * @param meetroom ��������Ϣ
	 * @return ����Ӱ������
	 */
	public int addMeetingRoom(MeetingRoom meetroom);
	
	/**
	 * ���ݱ�Ų�ѯ��������Ϣ
	 * @param meetingroomId �����ұ��
	 * @return
	 */
	public MeetingRoom getMeetingRoom(Integer meetingroomId); 
	
	/**
	 * �޸Ļ�������Ϣ
	 * @param meetroom ��������Ϣ
	 * @return ����Ӱ�������
	 */
	public int updateMeetingRoom(MeetingRoom meetroom);
	
}
