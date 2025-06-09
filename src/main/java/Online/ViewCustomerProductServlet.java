package Online;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/View2")
public class ViewCustomerProductServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
	{
		HttpSession session=req.getSession(false);
		if(session==null)
		{
			req.setAttribute("msg", "Session experied!!");
			RequestDispatcher rd=req.getRequestDispatcher("index.html");
			rd.forward(req, res);
			
		}
		else{
			ArrayList<ProductBean> al2=new ViewCustomerProductServlet().reteriveData2();
			session.setAttribute("products2", al2);
			RequestDispatcher rd=req.getRequestDispatcher("CustomerProducts2.jsp");
			rd.forward(req, res);
			
		}
		
	}

	private ArrayList<ProductBean> reteriveData2() {
		// TODO Auto-generated method stub
		return null;
	}
}
