package com.ERS.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.RES.Dao.ReimbersementDao;
import com.RES.Dao.UserDao;
import com.RES.models.Reiembersement;
import com.RES.models.ReiembersementStatus;
import com.RES.models.ReiembersementTypes;
import com.RES.models.Users;
import com.RES.services.ReimbersementServices;
import com.RES.services.UserService;
//import com.example.models.PostDisplay;
//import com.example.models.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class ReimbursementController {
	private static Reiembersement reimb = new Reiembersement();
	private static ReimbersementDao reimbDao = new ReimbersementDao();
	private static UserDao uDao = new UserDao();
	private static ReimbersementServices rServ = new ReimbersementServices(reimbDao, uDao);
	private static UserService uServ = new UserService(uDao);
	private static ReiembersementTypes rType = new ReiembersementTypes();
	private static ReiembersementStatus rStatus = new ReiembersementStatus();
	
	public static void getAllReimbursements(HttpServletRequest req, HttpServletResponse res) throws JsonProcessingException, IOException{
		if(req.getMethod().equals("GET")) {
			
			List<Reiembersement> reimb = rServ.selectAllReimbursements();
			System.out.println(reimb);
			res.addHeader("Access-Control-Allow-Origin", "*");
			res.setHeader("Access-Control-Allow-Methods", "GET");
			res.getWriter().write(new ObjectMapper().writeValueAsString(reimb));
		}
	}		
	
	public static void getAllById(HttpServletRequest req, HttpServletResponse res)
			throws JsonProcessingException, IOException {

		Integer id = Integer.parseInt(req.getParameter("id"));
		List<Reiembersement> rList = rServ.selectAllReimbursements();
		System.out.println(rList);
		List<Reiembersement> retList = new ArrayList<>();
		for (int i = 0; i < rList.size(); i++) {
			Reiembersement ret = rList.get(i);
			
			if (ret.getRemAuthor().getId() == id ) {
				retList.add(ret);
			}
		}
		res.getWriter().write((new ObjectMapper().writeValueAsString(retList)));
	}
		public static void addNewReimbursement(HttpServletRequest req, HttpServletResponse res)
				throws JsonProcessingException, IOException {
			StringBuilder buffer = new StringBuilder();
			BufferedReader reader = req.getReader();
			
			String line;
			while((line = reader.readLine()) != null) {
				buffer.append(line);
				buffer.append(System.lineSeparator());
			}
			String data = buffer.toString();
			System.out.println(data);
			ObjectMapper mapper = new ObjectMapper();
			JsonNode parsedObj = mapper.readTree(data);
			
			int userId = Integer.parseInt(parsedObj.get("userId").asText());
			int reimbAmount = Integer.parseInt(parsedObj.get("reimbAmount").asText());
			String reimbSubmitted = parsedObj.get("reimbSubmitted").asText();
			String reimbDescription = parsedObj.get("reimbDescription").asText();
			int author = Integer.parseInt(parsedObj.get("author").asText());
//			String ersStatus = parsedObj.get("ersStatus").asText();
			String ersType = String.valueOf(parsedObj.get("ersType").asText());
			Users u = uServ.getUsersById(userId);			
			Users a = uServ.getAuthor(author);
		

			ReiembersementTypes type = rServ.getReimbursementType(ersType);
			
			rServ.addReimbursement(u, reimbAmount, reimbSubmitted, reimbDescription, a, type);
			
			ObjectNode ret = mapper.createObjectNode();
			ret.put("message", "successfully submitted a new reimbursment");
			res.addHeader("Access-Control-Allow-Origin", "*");
			res.setHeader("Access-Control-Allow-Methods", "POST");
			res.getWriter().write(new ObjectMapper().writeValueAsString(ret));
		
	}
	
		public static void filterByStatus(HttpServletRequest req, HttpServletResponse res)
				throws JsonProcessingException, IOException {
			System.out.println("inside the status filter");
			String status = String.valueOf(req.getParameter("status"));
			List<Reiembersement> sList = rServ.selectByReimbursementStatus(status);
			System.out.println(sList);
			List<Reiembersement> retList = new ArrayList<>();
			for (int i = 0; i < sList.size(); i++) {
				Reiembersement ret = sList.get(i);
				if (ret.getReimbStatus().equals(status)) {
					retList.add(ret);
				}
			}
			res.getWriter().write((new ObjectMapper().writeValueAsString(sList)));
		}
	
	
	

}
