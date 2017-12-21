package pl.coderslab.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.dao.GroupDao;
import pl.coderslab.model.Group;

@WebServlet("/managegroups")
public class ManageGroups extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Group> allGroups = GroupDao.findAll();
		request.setAttribute("allGroupsToManage", allGroups);
		getServletContext().getRequestDispatcher("/views/managegroups.jsp").forward(request, response);
	}
}
