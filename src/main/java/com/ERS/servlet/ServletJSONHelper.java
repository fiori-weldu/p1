package com.ERS.servlet;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ERS.controller.LoginController;
import com.ERS.controller.LogoutController;
import com.ERS.controller.ReimbursementController;
import com.fasterxml.jackson.core.JsonProcessingException;

//import com.example.controllers.LoginController;
//import com.example.controllers.LogoutController;
//import com.example.controllers.PostsController;
import com.ERS.controller.SessionController;
//import com.fasterxml.jackson.core.JsonProcessingException;

public class ServletJSONHelper  {
	
	public static void process(HttpServletRequest req, HttpServletResponse res) throws JsonProcessingException, IOException{
		System.out.println("In the ServletJSONHelper with URI: " + req.getRequestURI());
		switch(req.getRequestURI()) {
			case "/RESProject1/api/login":
				LoginController.login(req, res);
				break;
			case "/RESProject1/api/logout":
				LogoutController.logout(req, res);
				break;
//			case "/RESProject1/api/posts":
//				ReimbursementController.handlePosts(req, res);
//				break;
//			case "/RESProject1/api/session":
//				SessionController.getSession(req, res);
//				break;
		}
	}
	
}
