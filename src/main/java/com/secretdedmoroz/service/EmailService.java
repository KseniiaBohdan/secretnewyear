package com.secretdedmoroz.service;

import java.util.Date;
import java.util.Map;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;

import com.secretdedmoroz.model.User;
import com.sun.mail.smtp.SMTPTransport;


@Service
public class EmailService {

    private static final String SMTP_SERVER = "smtp server ";
    private static final String USERNAME = "";
    private static final String PASSWORD = "";

    private static final String EMAIL_FROM = "ks.13.bogdan@gmail.com";

    private static final String EMAIL_SUBJECT = "Secret Party";
    private static final String EMAIL_TEXT = "Hello you should buy present for ";

    public void sendEmails(Map<User, User> pares) {
        Properties prop = System.getProperties();
        prop.put("mail.smtp.host", SMTP_SERVER); //optional, defined in SMTPTransport
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.port", "25"); // default port 25

        Session session = Session.getInstance(prop, null);
        Message msg = new MimeMessage(session);


        pares.keySet().forEach(sender -> {
            try {
                msg.setFrom(new InternetAddress(EMAIL_FROM));
                msg.setRecipients(Message.RecipientType.TO,
                        InternetAddress.parse(sender.getEmail(), false));
                msg.setSubject(EMAIL_SUBJECT);
                msg.setText(EMAIL_TEXT + pares.get(sender).getName());
                msg.setSentDate(new Date());
                SMTPTransport t = (SMTPTransport) session.getTransport("smtp");
                t.connect(SMTP_SERVER, USERNAME, PASSWORD);
                t.sendMessage(msg, msg.getAllRecipients());
                System.out.println("Response: " + t.getLastServerResponse());
                t.close();
            } catch (MessagingException e) {
                e.printStackTrace();
            }
        });
    }
}
