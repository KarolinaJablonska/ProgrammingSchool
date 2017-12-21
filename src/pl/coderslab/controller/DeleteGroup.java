package pl.coderslab.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.dao.GroupDao;

@WebServlet("/deletegroup")
public class DeleteGroup extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int groupId = Integer.parseInt(request.getParameter("id"));
		GroupDao.delete(GroupDao.findById(groupId));
		response.sendRedirect("./managegroups");
	}
}
