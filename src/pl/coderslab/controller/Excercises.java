package pl.coderslab.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.dao.ExcerciseDao;
import pl.coderslab.model.Excercise;

@WebServlet("/excercises")
public class Excercises extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Excercise> excercises = ExcerciseDao.findAll();
		request.setAttribute("allExcercises", excercises);
		getServletContext().getRequestDispatcher("/views/allExcercises.jsp").forward(request, response);
	
	}
}