package pl.coderslab.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.dao.SolutionDao;

@WebServlet("/deletesolution")
public class DeleteSolution extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int solutionId = Integer.parseInt(request.getParameter("id"));
		SolutionDao.delete(SolutionDao.findById(solutionId));
		response.sendRedirect("./managesolutions");
	}

}
