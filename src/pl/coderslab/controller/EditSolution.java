package pl.coderslab.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pl.coderslab.dao.SolutionDao;
import pl.coderslab.model.Interaction;
import pl.coderslab.model.Solution;

@WebServlet("/editsolution")
public class EditSolution extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Solution solutionToEdit;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		if (session.getAttribute("loggedIn") != null) {
			long userId = (long) session.getAttribute("userId");
			int excerciseId = Integer.parseInt(request.getParameter("ex_id"));
			solutionToEdit = SolutionDao.findByExcerciseAndUserId(excerciseId, userId);
		} else {
			int solutionId = Integer.parseInt(request.getParameter("id"));
			solutionToEdit = SolutionDao.findById(solutionId);
		}

		request.setAttribute("solution", solutionToEdit);
		getServletContext().getRequestDispatcher("/views/editsolution.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String description = request.getParameter("description");

		solutionToEdit.setUpdated(Interaction.getCurrentDateSql());
		solutionToEdit.setDescription(description);
		SolutionDao.saveToDB(solutionToEdit);

		HttpSession session = request.getSession();

		if (session.getAttribute("loggedIn") != null) {
			response.sendRedirect("./userpanel");
		} else {
			response.sendRedirect("./managesolutions");
		}
	}
}