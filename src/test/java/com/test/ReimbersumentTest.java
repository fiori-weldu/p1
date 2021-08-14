package com.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.stubbing.OngoingStubbing;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.RES.Dao.ReimbersementDao;
import com.RES.Dao.UserDao;
import com.RES.models.Users;
import com.RES.models.Reiembersement;
import com.RES.models.ReiembersementStatus;
import com.RES.models.ReiembersementTypes;
import com.RES.models.UserRole;
import com.RES.services.ReimbersementServices;
import com.RES.services.UserService;

import Exceptions.InvalidCredentialsException;
import Exceptions.UserDoesNotExistException;

public class ReimbersumentTest {
	@InjectMocks
	public UserService uServ;
	public ReimbersementServices rServ;
	@Mock
	public UserDao uDao;
	public ReimbersementDao rDao;
	
	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testSignIn() {
		UserRole UR1=new UserRole("Employee");
		UserRole UR2=new UserRole("Manager");

		Users u = new Users(34,"Fiori", "weldu", "Fioritetemke@gmail.com","fiorina23","password",UR1);
		Users not = new Users(34,"Fiori", "weldu", "Fioritetemke@gmail.com","fiorina23","password",UR1);
		
		when(uDao.selectByUsername(anyString())).thenReturn(u);
		
		
		Users loggedIn = uServ.signIn("fiorina23", "password");
		
		
		assertEquals(u.getId(), loggedIn.getId());
	}
//	
//	@Test(expected = UserDoesNotExistException.class)
//	public void testInvalidUsername() {
//		UserRole UR1=new UserRole("Employee");
//		UserRole UR2=new UserRole("Manager");
//		Users u1 = new Users(1, "test", "user",  "test@email.com","testuser","testpass", UR1);
//		Users not = new Users(0, "test", "user", "test@mail.com", "testuser","testpass", UR2);
//		
//		when(uDao.selectByUsername(anyString())).thenReturn(not);
//		
//		Users loggedIn = uServ.signIn("testuser", "testpass");
//	}
	
	@Test(expected = InvalidCredentialsException.class)
	public void testInvalidPassword() {
		UserRole UR1=new UserRole("Employee");
		UserRole UR2=new UserRole("Manager");
		Users u1 = new Users(1, "test", "user",  "test@email.com","testuser", "testpass",UR1);
		Users not = new Users(1, "test", "user", "test@mail.com", "testuser", "wrongpass",UR2);
		
		when(uDao.selectByUsername(anyString())).thenReturn(not);
		
		uServ.signIn("testuser", "testpass");
	}
	

	
	
}
