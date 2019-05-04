package com.qltv.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class HomeGui extends JFrame{
	private static final long serialVersionUID = 1L;

	public HomeGui() {
		setTitle("Home");
//		setSize(900, 500);
//		setUndecorated(true);
		setSize(906, 525);
		setResizable(false);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		//--text--//
		jlTitle = new JLabel("Quản lý thư viện");
		jlTitle.setBorder(null);
		jlTitle.setFont(new Font("", Font.ITALIC, 26));
		jlTitle.setOpaque(false);
		jlTitle.setForeground(Color.white);
		jlTitle.setBounds(150, 15, 300, 40);
		getContentPane().add(jlTitle);
		
		jlCN = new JLabel("Chức năng");
		jlCN.setBorder(null);
		jlCN.setFont(new Font("", Font.ITALIC, 19));
		jlCN.setOpaque(false);
		jlCN.setForeground(Color.white);
		jlCN.setBounds(674, 87, 100, 30);
		getContentPane().add(jlCN);
		//--chức năng--//
		jbQldg = new JButton(new ImageIcon("rec\\img\\home\\tpb1.png"));
		jbQlmt = new JButton(new ImageIcon("rec\\img\\home\\tpb4.png"));
		jbQlsach = new JButton(new ImageIcon("rec\\img\\home\\tpb3.png"));
		jbSearch = new JButton(new ImageIcon("rec\\img\\home\\tpb2.png"));
		jbThongke = new JButton(new ImageIcon("rec\\img\\home\\tpb5.png"));
		
		jbQldg.setBounds(168, 150, 118, 123);
		jbQlmt.setBounds(318, 150, 118, 123);
		jbQlsach.setBounds(468, 150, 118, 123);
		jbSearch.setBounds(618, 150, 118, 123);
		jbThongke.setBounds(168, 310, 118, 123);
		jbQldg.setLayout(null);
		jbQlmt.setLayout(null);
		jbSearch.setLayout(null);
		jbThongke.setLayout(null);
		jbQlsach.setLayout(null);
		jbQldg.setBorder(null);
		jbQlmt.setBorder(null);
		jbSearch.setBorder(null);
		jbThongke.setBorder(null);
		jbQlsach.setBorder(null);
		
		getContentPane().add(jbQldg);
		getContentPane().add(jbQlmt);
		getContentPane().add(jbSearch);
		getContentPane().add(jbThongke);
		getContentPane().add(jbQlsach);
						//----~~~~~~~~~----//
		jbQldg.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MainGUI m = new MainGUI();
				m.setVisible(true);
				m.selectPanelQldg();
				dispose();
			}
		});
		jbQlmt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MainGUI m = new MainGUI();
				m.setVisible(true);
				m.selectPanelQmt();
				dispose();
			}
		});
		jbSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MainGUI m = new MainGUI();
				m.setVisible(true);
				m.selectPanelSea();
				dispose();
			}
		});
		jbQlsach.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MainGUI m = new MainGUI();
				m.setVisible(true);
				m.selectPanelQlsach();
				dispose();
			}
		});
		jbThongke.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MainGUI m = new MainGUI();
				m.setVisible(true);
				m.selectPanelThongke();
				dispose();
			}
		});
						//----~~~~~~~~~----//
		JLabel icondg = new JLabel(new ImageIcon("rec\\img\\home\\icondocgia.png"));
		icondg.setBounds(20, 0, 100, 100);
		jbQldg.add(icondg);
		JLabel textdg1 = new JLabel("Quản lý");
		textdg1.setBounds(40, 67, 150, 30);
		setFone(textdg1);
		jbQldg.add(textdg1);
		JLabel textdg2 = new JLabel("độc giả");
		textdg2.setBounds(40, 90, 150, 30);
		setFone(textdg2);
		jbQldg.add(textdg2);
		
		JLabel iconmt = new JLabel(new ImageIcon("rec\\img\\home\\iconmuontra.png"));
		iconmt.setBounds(20, 0, 100, 100);
		jbQlmt.add(iconmt);
		JLabel textmt1 = new JLabel("Quản lý");
		textmt1.setBounds(40, 67, 150, 30);
		setFone(textmt1);
		jbQlmt.add(textmt1);
		JLabel textmt2 = new JLabel("mượn, trả");
		textmt2.setBounds(35, 90, 150, 30);
		setFone(textmt2);
		jbQlmt.add(textmt2);
		
		JLabel iconks = new JLabel(new ImageIcon("rec\\img\\home\\iconfile.png"));
		iconks.setBounds(20, 0, 100, 100);
		jbQlsach.add(iconks);
		JLabel textks1 = new JLabel("Quản lý");
		textks1.setBounds(40, 67, 150, 30);
		setFone(textks1);
		jbQlsach.add(textks1);
		JLabel textks2 = new JLabel("kho sách");
		textks2.setBounds(35, 90, 150, 30);
		setFone(textks2);
		jbQlsach.add(textks2);
		
		JLabel icontk = new JLabel(new ImageIcon("rec\\img\\home\\icontimkiem.png"));
		icontk.setBounds(20, 0, 100, 100);
		jbSearch.add(icontk);
		JLabel texttk = new JLabel("Tìm kiếm");
		texttk.setBounds(35, 85, 150, 30);
		setFone(texttk);
		jbSearch.add(texttk);
		
		JLabel icontkbc = new JLabel(new ImageIcon("rec\\img\\home\\iconthongke.png"));
		icontkbc.setBounds(20, 0, 100, 100);
		jbThongke.add(icontkbc);
		JLabel texttkbc1 = new JLabel("Thống kê,");
		texttkbc1.setBounds(33, 67, 150, 30);
		setFone(texttkbc1);
		jbThongke.add(texttkbc1);
		JLabel texttkbc2 = new JLabel("báo cáo");
		texttkbc2.setBounds(40, 90, 150, 30);
		setFone(texttkbc2);
		jbThongke.add(texttkbc2);
		//-bgr-//
		jlbgr = new JLabel(new ImageIcon("rec\\img\\home\\homebgr.png"));
		jlbgr.setBounds(0, 0, 900, 500);
		getContentPane().add(jlbgr);
		
		//--2 button--//
		jlExit = new JLabel();
		jlExit.setBounds(820, 406, 81, 54);
		getContentPane().add(jlExit);
		jlExit.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {
				System.exit(0);
				}
			public void mouseExited(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			public void mouseClicked(MouseEvent e) {}
		});
		
		jlBack = new JLabel();
		jlBack.setBounds(0, 406, 81, 54);
		getContentPane().add(jlBack);
		jlBack.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {
				new LoginGUI().setVisible(true);
				dispose();
			}
			public void mouseExited(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			public void mouseClicked(MouseEvent e) {}
		});
		
	}
	private void setFone(JLabel jl) {
		jl.setBorder(null);
		jl.setFont(new Font("", Font.PLAIN, 16));
		jl.setOpaque(false);
		jl.setForeground(Color.white);
	}
	public static void main(String[] args) {
		new HomeGui().setVisible(true);
	}
	JLabel jlbgr,jlExit,jlBack,jlTitle,jlCN;
	JButton jbQldg,jbQlmt,jbSearch,jbThongke,jbQlsach;
}
