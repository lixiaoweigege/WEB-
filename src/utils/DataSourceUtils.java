package utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;



public class DataSourceUtils {
	
	//1得到数据源对象
public  static DataSource ds=new ComboPooledDataSource();
//2提供静态方法的得到数据源对象
public static DataSource getDataSource() {
	return ds;
}
//3处理事务保证事物里面的是同一对象
private static ThreadLocal<Connection> tl=new ThreadLocal<Connection>(); 
//4提供得到唯一的数据对象
public static Connection getConnection() throws SQLException {
	Connection con=tl.get();
	if(con==null) {
		con=ds.getConnection();
		tl.set(con);
	}
	return con;
}

//开启事务
@SuppressWarnings("null")
public static void startTrasaction() throws SQLException {
	Connection con=getConnection();
	if(con==null) {
		con.setAutoCommit(false);
	}
}
//释放并关闭connection，结束事务
@SuppressWarnings("null")
public static void releaseaAndCloseConnection() throws SQLException {
	Connection con=getConnection();
	if(con==null) {
		con.commit();
		tl.remove();
		con.close();
	}
}
//事务回滚
@SuppressWarnings("null")
public static void rollback() throws SQLException {
	Connection con=getConnection();
	if(con==null) {
		con.rollback();
		
	}
}
}