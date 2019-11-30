package servlet;

import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.mchange.v2.codegen.bean.BeangenUtils;

import domain.UserBean;
import exception.RegisterException;
import service.UserService;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1У����֤��
		String userCode=request.getParameter("userCode");
		String serverCode=(String) request.getSession().getAttribute("checkcode_session");
		if(!serverCode.equalsIgnoreCase(userCode)) {
			request.setAttribute("codeError","��֤�벻��ȷ");
			request.getRequestDispatcher("register.jsp").forward(request, response);
			return;
		}
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String gender=request.getParameter("gender");
		String email=request.getParameter("email");
	    String instroduce=request.getParameter("instroduce");
		String actioncode=request.getParameter("username");
		
		//2��װ���ݵ�UserBean
	UserBean user=new UserBean();
		user.setUsername(username);
		user.setPassword(password);
		user.setGender(gender);
		user.setEmail(email);
		user.setInstroduce(instroduce);
	
		//3����service�����ע�����
		UserService service=new UserService();
		try {//ע��ɹ�
			service.register(user);
			//��ת���ɹ�ҳ��
			response.sendRedirect("head.jsp");
		} catch (RegisterException e) {
			// TODO �Զ����ɵ� catch ��
			String error=e.getMessage();
			response.getWriter().write(error);
		}
	}

}
