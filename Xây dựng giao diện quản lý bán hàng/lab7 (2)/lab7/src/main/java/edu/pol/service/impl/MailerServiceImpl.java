package edu.pol.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import edu.pol.model.MailInfo;
import edu.pol.service.MailerService;
import jakarta.mail.MessagingException;

@Service
public class MailerServiceImpl implements MailerService {
	@Autowired
	JavaMailSender sender;
	@Override
	public void send(MailInfo mail) throws MessagingException {
	// TODO mã nguồn gửi email đặt ở đây
	}
	@Override
	public void send(String to, String subject, String body) 
	throws MessagingException {
	this.send(new MailInfo(to, subject, body));
	}
}
