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

@WebServlet("/manageexcercises")
public class ManageExcercises extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Excercise> allExcercises = ExcerciseDao.findAll();
		request.setAttribute("allExcercisesToManage", allExcercises);
		getServletContext().getRequestDispatcher("/views/manageexcercises.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String title = request.getParameter("title");
		String description = request.getParameter("description");
		ExcerciseDao.saveToDB(new Excercise(title, description));
	}

}
