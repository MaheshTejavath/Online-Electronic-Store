package Online;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CustomerLoginDAO 
{

	public CustomerBean checkCustomerLogin(String cUsername,String cPassword)
	{
		CustomerBean cbean=null;
		try
		{
			Connection con=DBConnect.getCon();
			PreparedStatement pstm=con.prepareStatement("select * from admin where uname=? and pwd=?");
			pstm.setString(1, cUsername);
			pstm.setString(2, cPassword);
			ResultSet rs=pstm.executeQuery();
			
			if(rs.next())
			{
			    cbean=new CustomerBean();
			    cbean.setUsername(rs.getString(1));
			    cbean.setPassword(rs.getString(2));
			    cbean.setFname(rs.getString(3));
			    cbean.setLname(rs.getString(4));
			    cbean.setAddress(rs.getString(5));
			    cbean.setMailid(rs.getString(6));
			    cbean.setMobile(rs.getString(7));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return cbean;
	}

	public int insertData(CustomerBean cbean) {
		// TODO Auto-generated method stub
		return 0;
	}

	public CustomerBean reteriveData(String parameter, String parameter2) {
		// TODO Auto-generated method stub
		return null;
	}
}
