package utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;



public class DataSourceUtils {
	
	//1�õ�����Դ����
public  static DataSource ds=new ComboPooledDataSource();
//2�ṩ��̬�����ĵõ�����Դ����
public static DataSource getDataSource() {
	return ds;
}
//3��������֤�����������ͬһ����
private static ThreadLocal<Connection> tl=new ThreadLocal<Connection>(); 
//4�ṩ�õ�Ψһ�����ݶ���
public static Connection getConnection() throws SQLException {
	Connection con=tl.get();
	if(con==null) {
		con=ds.getConnection();
		tl.set(con);
	}
	return con;
}

//��������
@SuppressWarnings("null")
public static void startTrasaction() throws SQLException {
	Connection con=getConnection();
	if(con==null) {
		con.setAutoCommit(false);
	}
}
//�ͷŲ��ر�connection����������
@SuppressWarnings("null")
public static void releaseaAndCloseConnection() throws SQLException {
	Connection con=getConnection();
	if(con==null) {
		con.commit();
		tl.remove();
		con.close();
	}
}
//����ع�
@SuppressWarnings("null")
public static void rollback() throws SQLException {
	Connection con=getConnection();
	if(con==null) {
		con.rollback();
		
	}
}
}