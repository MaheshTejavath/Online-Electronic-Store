package Online;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect 
{
      static Connection con=null;

private DBConnect() {}
	
	static 
	{
		try
		{
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection(DBInfo.DBURL,DBInfo.DBUname,DBInfo.DBPwd);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public static Connection getCon() 
	{
		
		return con;
	}
	
	
}

