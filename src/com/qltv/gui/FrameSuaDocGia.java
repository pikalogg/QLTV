package com.qltv.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import com.github.lgooddatepicker.components.DatePicker;
import com.qltv.bll.CmdLines;
import com.qltv.bll.MyMatchet;
import com.qltv.bll.SqlCommands;

@SuppressWarnings("serial")
public class FrameSuaDocGia extends JFrame{

	JTable table;
	DefaultTableModel model;
	public FrameSuaDocGia(JTable table, DefaultTableModel model) {
		this.table = table;
		this.model = model;
		setSize(480, 300);
		setResizable(false);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		jlMathe = new JLabel("Mã thẻ");
		jlTienno = new JLabel("Tiền nợ");
		jlTen = new JLabel("* Họ và tên");
		jlEmail = new JLabel("* Email");
		jlNgaysinh = new JLabel("* Ngày Sinh");
		jlDiachi = new JLabel("Địa chỉ");
		getContentPane().add(jlMathe);
		getContentPane().add(jlTienno);
		getContentPane().add(jlTen);
		getContentPane().add(jlEmail);
		getContentPane().add(jlNgaysinh);
		getContentPane().add(jlDiachi);
		setFone(jlMathe);
		setFone(jlTienno);
		setFone(jlTen);
		setFone(jlEmail);
		setFone(jlNgaysinh);
		setFone(jlDiachi);
		jlMathe.setBounds(100, 35, 120, 30);
		jlTienno.setBounds(65, 140, 120, 30);
		jlTen.setBounds(250, 5, 125, 30);
		jlEmail.setBounds(250, 60, 120, 30);
		jlNgaysinh.setBounds(250, 110, 220, 30);
		jlDiachi.setBounds(250, 160, 120, 30);
		
		jtMathe = new JTextField();
		jtTienno = new JTextField();
		jtTen = new JTextField();
		jtEmail = new JTextField();
		dpNgaySinh = new DatePicker();
		jtDiachi = new JTextArea();
		jsDiachi = new JScrollPane();
		jsDiachi.setViewportView(jtDiachi);
		jtDiachi.setLineWrap(true);//tự ngắt dòng khi tràn khung
		jtDiachi.setWrapStyleWord(true);
		jsDiachi.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		getContentPane().add(jtTienno);
		getContentPane().add(jtMathe);
		getContentPane().add(jtTen);
		getContentPane().add(jtEmail);
		getContentPane().add(dpNgaySinh);
		getContentPane().add(jsDiachi);
		jtDiachi.setEditable(false);
		jtTienno.setEditable(false);
		jtTen.setEditable(false);
		jtEmail.setEditable(false);
		dpNgaySinh.setEnabled(false);
		
		jtMathe.setBounds(50, 60, 150, 30);
		jtTienno.setBounds(65, 165, 120, 30);
		jtTen.setBounds(250, 35, 190, 30);
		jtEmail.setBounds(250, 85, 190, 30);
		dpNgaySinh.setBounds(250, 135, 190, 30);
		dpNgaySinh.setBackground(new Color(0f, 0f, 0f, 0f));
		jsDiachi.setBounds(250, 185, 190, 60);
		
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
		jlbgr.setBounds(0, 0, 480, 300);
		getContentPane().add(jlbgr);
		addListener();
		mathe = 0;
	}
	private void setFone(JLabel jl) {
		jl.setBorder(null);
		jl.setFont(new Font("", Font.PLAIN, 12));
		jl.setOpaque(false);
		jl.setForeground(Color.WHITE);
	}
	private void addListener() {
		jbKiemtra.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				ResultSet rs = null;
				if (MyMatchet.Chet(MyMatchet.Myregex.MATHE, jtMathe.getText())) {
					rs = SqlCommands.SelectDG_mathe(MyMatchet.ConvertMathe(jtMathe.getText()));
					try {
						if (rs.next()) {
							jtDiachi.setEditable(true);
							jtTienno.setEditable(true);
							jtTen.setEditable(true);
							jtEmail.setEditable(true);
							dpNgaySinh.setEnabled(true);
							
							jtDiachi.setText(rs.getString(6));
							jtTienno.setText(rs.getString(7));
							jtTen.setText(rs.getString(2));
							jtEmail.setText(rs.getString(3));
							int year = Integer.parseInt(rs.getString(4).substring(0, 4));
							int month = Integer.parseInt(rs.getString(4).substring(5, 7));
							int day = Integer.parseInt(rs.getString(4).substring(8, 10));
							dpNgaySinh.setDate(LocalDate.of(year, month, day));
							
							mathe = MyMatchet.ConvertMathe(jtMathe.getText());
						}
						else {
							JOptionPane.showMessageDialog(null, "Không tìm thấy độc giả", "Message", JOptionPane.ERROR_MESSAGE);
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} 
				else JOptionPane.showMessageDialog(null, "Nhập sai mã độc giả", "Message", JOptionPane.ERROR_MESSAGE);
			}
		});
		jbLuu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (mathe!=0) {
					if(SqlCommands.Updatedg(mathe, jtTen.getText(), jtEmail.getText(), dpNgaySinh.toString(), jtDiachi.getText(), Integer.parseInt(jtTienno.getText().replace(" VND", "")))) {
						JOptionPane.showMessageDialog(null, "Update thành công", "Message", JOptionPane.ERROR_MESSAGE);
						mathe = 0;
					}
					else JOptionPane.showMessageDialog(null, "Update error", "Message", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		jbThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				model = SqlCommands.GetTableModel(SqlCommands.SelectCommands(CmdLines.selectTable.DOCGIA), CmdLines.columnNames.DOCGIA);
				table.setModel(model);
				dispose();
			}
		});
	}
	JLabel jlbgr,jlTen, jlEmail, jlNgaysinh, jlDiachi, jlMathe, jlTienno;
	JTextField jtTen, jtEmail, jtMathe, jtTienno;
	JButton jbKiemtra, jbLuu, jbThoat;
	DatePicker dpNgaySinh;
	int mathe;
	JTextArea jtDiachi;
	JScrollPane jsDiachi, jsTable;
}
