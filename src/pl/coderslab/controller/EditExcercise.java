package pl.coderslab.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.dao.ExcerciseDao;
import pl.coderslab.model.Excercise;

@WebServlet("/editexcercise")
public class EditExcercise extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Excercise excerciseToEdit;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int excerciseId = Integer.parseInt(request.getParameter("id"));
		excerciseToEdit = ExcerciseDao.findById(excerciseId);
		request.setAttribute("excercise", excerciseToEdit);
		getServletContext().getRequestDispatcher("/views/editexcercise.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String title = request.getParameter("title");
		String description = request.getParameter("description");
		excerciseToEdit.setAttributes(title, description);
		ExcerciseDao.saveToDB(excerciseToEdit);
		response.sendRedirect("./manageexcercises");
	}
}
