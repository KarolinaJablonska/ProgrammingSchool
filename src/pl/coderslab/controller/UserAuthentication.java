package pl.coderslab.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pl.coderslab.dao.UserDao;
import pl.coderslab.model.User;

@WebServlet("/userauthentication")
public class UserAuthentication extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/views/userauthentication.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");
		User user = UserDao.findByEmail(email);

		if (user != null) {
			long userId = user.getId();
			String password = request.getParameter("password");

			if (UserDao.passwordMatches(password, userId)) {
				System.out.println("password matches");
				HttpSession session = request.getSession();

				session.setAttribute("loggedIn", true);
				session.setAttribute("userId", userId);
			}
		}
		response.sendRedirect("./userpanel");
	}
}
