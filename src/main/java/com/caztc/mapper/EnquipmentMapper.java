package com.caztc.mapper;

import java.util.List;

import com.caztc.domain.EnzhequipmentInfo;

/**
 * 设备信息数据库访问接口
 * @author Administrator
 *
 */
public interface EnquipmentMapper {

	
	/**
	 * 添加设备信息
	 * @param info 设备信息
	 * @return 返回影响行数
	 */
	public int addEnquipment(EnzhequipmentInfo info);
	
	/**
	 * 查询设备信息
	 * @param info 查询条件
	 * @return 返回多个设备信息
	 */
	public List<EnzhequipmentInfo> getAllEnzhequipmentInfo(EnzhequipmentInfo info);
	
	
	/**
	 * 根据设备编号查询设备信息
	 * @param enzhequipmentId 设备编号
	 * @return 返回设备信息
	 */
	public EnzhequipmentInfo getEnzhequipmentInfo(Integer enzhequipmentId);
	
	/**
	 * 修改设备信息
	 * @param info 设备信息
	 * @return  返回影响的行数
	 */
	public int updateEnzhequipmentInfo(EnzhequipmentInfo info);
	
	/**
	 * 根据设备编号删除设备信息
	 * @param enzhequipmentId 设备编号
	 * @return 返回影响行数
	 */
	public int deleteEnzhequipmentInfo(Integer enzhequipmentId);
	
	/**
	 * 查询设备信息
	 * @param info 查询条件
	 * @return
	 */
	public List<EnzhequipmentInfo> selectEnzhequipmentInfo(EnzhequipmentInfo info);
	
	
	/**
	 * 根据编号多表连查 设备信息
	 * @param enzhequipmentId
	 * @return
	 */
	public EnzhequipmentInfo showEnquipmentInfo(Integer enzhequipmentId);
	
	
	/**
	 * 查询未使用设备信息
	 * @return
	 */
	public List<EnzhequipmentInfo> queryEnzhequipmentInfo();
}
