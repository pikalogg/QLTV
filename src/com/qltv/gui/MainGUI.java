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

public class MainGUI extends JFrame{
	private static final long serialVersionUID = 1L;

	public MainGUI() {
		setTitle("Main");
		setSize(900, 540);
		setUndecorated(true);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//
		panelDocgia = new PanelQldg();
		panelMuontra = new PanelQlmt();
		panelSach = new PanelQlSach();
		panelTimkiem = new PanelTimkiem();
		panelThongke = new PanelThongke();
		getContentPane().add(panelDocgia);
		getContentPane().add(panelMuontra);
		getContentPane().add(panelSach);
		getContentPane().add(panelTimkiem);
		getContentPane().add(panelThongke);

		panelThongke.setBounds(0, 130, 900, 310);
		panelTimkiem.setBounds(0, 130, 900, 310);
		panelSach.setBounds(0, 130, 900, 310);
		panelMuontra.setBounds(0, 130, 900, 310);
		panelDocgia.setBounds(0, 130, 900, 315);
		
		//- lựa chức năng- //
		jbQldg = new JButton();
		jbQlmt = new JButton();
		jbQlsach = new JButton();
		jbSearch = new JButton();
		jbThongke = new JButton();
		
		jbQldg.setBounds(0, 0, 180, 40);
		jbQlmt.setBounds(180, 0, 180, 40);
		jbQlsach.setBounds(360, 0, 180, 40);
		jbSearch.setBounds(540, 0, 180, 40);
		jbThongke.setBounds(720, 0, 180, 40);
		
		jbQldg.setBackground(Color.BLUE);
		jbQlmt.setBackground(Color.PINK);
		jbQlsach.setBackground(Color.YELLOW);
		jbSearch.setBackground(Color.ORANGE);
		jbThongke.setBackground(Color.GREEN);
		jbQldg.setLayout(null);
		jbQlmt.setLayout(null);
		jbQlsach.setLayout(null);
		jbSearch.setLayout(null);
		jbThongke.setLayout(null);
		
		getContentPane().add(jbQldg);
		getContentPane().add(jbQlmt);
		getContentPane().add(jbQlsach);
		getContentPane().add(jbSearch);
		getContentPane().add(jbThongke);
		
		JLabel icondg = new JLabel(new ImageIcon("rec\\img\\main\\icondocgia.png"));
		icondg.setBounds(20, 6, 40, 40);
		jbQldg.add(icondg);
		JLabel textdg = new JLabel("Quản lý độc giả");
		textdg.setBounds(60, 6, 150, 30);
		setFone(textdg);
		jbQldg.add(textdg);
		
		JLabel iconmt = new JLabel(new ImageIcon("rec\\img\\main\\iconmuontra.png"));
		iconmt.setBounds(20, 6, 40, 40);
		jbQlmt.add(iconmt);
		JLabel textmt = new JLabel("Quản lý mượn, trả");
		textmt.setBounds(60, 6, 150, 30);
		setFone(textmt);
		jbQlmt.add(textmt);
		
		JLabel iconsach = new JLabel(new ImageIcon("rec\\img\\main\\iconfile.png"));
		iconsach.setBounds(20, 6, 40, 40);
		jbQlsach.add(iconsach);
		JLabel textsach = new JLabel("Quản lý kho sách");
		textsach.setBounds(60, 6, 150, 30);
		setFone(textsach);
		jbQlsach.add(textsach);
		
		JLabel iconsea = new JLabel(new ImageIcon("rec\\img\\main\\icontimkiem.png"));
		iconsea.setBounds(20, 4, 40, 40);
		jbSearch.add(iconsea);
		JLabel textsea = new JLabel("Tìm kiếm");
		textsea.setBounds(80, 6, 150, 30);
		setFone(textsea);
		jbSearch.add(textsea);
		
		JLabel icontk = new JLabel(new ImageIcon("rec\\img\\main\\iconthongke.png"));
		icontk.setBounds(20, 4, 40, 40);
		jbThongke.add(icontk);
		JLabel texttk = new JLabel("Thống kê, báo cáo");
		texttk.setBounds(60, 6, 150, 30);
		setFone(texttk);
		jbThongke.add(texttk);
		
		jbQldg.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectPanelQldg();
			}
		});
		jbQlmt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectPanelQmt();
			}
		});
		jbSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectPanelSea();
			}
		});
		jbQlsach.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectPanelQlsach();
			}
		});
		jbThongke.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectPanelThongke();
			}
		});
		//-Title-//
		jlTitle = new JLabel("Pika");
		jlTitle.setBorder(null);
		jlTitle.setFont(new Font("", Font.ITALIC, 26));
		jlTitle.setOpaque(false);
		jlTitle.setForeground(Color.white);
		jlTitle.setBounds(150, 55, 300, 40);
		getContentPane().add(jlTitle);
		

		jlExit = new JLabel();
		jlExit.setBounds(820, 436, 81, 54);
		getContentPane().add(jlExit);
		jlExit.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {
				dispose();
				}
			public void mouseExited(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			public void mouseClicked(MouseEvent e) {}
		});
		
		jlBack = new JLabel();
		jlBack.setBounds(0, 436, 81, 54);
		getContentPane().add(jlBack);
		jlBack.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {
				new HomeGui().setVisible(true);
				dispose();
			}
			public void mouseExited(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			public void mouseClicked(MouseEvent e) {}
		});
		
		selectPanelQldg();
		//-bgr-//
		jlbgr = new JLabel(new ImageIcon("rec\\img\\main\\mainbgr.png"));
		jlbgr.setBounds(0, 40, 900, 500);
		getContentPane().add(jlbgr);
		//
	}
	public void selectPanelQldg() {
		jlTitle.setText("Quản lý độc giả");
		removeAllPanel();
		panelDocgia.setVisible(true);
	}
	public void selectPanelQmt() {
		jlTitle.setText("Quản lý mượn, trả sách");	
		removeAllPanel();
		panelMuontra.setVisible(true);
	}
	public void selectPanelQlsach() {
		jlTitle.setText("Quản lý kho sách");
		removeAllPanel();
		panelSach.setVisible(true);
	}
	public void selectPanelSea() {
		jlTitle.setText("Tìm kiếm sách");
		removeAllPanel();
		panelTimkiem.setVisible(true);
	}
	public void selectPanelThongke() {
		jlTitle.setText("Thống kê, báo cáo");
		removeAllPanel();
		panelThongke.setVisible(true);
	}
	private void removeAllPanel() {
		panelDocgia.setVisible(false);
		panelMuontra.setVisible(false);
		panelSach.setVisible(false);
		panelThongke.setVisible(false);
		panelTimkiem.setVisible(false);
	}
	private void setFone(JLabel jl) {
		jl.setBorder(null);
		jl.setFont(new Font("", Font.PLAIN, 12));
		jl.setOpaque(false);
		jl.setForeground(Color.white);
	}
	public static void main(String[] args) {
		new MainGUI().setVisible(true);
	}
	JLabel jlbgr,jlExit, jlBack, jlTitle;
	JButton jbQldg,jbQlmt,jbSearch,jbThongke,jbQlsach;
	PanelQldg panelDocgia;
	PanelQlmt panelMuontra;
	PanelQlSach panelSach;
	PanelTimkiem panelTimkiem;
	PanelThongke panelThongke;
}
