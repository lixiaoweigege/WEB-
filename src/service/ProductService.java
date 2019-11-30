package service;

import java.sql.SQLException;
import java.util.List;

import dao.ProductDao;
import domain.Product;
import exception.FindProductByIdException;

public class ProductService {
	ProductDao dao=new ProductDao();
	public Product fingProductById(String id) throws FindProductByIdException {
		// TODO �Զ����ɵķ������
		
		Product product;
		try {
			product = dao.fingProductById(id);
			return product;
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
			throw new FindProductByIdException("����ID������Ʒʧ��");
		}		
		
	}

	public List<Product> listAll() throws FindProductByIdException {
		// TODO �Զ����ɵķ������
		
			try {
				return dao.listAll();
			} catch (SQLException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
				throw new FindProductByIdException("��ѯʧ��");
			}
		
		
		
	}

	public List<Product> FindProductByCondtion(String id, String name, String category, String minprice, String maxprice) throws FindProductByIdException {
		// TODO �Զ����ɵķ������
		List<Product> ps=null;
		try {
			ps=dao.FindProductByCondtion(id,name,category,minprice,maxprice);
			
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		
		}
		
		return ps;
	}

}
