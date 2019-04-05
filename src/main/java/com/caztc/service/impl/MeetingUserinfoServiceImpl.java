package com.caztc.service.impl;

import java.util.List;

import com.caztc.domain.MeetingUserinfo;
import com.caztc.mapper.MeetingUserinfoMapper;
import com.caztc.service.MeetingUserinfoService;
import com.caztc.utils.DBFactoryUtils;

public class MeetingUserinfoServiceImpl implements MeetingUserinfoService {

	@Override
	public List<MeetingUserinfo> getAllMeetingUserinfo(
			MeetingUserinfo meetinguserinfo) {

		try {

			MeetingUserinfoMapper mapper = DBFactoryUtils
					.getMapper(MeetingUserinfoMapper.class);
			return mapper.getAllMeetingUserinfo(meetinguserinfo);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
