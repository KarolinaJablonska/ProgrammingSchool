package pl.coderslab.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.dao.ExcerciseDao;
import pl.coderslab.model.Excercise;

@WebServlet("/excercisedetails")
public class ExcerciseDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int excerciseId = Integer.parseInt(request.getParameter("id"));

		Excercise excercise = ExcerciseDao.findById(excerciseId);

		request.setAttribute("excerciseInDetail", excercise);
		getServletContext().getRequestDispatcher("/views/excercisedetails.jsp").forward(request, response);
		

	}

}
