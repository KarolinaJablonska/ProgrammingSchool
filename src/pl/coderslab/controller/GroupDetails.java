package pl.coderslab.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.dao.GroupDao;
import pl.coderslab.model.Group;

@WebServlet("/groupdetails")
public class GroupDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int groupId = Integer.parseInt(request.getParameter("id"));

		Group group = GroupDao.findById(groupId);

		request.setAttribute("groupInDetail", group);
		getServletContext().getRequestDispatcher("/views/groupdetails.jsp").forward(request, response);

	}

}
