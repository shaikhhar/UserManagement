package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import service.UserDao;
import service.UserDaoImpl;



/**
 * Servlet implementation class SignupServlet
 */
@WebServlet("/SignupServlet")
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignupServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/Signup.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fn= request.getParameter("FirstName");
		String ln= request.getParameter("LastName");
		String e= request.getParameter("email");
		String un= request.getParameter("username");
		String pw= request.getParameter("password");
		User u = new User(fn,ln,e,un,pw);
		UserDao udao = new UserDaoImpl();
		if(fn.isEmpty()||ln.isEmpty()||e.isEmpty()||un.isEmpty()||pw.isEmpty()) {
			request.setAttribute("ErrMsg", "Please fill up all field");
			request.getRequestDispatcher("/Signup.jsp").forward(request, response);			
		}else if(udao.userExists(un)|| un.equals("admin")) {
			request.setAttribute("ErrMsg", "Username already Exists!!!");
			request.getRequestDispatcher("/Signup.jsp").forward(request, response);
		}else {
			udao.addUser(u);
			request.getRequestDispatcher("/Login.jsp").forward(request, response);
		}
			
			
		
	}

}
