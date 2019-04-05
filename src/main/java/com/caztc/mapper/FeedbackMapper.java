package com.caztc.mapper;

import com.caztc.domain.Feedback;

import java.util.List;

/**
 * @author narata
 * @since 2019/03/27
 */
public interface FeedbackMapper {
    public boolean add(Feedback feedback);

    public List<Feedback> list();
}
