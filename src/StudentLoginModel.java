import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;

public class StudentLoginModel {
	public Database db;
	public Statement stmt;
	ArrayList<String> IDs;

	public StudentLoginModel() {
		try {
			db = new Database();
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
		String ids = "SELECT ID FROM students";
		
		try (ResultSet rs = stmt.executeQuery(ids)) {
		while(rs.next()){

		
					if(ID == rs.getInt("ID")){
				
					
					
						String pss = "SELECT PS FROM students where ID = '"+ID+"'";
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
	
					

