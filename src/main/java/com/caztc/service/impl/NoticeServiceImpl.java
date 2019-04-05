package com.caztc.service.impl;

import com.caztc.domain.Notice;
import com.caztc.mapper.NoticeMapper;
import com.caztc.service.NoticeService;
import com.caztc.utils.DBFactoryUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @author narata
 * @since 2019/03/31
 */

public class NoticeServiceImpl implements NoticeService {
    @Override
    public List<Notice> list() {
        NoticeMapper mapper = DBFactoryUtils.getMapper(NoticeMapper.class);
        return mapper.getAll();
    }

    @Override
    public boolean add(Notice notice) {
        SqlSession session = DBFactoryUtils.getSqlSession();
//        try {
            NoticeMapper mapper = session.getMapper(NoticeMapper.class);
            int i = mapper.add(notice);
            session.commit();
            if (i > 0) {
                return true;
            }
//        } catch (Exception e) {
//            session.rollback();
//        }
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        SqlSession session = DBFactoryUtils.getSqlSession();
        try {
            NoticeMapper mapper = session.getMapper(NoticeMapper.class);
            int i = mapper.delete(id);
            if (i > 0) {
                session.commit();
                return true;
            }
        } catch (Exception e) {
            session.rollback();
        }
        return false;
    }
}
