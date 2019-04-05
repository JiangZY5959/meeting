package com.caztc.service;

import javax.mail.internet.AddressException;


public interface MailService {
    void sendMail(String title, String content, String receiver) throws Exception;
}
