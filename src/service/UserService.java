package service;

import java.sql.SQLException;

import org.apache.catalina.User;

import dao.UserDao;
import domain.UserBean;
import exception.RegisterException;

public class UserService {
/*
 * 
 * ע�᷽��
 */
	//����DAO�������ݿ�
			UserDao dao=new UserDao();
	public void register(UserBean user) throws RegisterException {		
		try {
			dao.addUser(user);
		} catch (SQLException e) {
			//ע��ʧ��
			e.printStackTrace();
			throw new RegisterException("ע��ʧ��");
			
		}
	}
/*
 * ��½�ж�
 */
	public UserBean login(String username, String password) throws SQLException {
		
		
		return dao.findUser(username,password);
	}
}
