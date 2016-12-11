
public class Student {
	int studentID;
	int password;
	boolean isDisabled;
	boolean isFullyScholarship;
	int priorityCounter = 0;

	public Student(int studentID, int password) {
		this.studentID = studentID;
		this.password = password;
		isDisabled = false;
		isFullyScholarship = false;
	}

	public boolean getDisabled() {
		return isDisabled;
	}

	public boolean getFullyScholarship() {
		return isFullyScholarship;

	}

	public void setDisabled(boolean bool) {
		isDisabled = bool;
	}

	public void setFullyScholarship(boolean bool) {
		isFullyScholarship = bool;
	}

	public int getStudentID() {
		return studentID;

	}

	public int getPassword() {
		return password;
	}
public void checkPriortyCounter(){
	priorityCounter = ((isDisabled)?1:0) + ((isFullyScholarship)?1:0);
}
public int getPriorityCounter(){
	return priorityCounter;
}
}

