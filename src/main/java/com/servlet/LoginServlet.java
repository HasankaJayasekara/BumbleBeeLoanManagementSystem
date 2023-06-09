package com.servlet;

import com.conn.DBConnect;
import com.dao.UserDAO;
import com.entity.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/user-login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {
			String email = request.getParameter("login-email");
			String password = request.getParameter("login-password");

			UserDAO udao = new UserDAO(DBConnect.getConn());
			User user = udao.userLogin(email, password);
			if (user != null) {
				request.getSession().setAttribute("auth", user);
//				System.out.print("user logged in");
				response.sendRedirect("CustomerIndex.jsp");
			} else {
				out.println("there is no user");
			}

		} catch(Exception e){
           e.printStackTrace();
       } 

	}
}
