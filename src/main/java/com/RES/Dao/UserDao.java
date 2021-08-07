package com.RES.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ERS.Utils.HibernateUtils;
import com.RES.models.UserRole;
import com.RES.models.Users;
//import com.example.models.User;
//import com.example.utils.HibernateUtil;

public class UserDao {
	
   public UserDao() {
		super();
			}

public void Insert(Users u) {
	   Session ses = HibernateUtils.getSession();
		Transaction tx = ses.beginTransaction();
		ses.save(u);
		tx.commit();
   }
public void Insert(UserRole ur) {
	   Session ses = HibernateUtils.getSession();
		Transaction tx = ses.beginTransaction();
		ses.save(ur);
		tx.commit();
}

public void updateUser(Users U) {
	Session ses = HibernateUtils.getSession();
	Transaction tx = ses.beginTransaction();
	ses.update(U);
	tx.commit();
}
public Users selectByUserId(int userId) {
	Session ses = HibernateUtils.getSession();
	Users user = ses.get(Users.class, userId);
	return user;
}

@SuppressWarnings("deprecation")
public Users selectByUsername(String userName) {
	Session ses = HibernateUtils.getSession();
	Users u = ses.createQuery("from Users where userName=:userName", Users.class).setString("userName", userName).uniqueResult();
	//Users user = ses.get(Users.class, userName);
	return u;
	
	
}

public List<Users> selectAllUsers(){
	Session ses = HibernateUtils.getSession();
	List<Users> uList = ses.createQuery("from Users", Users.class).list();
	return uList;
}

public UserRole updateUser(String userRole) {
	Session ses = HibernateUtils.getSession();
	UserRole ur = ses.get(UserRole.class, userRole);
	ses.update(ur);
	return ur;
}
}
