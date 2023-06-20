package main.java.cn.edu.whut.sept.zuul;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.SystemColor;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
//	private LogRecService logRecService = new LogRecService();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setLocationRelativeTo(null);
					frame.setResizable(false);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		super("登录");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 401, 260);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(245, 245, 245));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		textField = new JTextField();
		textField.setFont(new Font("宋体", Font.BOLD, 14));
		textField.setBounds(124, 35, 179, 23);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel labName = new JLabel("用户名：");
		labName.setFont(new Font("宋体", Font.BOLD, 16));
		labName.setBounds(61, 35, 64, 23);
		panel.add(labName);
		JButton btnNewButton = new JButton("新游戏");
		btnNewButton.setBackground(new Color(211, 211, 211));
		btnNewButton.setFont(new Font("宋体", Font.BOLD, 16));
		btnNewButton.setBounds(122, 111, 150, 31);
		panel.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text = textField.getText();
				if(text.equals(""))
					JOptionPane.showMessageDialog(null,"请输入用户名！","错误提示",JOptionPane.ERROR_MESSAGE);
				else {
					Login.this.setVisible(false);
					new GameFrame(textField.getText().trim(), true);
				}
			}
		});
		
		JButton btnNewButton_1 = new JButton("清空输入框");
		btnNewButton_1.setFont(new Font("宋体", Font.BOLD, 16));
		btnNewButton_1.setBackground(new Color(211, 211, 211));
		btnNewButton_1.setBounds(122, 70, 150, 31);
		panel.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
			}
		});
		
		JButton btnNewButton_2 = new JButton("继续游戏");
		btnNewButton_2.setBackground(new Color(211, 211, 211));
		btnNewButton_2.setFont(new Font("宋体", Font.BOLD, 16));
		btnNewButton_2.setBounds(122, 152, 150, 34);
		panel.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text = textField.getText();
				if(text.equals(""))
					JOptionPane.showMessageDialog(null,"请输入用户名！","错误提示",JOptionPane.ERROR_MESSAGE);
				else {
					Login.this.setVisible(false);
					new GameFrame(textField.getText().trim(), false);
				}
			}
		});
	}
}
