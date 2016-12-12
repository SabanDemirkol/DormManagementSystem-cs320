import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;


public class AdminLoginModel {
	public AdminDatabase db;
	public Statement stmt;
	ArrayList<String> IDs;

	public AdminLoginModel() {
		try {
			db = new AdminDatabase();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		stmt = (Statement) db.stmt;
	}

	public boolean checkID(String id,char[] ps) throws SQLException {
		
		int ID = Integer.parseInt(id);
		System.out.println(ID);
		int password = Integer.parseInt(new String(ps));
		System.out.println(password);
		String ids = "SELECT ID FROM admin";
		
		try (ResultSet rs = stmt.executeQuery(ids)) {
		while(rs.next()){

		
					if(ID == rs.getInt("ID")){
				
					
					
						String pss = "SELECT PS FROM admin where ID = '"+ID+"'";
						try (ResultSet rs2 = stmt.executeQuery(pss)) {
							while(rs2.next()){
								if(password == rs2.getInt("ps")) {
									return true;
								}
								
							}
						}
					return false;
					}
	
}
		return false;
	}
}
}
