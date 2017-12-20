package pl.coderslab.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.dao.SolutionDao;
import pl.coderslab.model.Solution;

@WebServlet("/solutiondetails")
public class SolutionDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int solutionId = Integer.parseInt(request.getParameter("id"));

		Solution solution = SolutionDao.findById(solutionId);
		
		request.setAttribute("solutionInDetail", solution);
		getServletContext().getRequestDispatcher("/views/solutiondetails.jsp").forward(request, response);
	}

}
