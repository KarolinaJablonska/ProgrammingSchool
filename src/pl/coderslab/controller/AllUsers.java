package pl.coderslab.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.dao.UserDao;
import pl.coderslab.model.User;

@WebServlet("/allusers")
public class AllUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<User> allUsers = UserDao.findAll();
		request.setAttribute("allUsers", allUsers);
		getServletContext().getRequestDispatcher("/views/allusers.jsp").forward(request, response);
	}
}
