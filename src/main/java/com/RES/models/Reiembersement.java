package com.RES.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
@Entity
@Table(name="Reiembersement")
public class Reiembersement {
	@Id
	@Column(name = "reimb_id", nullable = false, unique = true)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int reimbursement_id;
	
	@Column(name = "reimb_amount", nullable = false)
	private int reimbursement_amt;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "reimb_submit", nullable = false)
	private Date reimbursement_submt;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "reimb_resolve", nullable = false)
	private Date reimbursement_resolv;
	
	@Column(name = "reimb_description")
	private String reimbursement_despt;
//	@Column(name = "reimb_reciept", nullable = false)
//	private String reimbursement_receipt;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "Reimbursements_Author", referencedColumnName = "user_id")
	private Users RemAuthor;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "Reimbursements_Resolver", referencedColumnName = "user_id")
	private Users RemResolver;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="Etype_FK")//name of the new table
	private ReiembersementTypes RembType;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "Estatus_FK")
	private ReiembersementStatus ReimbStatus;

	public Reiembersement() {
		super();
	}



	public Reiembersement(int reimbursement_amt, String reimbursement_despt, Users remAuthor, Users remResolver,
			ReiembersementTypes rembType, ReiembersementStatus reimbStatus) {
		super();
		this.reimbursement_amt = reimbursement_amt;
		this.reimbursement_despt = reimbursement_despt;
		RemAuthor = remAuthor;
		RemResolver = remResolver;
		RembType = rembType;
		ReimbStatus = reimbStatus;
	}

	public Reiembersement(Users remAuthor, int reimbursement_amt2, Date reimbursement_submt2,
			String reimbursement_despt2, ReiembersementTypes rembType2, ReiembersementStatus reimbStatus2) {
		// TODO Auto-generated constructor stub
	}


	public Reiembersement(int reimbursement_amt, Date reimbursement_submt, String reimbursement_despt, Users remAuthor,
			ReiembersementTypes rembType, ReiembersementStatus reimbStatus) {
		super();
		this.reimbursement_amt = reimbursement_amt;
		this.reimbursement_submt = reimbursement_submt;
		this.reimbursement_despt = reimbursement_despt;
		RemAuthor = remAuthor;
		RembType = rembType;
		ReimbStatus = reimbStatus;
	}



	public Reiembersement(int reimbursement_id, int reimbursement_amt, Date reimbursement_submt,
			Date reimbursement_resolv, String reimbursement_despt, Users RemAuthor,
			Users RemResolver, ReiembersementTypes rembType, ReiembersementStatus ReimbStatus) {
		super();
		this.reimbursement_id = reimbursement_id;
		this.reimbursement_amt = reimbursement_amt;
		this.reimbursement_submt = reimbursement_submt;
		this.reimbursement_resolv = reimbursement_resolv;
		this.reimbursement_despt = reimbursement_despt;
		//this.reimbursement_receipt = reimbursement_receipt;
		this.RemAuthor = RemAuthor;
		this.RemResolver = RemResolver;
		RembType = rembType;
		ReimbStatus = ReimbStatus;
	}




	public Reiembersement(Users u, int reimbAmount, String reimbSubmitted, String reimbDescription, Users author,
			ReiembersementTypes ersType) {
		// TODO Auto-generated constructor stub
	}



	public Reiembersement(Users rAuthor, int amt, String descp, ReiembersementTypes type) {
		// TODO Auto-generated constructor stub
	}



	public int getReimbursement_id() {
		return reimbursement_id;
	}

	public void setReimbursement_id(int reimbursement_id) {
		this.reimbursement_id = reimbursement_id;
	}

	public int getReimbursement_amt() {
		return reimbursement_amt;
	}

	public void setReimbursement_amt(int reimbursement_amt) {
		this.reimbursement_amt = reimbursement_amt;
	}

	public Date getReimbursement_submt() {
		return reimbursement_submt;
	}

	public void setReimbursement_submt(Date reimbursement_submt) {
		this.reimbursement_submt = reimbursement_submt;
	}

	public Date getReimbursement_resolv() {
		return reimbursement_resolv;
	}

	public void setReimbursement_resolv(Date reimbursement_resolv) {
		this.reimbursement_resolv = reimbursement_resolv;
	}

	public String getReimbursement_despt() {
		return reimbursement_despt;
	}

	public void setReimbursement_despt(String reimbursement_despt) {
		this.reimbursement_despt = reimbursement_despt;
	}

//	public String getReimbursement_receipt() {
//		return reimbursement_receipt;
//	}
//
//	public void setReimbursement_receipt(String reimbursement_receipt) {
//		this.reimbursement_receipt = reimbursement_receipt;
//	}

	public Users getRemAuthor() {
		return RemAuthor;
	}

	public void setRemAuthor(Users RemAuthor) {
		this.RemAuthor = RemAuthor;
	}

	public Users getRemResolver() {
		return RemResolver;
	}

	public void setRemResolver(Users RemResolver) {
		this.RemResolver = RemResolver;
	}

	public ReiembersementTypes getRembType() {
		return RembType;
	}

	public void setRembType(ReiembersementTypes rembType) {
		RembType = rembType;
	}

	public ReiembersementStatus getReimbStatus() {
		return ReimbStatus;
	}

	public void setReimbStatus(ReiembersementStatus ReimbStatus) {
		ReimbStatus = ReimbStatus;
	}



	@Override
	public String toString() {
		return "Reiembersement [reimbursement_id=" + reimbursement_id + ", reimbursement_amt=" + reimbursement_amt
				+ ", reimbursement_submt=" + reimbursement_submt + ", reimbursement_resolv=" + reimbursement_resolv
				+ ", reimbursement_despt=" + reimbursement_despt + ", RemAuthor=" + RemAuthor + ", RemResolver="
				+ RemResolver + ", RembType=" + RembType + ", ReimbStatus=" + ReimbStatus + "]";
	}

	//@Override
//	public String toString() {
//		return "Reiembersement [reimbursement_id=" + reimbursement_id + ", reimbursement_amt=" + reimbursement_amt
//				+ ", reimbursement_submt=" + reimbursement_submt + ", reimbursement_resolv=" + reimbursement_resolv
//				+ ", reimbursement_despt=" + reimbursement_despt 
//				+ ", RemAuthor=" + RemAuthor + ", RemResolver=" + RemResolver + ", RembType=" + RembType + ", ReimbStatus=" + ReimbStatus
//				+ "]";
//	}
//	
	
	
}
