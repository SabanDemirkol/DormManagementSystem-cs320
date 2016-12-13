import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import sun.applet.Main;

public class StudentPage extends JPanel {
	private int width = 600;
	private int height = 600;
	private StudentController controller;
	private int studentID;
	JFrame frame;
	public static void main(String[] args) {
		new StudentPage(4392);
	}

	public StudentPage( int studentID ) {
		this.studentID = studentID;
		controller = new StudentController();
		 frame = new JFrame();
		frame.setSize(width, height);
		createStudentMenu(frame);
	}

	private void createStudentMenu(JFrame frame) {
		this.setSize(width, height);
		this.setLayout(new GridLayout(6, 1));

		JLabel label1 = new JLabel("Welcome to Student Interface");
		label1.setBounds(200, -10, 300, 100);
		label1.setForeground(Color.blue);
		label1.setBounds(100, -10, 400, 100);
		label1.setFont(new Font("", Font.BOLD, 20));
		this.add(label1);

		JButton checkRooms = new JButton("Check Rooms Availability");
		JButton applyForm = new JButton("Fill up a form");
		JButton checkAppointment = new JButton("Check Allocation");
		JButton payDormFee = new JButton("Pay Dorm Fee");
		JButton LogOff = new JButton("Log Off");

		checkRooms.setVisible(true);
		this.add(checkRooms);
		checkRooms.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});

		applyForm.setVisible(true);
		this.add(applyForm);
		applyForm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(controller.fillForm(studentID)){
					fillForm();
				}else{
				JOptionPane.showMessageDialog(null, "Application form already filled.");
		}}});

		checkAppointment.setVisible(true);
		this.add(checkAppointment);

		payDormFee.setVisible(true);
		this.add(payDormFee);
		payDormFee.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				openPaymentWindow();
			}
		});

		LogOff.setVisible(true);
		this.add(LogOff);
		LogOff.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, " Logged Off Successfully ");
				System.exit(0);
			}
		});

		frame.add(this);
		frame.setVisible(true);
	}

	public void openPaymentWindow() {
		int width = 500;
		int height = 300;

		JFrame paymentFrame = new JFrame();
		paymentFrame.setSize(width, height);
		paymentFrame.setLayout(null);

		JLabel amount = new JLabel(" Dormitory fee is 7500 TL. ");
		amount.setBounds(180, 10, 250, 50);

		JLabel explanation = new JLabel("The payment will be withdrawed from your registered account in the system. ");
		explanation.setBounds(25, 40, 500, 50);

		JButton approve = new JButton(" Approve payment ");
		approve.setBounds(150, 150, 200, 30);
		approve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(controller.checkFormStatus(studentID))
				JOptionPane.showMessageDialog(null, " Payment is successfull ");
				controller.setPayment(studentID);
paymentFrame.setVisible(false);			}
		});

		paymentFrame.add(amount);
		paymentFrame.add(approve);
		paymentFrame.add(explanation);
		paymentFrame.setVisible(true);
	}

	public void fillForm() {

		JFrame formFrame = new JFrame();
		formFrame.setSize(width, height);
		formFrame.setLayout(null);
		String[] roomList = { "-", "Single room with bathroom" };
		String[] priorityOptions = { "-", "None", "Scholarship", "Disabled" };
		String[] genderOption = { "-", "male", "female" };
		JLabel label1 = new JLabel(" Application Form ");
		JLabel explanation = new JLabel(" Please fill the following questions: ");
		JLabel nameLabel = new JLabel("Enter your name: ");
		JLabel surnameLabel = new JLabel("Enter your surname: ");
		JTextField nameField = new JTextField();
		JTextField surnameField = new JTextField();
		JComboBox<String> priority = new JComboBox<>(priorityOptions);
		JComboBox<String> gender = new JComboBox<>(genderOption);
		JComboBox<String> room = new JComboBox<>(roomList);
		JButton apply = new JButton("Apply");

		label1.setBounds(220, -10, 400, 100);
		label1.setForeground(Color.blue);
		label1.setFont(new Font("", Font.BOLD, 20));

		nameLabel.setBounds(50, 150, 150, 30);
		surnameLabel.setBounds(50, 200, 150, 30);
		explanation.setBounds(10, 50, 400, 100);
		nameField.setBounds(200, 150, 300, 30);
		surnameField.setBounds(200, 200, 300, 30);
		priority.setBounds(50, 300, 100, 30);
		gender.setBounds(50, 400, 100, 30);
		room.setBounds(50, 500, 100, 30);
		apply.setBounds(250, 500, 100, 30);
		apply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String comboGender = gender.getSelectedItem().toString();
				String comboRoom = room.getSelectedItem().toString();
				String comboPriority = priority.getSelectedItem().toString();
				System.out.println(comboPriority);
				if ((comboGender + comboPriority + comboRoom).contains("-") || nameField.getText().isEmpty()
						|| surnameField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please fill all blanks");

				} else {
					controller.setFormFilled(""+studentID);
					controller.checkPriorty(comboPriority,studentID);
					JOptionPane.showMessageDialog(null, " Application is successfull. ");
					formFrame.setVisible(false);
				}
			}
		});
		formFrame.add(gender);
		formFrame.add(room);
		formFrame.add(nameLabel);
		formFrame.add(surnameLabel);
		formFrame.add(label1);
		formFrame.add(explanation);
		formFrame.add(nameField);
		formFrame.add(surnameField);
		formFrame.add(priority);
		formFrame.add(apply);

		formFrame.setVisible(true);

	}
}
