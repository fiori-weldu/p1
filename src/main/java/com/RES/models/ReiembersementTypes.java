package com.RES.models;

import java.util.ArrayList;
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

//import com.example.model.SuperPrison;
@Entity
@Table
public class ReiembersementTypes {
	@Id
	@Column(name = "reim_type_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Id;
	@Column(name = "reimb_type")
	private String reimb_Type;
	@OneToMany(mappedBy = "RembType", fetch = FetchType.LAZY)
	private List<Reiembersement> reimList = new ArrayList<Reiembersement>();
	
	public ReiembersementTypes() {
		super();
	}

	
public ReiembersementTypes(int id, String reimb_Type) {
	super();
	Id = id;
	this.reimb_Type = reimb_Type;
}
   

	public ReiembersementTypes(String reimb_Type) {
	super();
	this.reimb_Type = reimb_Type;
}


	public ReiembersementTypes(int id, String reimb_Type, List<Reiembersement> reimList) {
		super();
		Id = id;
		this.reimb_Type = reimb_Type;
		this.reimList = reimList;
	}

	public ReiembersementTypes(String reimb_Type, List<Reiembersement> reimList) {
		super();
		this.reimb_Type = reimb_Type;
		this.reimList = reimList;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getReimb_Type() {
		return reimb_Type;
	}

	public void setReimb_Type(String reimb_Type) {
		this.reimb_Type = reimb_Type;
	}

	public List<Reiembersement> getReimList() {
		return reimList;
	}

	public void setReimList(List<Reiembersement> reimList) {
		this.reimList = reimList;
	}

	@Override
	public String toString() {
		return "ReiembersementTypes [Id=" + Id + ", reimb_Type=" + reimb_Type + ", reimList=" + reimList + "]";
	}
	
	
}
