package com.RES.services;

import java.util.Date;
import java.util.List;

import com.RES.Dao.ReimbersementDao;
import com.RES.Dao.UserDao;
import com.RES.models.Reiembersement;
import com.RES.models.ReiembersementStatus;
import com.RES.models.ReiembersementTypes;
import com.RES.models.Users;

public class ReimbersementServices {

	private ReimbersementDao rDao;
	private UserDao uDao;
	
	public ReimbersementServices(ReimbersementDao rDao) {
		this.rDao = rDao;
	}
	
	public ReimbersementServices(ReimbersementDao rDao, UserDao uDao) {
		this.rDao = rDao;
		this.uDao = uDao;
	}

	//Selects all reimbursements
	public List< Reiembersement> selectAllReimbursements(){
		
		List< Reiembersement> rList = rDao.selectAllReimb();		
		
		return rList;
	}
	public Reiembersement addReimbursements(Users rAuthor, int amt, String descp, ReiembersementTypes type) {
		Reiembersement r = new Reiembersement(rAuthor ,amt, descp, type);
		rDao.Insert(r);
		return r;
	}
	//Adds new reimbursement
	public void addReimbursement(Users remAuthor,  int reimbursement_amt, Date reimbursement_submt,String reimbursement_despt, ReiembersementTypes RembType, ReiembersementStatus ReimbStatus) {
		
		Reiembersement r = new Reiembersement( remAuthor ,reimbursement_amt,reimbursement_submt, reimbursement_despt, RembType, ReimbStatus);
		rDao.Insert(r);;
	}
	
	//Select Pending Reimbursements
	public List<Reiembersement> selectPendingReimb(){
		return rDao.selectPendingReimb();
	}
	public ReiembersementTypes getReimbursementType(String ersType) {
		return rDao.getReimbursementType(ersType);
	}
	public Reiembersement addReimbursement(Users u, int reimbAmount, String reimbSubmitted, String reimbDescription, Users author, ReiembersementTypes ersType) {
		Reiembersement r = new Reiembersement(u, reimbAmount, reimbSubmitted, reimbDescription, author, ersType);
		rDao.Insert(r);
		List<Reiembersement> rList = u.getRempList();
		rList.add(r);
		uDao.updateUser(u);
		return r;
	}
	public List<Reiembersement> selectByReimbursementStatus(String status) {
		return rDao.selectByReimbursementStatus(status);
	}
}
