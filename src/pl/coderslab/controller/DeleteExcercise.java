package pl.coderslab.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.dao.ExcerciseDao;

@WebServlet("/deleteexcercise")
public class DeleteExcercise extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int excerciseId = Integer.parseInt(request.getParameter("id"));
		ExcerciseDao.delete(ExcerciseDao.findById(excerciseId));
		response.sendRedirect("./manageexcercises");
	}
}
