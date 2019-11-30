package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.UserBean;



/**
 * Servlet implementation class MyAccountServlet
 */
@WebServlet("/MyAccountServlet")
public class MyAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@SuppressWarnings("unlikely-arg-type")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/**
		 * ���ǰ̨ϵͳ�еġ��ҵ��˻��������������������
		 * 1���û�δ��¼�������¼ҳ��
		 * 2���û��ѵ�¼
		 *   a�������û������뵽��̨ϵͳ
		 *   b����ͨ�û�����¼���ҵ��˻�
		 */
		//��session�в�����Ϊ��user���ĻỰ
		UserBean user = (UserBean) request.getSession().getAttribute("user");
		//����ҵ�û����Ϊ��user���ĻỰ��˵���û�û�е�¼����ʱ��ת����¼ҳ��
		if (user == null) {
			response.sendRedirect("login.jsp");
			return;
		}
		//����ǳ����û������뵽������Ǻ�̨����ϵͳ��������뵽��ͨ�û����˻���Ϣҳ��
		if ("�����û�".equals(user.getRole())) {
			response.sendRedirect("foot.jsp");
//			return;
		}else{
			response.sendRedirect("account.jsp");
//			return;
		}
	}
		
		
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
