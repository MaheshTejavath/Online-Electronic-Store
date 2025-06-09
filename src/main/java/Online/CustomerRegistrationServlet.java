package Online;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebServlet("/reg")
public class CustomerRegistrationServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		CustomerBean cbean=new CustomerBean();
		cbean.setFname(req.getParameter("fname"));
		cbean.setLname(req.getParameter("lname"));
		cbean.setAddress(req.getParameter("address"));
		cbean.setMailid(req.getParameter("mailid"));
		cbean.setMobile(req.getParameter("mobile"));
		
		
		CustomerBean cbean1=new CustomerRegisterDAO().checkCustomerRegister(req.getParameter("uname"),req.getParameter("pword"));
		if(cbean==null)
		{
			req.setAttribute("msg","Invalid Admin Credentials");
			RequestDispatcher rd=req.getRequestDispatcher("CustomerLogin.html");
			rd.forward(req,res);
		}
		else
		{
			HttpSession session=req.getSession();
			session.setAttribute("cbean",cbean1);
			RequestDispatcher rd=req.getRequestDispatcher("CustomerHome.jsp");
			rd.forward(req,res);
		}
	}
}
