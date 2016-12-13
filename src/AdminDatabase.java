import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;


public class AdminDatabase {
	private static final String DB_URL = "jdbc:mysql://localhost:3306/dms";
	private static final String USER = "root";
	private static final String PASS = "12345";
	public Statement stmt;
	
	public AdminDatabase() throws SQLException {
		 Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
		 stmt = conn.createStatement();
		 
	}
	
	public void createAdmins() {
		ArrayList<Integer> ids = new ArrayList<Integer>();
		ArrayList<Integer> passwords = new ArrayList<Integer>();
		Random random = new Random();
		createIDs(ids, random);
		createPasswords(passwords, random);
		executeDatabase(ids, passwords, stmt);
	}


public void createIDs(ArrayList<Integer> ids, Random random) {
	for (int i = 0; i < 5; i++) {
		int id = 100 + random.nextInt(50);
		if (!ids.contains(id)) {
			ids.add(id);
			i++;
		}
		i--;
	}
}
public void createPasswords(ArrayList<Integer> passwords, Random random) {
	for (int k = 0; k < 5; k++) {
		int ps = 100000 + random.nextInt(800000);
		if (!passwords.contains(ps)) {
			passwords.add(ps);
			k++;
		}
		k--;
	}
}
public void executeDatabase(ArrayList<Integer> ids,
		ArrayList<Integer> passwords, Statement stmt) {
	for (int j = 0; j < 5; j++) {
		String sql = "INSERT INTO admin (ID,password) " + "VALUES ('"
				+ ids.get(j) + "','" + passwords.get(j) + "')";
		try {
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
public static void main(String[] args) throws SQLException {
	AdminDatabase main = new AdminDatabase();
	main.createAdmins();
	
}
}