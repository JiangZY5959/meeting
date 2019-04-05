package com.caztc.service;

import com.caztc.domain.Notice;

import java.util.List;

/**
 * @author narata
 * @since 2019/03/31
 */
public interface NoticeService {
    public List<Notice> list();

    public boolean add(Notice notice);

    public boolean delete(Integer id);
}
