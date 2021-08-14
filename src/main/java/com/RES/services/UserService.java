package com.RES.services;

import com.RES.Dao.UserDao;
import com.RES.models.UserRole;
import com.RES.models.Users;
// import com.example.models.User;

import Exceptions.InvalidCredentialsException;
import Exceptions.UserDoesNotExistException;
import Exceptions.UserNameAlreadyExistsException;
import logging.Logging;
//import com.RES.Dao.UsersDao;

public class UserService {

private UserDao uDao;
	
	public UserService(UserDao u) {
		this.uDao = u;
	}
	
	public Users signUp(String first, String last, String email, String password ,UserRole RembRole)throws UserNameAlreadyExistsException {
		Users u = new Users(first, last, email, password, RembRole);
		uDao.Insert(u);
		Logging.logger.warn("User sighnedUp");
	    return u;
	    
	}
	
	public Users signIn(String username, String password) throws UserDoesNotExistException, InvalidCredentialsException{
		
		System.out.println("In uServ");
		System.out.println(username);
		System.out.println(password);
		Users u = uDao.selectByUsername(username);
		System.out.println(u);
		if(u==null) {
			Logging.logger.warn("User tried logging in that does not exist");
			throw new UserDoesNotExistException();
		}
		if(!u.getPassword().equals(password)) {
			Logging.logger.warn("User tried to login with invalid credentials");
			throw new InvalidCredentialsException();
		}
		else {
			Logging.logger.info("User was logged in");
			return u;
		}
	}
	
	public Users getUsersById(int userid) {
		return uDao.selectByUserId(userid);
	}
	public Users getAuthor(int author) {
		return uDao.getAuthor(author);
	}
	
	
	
}
