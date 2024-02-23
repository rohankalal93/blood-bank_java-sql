package services;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connectDB.DBconnect;
import connectDB.UserInfo;

/**
 * Servlet implementation class UserLogin
 */
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLogin() {
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
		try
		{
			Connection conn=DBconnect.getConnect();
			PreparedStatement ps = conn.prepareStatement("select * from account where email=? and password=?");
			ps.setString(1, email);
			ps.setString(2, pass);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				UserInfo.setAccNo(rs.getString("accno"));
				response.sendRedirect("addCustomer.jsp");
			}
			else
			{
				request.getSession().setAttribute("msg", "Wrong User Credentials..!!");
				response.sendRedirect("index.jsp");
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
