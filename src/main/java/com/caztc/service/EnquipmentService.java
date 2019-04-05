package com.caztc.service;

import java.util.List;

import com.caztc.domain.EnzhequipmentInfo;

/**
 * �豸��Ϣ����Ľӿ�
 * @author Administrator
 *
 */
public interface EnquipmentService {
	
	/**
	 * ����豸��Ϣ
	 * @param info �豸��Ϣ
	 * @return true Ϊ�ɹ� falseΪʧ��
	 */
	public boolean addEnquipment(EnzhequipmentInfo info);
	
	/**
	 * ��ѯ����豸��Ϣ
	 * @param info
	 * @return
	 */
	public List<EnzhequipmentInfo> getAllEnzhequipmentInfo(EnzhequipmentInfo info);
	
	/**
	 * �����豸��Ų�ѯ�����Ϣ
	 * @param enzhequipmentId �豸���
	 * @return �豸��Ϣ
	 */
	public EnzhequipmentInfo getEnzhequipmentInfo(String enzhequipmentId);
	
	/**
	 * �޸��豸��Ϣ
	 * @param info ����
	 * @return true Ϊ�ɹ� falseΪʧ��
	 */
	public boolean updateEnzhequipmentInfo(EnzhequipmentInfo info);
	
	/**
	 * �����豸���ɾ���豸��Ϣ
	 * @param enzhequipmentId �豸���
	 * @return true Ϊ�ɹ� falseΪʧ��
	 */
	public boolean deleteEnzhequipmentInfo(String enzhequipmentId);
	
	/**
	 * ��ѯ�豸��Ϣ
	 * @param info
	 * @return
	 */
	public List<EnzhequipmentInfo> selectEnquipmentInfo(EnzhequipmentInfo info);
	
	/**
	 * ���ݱ�Ŷ������ �豸��Ϣ
	 * @param enzhequipmentId
	 * @return
	 */
	public EnzhequipmentInfo showEnzhequipmentInfo(String enzhequipmentId);
	
	/**
	 * ��ѯδʹ�õ��豸��Ϣ
	 * @return
	 */
	public List<EnzhequipmentInfo> queryEnzhequipmentInfo();

}
