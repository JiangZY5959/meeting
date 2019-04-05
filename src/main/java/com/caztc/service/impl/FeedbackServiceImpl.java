package com.caztc.service.impl;

import com.caztc.domain.Feedback;
import com.caztc.domain.MeetingRoom;
import com.caztc.domain.UserInfo;
import com.caztc.mapper.FeedbackMapper;
import com.caztc.mapper.UserInfoMapper;
import com.caztc.service.FeedbackService;
import com.caztc.service.MailService;
import com.caztc.utils.DBFactoryUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.List;

/**
 * @author narata
 * @since 2019/03/27
 */
public class FeedbackServiceImpl implements FeedbackService {
    private static final UserInfoMapper userMapper = DBFactoryUtils.getMapper(UserInfoMapper.class);
    private MailService mailService = new MailServiceImpl();
    @Override
    public boolean add(Feedback feedback) {
        SqlSession session = DBFactoryUtils.getSqlSession();
        try {
            FeedbackMapper feedbackMapper = session.getMapper(FeedbackMapper.class);
            feedbackMapper.add(feedback);
            session.commit();
            return true;
        } catch (Exception e) {
            session.rollback();
            return false;
        }
    }

    @Override
    public List<Feedback> list() {
        FeedbackMapper feedbackMapper = DBFactoryUtils.getMapper(FeedbackMapper.class);
        return feedbackMapper.list();
    }

    @Override
    public boolean sendmail(Feedback feedback) {
        try {
            String content = String.format("收到新的用户反馈：\n主题：%s\n姓名：%s\n电话：%s\n详情：%s",
                    feedback.getSubject(), feedback.getName(), feedback.getPhone(), feedback.getDescription());
            List<UserInfo> allUser = new ArrayList<>();
            String[] anthorities = new String[]{"2", "3"};
            for (String anthority : anthorities) {
                List<UserInfo> users = userMapper.getAllUserByAnthority(anthority);
                allUser.addAll(users);
            }
            for (UserInfo info : allUser) {
                if (info.getUserMail() != null && !info.getUserMail().isEmpty()) {
                    mailService.sendMail("新的用户反馈", content, info.getUserMail());
                }
            }
            System.out.println(content);
            return true;
        } catch (Exception e) {
            return false;
        }

    }
}
