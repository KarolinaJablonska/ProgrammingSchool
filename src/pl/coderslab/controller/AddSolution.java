package pl.coderslab.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pl.coderslab.dao.ExcerciseDao;
import pl.coderslab.dao.SolutionDao;
import pl.coderslab.model.Excercise;
import pl.coderslab.model.Interaction;
import pl.coderslab.model.Solution;

@WebServlet("/addsolution")
public class AddSolution extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Solution solutionToAdd;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		if (session.getAttribute("loggedIn") != null) {
			boolean loggedIn = (boolean) session.getAttribute("loggedIn");
			if (loggedIn) {
				long userId = Long.parseLong(request.getParameter("user_id"));
				int excerciseId = Integer.parseInt(request.getParameter("ex_id"));
				Excercise excerciseToSolve = ExcerciseDao.findById(excerciseId);
				solutionToAdd = SolutionDao.findByExcerciseAndUserId(excerciseId, userId);
				request.setAttribute("solution", solutionToAdd);
				request.setAttribute("excercise", excerciseToSolve);
				getServletContext().getRequestDispatcher("/views/addsolution.jsp").forward(request, response);
			}
		} else {
			response.sendRedirect("./userauthentication");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String description = request.getParameter("description");

		solutionToAdd.setUpdated(Interaction.getCurrentDateSql());
		solutionToAdd.setDescription(description);
		SolutionDao.saveToDB(solutionToAdd);
		response.sendRedirect("./userpanel");
	}

}
