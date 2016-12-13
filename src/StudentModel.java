
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;

public class StudentModel {
	public Database db;
	public Statement stmt;
	ArrayList<String> IDs;

	public StudentModel() {
		try {
			db = new Database();
			stmt = (Statement) db.stmt;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean isLoginCorrect(String id, char[] ps) throws SQLException {

		int ID = Integer.parseInt(id);
		System.out.println(ID);
		int password = Integer.parseInt(new String(ps));
		System.out.println(password);
		String ids = "SELECT ID FROM students";

		try (ResultSet rs = stmt.executeQuery(ids)) {
			while (rs.next()) {

				if (ID == rs.getInt("ID")) {

					String pss = "SELECT PS FROM students where ID = " + ID ;
					try (ResultSet rs2 = stmt.executeQuery(pss)) {
						while (rs2.next()) {
							if (password == rs2.getInt("ps")) {
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
	public boolean isFormFilled(int studentID) {
		String sql = "select isFormFilled from students where ID="+studentID;
		try( ResultSet rs3 = stmt.executeQuery(sql)) {
			while(rs3.next()) {
				if(rs3.getInt("isFormFilled") == 1)
					return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	public void setStudentsPriority(int priority,int ID)  {
		String sql = "update students set priority = "+priority+" where ID = "+ID + "";
		try {
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	public void setIsFormFilled( String ID) {
		String sql = "update students set isFormFilled="+1+" where ID="+ID;
		try {
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
