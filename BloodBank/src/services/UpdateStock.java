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
 * Servlet implementation class UpdateStock
 */
public class UpdateStock extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateStock() {
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
			//try
			//{
				String ano=request.getParameter("bno");
				String a1=request.getParameter("apos");
				String a2=request.getParameter("aneg");
				String a3=request.getParameter("bpos");
				String a4=request.getParameter("bneg");
				String a5=request.getParameter("abpos");
				String a6=request.getParameter("abneg");
				String a7=request.getParameter("opos");
				String a8=request.getParameter("oneg");

				
				//int amount=Integer.parseInt(request.getParameter("amt"));
				
				Connection conn=DBconnect.getConnect();
			
				try{
				PreparedStatement ps=conn.prepareStatement("select * from bloodbank where Bno='"+ano+"'");
				ps.setString(1,ano);
				
				
				ResultSet r= ps.executeQuery();
				String apos1="0", aneg1="0", bpos1="0", bneg1="0", abpos1="0", abneg1="0", opos1="0", oneg1="0";
				if(r.next())
				{
					apos1=r.getString(5);
					aneg1=r.getString(6);
					bpos1=r.getString(7);
					bneg1=r.getString(8);
					abpos1=r.getString(9);
					abneg1=r.getString(10);
					opos1=r.getString(11);
					oneg1=r.getString(12);

					
					a1=a1+apos1;
					a2=a2+aneg1;
					a3=a3+bpos1;
					a4=a4+bneg1;
					a5=a5+abpos1;
					a6=a6+abneg1;
					a7=a7+opos1;
					a8=a8+oneg1;


					
					PreparedStatement ps1=conn.prepareStatement("update bloodbank set Apos=?,Aneg=?,Bpos=?,Bneg=?,ABpos=?,ABneg=?,Opos=?,Oneg=? where Bno=?");
					//ps1.setString(1,Integer.toString(amount));
					ps1.setString(1,a1);
					ps1.setString(2,a2);
					ps1.setString(3,a3);
					ps1.setString(4,a4);
					ps1.setString(5,a5);
					ps1.setString(6,a6);
					ps1.setString(7,a7);
					ps1.setString(8,a8);
					ps1.setString(9,ano);
						
					int n= ps1.executeUpdate();
					
					if(n>=1)
					{
						System.out.println("Blood group updated");
						request.getSession().setAttribute("msg", "Blood group updated Successfully..!!");
						response.sendRedirect("updateStock.jsp"); 
					}
					else
					{
						request.getSession().setAttribute("msg", "Failed To update..!!");
						response.sendRedirect("updateStock.jsp"); 
					}
				}
				else
				{
					request.getSession().setAttribute("msg", "Invalid Account Number, Record Not Exist..!!");
	        		response.sendRedirect("updateStock.jsp"); 
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
