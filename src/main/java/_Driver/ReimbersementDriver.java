package _Driver;

import java.util.List;
import java.util.Scanner;

import org.apache.tomcat.jni.User;

import com.RES.Dao.ReimbersementDao;
import com.RES.Dao.UserDao;
import com.RES.models.Reiembersement;
import com.RES.models.ReiembersementStatus;
import com.RES.models.ReiembersementTypes;
import com.RES.models.UserRole;
import com.RES.models.Users;
import com.RES.services.UserService;

public class ReimbersementDriver {
	public static void main(String[] args) {
	UserDao uDao= new UserDao();
	UserService uServ=new UserService(uDao);
	ReimbersementDao remDao=new ReimbersementDao();
	 
	ReiembersementStatus RS1=new ReiembersementStatus("Pending");
	remDao.Insert(RS1);
	ReiembersementStatus RS2=new ReiembersementStatus("Apprroved");
	remDao.Insert(RS2);
	ReiembersementStatus RS3=new ReiembersementStatus("Denied");
	remDao.Insert(RS3);
	
	ReiembersementTypes RT1=new ReiembersementTypes("Food");
	remDao.Insert(RT1);
	ReiembersementTypes RT2=new ReiembersementTypes("Travel");
	remDao.Insert(RT2);
	ReiembersementTypes RT3=new ReiembersementTypes("Lodging");
	remDao.Insert(RT3);
	ReiembersementTypes RT4=new ReiembersementTypes("Others");
	remDao.Insert(RT4);
	
	UserRole UR1=new UserRole("Employee");
	UserRole UR2=new UserRole("Manager");
	uDao.Insert(UR1);
	uDao.Insert(UR2);
	
 Users user1=new Users("Fiori", "weldu", "Fioritetemke@gmail.com","password",UR1);
 uDao.Insert(user1);
 Users user2=new Users("Winta", "Tetemke", "Wintaw3@gmail.com", "password2",UR2);
 uDao.Insert(user2);
 Users user3=new Users("Samson","teklay","Samson34@gmail.com","samson34@gmail.com",UR1);
 uDao.Insert(user3);
 Users user4=new Users("Bereket","Teklay","bereket@gmail.com","Password43@gmail.com",UR2);
 uDao.Insert(user4);
 
 
 
   Reiembersement Rem1=new Reiembersement(400,"Food scan field",user1,user2,RT1,RS1);
   remDao.Insert(Rem1);
   Reiembersement Rem2=new Reiembersement(1000,"Plane ticket to New York",user1,user2,RT2,RS1);
   remDao.Insert(Rem2);
   Reiembersement Rem3=new Reiembersement(500,"Rent for room scan Vegas",user3,user4,RT3,RS1);
   remDao.Insert(Rem3);
   Reiembersement Rem4=new Reiembersement(300,"Rent for room scan london",user3,user4,RT3,RS1);
   remDao.Insert(Rem4);
   
   
  List<Users> u1=uDao.selectAllUsers();
  System.out.println(u1);
 Users u=uServ.signIn(user1.getUserName(), "password");
 System.out.println(u);
      
	
	}
	}
