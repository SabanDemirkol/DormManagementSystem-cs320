
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
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		stmt = (Statement) db.stmt;
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

					String pss = "SELECT PS FROM students where ID = '" + ID + "'";
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
		String sql = "select isFormFilled from student where ID='"+studentID+"'";
		try( ResultSet rs3 = stmt.executeQuery(sql)) {
			while(rs3.next()) {
				if(rs3.getInt("isFormFilled") == 1)
					return true;
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public void setStudentsPriority(int priority,String ID)  {
		String sql = "update student set priority="+priority+" where ID='"+ID+"'";
		try {
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	public void setIsFormFilled(int isFormFilled, String ID) {
		String sql = "update student set isFormFilled="+isFormFilled+" where ID='"+ID+"'";
		try {
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
