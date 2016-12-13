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

public class StudentPage extends JPanel{
	private int width = 600;
	private int height = 600;
	private MenuController controller;
	
	public static void main(String[] args) {

		new StudentPage();
	}
	
	public StudentPage() {
		controller = new MenuController();
		JFrame frame = new JFrame();
		frame.setSize(width, height);
		createStudentMenu(frame);
	}

	private void createStudentMenu(JFrame frame) {
		this.setSize(width, height);
		this.setLayout(new GridLayout(6, 1));
		
		JLabel label1 = new JLabel("Welcome to Student Interface");
		label1.setBounds(100, -10, 400, 100);
		label1.setForeground(Color.blue);
		label1.setBounds(100, -10, 400, 100);
		label1.setFont(new Font("", Font.BOLD, 20));
		this.add(label1);
		
		JButton applyForm = new JButton("Fill up a form");
		JButton checkAllocation = new JButton("Check Allocation");
		JButton payDormFee = new JButton("Pay Dorm Fee");
		JButton LogOff = new JButton("Log Off");
		
		applyForm.setVisible(true);
		this.add(applyForm);
		applyForm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				fillForm();
			}
		});
		
		checkAllocation.setVisible(true);
		this.add(checkAllocation);
		
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
				JOptionPane.showMessageDialog(null, " Payment is successfull ");
				System.exit(0);
			}
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
		
		String[] priorityOptions = new String[] {"None", "Scholarship", "Disabled"};
		String[] genderOptions = new String[] {"Male", "Female"};
		
		JLabel label1 = new JLabel(" Application Form ");
		JLabel explanation = new JLabel( " Please fill the following questions: ");
		JTextField name = new JTextField("Enter your name: ");
		JTextField surname = new JTextField("Enter your surname: ");
		JLabel labelGender = new JLabel(" Choose your gender");
		JLabel labelPriority = new JLabel(" Choose your priority type");
		JComboBox<String> gender = new JComboBox<>(genderOptions);
		JComboBox<String> priority = new JComboBox<>(priorityOptions);	
		JButton apply = new JButton("Apply");
		
		label1.setBounds(220, -10, 400, 100);
		label1.setForeground(Color.blue);
		label1.setFont(new Font("", Font.BOLD, 20));
		
		explanation.setBounds(10, 50, 400, 100);
		name.setBounds(50, 150, 300, 30);
		surname.setBounds(50, 200, 300, 30);
		labelGender.setBounds(50, 250, 150, 30);
		gender.setBounds(50, 280, 100, 30);
		labelPriority.setBounds(50, 330, 150, 30);
		priority.setBounds(50, 360, 100, 30);
		
		apply.setBounds(250, 500, 100, 30);
		apply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, " Application is successfull. ");
				System.exit(0);			
			}
		});
		
		formFrame.add(label1);
		formFrame.add(explanation);
		formFrame.add(name);
		formFrame.add(surname);
		formFrame.add(labelGender);
		formFrame.add(gender);
		formFrame.add(labelPriority);
		formFrame.add(priority);
		formFrame.add(apply);
		
		formFrame.setVisible(true);
		
	}
}
