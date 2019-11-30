package servlet;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.VerifyCode;

/**
 * Servlet implementation class CheckImageServlet
 */
@WebServlet("/imageCode")
public class CheckImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("image/jpeg;utf-8");
		VerifyCode code = new VerifyCode();
		BufferedImage image = code.createImage();
		String str=code.getText();
		// 将验证码内容保存session
				request.getSession().setAttribute("checkcode_session", str);
		ImageIO.write(image,"jpg",response.getOutputStream());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
