package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Validate
 * 
 * Session Management API – Session Management API is built on top of above
 * methods for session tracking. Some of the major disadvantages of all the
 * above methods are: Most of the time we don’t want to only track the session,
 * we have to store some data into the session that we can use in future
 * requests. This will require a lot of effort if we try to implement this. All
 * the above methods are not complete in themselves, all of them won’t work in a
 * particular scenario. So we need a solution that can utilize these methods of
 * session tracking to provide session management in all cases. That’s why we
 * need Session Management API and J2EE Servlet technology comes with session
 * management API that we can use.
 */
@WebServlet("/Validate")
public class Validate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Validate() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");

		String name = request.getParameter("user");
		String pass = request.getParameter("pass");

		if (pass.equals("1234")) {
			// creating a session
			HttpSession session = request.getSession();
			session.setAttribute("user", name);
			response.sendRedirect("Welcome");
		} else {
			response.sendRedirect("Error.jsp");
		}
	}

}
