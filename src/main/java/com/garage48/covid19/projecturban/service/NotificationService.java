package com.garage48.covid19.projecturban.service;

import org.springframework.web.multipart.MultipartFile;

public interface NotificationService {

	
	boolean sendEmail(String stringTo,String text,MultipartFile file,boolean isFileExist) throws Exception;
	
	boolean sendSms(String stringTo,String text) throws Exception;
}
