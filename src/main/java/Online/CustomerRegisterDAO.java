package Online;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CustomerRegisterDAO 
{
    public CustomerBean checkCustomerRegister(String username, String password)
    {
        CustomerBean cbean = null;
        try
        {
            Connection con = DBConnect.getCon();
            PreparedStatement pstm = con.prepareStatement("SELECT * FROM admin WHERE uname = ? AND pword = ?");
            pstm.setString(1, username);
            pstm.setString(2, password);
            ResultSet rs = pstm.executeQuery();
            
            if (rs.next())
            {
                cbean = new CustomerBean();
                cbean.setUsername(rs.getString("uname"));
                cbean.setPassword(rs.getString("pword"));
                cbean.setFname(rs.getString("fname"));
                cbean.setLname(rs.getString("lname"));
                cbean.setAddress(rs.getString("address"));
                cbean.setMailid(rs.getString("mailid"));
                cbean.setMobile(rs.getString("mobile"));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return cbean;
    }
}
