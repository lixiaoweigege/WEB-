package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.User;

import domain.UserBean;
import service.UserService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1��ȡ�û���������
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		//2����service�ж�
		UserService service=new UserService();
		
	
			
			try {
				UserBean user= service.login(username,password);
				if(user==null) {
					request.setAttribute("login_message", "�û������������");
					request.getRequestDispatcher("login.jsp").forward(request, response);
					return;
					
				}else{
					request.getSession().setAttribute("user", user);
					String role=user.getRole();
					if("��ͨ�û�".equals(role)) {
						
						response.sendRedirect("account.jsp");
						
					}else {
						response.sendRedirect("manage/product.jsp");
					}
				}
			} catch (SQLException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
			
		
		
		
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
