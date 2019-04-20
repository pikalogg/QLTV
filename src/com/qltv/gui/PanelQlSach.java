package com.qltv.gui;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelQlSach extends JPanel{
	private static final long serialVersionUID = 1L;

	public PanelQlSach() {
		setLayout(null);
		setBackground(new Color(0f,0f,0f,0f));
		letfPanel = new JPanel();
		letfPanel.setLayout(null);
		add(letfPanel);
		letfPanel.setBackground(new Color(0f,0f,0f,0.4f));
		letfPanel.setBorder(BorderFactory.createLineBorder(Color.GREEN,3));
		letfPanel.setBounds(0, 50, 210, 250);
		
		rightPanel = new JPanel();
		rightPanel.setLayout(null);
		add(rightPanel);
		rightPanel.setBackground(new Color(0f,0f,0f,0.4f));
		rightPanel.setBorder(BorderFactory.createLineBorder(Color.GREEN,3));
		rightPanel.setBounds(320, 50, 580, 250);
		
		jbThem = new JButton("Thêm");
		jbSua = new JButton("Sửa");
		jbXoa = new JButton("Xóa");
		jbHuy = new JButton("Hủy");
		
		add(jbThem);
		add(jbSua);
		add(jbXoa);
		add(jbHuy);
		
		jbThem.setBounds(225, 60, 80, 35);
		jbSua.setBounds(225, 120, 80, 35);
		jbXoa.setBounds(225, 180, 80, 35);
		jbHuy.setBounds(225, 240, 80, 35);
	}
	JPanel letfPanel, rightPanel;
	JButton jbThem, jbSua, jbXoa, jbHuy;
}
