package pl.coderslab.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.dao.ExcerciseDao;
import pl.coderslab.dao.SolutionDao;
import pl.coderslab.dao.UserDao;
import pl.coderslab.model.Excercise;
import pl.coderslab.model.Interaction;
import pl.coderslab.model.Solution;
import pl.coderslab.model.User;

@WebServlet("/assignextouser")
public class AssignExToUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Excercise> allExcercises = ExcerciseDao.findAll();
		request.setAttribute("allExcercises", allExcercises);
		List<User> allUsers = UserDao.findAll();
		request.setAttribute("allUsers", allUsers);
		List<Solution> allSolutions = SolutionDao.findAll();
		request.setAttribute("allSolutions", allSolutions);
		getServletContext().getRequestDispatcher("/views/assignextouser.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Long userId = Long.parseLong(request.getParameter("user_id"));
		int excerciseId = Integer.parseInt(request.getParameter("ex_id"));
		Solution solution = new Solution(Interaction.getCurrentDateSql(), null, "", excerciseId, userId);
		SolutionDao.saveToDB(solution);
		response.sendRedirect("./assignextouser");
	}
}
