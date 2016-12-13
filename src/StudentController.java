import java.awt.HeadlessException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class StudentController {
	StudentModel model = new StudentModel();
String ID;
	public StudentController() {
	}

	public void checkLogin(String ID, char[] ps) {
		this.ID = ID;
		try {
			if (!model.isLoginCorrect(ID, ps)) {
				JOptionPane.showMessageDialog(null, " Please check the username or password and try again! ");
			} else {
				new StudentPage(Integer.valueOf(ID));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean fillForm(int studentID) {
		return (model.isFormFilled(studentID));
	}

	
		

	public void setFormFilled(String id) {
model.setIsFormFilled(id);
	}

	public void checkPriorty(String comboPriority, int studentID) {
		// TODO Auto-generated method stub
		System.out.println(ID);
		if(comboPriority.equals("None"))
			model.setStudentsPriority(0,studentID);
		else if ( comboPriority.equals("Scholarship"))
			model.setStudentsPriority(1,studentID);
		else if(comboPriority.equals("Disabled"))
			model.setStudentsPriority(2,studentID);
	}
}
	

