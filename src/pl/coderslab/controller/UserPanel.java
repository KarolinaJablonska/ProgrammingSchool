package pl.coderslab.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pl.coderslab.dao.ExcerciseDao;
import pl.coderslab.dao.SolutionDao;
import pl.coderslab.dao.UserDao;
import pl.coderslab.model.Excercise;
import pl.coderslab.model.Solution;
import pl.coderslab.model.User;

@WebServlet("/userpanel")
public class UserPanel extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		if (session.getAttribute("loggedIn") != null) {
			boolean loggedIn = (boolean) session.getAttribute("loggedIn");
			if (loggedIn) {
				long userId = (long) session.getAttribute("userId");
				User user = UserDao.findById(userId);
				List<Excercise> allSolved = ExcerciseDao.findSolvedByUserId(userId);
				List<Excercise> allUnsolved = ExcerciseDao.findUnsolvedByUserId(userId);
				List<Solution> allUserSolutions = SolutionDao.findAllByUserId(userId);
				session.setAttribute("user", user);
				session.setAttribute("allSolvedExcercises", allSolved);
				session.setAttribute("allUnsolvedExcercises", allUnsolved);
				session.setAttribute("allUserSolutions", allUserSolutions);
				getServletContext().getRequestDispatcher("/views/userpanel.jsp").forward(request, response);
			}
		} else {
			response.sendRedirect("./userauthentication");
		}
	}
}
