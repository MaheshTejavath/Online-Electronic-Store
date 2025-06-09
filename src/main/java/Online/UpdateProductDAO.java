package Online;

import java.sql.Connection;
import java.sql.PreparedStatement;


public class UpdateProductDAO
{
	public int updateProduct(ProductBean pb)
	{
		int rowCount=0;
		try
		{
			Connection con=DBConnect.getCon();
			PreparedStatement pstm=con.prepareStatement("update product set PPRICE=?,PQTY=? where PCODE=?");
			pstm.setString(1,pb.getpPrice());
			pstm.setString(2,pb.getpQuantity());
			pstm.setString(3,pb.getpCode());
			rowCount=pstm.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return rowCount;
		
	}

	public int update(String qty, ProductBean pb) {
		// TODO Auto-generated method stub
		return 0;
	}
}
