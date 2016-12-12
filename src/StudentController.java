import java.awt.HeadlessException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class StudentController {
	StudentLoginModel model = new StudentLoginModel();

	public StudentController() {
	}

	public void checkLogin(String user, char[] ps, ArrayList<Student> students) {
		try {
			if (!model.isLoginCorrect(user, ps)) {
				JOptionPane.showMessageDialog(null, " Please check the username or password and try again! ");
				new StudentLoginPanel();
			} else {
				boolean isValid = false;
				int indexOfStudent = 0;
				for (Student student : students) {
					if(student.getStudentID()==Integer.valueOf(user)){
						indexOfStudent = students.indexOf(student);

					}
				
				}
				
				new StudentPage(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
