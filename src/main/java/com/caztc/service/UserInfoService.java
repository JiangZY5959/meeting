package com.caztc.service;

import java.util.List;

import com.caztc.domain.UserInfo;

/**
 * �û���Ϣ��ҵ���߼��ӿ�
 * @author Administrator
 *
 */
public interface UserInfoService {
	
	/**
	 * �û���¼
	 * @param userId �˺�
	 * @param passWord ����
	 * @return �û���Ϣ
	 */
	public UserInfo isLogin(String userId,String passWord);
	
	/**
	 * ����û���Ϣ
	 * @param userinfo
	 * @return
	 */
	public boolean add(UserInfo userinfo);
	
	/**
	 * ��ѯ�û���Ϣ
	 * @param user ��ѯ����
	 * @return ����û���Ϣ
	 */
	public List<UserInfo> getAllUser(UserInfo user);
	
	/**
	 * �����˺Ų�ѯ�û���Ϣ
	 * @param userId �˺�
	 * @return �û���Ϣ
	 */
	public UserInfo getUser(String userId);

	
	/**
	 * �޸��û���Ϣ
	 * @param user �޸�����
	 * @return true�ɹ� falseʧ�� 
	 */
	public boolean updateUser(UserInfo user);
	
	/**
	 * ����userIdɾ���û���Ϣ
	 * @param userId �˺�
	 * @return trueΪ�ɹ� falseΪʧ��
	 */
	public boolean deleteUser(String userId);
	
	/**
	 * ���Ȩ��
	 * @param user �û���Ϣ
	 * @return trueΪ�ɹ� falseΪʧ��
	 */
	public boolean anthorityChange(UserInfo user);

}
