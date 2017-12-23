package pl.coderslab.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.dao.SolutionDao;
import pl.coderslab.model.Interaction;
import pl.coderslab.model.Solution;

@WebServlet("")
public class Homepage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int numberSolution = Integer.parseInt(getServletContext().getInitParameter("number-solution"));

		List<Solution> newestSolutions = SolutionDao.findAll(numberSolution);
		request.setAttribute("newestSolutions", newestSolutions);
		getServletContext().getRequestDispatcher("/views/index.jsp").forward(request, response);
	}
}
