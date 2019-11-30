package servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.Product;
import exception.FindProductByIdException;
import service.ProductService;

/**
 * Servlet implementation class AddServlet
 */
@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1�����Ʒid
		String id=request.getParameter("id");
		//2����srvice
		ProductService service=new ProductService ();
		try {
			Product p=service.fingProductById(id);
			HttpSession session=request.getSession();
			//3.2��session�л�ȡ���ﳵ����
			@SuppressWarnings("unchecked")
			Map<Product, Integer> cart = (Map<Product, Integer>)session.getAttribute("cart");
			//3.3������ﳵΪnull,˵��û����Ʒ�洢�ڹ��ﳵ�У����������ﳵ
			if (cart == null) {
				cart = new HashMap<Product, Integer>();
			}
			//3.4���ﳵ�������Ʒ
			Integer count = cart.put(p, 1);
			//3.5�����Ʒ������Ϊ�գ�����Ʒ����+1����������µ���Ʒ��Ϣ
			if (count != null) {
				cart.put(p, count + 1);
			}			
			session.setAttribute("cart", cart);
			response.sendRedirect(request.getContextPath() + "/cart.jsp");
			return;
		} catch (FindProductByIdException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
