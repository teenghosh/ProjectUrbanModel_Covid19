package com.garage48.covid19.projecturban.service;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class NotificationServiceImpl implements NotificationService{

	
	@Autowired
    public JavaMailSender sender;
	@Value("${mail.notification.subject}")
	private String subject;
	
	@Override
	public boolean sendEmail(String stringTo, String text, MultipartFile file,boolean isFileExist) throws Exception {
		MimeMessage message = sender.createMimeMessage();
	      
	    MimeMessageHelper helper = new MimeMessageHelper(message, true);
	     
	    helper.setTo(stringTo);
	    helper.setSubject(subject);
	    helper.setText(text);
	    if(isFileExist)
	    	helper.addAttachment("attatchment", file);
	 
	    sender.send(message);
		return false;
	}

	
	//TODO will be implemented later.
	@Override
	public boolean sendSms(String stringTo, String text) throws Exception {
		return false;
	}

}
