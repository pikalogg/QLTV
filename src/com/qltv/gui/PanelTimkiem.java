package com.qltv.gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class PanelTimkiem extends JPanel{
	private static final long serialVersionUID = 1L;

	public PanelTimkiem() {
		setLayout(null);
		setBackground(new Color(0f,0f,0f,0f));
		
		jpanel = new JPanel();
		jpanel.setLayout(null);
		add(jpanel);
		jpanel.setBackground(new Color(0f,0f,0f,0.4f));
		jpanel.setBorder(BorderFactory.createLineBorder(Color.GREEN,3));
		jpanel.setBounds(75, 150, 750, 150);
		
		jbTk = new JButton("Tìm kiếm");
		jbHuy = new JButton("Hủy");
		add(jbTk);
		add(jbHuy);
		jbTk.setBounds(335, 110, 100, 30);
		jbHuy.setBounds(455, 110, 100, 30);
		
		jlTensach = new JLabel("Tên sách");
		jlTacgia = new JLabel("Tác giả");
		jlTheloai = new JLabel("Thể Loại");
		jlNXB = new JLabel("Nhà xuất bản");
		jtTensach = new JTextField();
		jtTacgia = new JTextField();
		jtTheloai = new JTextField();
		jtNXB = new JTextField();
		
		add(jlTensach);
		add(jlTacgia);
		add(jlTheloai);
		add(jlNXB);
		add(jtTacgia);
		add(jtTensach);
		add(jtTheloai);
		add(jtNXB);
		
		setFone(jlTensach);
		setFone(jlTacgia);
		setFone(jlTheloai);
		setFone(jlNXB);
		
		jlTensach.setBounds(163, 10, 52, 30);
		jlTacgia.setBounds(480, 10, 50, 30);
		jlTheloai.setBounds(165, 60, 50, 30);
		jlNXB.setBounds(450, 60, 80, 30);
		
		jtTensach.setBounds(220, 10, 200, 30);
		jtTacgia.setBounds(530, 10, 200, 30);
		jtTheloai.setBounds(220, 60, 200, 30);
		jtNXB.setBounds(530, 60, 200, 30);
		
		jstable= new JScrollPane();
		table = new JTable();
		jpanel.add(jstable);
		jstable.setViewportView(table);
		table.setModel(new DefaultTableModel(
            new Object [][] {
            	{null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4","Title 5", "Title 6", "Title 7", "Title 8"
            })
			{
			private static final long serialVersionUID = 1L;
			public boolean isCellEditable(int row, int column){return false;}}
		);
		jstable.setBounds(5, 5, 740, 140);
	}
	private void setFone(JLabel jl) {
		jl.setBorder(null);
		jl.setFont(new Font("", Font.ITALIC, 12));
		jl.setOpaque(false);
		jl.setForeground(Color.RED);
	}
	JPanel jpanel;
	JButton jbTk,jbHuy;
	JLabel jlTensach,jlTacgia,jlTheloai,jlNXB;
	JTextField jtTensach,jtTacgia,jtTheloai,jtNXB;
	
	JTable table;
	JScrollPane jstable;
}
