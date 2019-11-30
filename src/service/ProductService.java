package service;

import java.sql.SQLException;
import java.util.List;

import dao.ProductDao;
import domain.Product;
import exception.FindProductByIdException;

public class ProductService {
	ProductDao dao=new ProductDao();
	public Product fingProductById(String id) throws FindProductByIdException {
		// TODO 自动生成的方法存根
		
		Product product;
		try {
			product = dao.fingProductById(id);
			return product;
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			throw new FindProductByIdException("根据ID查找商品失败");
		}		
		
	}

	public List<Product> listAll() throws FindProductByIdException {
		// TODO 自动生成的方法存根
		
			try {
				return dao.listAll();
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
				throw new FindProductByIdException("查询失败");
			}
		
		
		
	}

	public List<Product> FindProductByCondtion(String id, String name, String category, String minprice, String maxprice) throws FindProductByIdException {
		// TODO 自动生成的方法存根
		List<Product> ps=null;
		try {
			ps=dao.FindProductByCondtion(id,name,category,minprice,maxprice);
			
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		
		}
		
		return ps;
	}

}
