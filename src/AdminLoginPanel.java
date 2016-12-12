import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class AdminLoginPanel{

	private JTextField loginName;
	private JPasswordField loginPassword;
	private AdminController controller;

	public AdminLoginPanel() {
		controller = new AdminController();
		
		JFrame adminFrame = new JFrame("Admin Login");
		adminFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		adminFrame.setSize(600, 280);
		adminFrame.setLocation(250, 40);
		adminFrame.setVisible(true);
		adminFrame.setTitle("Admin Login");
		adminFrame.setLayout(null);

		JLabel label1 = new JLabel("Administrator Name: ");
		label1.setBounds(50, 54, 120, 120);
		adminFrame.add(label1);

		JLabel label2 = new JLabel("PassWord: ");
		label2.setBounds(100, 85, 120, 120);
		adminFrame.add(label2);

		// Administrator Log Name
		loginName = new JTextField();
		loginName.setBounds(180, 100, 290, 25);
		adminFrame.add(loginName);

		// Administrator Log PassWord
		loginPassword = new JPasswordField();
		loginPassword.setBounds(180, 131, 290, 25);
		adminFrame.add(loginPassword);

		JButton loginButton = new JButton("Login");
		loginButton.setBounds(380, 190, 90, 25);
		adminFrame.add(loginButton);
		loginButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				controller.checkAdminLogin(loginName.getText(),loginPassword.getPassword());
			}
		});
		JButton closeButton = new JButton("Close");
		closeButton.setBounds(480, 190, 90, 25);
		adminFrame.add(closeButton);
		closeButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				adminFrame.setVisible(false);		
			}
		});

	}

}
