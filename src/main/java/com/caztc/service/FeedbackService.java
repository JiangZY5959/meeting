package com.caztc.service;

import com.caztc.domain.Feedback;

import java.util.List;

/**
 * @author narata
 * @since 2019/03/27
 */
public interface FeedbackService {

    public boolean add(Feedback feedback);

    public List<Feedback> list();

    public boolean sendmail(Feedback feedback);
}
