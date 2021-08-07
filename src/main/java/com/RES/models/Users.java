package com.RES.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
//import javax.persistence.OneToMany;
//import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties(value= {"hibernateLazyInitializer", "handler"})
@Table(name="ERS_USERS")
public class Users {
	
	@Id
	@Column(name="user_id", unique = true)
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int Id;
	@Column(name="first_name",nullable=false)
    private String firstName;
	@Column(name="last_name", nullable=false)
    private String lastName;
	@Column(name="email", nullable=false)
    private String email;
	@Column(name="user_name", nullable=false)
    private String userName;
	@Column(name="password", nullable=false)
    private String Password;
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="Erole_FK")//name of the new table
	private UserRole RembRole;
	@OneToMany(mappedBy = "RemAuthor", fetch = FetchType.LAZY)
	private List<Reiembersement> RempList = new ArrayList<Reiembersement>();
	@OneToMany(mappedBy = "RemResolver", fetch = FetchType.LAZY)
	private List<Reiembersement> RmanagerList = new ArrayList<Reiembersement>();
	
	public Users() {
		super();
	}

	public Users(String firstName, String lastName, String email, String password,UserRole RembRole) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.userName = firstName + lastName + (new Random().nextInt(9000) + 1000);
		Password = password;
		//RembRole = RembRole;
	}

	

	public Users(int id, String firstName, String lastName, String email, String userName, String password,
			UserRole rembRole) {
		super();
		Id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.userName = userName;
		Password = password;
		RembRole = rembRole;
	}

//	public Users(int id, String firstName, String lastName, String email, String userName, String password,
//			UserRole RembRole, List<Reiembersement> rempList) {
//		super();
//		Id = id;
//		this.firstName = firstName;
//		this.lastName = lastName;
//		this.email = email;
//		this.userName = userName;
//		Password = password;
//		RembRole = RembRole;
//		RempList = rempList;
//	}

	
	
	
	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	

	public UserRole getRembRole() {
		return RembRole;
	}

	public void setRembRole(UserRole rembRole) {
		RembRole = rembRole;
	}

	public List<Reiembersement> getRempList() {
		return RempList;
	}

	public void setRempList(List<Reiembersement> rempList) {
		RempList = rempList;
	}

	public List<Reiembersement> getRmanagerList() {
		return RmanagerList;
	}

	public void setRmanagerList(List<Reiembersement> rmanagerList) {
		RmanagerList = rmanagerList;
	}

	@Override
	public String toString() {
		return "Users [Id=" + Id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", userName=" + userName + ", Password=" + Password + ", RembRole=" + RembRole + "]";
	}
	
	
	
	
}
