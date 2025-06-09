<%@page import="java.time.LocalDate"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="java.util.stream.IntStream"%>
<%@page import="java.util.Random"%>
<%@page import="Online.ProductBean"%>
<%@page import="Online.CustomerBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>buy</title>
<style type="text/css">
.bill{
	background-color:#005e75;
	padding-top:5px;
	display: flex;
	justify-content: center;
	border: 3px solid rgba(255,255,255,0.30);
	margin: 20px 400px 20px 400px;
	text-align: left;
	font-size: 20px;
	color: white;
	font-family: serif;
	
}
a{
color : Blue;
font-size: 20px;
}
body{
	background-color: #65e3ec;
}
</style>
</head>
<body>
<center>
<div class="bill">
<p>
&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;ElectroMart Electronic Store<br>
	<%
		Random rm=new Random();
		long OrderId=rm.nextLong(999999);
		CustomerBean cb=(CustomerBean)session.getAttribute("cbean");
		int msg=(Integer)request.getAttribute("msg");
		out.println("---------------------Order Invoice---------------------<br>");
		out.println("-----------------------------------------------------------<br>");
		out.println("Order Status&emsp;&emsp;&nbsp;&nbsp;&nbsp;: &emsp;Confirmed<br>");
		out.println("Buyer Name&emsp; &emsp;&nbsp;&nbsp;:&emsp; "+cb.getFname()+"<br>");
		out.println("Order ID &emsp;&emsp;&emsp;&emsp;: &emsp;"+cb.getFname().substring(0,3).toUpperCase()+""+OrderId);
		out.println("<br>Order Date &emsp;&emsp; &emsp;:&emsp; "+LocalDate.now());
		out.println("<br>Product Name &emsp;&emsp;: &emsp;"+request.getAttribute("pname"));
		out.println("<br>Product Company &nbsp;&nbsp;:&emsp; "+request.getAttribute("pcom"));
		out.println("<br>Product Price &emsp;&emsp;&nbsp;:&emsp; "+request.getParameter("price"));
		out.println("<br>No. of Products &emsp;&nbsp;&nbsp;:&emsp; "+request.getParameter("qty"));
		out.println("<br>----------------------------------------------------------<br>");
		out.println("Total amount &emsp;&emsp;&nbsp;&nbsp;:&emsp; &#8377;"+ msg +" (Include GST)");
		out.println("<br>----------------------------------------------------------<br>");
		out.println("GST &emsp;&emsp; 18%<br>");
		out.println("Payment Status : Success<br>");
		out.println("-->You will be get Order With in 5 days.");
		out.println("<br>Payment method : Online<br>No-refund <br><br><br>");
		out.println("Thank you<br><br>");
	%>

</div>
<a href="CustomerHome.jsp">Home</a>
</body>
</html>