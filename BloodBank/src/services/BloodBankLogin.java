package services;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BloodBankLogin
 */
public class BloodBankLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BloodBankLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
doGet(request, response);
		
		String email=request.getParameter("email");
		String pass=request.getParameter("password");
		if(email.equals("bloodbank@gmail.com") && pass.equals("bloodbank"))
		{
			response.sendRedirect("addCamp.jsp");
		}
		else
		{
			request.getSession().setAttribute("msg", "Wrong User Credentials..!!");
			response.sendRedirect("index.jsp");
		}
	}

}
