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

@WebServlet("/editprofile")
public class EditProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private User userToEdit;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		if (session.getAttribute("loggedIn") != null) {
			boolean loggedIn = (boolean) session.getAttribute("loggedIn");
			if (loggedIn) {
				getServletContext().getRequestDispatcher("/views/editprofile.jsp").forward(request, response);
			}
		} else {
			response.sendRedirect("./userauthentication");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		long userId = (long) session.getAttribute("userId");
		userToEdit = UserDao.findById(userId);

		String email = request.getParameter("email");
		String password = request.getParameter("password");
		userToEdit.setEmail(email);
		userToEdit.setHashedPassword(password);
		UserDao.saveToDB(userToEdit);
		response.sendRedirect("./userpanel");
	}
}
