<%@page import="java.util.*" %>
<%@page import="java.sql.*"%>
<%@page import="connectDB.*"%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
      <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>BANK of SHIRPUR</title>
	<!-- BOOTSTRAP STYLES-->
    <link href="assets/css/bootstrap.css" rel="stylesheet" />
     <!-- FONTAWESOME STYLES-->
    <link href="assets/css/font-awesome.css" rel="stylesheet" />
        <!-- CUSTOM STYLES-->
    <link href="assets/css/custom.css" rel="stylesheet" />
     <!-- GOOGLE FONTS-->
   <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
    <script type="text/javascript">
   	function access(){
		<% Object s1 = request.getSession().getAttribute("msg");
		 if(s1!=null){ %>
		alert('<%=s1.toString()%>');
		<% request.getSession().setAttribute("msg",null);
		}	%>
	}
   	</script>
</head>
<body onload="access()">
<%
//AbstractDao abstractDao=new AbstractDao();
%>

    <div id="wrapper">
        <nav class="navbar navbar-default navbar-cls-top " role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" style="font-size:19px" href="#">BANK of SHIRPUR</a> 
            </div>
  <div style="color: white;
padding: 15px 50px 5px 50px;
float: right;
font-size: 16px;"> &nbsp; <a href="index.jsp" class="btn btn-danger square-btn-adjust">Logout</a> </div>
            </nav>   
            <!-- /. NAV TOP  -->
            <nav class="navbar-default navbar-side" role="navigation">
            <div class="sidebar-collapse">
             <ul class="nav" id="main-menu">
				<li class="text-center">
            <img src="assets/img/find_user.png" class="user-image img-responsive" style="height: 100px;"/>
				</li>
				 <li>
                        <a  href="addBloodBank.jsp"><i class="fa fa-edit fa-3x"></i>Add blood Bank</a>
                    </li>
                    <li>
                        <a  href="viewBloodBankAdmin.jsp"><i class="fa fa-edit fa-3x"></i>View Blood Bank</a>
                    </li>
	                </ul>
               
            </div>
            
        </nav>  
        <!-- /. NAV SIDE  -->
        
      <div id="page-wrapper" >
            <div id="page-inner">
                <div class="row">
         		<h2>View Blood Bank</h2>
           <div class="col-md-12">
                                              
						<table border="1" id="displaytable" class="table table-bordered" style="display.none" >
								          <thead>
								          <tr>
								          				<th>Blood Bank id</th>
								        			    <th>Blood bank Name</th>
														<th>Contact No.</th>
														<th>Address</th>
														<th>A+</th>
														<th>A-</th>
														<th>B+</th>
														<th>B-</th>
														<th>AB+</th>
														<th>AB-</th>
														<th>O+</th>
														<th>O-</th>
														<th>Action</th>
													
								          </tr>
								          <% 
                                          Statement statement = null;
                                          ResultSet resultSet = null;
                                          %>
                                          <%
                                          try{
                                          Connection conn=DBconnect.getConnect();
                                          statement=conn.createStatement();
                                          String sql ="select * from bloodbank";
                                          resultSet = statement.executeQuery(sql);
                                          while(resultSet.next()){
                                          %>
                                          <tbody>
                                                   <tr>
                                                   <td><%=resultSet.getString("Bno") %></td>
                                                   <td><%=resultSet.getString("Bname") %></td>
                                                   <td><%=resultSet.getString("mobile") %></td>
                                                   <td><%=resultSet.getString("address") %></td>
                                                   <td><%=resultSet.getString("Apos") %></td>
                                                   <td><%=resultSet.getString("Aneg") %></td>
                                                   <td><%=resultSet.getString("Bpos") %></td>
                                                   <td><%=resultSet.getString("Bneg") %></td>
                                                   <td><%=resultSet.getString("ABpos") %></td>
                                                   <td><%=resultSet.getString("ABneg") %></td>
                                                   <td><%=resultSet.getString("Opos") %></td>
                                                   <td><%=resultSet.getString("Oneg") %></td>
                                                   
                                                   <td><a href="deleteBloodBank.jsp?id=<%=resultSet.getString("Bno") %>" onclick="return confirm_alert(this);">Delete</a></td>

                                                   </tr>
                                          </tbody>
                                                   <%
                                                   }
                                                   //connection.close();
                                                   } catch (Exception e) {
                                                   e.printStackTrace();
                                                   }
                                                   %>
								          
										</thead>
				 </table>                  
			</div>
         		</div>
                   
                </div>
                                       
	 </div>
					                    </div>                                           
                                         
                    </div>
               
           
             <!-- /. PAGE INNER  -->
            </div>
         <!-- /. PAGE WRAPPER  -->
        </div>
     <!-- /. WRAPPER  -->
    <!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->
    <!-- JQUERY SCRIPTS -->
    <script src="assets/js/jquery-1.10.2.js"></script>
      <!-- BOOTSTRAP SCRIPTS -->
    <script src="assets/js/bootstrap.min.js"></script>
    <!-- METISMENU SCRIPTS -->
    <script src="assets/js/jquery.metisMenu.js"></script>
      <!-- CUSTOM SCRIPTS -->
    <script src="assets/js/custom.js"></script>
    <SCRIPT language=Javascript>
     function isNumberKey(evt)
{
var charCode = (evt.which) ? evt.which : event.keyCode;

if (charCode > 31 && (charCode<48 || charCode>57))
	return false;
	
return true;
}
       
</SCRIPT>
   
</body>
</html>
