package com.caztc.service.impl;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.caztc.domain.MeetingRoom;
import com.caztc.domain.UserInfo;
import com.caztc.mapper.MeetingRoomMapper;
import com.caztc.mapper.UserInfoMapper;
import com.caztc.service.MailService;
import org.apache.ibatis.session.SqlSession;

import com.caztc.domain.MeetingUserinfo;
import com.caztc.domain.MeetingroomBespeak;
import com.caztc.mapper.MeetingUserinfoMapper;
import com.caztc.mapper.MeetingroomBespeakMapper;
import com.caztc.service.BespeakService;
import com.caztc.utils.DBFactoryUtils;

import javax.swing.table.TableRowSorter;
import javax.xml.stream.FactoryConfigurationError;

public class BespeakServiceImpl implements BespeakService {

    private static final MeetingroomBespeakMapper mapper = DBFactoryUtils
            .getMapper(MeetingroomBespeakMapper.class);
    private static final UserInfoMapper userMapper = DBFactoryUtils.getMapper(UserInfoMapper.class);
    private static final MeetingRoomMapper roomMapper = DBFactoryUtils.getMapper(MeetingRoomMapper.class);
    private MailService mailService = new MailServiceImpl();

    @Override
    public boolean delMeetingRoomBespeak(String bespeakId) {
        SqlSession session = DBFactoryUtils.getSqlSession();
        try {

            MeetingroomBespeakMapper bespeakmapper = session.getMapper(MeetingroomBespeakMapper.class);
            bespeakmapper.delBespeak(bespeakId);
            session.commit();
            return true;
        } catch (Exception e) {
            session.rollback();
            return false;
        }

    }

    @Override
    public boolean sendMail(String bespeakId) {
        try {
            MeetingroomBespeak meetingroomBespeak = mapper.findById(bespeakId);
            String content = String.format("用户%s预约的%s->%s使用%s会议室已取消",
                    meetingroomBespeak.getUserName(),
                    meetingroomBespeak.getStratTime().toString(),
                    meetingroomBespeak.getEndTime().toString(),
                    meetingroomBespeak.getMeetingName());
            System.out.println(content);
            List<UserInfo> userInfos = new ArrayList<>();
            userInfos.add(userMapper.getUserInfo(meetingroomBespeak.getUserId()));
            userInfos.addAll(userMapper.getAllUserByAnthority("2"));
            userInfos.addAll(userMapper.getAllUserByAnthority("3"));
            for (UserInfo userInfo: userInfos) {
                mailService.sendMail("会议室预约取消", content, userInfo.getUserMail());
            }
            return true;
        } catch (Exception e) {
            System.out.println("========="+e.getMessage());
            return false;
        }
    }

    @Override
    public boolean addMeetingroomBespeak(MeetingroomBespeak meetbe,
                                         String userIds) {

        SqlSession session = DBFactoryUtils.getSqlSession();

        try {
            MeetingroomBespeakMapper bespeakmapper = session
                    .getMapper(MeetingroomBespeakMapper.class);

            if (meetbe.getBespeakId() == null) {
                String id = String.format("%s-%s-%s-%s", meetbe.getStratTime().getTime(),
                        meetbe.getEndTime().getTime(), meetbe.getMeetingroomId(), meetbe.getUserId());
                meetbe.setBespeakId(id);
            }
            int i = bespeakmapper.addBespeak(meetbe);

            int x = -1;

            if (userIds != null && !userIds.equals("")) {

                MeetingUserinfoMapper meetingUsermapper = session
                        .getMapper(MeetingUserinfoMapper.class);
                String[] ids = userIds.split(",");

                for (String userId : ids) {

                    MeetingUserinfo meetuserinfo = new MeetingUserinfo();
                    meetuserinfo.setUserId(userId);
                    meetuserinfo.setBespeakId(meetbe.getBespeakId());

                    x = meetingUsermapper.addMeetingUserinfo(meetuserinfo);
                    if (x == 0) {
                        break;
                    }
                }

            }

            if (i > 0 && x == -1) {
                session.commit();
                sendMail(meetbe);
                return true;
            } else if (i > 0 && x > 0) {
                session.commit();
                sendMail(meetbe);
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }

        return false;
    }

    private void sendMail(MeetingroomBespeak meetbe) throws Exception {
        UserInfo userInfo = userMapper.getUserInfo(meetbe.getUserId());
        MeetingRoom meetingRoom = roomMapper.getMeetingRoom(meetbe.getMeetingroomId());
        String content = String.format("用户 %s 申请使用 %s 会议室。",
                userInfo.getUserName(), meetingRoom.getMeetingroomName());
        List<UserInfo> allUser = new ArrayList<>();
        String[] anthorities = new String[]{"2", "3", "4"};
        for (String anthority : anthorities) {
            List<UserInfo> users = userMapper.getAllUserByAnthority(anthority);
            allUser.addAll(users);
        }
        for (UserInfo info : allUser) {
            if (info.getUserMail() != null && !info.getUserMail().isEmpty()) {
                try {
                    mailService.sendMail(
                            "新的会议室预约申请",
                            content,
                            info.getUserMail());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public List<MeetingroomBespeak> getAllMeetingroomBespeak(
            MeetingroomBespeak meetbe) {

        try {
            MeetingroomBespeakMapper mapper = DBFactoryUtils
                    .getMapper(MeetingroomBespeakMapper.class);

            if (meetbe != null && meetbe.getMeetingName() != null
                    && !meetbe.getMeetingName().equals("")) {
                meetbe.setMeetingName("%" + meetbe.getMeetingName() + "%");
            }

            return mapper.getAllMeetingroomBespeak(meetbe);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public MeetingroomBespeak getMeetingroomBespeak(String bespeakId) {

        try {
            if (bespeakId != null) {
                MeetingroomBespeakMapper mapper = DBFactoryUtils
                        .getMapper(MeetingroomBespeakMapper.class);

                return mapper.getMeetingroomBespeak(bespeakId);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean updateMeetingroomBespeak(MeetingroomBespeak meetbe,
                                            String userIds) {
        SqlSession session = DBFactoryUtils.getSqlSession();

        try {
            MeetingroomBespeakMapper mapper = session
                    .getMapper(MeetingroomBespeakMapper.class);


            MeetingroomBespeak bespeak = mapper.getMeetingroomBespeak(meetbe
                    .getBespeakId());

            if (bespeak != null) {
                bespeak.setMeetingroomNote(meetbe.getMeetingroomNote());
                bespeak.setMeetingroomId(meetbe.getMeetingroomId());
                bespeak.setMeetingName(meetbe.getMeetingName());
                bespeak.setStratTime(meetbe.getStratTime());
                bespeak.setEndTime(meetbe.getEndTime());
            }

            int i = mapper.updateBespeak(bespeak);

            int x = -1;

            if (userIds != null && !userIds.equals("")) {

                MeetingUserinfoMapper meetingUsermapper = session
                        .getMapper(MeetingUserinfoMapper.class);
                String[] ids = userIds.split(",");

                for (String userId : ids) {

                    MeetingUserinfo meetuserinfo = new MeetingUserinfo();
                    meetuserinfo.setUserId(userId);
                    meetuserinfo.setBespeakId(meetbe.getBespeakId());

                    x = meetingUsermapper.addMeetingUserinfo(meetuserinfo);
                    if (x == 0) {
                        break;
                    }
                }

            }

            if (i > 0 && x == -1) {
                session.commit();
                return true;
            } else if (i > 0 && x > 0) {
                session.commit();
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateMeetingroomBespeak(MeetingroomBespeak meetbe) {
        SqlSession session = DBFactoryUtils.getSqlSession();

        try {
            MeetingroomBespeakMapper mapper = session
                    .getMapper(MeetingroomBespeakMapper.class);


            MeetingroomBespeak bespeak = mapper.getMeetingroomBespeak(meetbe
                    .getBespeakId());
            if (bespeak != null) {

                bespeak.setUseUserId(meetbe.getUseUserId());

                bespeak.setAuditingTime(meetbe.getAuditingTime());

                bespeak.setBespeakState(meetbe.getBespeakState());

                bespeak.setAuditingInfo(meetbe.getAuditingInfo());

                int i = mapper.updateBespeak(bespeak);

                if (i > 0) {
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

    @Override
    public List<MeetingroomBespeak> findAllByStartTimeAfterAndEndTimeBeforeAndRoomId(
            Date startTime, Date endTime, Integer roomId) {
        return mapper.findAllByStartTimeAfterAndEndTimeBeforeAndRoomId(startTime, endTime, roomId);
    }
}
