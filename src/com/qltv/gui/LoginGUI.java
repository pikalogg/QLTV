package com.qltv.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.qltv.bll.SqlCommands;

public class LoginGUI extends JFrame{
	private static final long serialVersionUID = 1L;

	public LoginGUI() {
		setTitle("Login");
		setSize(680, 400);
		setResizable(false);
		setUndecorated(true);
		setOpacity(0.9F);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		getContentPane().setBackground(Color.BLACK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel l1 = new JLabel(new ImageIcon("rec\\img\\login\\tpb.jpg"));
		JLabel l2 = new JLabel(new ImageIcon("rec\\img\\login\\tpb.jpg"));
		
		jbExit = new JButton(new ImageIcon("rec\\img\\login\\exit.png"));
		jblogin = new JButton(new ImageIcon("rec\\img\\login\\login.jpg"));
		jlbgr = new JLabel(new ImageIcon("rec\\img\\login\\bgr.png"));
		jlUsername = new JLabel("Username");
		jlPassword = new JLabel("Password");
		jtextUsername = new JTextField("user-name");
		jpassPassword = new JPasswordField("password");
		jpLogin = new JPanel();
		
		jbExit.setBounds(655, 0, 25, 25);
		getContentPane().add(jbExit);
		jbExit.setBackground(Color.BLACK);
		jbExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		
		jlbgr.setBounds(20, 20, 350, 350);
		getContentPane().add(jlbgr);
		
		/////-layout login-/////////
		jpLogin.setBackground(Color.RED);
		jpLogin.setBounds(390, 50, 250, 300);
		jpLogin.setLayout(null);
		getContentPane().add(jpLogin);
		
		jlLogin = new JLabel("Login");
		jlLogin.setFont(new Font("", Font.ITALIC, 25));
		jlLogin.setBounds(90, 5, 100, 45);
		jlLogin.setForeground(Color.white);
		jpLogin.add(jlLogin);
		
		//
		jlUsername.setFont(new Font("", Font.ITALIC, 14));
		jlUsername.setBounds(17, 65, 100, 30);
		jlUsername.setForeground(Color.white);
		jpLogin.add(jlUsername);
		//
		jtextUsername.setBorder(null);
		jtextUsername.setFont(new Font("", Font.PLAIN, 14));
		jtextUsername.setOpaque(false);
		jtextUsername.setForeground(Color.white);
		
		l1.setBounds(17, 100, 218, 30);
		l1.setLayout(null);
		jtextUsername.setBounds(0, 2, 218, 28);
		l1.add(jtextUsername);
		jpLogin.add(l1);
		
		//
		jlPassword.setFont(new Font("", Font.ITALIC, 14));
		jlPassword.setBounds(17, 145, 100, 30);
		jlPassword.setForeground(Color.white);
		jpLogin.add(jlPassword);
		//
		jpassPassword.setBorder(null);
		jpassPassword.setFont(new Font("", Font.PLAIN, 14));
		jpassPassword.setOpaque(false);
		jpassPassword.setForeground(Color.white);
		
		l2.setBounds(17, 180, 218, 30);
		l2.setLayout(null);
		jpassPassword.setBounds(0, 2, 218, 28);
		l2.add(jpassPassword);
		jpLogin.add(l2);
		
		///
		jblogin.setBounds(148, 235, 84, 35);
		jpLogin.add(jblogin);
		
		jblogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loged();
			}
		});
		///////////select all text on focus/////////////
		jtextUsername.addFocusListener(new java.awt.event.FocusAdapter() {
		    public void focusGained(java.awt.event.FocusEvent evt) {
		    	jtextUsername.selectAll();
		    }
		});
		jpassPassword.addFocusListener(new java.awt.event.FocusAdapter() {
		    public void focusGained(java.awt.event.FocusEvent evt) {
		    	jpassPassword.selectAll();
		    }
		});
		////////////////kl for enter///////////////
		jtextUsername.addKeyListener(new KeyAdapter()
		{
			public void keyPressed(KeyEvent e)
			{
			if(e.getKeyCode()==KeyEvent.VK_ENTER)	
				jpassPassword.requestFocusInWindow(); 
			}
		});
		jpassPassword.addKeyListener(new KeyAdapter()
		{
			public void keyPressed(KeyEvent e)
			{
			if(e.getKeyCode()==KeyEvent.VK_ENTER)	
				loged();
			}
		});
	}
	
	private void loged()
	{
		String user = jtextUsername.getText();
		String passw = String.valueOf(jpassPassword.getPassword());
		if(user.equals(SqlCommands.usename)&&passw.equals(SqlCommands.pass))   
		{
//			JOptionPane.showMessageDialog(null, "Đăng nhập thành công","", JOptionPane.INFORMATION_MESSAGE);
			new  HomeGui().setVisible(true);
			dispose();
		}
		else{
			JOptionPane.showMessageDialog(null, "Sai tài khoản hoặc mật khẩu","", JOptionPane.ERROR_MESSAGE);	
			jpassPassword.setText("");
			jtextUsername.setText("User-name");
			jtextUsername.requestFocusInWindow();
		}	
	}
	JButton jbExit, jblogin;
	JLabel jlbgr, jlLogin, jlUsername, jlPassword;
	JPanel jpLogin;
	JTextField jtextUsername;
	JPasswordField jpassPassword;
	
	
	public static void main(String[] args) {
		new LoginGUI().setVisible(true);
	}
}
