package pl.coderslab.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.dao.SolutionDao;
import pl.coderslab.dao.UserDao;
import pl.coderslab.model.Solution;
import pl.coderslab.model.User;

@WebServlet("/userdetails")
public class UserDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		long userId = Long.parseLong(request.getParameter("id"));

		User user = UserDao.findById(userId);
		List<Solution> userSolutions = SolutionDao.findAllByUserId(userId);

		request.setAttribute("userInDetail", user);
		request.setAttribute("userSolutions", userSolutions);

		getServletContext().getRequestDispatcher("/views/userdetails.jsp").forward(request, response);
	}

}
