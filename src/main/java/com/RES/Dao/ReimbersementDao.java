package com.RES.Dao;

import java.util.List;

//import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.ERS.Utils.HibernateUtils;
import com.RES.models.Reiembersement;
import com.RES.models.ReiembersementStatus;
import com.RES.models.ReiembersementTypes;
import com.RES.models.Users;

public class ReimbersementDao {
	public void Insert(Reiembersement Rem) {
		   Session ses = HibernateUtils.getSession();
			Transaction tx = ses.beginTransaction();
			ses.save(Rem);
			tx.commit();
			
	}
	public void Insert(ReiembersementStatus RStatus) {
		   Session ses = HibernateUtils.getSession();
			Transaction tx = ses.beginTransaction();
			ses.save(RStatus);
			tx.commit();
			   }
	   
	public void Insert(ReiembersementTypes RTypes) {
		   Session ses = HibernateUtils.getSession();
			Transaction tx = ses.beginTransaction();
			ses.save(RTypes);
			tx.commit();
    }
	public Reiembersement selectByRemId(int rem_Id) {
		Session ses = HibernateUtils.getSession();
		Reiembersement reimb = ses.get(Reiembersement.class, rem_Id);
		return reimb;
	}
	public void updateRem(Reiembersement remb) {
		Session ses = HibernateUtils.getSession();
		Transaction tx = ses.beginTransaction();
		ses.update(remb);
		tx.commit();
	}
	public List<Reiembersement> selectAllReimb(){
		Session ses = HibernateUtils.getSession();
		List<Reiembersement> rList = ses.createQuery("from Reimbursement", Reiembersement.class).list();
		return rList;
	}

	public List<Reiembersement> selectPendingReimb(){
		Session ses = HibernateUtils.getSession();
		List<Reiembersement> rList = ses.createQuery("from Reimbursement where Estatus_FK = 1", Reiembersement.class ).list();
		return rList;
	}
	public ReiembersementTypes getReimbursementType(String ersType) {
		Session ses = HibernateUtils.getSession();
		ReiembersementTypes r = ses.createQuery("from ReimbursementType where ersType=" + ersType, ReiembersementTypes.class).uniqueResult();
		return r;
	}
	public List<Reiembersement> selectByReimbursementStatus(String status) {
		Session ses = HibernateUtils.getSession();
		Query<Reiembersement> q = ses.createQuery("FROM Reimbursement WHERE ersStatus.status = '"+status+"'",Reiembersement.class);
		return q.list();
	}
	
}
