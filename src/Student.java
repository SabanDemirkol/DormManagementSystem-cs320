
public class Student {
	int studentID;
	int password;
	int priorityCounter = 0;
	boolean isDisabled;
	boolean isFullyScholarship;
	String gender = null;
	public Student(int studentID, int password) {
		this.studentID = studentID;
		this.password = password;
		isDisabled = false;
		isFullyScholarship = false;
	}
	public void setGender(String gender){
		this.gender = gender;
	}
	public String getGender(){
		if(!gender.equals(null))
		return gender;
		else return " ";
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
	priorityCounter =((isFullyScholarship)?1:0);
	priorityCounter = ((isDisabled)?2:priorityCounter);
}
public int getPriorityCounter(){
	return priorityCounter;
}
}

