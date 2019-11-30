package manageServlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Product;
import exception.FindProductByIdException;
import service.ProductService;

/**
 * Servlet implementation class FindProductByCondtion
 */
@WebServlet("/FindProductByCondtion")
public class FindProductByCondtion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		String name=request.getParameter("name");
		String category=request.getParameter("category");
		String minprice=request.getParameter("minprice");
		String maxprice=request.getParameter("maxprice");
		
		ProductService service=new ProductService();
		
			List<Product> ps = null;
			try {
				ps = service.FindProductByCondtion(id,name,category,minprice,maxprice);
			
			} catch (FindProductByIdException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			request.setAttribute("ps", ps);
			
			request.getRequestDispatcher("manage/productManage.jsp").forward(request, response);
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
