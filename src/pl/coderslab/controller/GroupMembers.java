package pl.coderslab.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.dao.UserDao;
import pl.coderslab.model.User;

@WebServlet("/groupmembers")
public class GroupMembers extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int groupId = Integer.parseInt(request.getParameter("id"));

		List<User> groupMembers = UserDao.findAllByGroupId(groupId);

		request.setAttribute("groupMembers", groupMembers);
		getServletContext().getRequestDispatcher("/views/groupmembers.jsp").forward(request, response);

	}

}
