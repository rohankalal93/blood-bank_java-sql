package services;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.ResultSet;

import connectDB.DBconnect;

/**
 * Servlet implementation class BloodRequest
 */
public class BloodRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BloodRequest() {
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
				String a2=request.getParameter("rname");
				String a3=request.getParameter("rmobno");
				String a4=request.getParameter("rgb");
				String rstatus=request.getParameter("Status");

				 //rstatus="0";
			
				
				Connection conn=DBconnect.getConnect();
			
				//PreparedStatement ps=conn.prepareStatement("select * from result where rno='"+a1+"'");
				
				//ResultSet r= (ResultSet) ps.executeQuery();
			
				//if(r.next())
				//{
					//request.getSession().setAttribute("msg", "Duplicate Account Number, Records Already Exist..!!");
	        		//response.sendRedirect("bloodRequest.jsp"); 
				//}
				//else
				{
					PreparedStatement ps1=conn.prepareStatement("insert into result values(?,?,?,?,?)");
					ps1.setString(1,a1);
					ps1.setString(2,a2);
					ps1.setString(3,a3);
					ps1.setString(4,a4);
					ps1.setString(5,rstatus);
					
					
					int n= ps1.executeUpdate();
					System.out.println("Recort inserted");
					
					if(n>0)
					{
						request.getSession().setAttribute("msg", "Record Inserted Successfully..!!");
						response.sendRedirect("bloodRequest.jsp"); 
					}
					else
					{
						request.getSession().setAttribute("msg", "Record Failed To Insert..!!");
						response.sendRedirect("bloodRequest.jsp"); 
					}
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
