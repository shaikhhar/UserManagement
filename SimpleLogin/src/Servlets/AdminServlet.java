package Servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import service.UserDao;
import service.UserDaoImpl;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("param1").equals("edit")) {
			String un = request.getParameter("param2");
			UserDao udao = new UserDaoImpl();
			User u = udao.getByUn(un);
			request.setAttribute("FirstName", u.getFirstName());
			request.setAttribute("LastName", u.getLastName());
			request.setAttribute("email", u.getEmail());
			request.setAttribute("username", un);
			request.setAttribute("password", u.getPassword());
			request.getRequestDispatcher("/EditUser.jsp").forward(request, response);
		}
		else if(request.getParameter("param1").equals("delete")) {
			String un = request.getParameter("param2");
			UserDao udao = new UserDaoImpl();
			if(udao.deleteUser(un)) {
				request.setAttribute("Msg","Username "+un+"deleted!");
				UserDao udaonew = new UserDaoImpl();
				List<User> ulist = udaonew.getAll();
				request.setAttribute("UserList",ulist);
				request.getRequestDispatcher("/List.jsp").forward(request,response);
				
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String un = request.getParameter("usernameO");
		String fn = request.getParameter("FirstName");
		String ln = request.getParameter("LastName");
		String e = request.getParameter("email");
		String pw = request.getParameter("password");
		User u = new User(fn, ln, e, un, pw);
		UserDao udao = new UserDaoImpl();
		if(udao.updateUser(u)) {
			UserDao udaonew = new UserDaoImpl();
			List<User> ulist = udaonew.getAll();
			request.setAttribute("UserList",ulist);
			request.getRequestDispatcher("/List.jsp").forward(request,response);
		}else {
			request.setAttribute("ErrMsg","Error in updating");
			request.getRequestDispatcher("/EditUser.jsp").forward(request,response);
		}
		
	}

}
