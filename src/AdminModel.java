import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;

public class AdminModel {
	public AdminDatabase db;
	public Statement stmt;
	ArrayList<Integer> IDs = new ArrayList<Integer>();
	private static int roomCounter = 0;
	public AdminModel() {
		try {
			db = new AdminDatabase();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		stmt = (Statement) db.stmt;
	}

	public boolean checkID(String id, char[] ps) throws SQLException {

		int ID = Integer.parseInt(id);
		System.out.println(ID);
		int password = Integer.parseInt(new String(ps));
		System.out.println(password);
		String ids = "SELECT ID FROM admin";

		try (ResultSet rs = stmt.executeQuery(ids)) {
			while (rs.next()) {

				if (ID == rs.getInt("ID")) {

					String pss = "SELECT password FROM admin where ID = '" + ID + "'";
					try (ResultSet rs2 = stmt.executeQuery(pss)) {
						while (rs2.next()) {
							if (password == rs2.getInt("password")) {
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

	public void allocation() {
		String sql = "Select * from students where isFormFilled = "+1+" order by priority desc";
		try( ResultSet rs = stmt.executeQuery(sql)) {
			while(rs.next()) {
				int ID = rs.getInt("ID");
				System.out.println(ID);
				String sql1 = "update students set isAllocated = "+1+" where ID = "+ID;
				try {
					stmt.executeQuery(sql1);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	private void updateIsAllocation(int ID) {
		String sql = "update students set isAllocated = "+1+" where ID = "+ID;
		try {
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}