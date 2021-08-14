package com.RES.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="REimbersument_Status")
public class ReiembersementStatus {
	@Id
	@Column(name = "reim_status_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int statusId;
	
	@Column(name = "reimb_status")
	private String reimb_status;
	@OneToMany(mappedBy = "ReimbStatus", fetch = FetchType.LAZY)
	
	private List<Reiembersement> reimList = new ArrayList<Reiembersement>();

	public ReiembersementStatus() {
		super();
	}

	
	public ReiembersementStatus(String reimb_status) {
		super();
		this.reimb_status = reimb_status;
	}


	public ReiembersementStatus(int statusId, String reimb_status) {
		super();
		this.statusId = statusId;
		this.reimb_status = reimb_status;
	}


	public ReiembersementStatus(String reimb_status, List<Reiembersement> reimList) {
		super();
		this.reimb_status = reimb_status;
		this.reimList = reimList;
	}

	public ReiembersementStatus(int statusId, String reimb_status, List<Reiembersement> reimList) {
		super();
		this.statusId = statusId;
		this.reimb_status = reimb_status;
		this.reimList = reimList;
	}

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public String getReimb_status() {
		return reimb_status;
	}

	public void setReimb_status(String reimb_status) {
		this.reimb_status = reimb_status;
	}

	public List<Reiembersement> getReimList() {
		return reimList;
	}

	public void setReimList(List<Reiembersement> reimList) {
		this.reimList = reimList;
	}

	@Override
	public String toString() {
		return "ReiembersementStatus [statusId=" + statusId + ", reimb_status=" + reimb_status + ", reimList="
				+ reimList + "]";
	}
	
	

}


