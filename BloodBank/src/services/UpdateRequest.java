package services;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connectDB.DBconnect;

/**
 * Servlet implementation class UpdateRequest
 */
public class UpdateRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateRequest() {
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
		
		PrintWriter out=response.getWriter();
		{
			try
			{
				String a1=request.getParameter("rno");
				String a2=request.getParameter("Status");


				//String a4=request.getParameter("bneg");
				
				
				//int amount=Integer.parseInt(request.getParameter("amt"));
				
				Connection conn=DBconnect.getConnect();
			
				PreparedStatement ps=conn.prepareStatement("select * from result where rid='"+a1+"'");
				
				ResultSet r= ps.executeQuery();
				//String apos1="0", aneg1="0", bpos1="0", bneg1="0", abpos1="0", abneg1="0", opos1="0", oneg1="0";
				if(r.next())
				{
					//apos1=rs.getString();
					
					PreparedStatement ps1=conn.prepareStatement("update result set status=? where rid=?");
					//ps1.setString(1,Integer.toString(amount));
					//ps1.setString(1,a5);
					ps1.setString(1,a2);
					ps1.setString(2, a1);
					
	
						
					int n= ps1.executeUpdate();
					
					if(n>=1)
					{
						System.out.println("Blood status updated");
						request.getSession().setAttribute("msg", "Blood group updated Successfully..!!");
						response.sendRedirect("updateStatus.jsp"); 
					}
					else
					{
						request.getSession().setAttribute("msg", "Failed To update..!!");
						response.sendRedirect("updateStatus.jsp"); 
					}
				}
				else
				{
					request.getSession().setAttribute("msg", "Invalid value, Record Not Exist..!!");
	        		response.sendRedirect("updateStatus.jsp"); 
				}
			}
			catch (SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
