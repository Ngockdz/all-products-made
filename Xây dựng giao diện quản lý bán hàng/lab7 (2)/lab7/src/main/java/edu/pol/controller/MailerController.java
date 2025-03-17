package edu.pol.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.pol.service.MailerService;
import jakarta.mail.MessagingException;

public class MailerController {
	@Autowired
	MailerService mailer;
	
	@ResponseBody
	@RequestMapping("/mailer")
	public String demo(Model model) {
	try {
	mailer.send("receiver@gmail.com", "Subject", "Body");
	return "OK";
	} catch (MessagingException e) {
	return e.getMessage();
	}
	}

}
