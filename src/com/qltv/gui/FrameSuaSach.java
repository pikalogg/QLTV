package com.qltv.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.github.lgooddatepicker.components.DatePicker;
import com.qltv.bll.CmdLines;
import com.qltv.bll.SqlCommands;

@SuppressWarnings("serial")
public class FrameSuaSach extends JFrame{

	private JTable table;
	private DefaultTableModel model;
	public FrameSuaSach(JTable table, DefaultTableModel model) {
		this.table = table;
		this.model = model;
		setSize(450, 300);
		setResizable(false);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		
		
		jlMasach = new JLabel("Mã sách");
		jlTensach = new JLabel("Tên sách");
		jlSoluong = new JLabel("Số lượng");
		jlTacgia = new JLabel("Tác giả");
		jlNhxb = new JLabel("Nhà xuất bản");
		jlNgxb = new JLabel("Ngày xuất bản");
		jlTheLoai = new JLabel("Thể loại");
		jlDongia = new JLabel("Đơn giá");
		jtMasach = new JTextField();
		jtTensach = new JTextField();
		jtSoluong = new JTextField();
		jtTacgia = new JTextField();
		jtNxb = new JTextField();
		jtTheLoai = new  JTextField();
		jtDongia = new JTextField();
		dpNgxb = new DatePicker();
		
		getContentPane().add(jlMasach);
		getContentPane().add(jlTensach);
		getContentPane().add(jlSoluong);
		getContentPane().add(jlTacgia);
		getContentPane().add(jlNhxb);
		getContentPane().add(jlNgxb);
		getContentPane().add(jlTheLoai);
		getContentPane().add(jlDongia);
		getContentPane().add(jtMasach);
		getContentPane().add(jtTacgia);
		getContentPane().add(jtNxb);
		getContentPane().add(jtTheLoai);
		getContentPane().add(jtTensach);
		getContentPane().add(jtSoluong);
		getContentPane().add(jtDongia);
		getContentPane().add(dpNgxb);
		setFone(jlMasach);
		setFone(jlTensach);
		setFone(jlSoluong);
		setFone(jlTacgia);
		setFone(jlNhxb);
		setFone(jlNgxb);
		setFone(jlTheLoai);
		setFone(jlDongia);
		jtTensach.setEditable(false);
		jtSoluong.setEditable(false);
		jtTacgia.setEditable(false);
		jtNxb.setEditable(false);
		jtTheLoai.setEditable(false);
		jtDongia.setEditable(false);
		dpNgxb.setEnabled(false);
		dpNgxb.setBackground(new Color(0f,0f,0f,0f));
		
		jlMasach.setBounds(100, 35, 120, 30);
		jlTensach.setBounds(250, 5, 100, 30);
		jlSoluong.setBounds(365, 5, 60, 30);
		jlTacgia.setBounds(250, 55, 100, 30);
		jlNhxb.setBounds(250, 105, 100, 30);
		jlNgxb.setBounds(250, 155, 100, 30);
		jlTheLoai.setBounds(250, 205, 100, 30);
		jlDongia.setBounds(340, 205, 100, 30);
		jtMasach.setBounds(50, 60, 150, 30);
		jtTensach.setBounds(250, 28, 110, 25);
		jtSoluong.setBounds(365, 28, 54, 25);
		jtTacgia.setBounds(250, 78, 170, 25);
		jtNxb.setBounds(250, 128, 170, 25);
		jtTheLoai.setBounds(250, 228, 85, 25);
		jtDongia.setBounds(340, 228, 82, 25);
		dpNgxb.setBounds(250, 178, 170, 25);
		
		jbKiemtra = new JButton("Kiểm tra");
		jbLuu = new JButton("Lưu");
		jbThoat = new JButton("Thoát");
		getContentPane().add(jbKiemtra);
		getContentPane().add(jbLuu);
		getContentPane().add(jbThoat);
		jbKiemtra.setBounds(80, 100, 85, 30);
		jbLuu.setBounds(20, 220, 85, 30);
		jbThoat.setBounds(140, 220, 85, 30);
		
		jlbgr = new JLabel(new ImageIcon("rec\\img\\main\\sua.png"));
		jlbgr.setBounds(0, 0, 450, 300);
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
		jbKiemtra.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		jbLuu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		jbThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				model = SqlCommands.GetTableModel(SqlCommands.SelectCommands(CmdLines.selectTable.SACH), CmdLines.columnNames.SACH);
				table.setModel(model);
				dispose();
			}
		});
	}
	JLabel jlbgr,jlTensach, jlSoluong, jlTacgia, jlNhxb, jlNgxb, jlTheLoai, jlDongia, jlMasach;
	JTextField jtTensach, jtSoluong, jtTacgia, jtNxb, jtTheLoai, jtDongia, jtMasach;
	// mui ten nua
	JButton jbKiemtra, jbLuu, jbThoat;
	DatePicker dpNgxb;
}
