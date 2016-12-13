import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class AdminController {
	AdminModel model = new AdminModel();
	String ID;
	public AdminController() {
		// TODO Auto-generated constructor stub
	}
	public void checkAdminLogin(String ID, char[] password) {
	this.ID =ID;	
	try {
		if (!model.checkID(ID, password)) {
			JOptionPane.showMessageDialog(null, " Please check the username or password and try again! ");
		} else {
			new AdminPage(Integer.valueOf(ID));
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}

	}
	public void startAllocate() {
		model.allocation();
	}
}
