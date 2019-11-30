package dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import domain.UserBean;
import utils.DataSourceUtils;

public class UserDao {

	/**
	 * ע�᷽��
	 * @param user
	 * @throws SQLException
	 */
	public void addUser(UserBean user) throws SQLException {
		// TODO �Զ����ɵķ������
		
		String sql="insert into user(username,password,gender,email,instroduce)"
				+ " values(?,?,?,?,?)";
		QueryRunner runner=new QueryRunner(DataSourceUtils.getDataSource());
		int row=runner.update(sql, user.getUsername(),user.getPassword(),user.getGender(),
				user.getEmail(),user.getInstroduce());
		if(row==0) {
			throw new RuntimeException();
		}
	}
/*	public static void main(String[] args) throws SQLException {
		String sql="insert into user(username,password,gender,email,instroduce)"
				+ " values('1','1','1','1','1')";
		QueryRunner runner=new QueryRunner(DataSourceUtils.getDataSource());
		runner.update(sql);
		System.out.println("�ɹ�");
	}*/

	public UserBean findUser(String username, String password) throws SQLException {
		// TODO �Զ����ɵķ������
		String sql="select* from user where username=? and password=?";
		QueryRunner runner=new QueryRunner(DataSourceUtils.getDataSource());
		return runner.query(sql, new BeanHandler<UserBean>(UserBean.class),username,password);
		
	}

}
