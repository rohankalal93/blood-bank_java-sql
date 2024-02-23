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
 * Servlet implementation class AddCamp
 */
public class AddCamp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCamp() {
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
				
				//int ano=Integer.parseInt(request.getParameter("acno"));
				String ano=request.getParameter("acno");
				String aname=request.getParameter("acname");
				String contact=request.getParameter("acmno");
			//	int emailid=Integer.parseInt(request.getParameter("acdate"));
				String addr=request.getParameter("acadd");
				//String balance="0";
			
				
				Connection conn=DBconnect.getConnect();
			
				//PreparedStatement ps=conn.prepareStatement("select * from camp where cid='"+ano+"'");
				
				//ResultSet r= ps.executeQuery();
			
				//if(r.next())
				//{
					//request.getSession().setAttribute("msg", "Duplicate Account Number, Records Already Exist..!!");
	        		//response.sendRedirect("addCamp.jsp"); 
				//}
				//else
				{
					PreparedStatement ps1=conn.prepareStatement("insert into camp values(?,?,?,?)");
					ps1.setString(1,ano);
					ps1.setString(2,aname);
					ps1.setString(3,contact);
//					ps1.setInt(4,emailid);
					ps1.setString(4,addr);

					
					
					int n= ps1.executeUpdate();
					System.out.println("Recort inserted");
					
					if(n>0)
					{
						request.getSession().setAttribute("msg", "Record Inserted Successfully..!!");
						response.sendRedirect("addCamp.jsp"); 
					}
					else
					{
						request.getSession().setAttribute("msg", "Record Failed To Insert..!!");
						response.sendRedirect("addCamp.jsp"); 
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
