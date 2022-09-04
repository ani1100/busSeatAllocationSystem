package com.aniket.portal.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.aniket.portal.pojos.RegistrationReqPojo;
import com.aniket.portal.pojos.RegistrationRespPojo;
import com.aniket.portal.service.RegistrationSrvc;

@RestController
public class RegistrationController {
	@Autowired
	RegistrationSrvc regsrvc;
	@PostMapping("/singleregisterbus")
	public RegistrationRespPojo singleregisterbus(@RequestBody RegistrationReqPojo regpojo)
	{
		RegistrationRespPojo resppojo=regsrvc.registersinglebusdetails(regpojo);
		return resppojo;
	}
	@PostMapping("/checkusername")
	public RegistrationRespPojo checkusername(@RequestBody String username)
	{
		RegistrationRespPojo resppojo=regsrvc.checkusername(username);
		return resppojo;
	}
}