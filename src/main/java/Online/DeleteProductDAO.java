package Online;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteProductDAO {
    public int deleteProduct(String pCode) {
        int rowCount = 0;
        try (Connection con = DBConnect.getCon();
             PreparedStatement pstm = con.prepareStatement("DELETE FROM product WHERE PCODE = ?")) {
            
            pstm.setString(1, pCode);
            rowCount = pstm.executeUpdate();
            System.out.println("Rows affected: " + rowCount); // Debug log for rows deleted

        } catch (SQLException e) {
            System.err.println("SQL Error: " + e.getMessage());
            e.printStackTrace();
        }
        return rowCount;
    }
}
