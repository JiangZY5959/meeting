package com.caztc.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.caztc.domain.EnzhequipmentInfo;
import com.caztc.domain.MeetingRoom;
import com.caztc.mapper.EnquipmentMapper;
import com.caztc.mapper.MeetingRoomMapper;
import com.caztc.service.MeetingRoomService;
import com.caztc.utils.DBFactoryUtils;

public class MeetingRoomServiceImpl implements MeetingRoomService {

	private static final MeetingRoomMapper mapper = DBFactoryUtils.getMapper(MeetingRoomMapper.class);

	@Override
	public List<MeetingRoom> getAllMeetingRoooms(MeetingRoom meetingroom) {

		try {
			MeetingRoomMapper mapper = DBFactoryUtils
					.getMapper(MeetingRoomMapper.class);

			if (meetingroom != null && meetingroom.getMeetingroomName() != null
					&& !meetingroom.getMeetingroomName().equals("")) {
				meetingroom.setMeetingroomName("%"
						+ meetingroom.getMeetingroomName() + "%");
			}

			List<MeetingRoom> list = mapper.getAllMeetingRoom(meetingroom);

			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public List<MeetingRoom> getAllEnableMeetingRoooms(MeetingRoom meetingroom) {

		try {
			MeetingRoomMapper mapper = DBFactoryUtils
					.getMapper(MeetingRoomMapper.class);

			if (meetingroom != null && meetingroom.getMeetingroomName() != null
					&& !meetingroom.getMeetingroomName().equals("")) {
				meetingroom.setMeetingroomName("%"
						+ meetingroom.getMeetingroomName() + "%");
			}

			List<MeetingRoom> list = mapper.getAllEnableMeetingRoom(meetingroom);

			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public List<MeetingRoom> findAll() {
        MeetingRoomMapper mapper = DBFactoryUtils
                .getMapper(MeetingRoomMapper.class);
		return mapper.findAll();
	}

	@Override
	public boolean addMeetingRoom(MeetingRoom meetingroom,
			String enzhequipmentIds) {
		SqlSession session = DBFactoryUtils.getSqlSession();

		try {

			// 锟斤拷锟斤拷锟斤拷
			MeetingRoomMapper meetmapper = session
					.getMapper(MeetingRoomMapper.class);

			int i = meetmapper.addMeetingRoom(meetingroom);
			int x = -1;
			// 锟借备锟斤拷息
			EnquipmentMapper enmapper = session
					.getMapper(EnquipmentMapper.class);
			// 锟睫革拷锟借备锟斤拷息
			String[] enzhequipmentId = enzhequipmentIds.split(",");
			for (int a = 0; a < enzhequipmentId.length; a++) {

				EnzhequipmentInfo enfinfo = enmapper
						.getEnzhequipmentInfo(Integer
								.parseInt(enzhequipmentId[a]));

				if (enfinfo != null) {
					enfinfo.setMeetingroomId(meetingroom.getMeetingroomId());
					x = enmapper.updateEnzhequipmentInfo(enfinfo);
				}

			}

			if (i > 0 && x > 0) {
				session.commit();
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}

		return false;
	}

	@Override
	public MeetingRoom getMeetingRoom(String meetingroomId) {

		try {
			MeetingRoomMapper mapper = DBFactoryUtils
					.getMapper(MeetingRoomMapper.class);
			if (meetingroomId != null && !meetingroomId.equals("")) {
				return mapper.getMeetingRoom(Integer.parseInt(meetingroomId));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public boolean updatemeetingRoom(MeetingRoom meetingroom,
			String enzhequipmentIds) {
		SqlSession session = DBFactoryUtils.getSqlSession();
		try {

			MeetingRoomMapper mapper = session
					.getMapper(MeetingRoomMapper.class);

			MeetingRoom mr = mapper.getMeetingRoom(meetingroom
					.getMeetingroomId());

			if (mr != null) {
				mr.setMeetingroomName(meetingroom.getMeetingroomName());
				mr.setMeetingroomSize(meetingroom.getMeetingroomSize());
				mr.setMeetingroomNote(meetingroom.getMeetingroomNote());
				mr.setMeetingRoomUseState(meetingroom.getMeetingRoomUseState());

				int i = mapper.updateMeetingRoom(mr);

				// 锟叫讹拷锟借备锟斤拷锟斤拷欠锟轿拷锟�
				if (enzhequipmentIds != null && !enzhequipmentIds.equals("")) {
					int x = -1;
					// 锟借备锟斤拷息
					EnquipmentMapper enmapper = session
							.getMapper(EnquipmentMapper.class);
					// 锟睫革拷锟借备锟斤拷息
					String[] enzhequipmentId = enzhequipmentIds.split(",");
					for (int a = 0; a < enzhequipmentId.length; a++) {

						EnzhequipmentInfo enfinfo = enmapper
								.getEnzhequipmentInfo(Integer
										.parseInt(enzhequipmentId[a]));

						if (enfinfo != null) {
							enfinfo.setMeetingroomId(meetingroom
									.getMeetingroomId());
							x = enmapper.updateEnzhequipmentInfo(enfinfo);

							if (x == 0) {
								break;
							}
						}

					}

					if (i > 0 && x > 0) {
						session.commit();
						return true;
					} else {
						return false;
					}

				} else {

					if (i > 0) {
						session.commit();
						return true;
					} else {
						return false;
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}

		return false;
	}

	@Override
	public boolean deleteMeetingRoom(String meetingroomId) {
		SqlSession session = DBFactoryUtils.getSqlSession();

		try {
			// 锟斤拷锟斤拷锟斤拷锟斤拷锟捷凤拷锟绞接匡拷
			MeetingRoomMapper mapper = session
					.getMapper(MeetingRoomMapper.class);

			MeetingRoom mr = mapper.getMeetingRoom(Integer
					.parseInt(meetingroomId));
			if (mr != null) {
				mr.setMeetingroomState("0");

				int i = mapper.updateMeetingRoom(mr);

				//锟斤拷询锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷璞革拷锟较�
				EnquipmentMapper enmapper = session
						.getMapper(EnquipmentMapper.class);
				EnzhequipmentInfo info = new EnzhequipmentInfo();
				info.setMeetingroomId(mr.getMeetingroomId());
				List<EnzhequipmentInfo> enlist = enmapper.selectEnzhequipmentInfo(info);
				
				for(EnzhequipmentInfo enqui:enlist){
					enqui.setMeetingroomId(null);
					enmapper.updateEnzhequipmentInfo(enqui);
				}
				
				if(i>0){
					session.commit();
					return true;
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}
		return false;
	}

}
