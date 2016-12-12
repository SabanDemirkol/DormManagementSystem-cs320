import java.awt.HeadlessException;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class StudentController {
StudentLoginModel model = new StudentLoginModel();
public StudentController() {
}
	public void checkLogin(String user, char[] ps) {
		try {
			if(!model.isLoginCorrect(user,ps)){
			JOptionPane.showMessageDialog(null, " Please check the username or password and try again! ");
new StudentLoginPanel();
			}else{
new StudentPage(new Student(Integer.valueOf(user),Integer.parseInt(new String(ps))));		
}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
