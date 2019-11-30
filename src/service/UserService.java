package service;

import java.sql.SQLException;

import org.apache.catalina.User;

import dao.UserDao;
import domain.UserBean;
import exception.RegisterException;

public class UserService {
/*
 * 
 * ×¢²á·½·¨
 */
	//ÒÀÀµDAO²Ù×÷Êý¾Ý¿â
			UserDao dao=new UserDao();
	public void register(UserBean user) throws RegisterException {		
		try {
			dao.addUser(user);
		} catch (SQLException e) {
			//×¢²áÊ§°Ü
			e.printStackTrace();
			throw new RegisterException("×¢²áÊ§°Ü");
			
		}
	}
/*
 * µÇÂ½ÅÐ¶Ï
 */
	public UserBean login(String username, String password) throws SQLException {
		
		
		return dao.findUser(username,password);
	}
}
