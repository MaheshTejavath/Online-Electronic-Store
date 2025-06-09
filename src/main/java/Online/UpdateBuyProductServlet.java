package Online;

import java.io.IOException;

import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/update2")
public class UpdateBuyProductServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
	{
		HttpSession session=req.getSession(false);
		if(session==null)
		{
			req.setAttribute("msg", "Session experied!!");
			RequestDispatcher rd=req.getRequestDispatcher("index.html");
			rd.forward(req, res);
			
		}
		else 
		{
			String pcode=req.getParameter("pcode");
			ArrayList<ProductBean> al=(ArrayList<ProductBean>)session.getAttribute("products2");
			ProductBean pb2=null;
			Iterator<ProductBean> i=al.iterator();
			while(i.hasNext())
			{
				pb2=i.next();
				if(pcode.equals(pb2.getpCode()))
				{
					break;
				}
			}			
			ProductBean pb=new ProductBean();
			pb.setpCode(pcode);
			pb.setpName(req.getParameter("name"));
			pb.setpCompany(req.getParameter("pcom"));
			pb.setpPrice(req.getParameter("price"));
			pb.setpQuantity(req.getParameter("qty"));
			
			int q1=Integer.parseInt(pb2.getpQuantity());
			int q2=Integer.parseInt(pb.getpQuantity());
			
			String qty=String.valueOf(q1-q2);
			pb.setpQuantity(qty);
			if(q2<=q1 && q2!=0) 
			{
				int rowCount=new UpdateProductDAO().update(qty, pb);
				if(rowCount==0)
				{
					
					req.setAttribute("msg", "Somthing went wrong !!!");
					RequestDispatcher rd=req.getRequestDispatcher("Error.jsp");
					rd.forward(req, res);
					
				}
				else {
					int price1=Integer.parseInt(pb.getpPrice());
					price1=price1*q2;
					int gst=(price1*18)/100;
					int price=price1+gst;
					req.setAttribute("pname", pb.getpName());
					req.setAttribute("pcom", pb.getpCompany());
					req.setAttribute("msg",price);
					RequestDispatcher rd=req.getRequestDispatcher("BuyDetails.jsp");
					rd.forward(req, res);
				}
			}
			else {
				req.setAttribute("msg", "Warning: Quantity is Not more Then Available Quantity Or Zero Quantity");
				RequestDispatcher rd=req.getRequestDispatcher("Error.jsp");
				rd.forward(req, res);
			}
		}
	}
}
