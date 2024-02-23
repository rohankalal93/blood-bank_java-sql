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
 * Servlet implementation class AddCustomer
 */
public class AddCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCustomer() {
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
				String ano=request.getParameter("no");
				String aname=request.getParameter("name");
				String contact=request.getParameter("mno");
				String emailid=request.getParameter("eid");
				String pass=request.getParameter("passwd");
				String addr=request.getParameter("add");
				//String balance="0";
			
				
				Connection conn=DBconnect.getConnect();
			
				PreparedStatement ps=conn.prepareStatement("select * from account where accno='"+ano+"'");
				
				ResultSet r= ps.executeQuery();
			
				if(r.next())
				{
					request.getSession().setAttribute("msg", "Duplicate Account Number, Records Already Exist..!!");
	        		response.sendRedirect("addCustomer.jsp"); 
				}
				else
				{
					PreparedStatement ps1=conn.prepareStatement("insert into account values(?,?,?,?,?,?)");
					ps1.setString(1,ano);
					ps1.setString(2,aname);
					ps1.setString(3,contact);
					ps1.setString(4,pass);
					ps1.setString(5,addr);
				//	ps1.setString(6,balance);
					ps1.setString(6,emailid);
					
					
					int n= ps1.executeUpdate();
					System.out.println("Recort inserted");
					
					if(n>=1)
					{
						request.getSession().setAttribute("msg", "Record Inserted Successfully..!!");
						response.sendRedirect("addCustomer.jsp"); 
					}
					else
					{
						request.getSession().setAttribute("msg", "Record Failed To Insert..!!");
						response.sendRedirect("addCustomer.jsp"); 
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
