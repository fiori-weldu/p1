package com.ERS.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.example.servlets.RequestViewHelper;

public class MasterViewServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		System.out.println("Starting in the Master doGet method");
		req.getRequestDispatcher(RequestViewHelper.process(req)).forward(req, res);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		doGet(req, res);
	}
}
