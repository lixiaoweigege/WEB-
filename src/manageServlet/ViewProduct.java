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
import net.sf.json.JSONArray;
import service.ProductService;

/**
 * Servlet implementation class ViewProduct
 */
@WebServlet("/ViewProduct")
public class ViewProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductService service=new ProductService();
		
		try {
			List<Product> ps=service.listAll();
			request.setAttribute("ps", ps);
			request.getRequestDispatcher("manage/viewproduct.jsp").forward(request, response);
			//String josnstring=JSONArray.fromObject(ps).toString();
			//System.out.println(josnstring);
			//response.getWriter().write(josnstring);
			//System.out.println(josnstring);
		} catch (FindProductByIdException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
