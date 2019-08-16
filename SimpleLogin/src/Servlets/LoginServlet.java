package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;
import service.UserDao;
import service.UserDaoImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("Login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String un = request.getParameter("username");
		String pw= request.getParameter("password");
		
		UserDao udao = new UserDaoImpl();
		if(un.equals("admin") && pw.equals("admin123")) {
			HttpSession session = request.getSession();
			session.setMaxInactiveInterval(60);
			session.setAttribute("activeUser", un);
			request.setAttribute("user", un);
			request.getRequestDispatcher("HomeAdmin.jsp").forward(request, response);
			
		}
		else if(udao.userValidate(un, pw)) {
			User u= udao.getByUn(un);
     		String fn=u.getFirstName();
			HttpSession session = request.getSession();
			session.setMaxInactiveInterval(10);
			session.setAttribute("activeUser", fn);
			request.setAttribute("user", fn);
			request.getRequestDispatcher("Home.jsp").forward(request, response);
			
		}else {
			request.setAttribute("ErrorMsg", "Invalid Username/Password");
			request.getRequestDispatcher("Login.jsp").forward(request, response);
		}
		
	}

}
