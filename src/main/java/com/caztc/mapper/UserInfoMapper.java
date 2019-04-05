package com.caztc.mapper;

import java.util.List;

import com.caztc.domain.UserInfo;

public interface UserInfoMapper {


	/**
	 * ����������ѯ�û���Ϣ
	 * @param user ��ѯ����
	 * @return �û���Ϣ
	 */
	public UserInfo getUser(UserInfo user);
	
	/**
	 * ����û���Ϣ
	 * @param user
	 * @return
	 */
	public int addUser(UserInfo user);
	
	/**
	 * ��ѯ����û���Ϣ
	 * @param user �û���Ϣ
	 * @return ����û���Ϣ
	 */
	public List<UserInfo> getAllUser(UserInfo user);
	
	/**
	 * ���ݱ�Ų�ѯ�û���Ϣ
	 * @param userId �û����
	 * @return �����û���Ϣ
	 */
	List<UserInfo> getAllUserByAnthority(String anthority);

	/**
	 * ���ݱ�Ų�ѯ�û���Ϣ
	 * @param userId �û����
	 * @return �����û���Ϣ
	 */
	public UserInfo getUserInfo(String userId);
	
	/**
	 * �޸��û���Ϣ
	 * @param user �޸ĵ�����
	 * @return ����Ӱ�������
	 */
	public int updateUser(UserInfo user);
	
/*	*//**
	 * ���� userIdɾ���û���Ϣ
	 * @param userId �˺�
	 * @return ����Ӱ�������
	 *//*
	public int deleteUser(String userId);*/
	
}
