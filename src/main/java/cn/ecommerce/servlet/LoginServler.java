package cn.ecommerce.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.ecommerce.connection.DbCon;
import cn.ecommerce.dao.UtilisateurDao;
import cn.ecommerce.model.Utilisateur;

/**
 * Servlet implementation class LoginServler
 */
@WebServlet("/ut-login")
public class LoginServler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("login.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		try(PrintWriter out = response.getWriter()){
			String email = request.getParameter("login-email");
			String password = request.getParameter("login-password");
			
			try {
				UtilisateurDao utDao = new UtilisateurDao(DbCon.getConnection());
				Utilisateur utilisateur = utDao.login_ut(email, password);
				
				if(utilisateur != null) {
					request.getSession().setAttribute("auth", utilisateur);
					response.sendRedirect("index.jsp");
				}
				else {
					out.print("user login failed");
				}
				
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			
		}
	}

}
