package com.caztc.mapper;

import java.util.List;

import com.caztc.domain.EnzhequipmentInfo;

/**
 * �豸��Ϣ���ݿ���ʽӿ�
 * @author Administrator
 *
 */
public interface EnquipmentMapper {

	
	/**
	 * ����豸��Ϣ
	 * @param info �豸��Ϣ
	 * @return ����Ӱ������
	 */
	public int addEnquipment(EnzhequipmentInfo info);
	
	/**
	 * ��ѯ�豸��Ϣ
	 * @param info ��ѯ����
	 * @return ���ض���豸��Ϣ
	 */
	public List<EnzhequipmentInfo> getAllEnzhequipmentInfo(EnzhequipmentInfo info);
	
	
	/**
	 * �����豸��Ų�ѯ�豸��Ϣ
	 * @param enzhequipmentId �豸���
	 * @return �����豸��Ϣ
	 */
	public EnzhequipmentInfo getEnzhequipmentInfo(Integer enzhequipmentId);
	
	/**
	 * �޸��豸��Ϣ
	 * @param info �豸��Ϣ
	 * @return  ����Ӱ�������
	 */
	public int updateEnzhequipmentInfo(EnzhequipmentInfo info);
	
	/**
	 * �����豸���ɾ���豸��Ϣ
	 * @param enzhequipmentId �豸���
	 * @return ����Ӱ������
	 */
	public int deleteEnzhequipmentInfo(Integer enzhequipmentId);
	
	/**
	 * ��ѯ�豸��Ϣ
	 * @param info ��ѯ����
	 * @return
	 */
	public List<EnzhequipmentInfo> selectEnzhequipmentInfo(EnzhequipmentInfo info);
	
	
	/**
	 * ���ݱ�Ŷ������ �豸��Ϣ
	 * @param enzhequipmentId
	 * @return
	 */
	public EnzhequipmentInfo showEnquipmentInfo(Integer enzhequipmentId);
	
	
	/**
	 * ��ѯδʹ���豸��Ϣ
	 * @return
	 */
	public List<EnzhequipmentInfo> queryEnzhequipmentInfo();
}
