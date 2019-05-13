package com.qltv.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.qltv.bll.SqlCommands;

@SuppressWarnings("serial")
public class FrameUpdateUser extends JFrame{

	public FrameUpdateUser() {
		setSize(480, 225);
		setResizable(false);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		jlTk = new JLabel("Tài Khoản:");
		jlUser = new JLabel("Username");
		jlPass = new JLabel("Password"); 
		jlQd = new JLabel("Quy định:");
		jlMucphat = new JLabel("Mức phạt");
		jlTuoimax = new JLabel("Tuổi max");
		jlTuoiMin = new JLabel("Tuổi min");
		jlSsdm = new JLabel("Số sách được mượn");
		jlsndc = new JLabel("Số ngày được mượn");
		jltpmn = new JLabel("Tiền phạt một ngày");
		getContentPane().add(jlTk);
		getContentPane().add(jlUser);
		getContentPane().add(jlPass);
		getContentPane().add(jlQd);
		getContentPane().add(jlMucphat);
		getContentPane().add(jlTuoimax);
		getContentPane().add(jlTuoiMin);
		getContentPane().add(jlSsdm);
		getContentPane().add(jlsndc);
		getContentPane().add(jltpmn);
		setFone(jlTk);
		setFone(jlUser);
		setFone(jlPass);
		setFone(jlQd);
		setFone(jlMucphat);
		setFone(jlTuoimax);
		setFone(jlTuoiMin);
		setFone(jlSsdm);
		setFone(jlsndc);
		setFone(jltpmn);
		jlTk.setBounds(10, 5, 120, 30);
		jlUser.setBounds(10, 30, 120, 30);
		jlPass.setBounds(220, 30, 120, 30);
		jlQd.setBounds(10, 60, 120, 30);
		jlMucphat.setBounds(10, 85, 220, 30);
		jlTuoimax.setBounds(165, 85, 120, 30);
		jlTuoiMin.setBounds(325, 85, 125, 30);
		jlSsdm.setBounds(10, 120, 220, 30);
		jlsndc.setBounds(165, 120, 220, 30);
		jltpmn.setBounds(325, 120, 220, 30);
		
		jtUser = new JTextField();
		jtPass = new JTextField();
		jtMucphat = new JTextField();
		jtTuoimax = new JTextField();
		jtTuoiMin = new JTextField();
		jtSsdm = new JTextField();
		jtsndc = new JTextField();
		jttpmn = new JTextField();
		getContentPane().add(jtUser);
		getContentPane().add(jtPass);
		getContentPane().add(jtMucphat);
		getContentPane().add(jtTuoimax);
		getContentPane().add(jtTuoiMin);
		getContentPane().add(jtSsdm);
		getContentPane().add(jtsndc);
		getContentPane().add(jttpmn);
		jtUser.setBounds(75, 30, 120, 30);
		jtPass.setBounds(280, 30, 120, 30);
		jtMucphat.setBounds(130, 85, 30, 30);
		jtTuoimax.setBounds(290, 85, 30, 30);
		jtTuoiMin.setBounds(440, 85, 30, 30);
		jtSsdm.setBounds(130, 120, 30, 30);
		jtsndc.setBounds(290, 120, 30, 30);
		jttpmn.setBounds(440, 120, 30, 30);
		
		jbUpdateUser = new JButton("UpdateUser");
		jbUpdateQd = new JButton("UpdateQD");
		jbThoat = new JButton("Thoát");
		getContentPane().add(jbUpdateUser);
		getContentPane().add(jbUpdateQd);
		getContentPane().add(jbThoat);
		jbUpdateQd.setBounds(25, 160, 120, 30);
		jbUpdateUser.setBounds(175, 160, 120, 30);
		jbThoat.setBounds(325, 160, 120, 30);
		
		jlbgr = new JLabel(new ImageIcon("rec\\img\\main\\sua.png"));
		jlbgr.setBounds(0, 0, 480, 300);
		getContentPane().add(jlbgr);
		addListener();
	}
	private void setFone(JLabel jl) {
		jl.setBorder(null);
		jl.setFont(new Font("", Font.PLAIN, 12));
		jl.setOpaque(false);
		jl.setForeground(Color.WHITE);
	}
	private void addListener() {
		jbUpdateUser.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					String _usename = jtUser.getText();
					String  _pass = jtPass.getText();
					if(SqlCommands.Updateroot_pa(_usename, _pass)) {
						JOptionPane.showMessageDialog(null, "Update thành công", "Message", JOptionPane.PLAIN_MESSAGE);
						SqlCommands.usename = _usename;
						SqlCommands.pass = _pass;
					}
					else JOptionPane.showMessageDialog(null, "Update error", "Message", JOptionPane.ERROR_MESSAGE);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Nhập lỗi kiểu dữ liệu", "Message", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		jbUpdateQd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {

					int _mucphat = Integer.parseInt(jtMucphat.getText());
					int _tuoimax = Integer.parseInt(jtTuoimax.getText());	
					int _tuoimin = Integer.parseInt(jtTuoiMin.getText());	
					int _songayduocmuon = Integer.parseInt(jtsndc.getText());	
					int _sosachduocmuon = Integer.parseInt(jtSsdm.getText());
					int _tienphatmotngay = Integer.parseInt(jttpmn.getText());
					if(SqlCommands.Updateroot_qd(_mucphat, _tuoimax, _tuoimin, _songayduocmuon, _sosachduocmuon, _tienphatmotngay)) {
						JOptionPane.showMessageDialog(null, "Update thành công", "Message", JOptionPane.PLAIN_MESSAGE);
						SqlCommands.mucphat = _mucphat;
						SqlCommands.tuoimax = _tuoimax;	
						SqlCommands.tuoimin = _tuoimin;	
						SqlCommands.songayduocmuon = _songayduocmuon;	
						SqlCommands.sosachduocmuon = _sosachduocmuon;
						SqlCommands.tienphatmotngay = _tienphatmotngay;
					}
					else JOptionPane.showMessageDialog(null, "Update error", "Message", JOptionPane.ERROR_MESSAGE);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Nhập lỗi kiểu dữ liệu", "Message", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		jbThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
	}
	JLabel jlbgr,jlTk, jlUser, jlPass, jlQd, jlMucphat, jlTuoimax, jlTuoiMin, jlSsdm, jlsndc, jltpmn;
	JTextField jtTk, jtUser, jtPass, jtMucphat, jtTuoimax, jtTuoiMin, jtSsdm, jtsndc, jttpmn;
	JButton jbUpdateUser, jbUpdateQd, jbThoat;
	
	public static void main(String[] args) {
		new FrameUpdateUser().setVisible(true);
	}
}
