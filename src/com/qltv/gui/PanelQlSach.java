package com.qltv.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.github.lgooddatepicker.components.DatePicker;

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
		letfPanel.setBounds(20, 40, 190, 270);
		
		rightPanel = new JPanel();
		rightPanel.setLayout(null);
		add(rightPanel);
		rightPanel.setBackground(new Color(0f,0f,0f,0.4f));
		rightPanel.setBorder(BorderFactory.createLineBorder(Color.GREEN,3));
		rightPanel.setBounds(320, 40, 560, 270);
		
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
		
		////////////////////////////////////////////////////////////
		jlTensach = new JLabel("Tên sách");
		jlSoluong = new JLabel("Số lượng");
		jlTacgia = new JLabel("Tác giả");
		jlNhxb = new JLabel("Nhà xuất bản");
		jlNgxb = new JLabel("Ngày xuất bản");
		jlTheLoai = new JLabel("Thể loại");
		jlDongia = new JLabel("Đơn giá");
		jtTensach = new JTextField();
		jtSoluong = new JTextField();
		jtTacgia = new JTextField();
		jtNxb = new JTextField();
		jtTheLoai = new  JTextField();
		jtDongia = new JTextField();
		dpNgxb = new DatePicker();
		
		letfPanel.add(jlTensach);
		letfPanel.add(jlSoluong);
		letfPanel.add(jlTacgia);
		letfPanel.add(jlNhxb);
		letfPanel.add(jlNgxb);
		letfPanel.add(jlTheLoai);
		letfPanel.add(jlDongia);
		letfPanel.add(jtTacgia);
		letfPanel.add(jtNxb);
		letfPanel.add(jtTheLoai);
		letfPanel.add(jtTensach);
		letfPanel.add(jtSoluong);
		letfPanel.add(jtDongia);
		letfPanel.add(dpNgxb);
		setFone(jlTensach);
		setFone(jlSoluong);
		setFone(jlTacgia);
		setFone(jlNhxb);
		setFone(jlNgxb);
		setFone(jlTheLoai);
		setFone(jlDongia);
		dpNgxb.setBackground(new Color(0f,0f,0f,0f));
		
		jlTensach.setBounds(10, 5, 100, 30);
		jlSoluong.setBounds(125, 5, 60, 30);
		jlTacgia.setBounds(10, 55, 100, 30);
		jlNhxb.setBounds(10, 105, 100, 30);
		jlNgxb.setBounds(10, 155, 100, 30);
		jlTheLoai.setBounds(10, 205, 100, 30);
		jlDongia.setBounds(100, 205, 100, 30);
		jtTensach.setBounds(10, 28, 110, 25);
		jtSoluong.setBounds(125, 28, 54, 25);
		jtTacgia.setBounds(10, 78, 170, 25);
		jtNxb.setBounds(10, 128, 170, 25);
		jtTheLoai.setBounds(10, 228, 85, 25);
		jtDongia.setBounds(100, 228, 82, 25);
		dpNgxb.setBounds(10, 178, 170, 25);
		
		jsTable= new JScrollPane();
		table = new JTable();
		rightPanel.add(jsTable);
		jsTable.setViewportView(table);
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
		jsTable.setBounds(5, 5, 550, 260);
		addListener();
	}
	private void setFone(JLabel jl) {
		jl.setBorder(null);
		jl.setFont(new Font("", Font.PLAIN, 12));
		jl.setOpaque(false);
		jl.setForeground(Color.WHITE);
	}
	private void addListener() {
		jbThem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		}); 
		jbSua.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		jbXoa.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		jbHuy.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	JPanel letfPanel, rightPanel;
	JButton jbThem, jbSua, jbXoa, jbHuy;
	
	JLabel jlTensach, jlSoluong, jlTacgia, jlNhxb, jlNgxb, jlTheLoai, jlDongia;
	JTextField jtTensach, jtSoluong, jtTacgia, jtNxb, jtTheLoai, jtDongia;
	DatePicker dpNgxb;
	
	JTable table;
	JScrollPane jsTable;
}
