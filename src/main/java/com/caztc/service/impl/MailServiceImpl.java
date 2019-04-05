package com.caztc.service.impl;

import com.caztc.service.MailService;

import java.util.Date;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.mail.*;

import javax.mail.internet.*;

import com.sun.mail.smtp.*;

/**
 * @author CJN
 */
public class MailServiceImpl implements MailService {
    private static final ExecutorService executorService = Executors.newCachedThreadPool();
    private static final String senderUsername = "caztchyzx@foxmail.com";
    private static final String senderPassword = "artoqclmhunybdjg";

    @Override
    public void sendMail(String title, String content, String receiver) throws Exception {
        executorService.submit(() -> {
            try {
                sendMailSync(title, content, receiver);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public void sendMailSync(String title, String content, String receiver) throws Exception {
        Properties props = System.getProperties();
        props.put("mail.smtps.host","smtp.qq.com");
        props.put("mail.smtps.auth","true");
        Session session = Session.getInstance(props, null);
        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress("caztchyzx@foxmail.com"));
        msg.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(receiver, false));
        msg.setSubject(title);
        msg.setText(content);
        msg.setHeader("X-Mailer", "meeting program");
        msg.setSentDate(new Date());
        SMTPTransport t =
                (SMTPTransport)session.getTransport("smtps");
        t.connect("smtp.qq.com", senderUsername, senderPassword);
        t.sendMessage(msg, msg.getAllRecipients());
        System.out.println("Response: " + t.getLastServerResponse());
        t.close();
    }
}
