package com.qltv.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.github.lgooddatepicker.components.DatePicker;
import com.qltv.bll.CmdLines;
import com.qltv.bll.MyMatchet;
import com.qltv.bll.SqlCommands;

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
		model = SqlCommands.GetTableModel(SqlCommands.SelectCommands(CmdLines.selectTable.SACH), CmdLines.columnNames.SACH);
		table.setModel(model);
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
				if (jtTensach.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "chưa nhập tên sách", "Message", JOptionPane.ERROR_MESSAGE);
				} else if (jtSoluong.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "chưa nhập số lượng", "Message", JOptionPane.ERROR_MESSAGE);
				} else if (jtTacgia.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "chưa nhập tên tác giả", "Message", JOptionPane.ERROR_MESSAGE);
				} else if (jtNxb.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "chưa nhập nxb luôn", "Message", JOptionPane.ERROR_MESSAGE);
				} else if (dpNgxb.toString()==null&&dpNgxb.toString().equals("")) {
					JOptionPane.showMessageDialog(null, "chưa nhập ngàyxb nữa", "Message", JOptionPane.ERROR_MESSAGE);
				} else if (jtTheLoai.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "chưa nhập thể loại kìa", "Message", JOptionPane.ERROR_MESSAGE);
				} else if (jtDongia.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "còn đơn giá kia kìa", "Message", JOptionPane.ERROR_MESSAGE);
				} else {
					try {
						if(SqlCommands.Insertsach(jtTensach.getText(), jtTheLoai.getText(), jtTacgia.getText(), jtNxb.getText(), dpNgxb.toString(), Integer.parseInt(jtDongia.getText()), Integer.parseInt(jtSoluong.getText()))) {
							JOptionPane.showMessageDialog(null, "Insert thành công ", "Message", JOptionPane.PLAIN_MESSAGE);
						}
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, "lại nhập sai gì rồi", "Message", JOptionPane.ERROR_MESSAGE);
					}
					model = SqlCommands.GetTableModel(SqlCommands.SelectCommands(CmdLines.selectTable.SACH), CmdLines.columnNames.SACH);
					table.setModel(model);
				}
			}
		}); 
		jbSua.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new FrameSuaSach(table,model).setVisible(true);
			}
		});
		jbXoa.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String masach = (String)model.getValueAt(table.getSelectedRow(), 0);
					if (SqlCommands.Deletesach(MyMatchet.ConvertMasach(masach))) {
						JOptionPane.showMessageDialog(null, masach + " đã bị xóa...mãi mãi!!");
						model = SqlCommands.GetTableModel(SqlCommands.SelectCommands(CmdLines.selectTable.SACH), CmdLines.columnNames.SACH);
						table.setModel(model);
					}
					else JOptionPane.showMessageDialog(null, "Delete Error ", "Message", JOptionPane.ERROR_MESSAGE);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "chưa chọn sách để xóa", "Message", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		jbHuy.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jtTensach.setText("");
				jtSoluong.setText("");
				jtTacgia.setText("");
				jtNxb.setText("");
				jtTheLoai.setText("");
				jtDongia.setText("");
				dpNgxb.setText("");
				model = SqlCommands.GetTableModel(SqlCommands.SelectCommands(CmdLines.selectTable.SACH), CmdLines.columnNames.SACH);
				table.setModel(model);
			}
		});
	}
	JPanel letfPanel, rightPanel;
	JButton jbThem, jbSua, jbXoa, jbHuy;
	
	JLabel jlTensach, jlSoluong, jlTacgia, jlNhxb, jlNgxb, jlTheLoai, jlDongia;
	JTextField jtTensach, jtSoluong, jtTacgia, jtNxb, jtTheLoai, jtDongia;
	DatePicker dpNgxb;
	
	JTable table;
	DefaultTableModel model;
	JScrollPane jsTable;
}
