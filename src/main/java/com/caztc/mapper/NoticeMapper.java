package com.caztc.mapper;

import com.caztc.domain.Notice;

import java.util.List;

/**
 * @author narata
 * @since 2019/03/31
 */
public interface NoticeMapper {
    public List<Notice> getAll();

    public int add(Notice notice);

    public int delete(Integer id);
}
