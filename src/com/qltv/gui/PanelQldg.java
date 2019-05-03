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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import com.github.lgooddatepicker.components.DatePicker;
import com.qltv.bll.CmdLines;
import com.qltv.bll.SqlCommands;
import com.qltv.bll.MyMatchet;

public class PanelQldg extends JPanel{
	private static final long serialVersionUID = 1L;
	public PanelQldg() {
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
		
		// --letf--//
		jlTen = new JLabel("* Họ và tên");
		jlEmail = new JLabel("* Email");
		jlNgaysinh = new JLabel("* Ngày Sinh");
		jlDiachi = new JLabel("Địa chỉ");
		letfPanel.add(jlTen);
		letfPanel.add(jlEmail);
		letfPanel.add(jlNgaysinh);
		letfPanel.add(jlDiachi);
		setFone(jlTen);
		setFone(jlEmail);
		setFone(jlNgaysinh);
		setFone(jlDiachi);
		jlTen.setBounds(10, 5, 120, 30);
		jlEmail.setBounds(10, 55, 120, 30);
		jlNgaysinh.setBounds(10, 105, 220, 30);
		jlDiachi.setBounds(10, 155, 120, 30);
		
		jtTen = new JTextField();
		jtEmail = new JTextField();
		dpNgaySinh = new DatePicker();
		jtDiachi = new JTextArea();
		jsDiachi = new JScrollPane();
		jsDiachi.setViewportView(jtDiachi);
		jtDiachi.setLineWrap(true);//tự ngắt dòng khi tràn khung
		jtDiachi.setWrapStyleWord(true);
		jsDiachi.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		letfPanel.add(jtTen);
		letfPanel.add(jtEmail);
		letfPanel.add(dpNgaySinh);
		letfPanel.add(jsDiachi);
		jtTen.setBounds(10, 30, 190, 30);
		jtEmail.setBounds(10, 80, 190, 30);
		dpNgaySinh.setBounds(10, 130, 190, 30);
		dpNgaySinh.setBackground(new Color(0f, 0f, 0f, 0f));
		jsDiachi.setBounds(10, 180, 190, 60);
		
		// --righr--//
		jsTable= new JScrollPane();
		table = new JTable();
		rightPanel.add(jsTable);
		jsTable.setViewportView(table);
		model = SqlCommands.GetTableModel(SqlCommands.SelectCommands(CmdLines.selectTable.DOCGIA), CmdLines.columnNames.DOCGIA);
		
		table.setModel(model);
		jsTable.setBounds(5, 5, 570, 240);
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
				if (jtTen.getText().equals("")) {
					System.out.println("Chưa nhập tên kìa!!");
				}
				else if (!MyMatchet.Chet(MyMatchet.Myregex.EMAIL, jtEmail.getText())) {
					System.out.println("nhập Email dạng này này \"Example@email.com\"");
				}
				else if (dpNgaySinh.toString()==null) {
					System.out.println("chưa nhập ngày sinh luôn");
				}
				else {
					if (jtDiachi.getText().equals("")) {
						System.out.println("Tui cho địa chỉ bừa ngoài nghĩa địa đó nha :<\n");
					}
					System.out.println("đã tạo một độc giả mang tên " + jtTen.getText());
					model = SqlCommands.GetTableModel(SqlCommands.SelectCommands(CmdLines.selectTable.DOCGIA), CmdLines.columnNames.DOCGIA);
				}
			}
		});
		jbSua.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new FrameSuaDocGia().setVisible(true);
				model = SqlCommands.GetTableModel(SqlCommands.SelectCommands(CmdLines.selectTable.DOCGIA), CmdLines.columnNames.DOCGIA);
			}
		});
		jbXoa.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String mathe = (String)model.getValueAt(table.getSelectedRow(), 0);
					//xoa thang day di
					System.out.println(mathe + " đã bị xóa...mãi mãi!!");
					model = SqlCommands.GetTableModel(SqlCommands.SelectCommands(CmdLines.selectTable.DOCGIA), CmdLines.columnNames.DOCGIA);
				} catch (Exception e2) {
					System.out.println("chưa chọn thằng để xóa");
				}
			}
		});
		jbHuy.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jtDiachi.setText("");
				jtEmail.setText("");
				jtTen.setText("");
				dpNgaySinh.setText("");
				table.setSelectionMode(table.getRowCount());
				model = SqlCommands.GetTableModel(SqlCommands.SelectCommands(CmdLines.selectTable.DOCGIA), CmdLines.columnNames.DOCGIA);
			}
		});
	}
	JPanel letfPanel, rightPanel;
	JButton jbThem, jbSua, jbXoa, jbHuy;
	JLabel jlTen, jlEmail, jlNgaysinh, jlDiachi;
	JTextField jtTen, jtEmail;
	DatePicker dpNgaySinh;
	JTextArea jtDiachi;
	JScrollPane jsDiachi, jsTable;
	JTable table;
	DefaultTableModel model;
}
