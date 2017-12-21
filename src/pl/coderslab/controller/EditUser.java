package pl.coderslab.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.dao.UserDao;
import pl.coderslab.model.User;

@WebServlet("/edituser")
public class EditUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private User userToEdit;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		long userId = Long.parseLong(request.getParameter("id"));
		userToEdit = UserDao.findById(userId);
		request.setAttribute("user", userToEdit);
		getServletContext().getRequestDispatcher("/views/edituser.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int person_group_id = Integer.parseInt(request.getParameter("person_group_id"));
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		userToEdit.setAttributes(person_group_id, username, email, password);
		UserDao.saveToDB(userToEdit);
		response.sendRedirect("./manageusers");
	}
}
