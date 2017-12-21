package pl.coderslab.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.dao.SolutionDao;
import pl.coderslab.model.Solution;

@WebServlet("/allsolutions")
public class AllSolutions extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Solution> allSolutions = SolutionDao.findAll();
		request.setAttribute("allSolutions", allSolutions);
		getServletContext().getRequestDispatcher("/views/allsolutions.jsp").forward(request, response);
	}
}
