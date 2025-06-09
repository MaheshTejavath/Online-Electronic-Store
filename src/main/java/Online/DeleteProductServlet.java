package Online;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/delete")
public class DeleteProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession(false); // Use false to avoid creating a new session
        if (session == null) {
            req.setAttribute("msg", "Session Expired! Please log in again.");
            RequestDispatcher rd = req.getRequestDispatcher("AdminLogin.html");
            rd.forward(req, res);
            return;
        }

        String code = req.getParameter("pCode");
        if (code == null || code.trim().isEmpty()) {
            req.setAttribute("msg", "Invalid Product Code.");
            RequestDispatcher rd = req.getRequestDispatcher("DeleteProduct.jsp");
            rd.forward(req, res);
            return;
        }

        int rowCount = new DeleteProductDAO().deleteProduct(code);
        if (rowCount > 0) {
            req.setAttribute("msg", "Product successfully deleted.");
        } else {
            req.setAttribute("msg", "No matching product found.");
        }

        RequestDispatcher rd = req.getRequestDispatcher("DeleteProduct.jsp");
        rd.forward(req, res);
    }
}
