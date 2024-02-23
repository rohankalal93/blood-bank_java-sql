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
 * Servlet implementation class AddBloodBank
 */
public class AddBloodBank extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBloodBank() {
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
		
		//PrintWriter out=response.getWriter();
		{
			try
			{
				int abno=Integer.parseInt(request.getParameter("bno"));
				String abname=request.getParameter("bname");
				String abcontact=request.getParameter("bmno");
				String abaddr=request.getParameter("badd");
				String a1=request.getParameter("apos");
				String a2=request.getParameter("aneg");
				String a3=request.getParameter("bpos");
				String a4=request.getParameter("bneg");
				String a5=request.getParameter("abpos");
				String a6=request.getParameter("abneg");
				String a7=request.getParameter("opos");
				String a8=request.getParameter("oneg");
				
				//String balance="0";
			
				
				Connection conn=DBconnect.getConnect();
			
			//	PreparedStatement ps=conn.prepareStatement("select * from bloodbank where bno='"+abno+"'");
				
				//ResultSet r= ps.executeQuery();
			
			//	if(r.next())
				//{
					//request.getSession().setAttribute("msg", "Duplicate  Number, Records Already Exist..!!");
	        		//response.sendRedirect("addBloodBank.jsp"); 
				//}
				//else
				{
					PreparedStatement ps1=conn.prepareStatement("insert into bloodbank values(?,?,?,?,?,?,?,?,?,?,?,?)");
					ps1.setInt(1,abno);
					ps1.setString(2,abname);
					ps1.setString(3,abcontact);
					ps1.setString(4,abaddr);
					ps1.setString(5,a1);
					ps1.setString(6,a2);
					ps1.setString(7,a3);
					ps1.setString(8,a4);
					ps1.setString(9,a5);
					ps1.setString(10,a6);
					ps1.setString(11,a7);
					ps1.setString(12,a8);
					
					
					
					int n= ps1.executeUpdate();
					System.out.println("Recort inserted");
					
					if(n>0)
					{
						request.getSession().setAttribute("msg", "Record Inserted Successfully..!!");
						response.sendRedirect("addBloodBank.jsp"); 
					}
					else
					{
						request.getSession().setAttribute("msg", "Record Failed To Insert..!!");
						response.sendRedirect("addBloodBank.jsp"); 
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
