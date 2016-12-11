import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
//SORUNSUZ ÇALIŞIYOR
public class MainMenuPanel extends JPanel {
	private int width = 600;
	private int height = 600;
	private MenuController controller;

	public static void main(String[] args) {

		new MainMenuPanel();
	}

	public MainMenuPanel() {
		 controller = new MenuController();
		JFrame frame = new JFrame();
		frame.setSize(width, height);
		createMenu(frame);
	}

	public void createMenu(JFrame frame) {

		this.setSize(width, height);
		this.setLayout(null);

		JLabel label1 = new JLabel("Welcome to Dorm Management System");
		JLabel label2 = new JLabel("Log in as :");
		JButton studentLog = new JButton("STUDENT");
		JButton adminLog = new JButton("ADMIN");
		JButton about = new JButton("About");
		JButton exit = new JButton("Exit");

		label1.setBounds(100, -10, 400, 100);
		label1.setForeground(Color.blue);
		label1.setFont(new Font("", Font.BOLD, 20));
		this.add(label1);

		label2.setBounds(70, 85, 400, 100);
		this.add(label2);

		studentLog.setVisible(true);
		studentLog.setBounds(150, 120, 120, 30);
		this.add(studentLog);
		studentLog.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				controller.getStudentLoginFrame();
			}
		});

		adminLog.setVisible(true);
		adminLog.setBounds(290, 120, 120, 30);
		this.add(adminLog);
		adminLog.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				controller.getAdminLoginFrame();
			}
		});

		exit.setVisible(true);
		exit.setBounds(450, 520, 120, 30);
		this.add(exit);
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				controller.closeDMS();
			}
		});

		about.setVisible(true);
		about.setBounds(20, 520, 120, 30);
		this.add(about);
		about.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				controller.getAboutMessage();
			}
		});
		frame.add(this);
		frame.setVisible(true);
	}

}
