<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Online.CustomerBean"%>
<%@page import="Online.ProductBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body style="padding: 0px 0px 0px 0px;  color:	black; background-image: url('https://tse3.mm.bing.net/th?id=OIP.o0-_5Yz2Vr32GtIPXUKTLQHaEo&pid=Api&P=0&h=220'); background-size: 100%; background-repeat: no-repeat;"><center>
<marquee class="mq">ElectroMart Electronic Store</marquee>
	<h1 class="head" style="padding: 5px 15px 10px 100px; color: yellow; ">ElectroMart Electronic Store</h1>
<div class="table">
	<table style="border: 2px solid; border-color: white; color: white; font-size: 20px; text-align: center; height:  " >
	<thead style="color: red; font-size: 30px;background-color:#afe3fd; padding: 10px 10px 10px 10px;">
	<tr>
	<th>&nbsp Code &nbsp</th>
	<th>&nbsp Name &nbsp</th>
	<th>&nbsp Compnay &nbsp</th>
	<th>&nbsp Price &nbsp</th>
	<th>&nbsp Quantity &nbsp</th>
	<th>&nbsp Buy &nbsp</th>
	</tr>
	</thead>
		<%
		CustomerBean ab=(CustomerBean)session.getAttribute("cbean");
		ArrayList<ProductBean> al=(ArrayList<ProductBean>)session.getAttribute("products2");
		out.println("<h1><u>Hello "+ab.getFname()+" , these are the products deatils.</u></h1><br><br>");
		if(al.size()>0)
		{
			Iterator<ProductBean> i=al.iterator();
			while(i.hasNext())
			{
				ProductBean pb=i.next();
				out.println("<tbody style='background-color:black;'>");
				out.println("<tr>");
				out.println("<td>"+pb.getpCode()+"</td>");
				out.println("<td>"+pb.getpName()+"</td>");
				out.println("<td>"+pb.getpCompany()+"</td>");
				out.println("<td>"+pb.getpPrice()+"</td>");
				out.println("<td>"+pb.getpQuantity()+"</td>");
				out.println("<td><a class='link' href='Buy?pcode="+pb.getpCode()+"'>Buy</a></td>");
				out.println("</tr>");
			}
		}
		else{
			out.println("Products are NOT available.");
		}		
		
	%>
	</tbody>
	</table>
</div><br><br>
<a style="font-size: 22px; color:white;" href="CustomerHome.jsp">Back to Home</a>&emsp;&emsp;&emsp;
<a style="font-size: 22px; color:black; " href="logout">Logout</a>

</body>
<style type="text/css">
th:hover {background-color: coral;}

.head{
background-image: url("https://tse1.mm.bing.net/th?id=OIP.5pvlM2oWX-xYRTiUbcfVEAHaEK&pid=Api&P=0&h=220");
}
a{
 	
	color:gold;
}
a:hover {
	background: highlight;
}
.link{
text-decoration: none;
}
</style>
</html>