package com.smc.service;

import javax.mail.MessagingException;

public interface MailService {
       
    void sendSimpleEmail();
    void sendHTMLMail(String email, String username) throws MessagingException;
    void sendNewPasswordEmail(String email, String newpassword);
    
	}
