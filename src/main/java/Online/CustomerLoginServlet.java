package Online;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebServlet("/cus")
public class CustomerLoginServlet  extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		CustomerLoginDAO clDAO=new CustomerLoginDAO();
		CustomerBean cbean=clDAO.reteriveData(req.getParameter("uname"),req.getParameter("pwordd"));
		
		if(cbean==null)
		{
			req.setAttribute("msg", "Invaild Credentials!!!");
			RequestDispatcher rd=req.getRequestDispatcher("CustomerLogin.html");
			rd.forward(req, res);
        }
		else
		{
			ServletContext Context=req.getServletContext();
			Context.setAttribute("cbean",cbean);
			Cookie c=new Cookie("Username",cbean.getUsername());
			res.addCookie(c);
			RequestDispatcher rd=req.getRequestDispatcher("CustomerHome.jsp");
			rd.forward(req, res);
			
		}
	}

}
