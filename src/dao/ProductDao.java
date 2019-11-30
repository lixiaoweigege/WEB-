package dao;



import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import domain.Product;
import utils.DataSourceUtils;

public class ProductDao {

	public Product fingProductById(String id) throws SQLException{
		// TODO 自动生成的方法存根
		String sql="select* from products where id=?";
		QueryRunner runner=new 	QueryRunner(DataSourceUtils.getDataSource());
		Product product=runner.query(sql,new BeanHandler<Product>(Product.class),id);
		return product;
	}

	public List<Product> listAll() throws SQLException {
		// TODO 自动生成的方法存根
		String sql="select* from products";
		QueryRunner runner=new QueryRunner(DataSourceUtils.getDataSource());
		return runner.query(sql,new BeanListHandler<Product>(Product.class));
	}

	public List<Product> FindProductByCondtion(String id, String name, String category, String minprice,
			String maxprice) throws SQLException {
		// TODO 自动生成的方法存根
		List<Object> list=new ArrayList<Object>();
		String sql="select* from products where 1=1";
		QueryRunner runner=new QueryRunner(DataSourceUtils.getDataSource());
		if(id!=null&&id.trim().length() >0) {
			sql+=" and id=?";
			list.add(id);
		}
		if(name!=null&&name.trim().length() >0) {
			sql+=" and name=?";
			list.add(name);
		}
		if(category!=null&&category.trim().length() >0) {
			sql+=" and category=?";
			list.add(category);
		}
		if(minprice!=null&&minprice.trim().length() >0&&maxprice!=null&&maxprice.trim().length()>0) {
			sql+=" and price between ? and ?";
			list.add(minprice);
			list.add(maxprice);
		}
		Object[] params=list.toArray();
		List<Product> product= runner.query(sql, new BeanListHandler<Product>(Product.class),params);
		return product;
		
	}

}
