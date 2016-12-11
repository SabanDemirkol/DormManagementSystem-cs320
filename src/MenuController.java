import javax.swing.JOptionPane;

public class MenuController {

	public void getStudentLoginFrame() {
		new StudentLoginPanel();
	}

	public void getAdminLoginFrame() {
		new AdminLoginPanel();
	}

	public void checkAdminLogin(String text, char[] password) {
		// TODO Auto-generated method stub
		
	}

	public void getAboutMessage() {
		JOptionPane.showMessageDialog(null,
				"DMS is a software which provides us how many rooms are empty, full and how many room is available to people.");
		
	}

	public void closeDMS() {
		JOptionPane.showMessageDialog(null, " Thanks to use DMS ");
		System.exit(0);		
	}

}
