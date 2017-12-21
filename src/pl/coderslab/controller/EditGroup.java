package pl.coderslab.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.dao.GroupDao;
import pl.coderslab.model.Group;

@WebServlet("/editgroup")
public class EditGroup extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Group groupToEdit;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int groupId = Integer.parseInt(request.getParameter("id"));
		groupToEdit = GroupDao.findById(groupId);
		request.setAttribute("group", groupToEdit);
		getServletContext().getRequestDispatcher("/views/editgroup.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("name");
		groupToEdit.setAttributes(name);
		GroupDao.saveToDB(groupToEdit);
		response.sendRedirect("./managegroups");
	}
}
