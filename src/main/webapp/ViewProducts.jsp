<%@ page import="Online.AdminBean" %>
<%@ page import="Online.ProductBean" %>
<%@ page import="java.util.*" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product Details</title>
</head>
<body> <center> <h1>
<%
    AdminBean abean=(AdminBean)session.getAttribute("abean");
    ArrayList<ProductBean> al=(ArrayList<ProductBean>)session.getAttribute("ProductsList");
    out.println("<u><i>Hello " +abean.getaFname() + " These are your Product Detail:</i></u><br><br>");
    if (al.size()==0) 
    {
        out.println("Products are NOT available!!!!<br><br>");
    }
    else 
    {
        Iterator<ProductBean> i=al.iterator();
        while (i.hasNext()) 
        {
            ProductBean pb=i.next();
            out.println(pb.getpCode() + " " + pb.getpName() + " " + pb.getpCompany() + " " + pb.getpPrice() + " " + pb.getpQuantity() +
                    " <a href='edit?pcode=" + pb.getpCode() + "'>Edit</a>" +
                    " <a href='delete?pcode=" + pb.getpCode() + "'>Delete</a><br><br>");
        }
    }

%>

    <a href="logout">Logout</a>

</body>
</html>
