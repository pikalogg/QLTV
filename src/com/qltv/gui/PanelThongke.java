package com.qltv.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.github.lgooddatepicker.components.DatePicker;
import com.qltv.bll.CmdLines;
import com.qltv.bll.SqlCommands;

public class PanelThongke extends JPanel{
	private static final long serialVersionUID = 1L;

	public PanelThongke() {
		setLayout(null);
		setBackground(new Color(0f,0f,0f,0f));
		
		jpanel = new JPanel();
		jpanel.setLayout(null);
		add(jpanel);
		jpanel.setBackground(new Color(0f,0f,0f,0.4f));
		jpanel.setBorder(BorderFactory.createLineBorder(Color.GREEN,3));
		jpanel.setBounds(75, 150, 750, 150);
		
		jbXem = new JButton("Xem");
		add(jbXem);
		jbXem.setBounds(710, 110, 100, 30);
		
		cbBox = new JComboBox<String>();
		cbBox.setModel(new DefaultComboBoxModel<>(new String[] {"Sách mượn","Sách trả","Quá Hạn"}));
		add(cbBox);
		cbBox.setBounds(710, 60, 100, 30);
		buttonGroup = new ButtonGroup();
		jrTheongay = new JRadioButton();
		jrTheothang = new JRadioButton();
		add(jrTheongay);
		add(jrTheothang);
		jrTheongay.setActionCommand("theongay");
		jrTheothang.setActionCommand("theothang");
		buttonGroup.add(jrTheongay);
		buttonGroup.add(jrTheothang);
		jrTheongay.setBounds(80, 65, 20, 20);
		jrTheothang.setBounds(80, 115, 20, 20);
		
		jlTungay = new JLabel("Từ ngày");
		jlDen = new JLabel("Đến");
		jlTheothang = new JLabel("Theo tháng");
		jlNam = new JLabel("Năm");
		jtThang = new JTextField();
		jtNam = new JTextField();
		dpTungay = new DatePicker();
		dpDen = new DatePicker();
		
		add(jlTungay);
		add(jlDen);
		add(jlTheothang);
		add(jlNam);
		add(jtThang);
		add(jtNam);
		add(dpTungay);
		add(dpDen);
		
		setFone(jlTungay);
		setFone(jlDen);
		setFone(jlTheothang);
		setFone(jlNam);
		dpDen.setBackground(new Color(0f,0f,0f,0f));
		dpTungay.setBackground(new Color(0f,0f,0f,0f));
		
		jlTungay.setBounds(125, 60, 52, 30);
		jlDen.setBounds(435, 60, 50, 30);
		jlTheothang.setBounds(107, 110, 100, 30);
		jlNam.setBounds(437, 110, 80, 30);
		
		dpTungay.setBounds(180, 60, 200, 30);
		dpDen.setBounds(465, 60, 200, 30);
		jtThang.setBounds(180, 110, 100, 30);
		jtNam.setBounds(467, 110, 100, 30);
		
		jstable= new JScrollPane();
		table = new JTable();
		jpanel.add(jstable);
		jstable.setViewportView(table);
		model = SqlCommands.GetTableModel(SqlCommands.SelectCommands(CmdLines.selectTable.PHIEUMUON), CmdLines.columnNames.PHIEUMUON);
		table.setModel(model);
		jstable.setBounds(5, 5, 740, 140);
		addListener();
	}
	private void setFone(JLabel jl) {
		jl.setBorder(null);
		jl.setFont(new Font("", Font.ITALIC, 12));
		jl.setOpaque(false);
		jl.setForeground(Color.BLACK);
	}
	private void addListener() {
		jbXem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (cbBox.getSelectedItem().equals("Quá Hạn")) {
					model = SqlCommands.GetTableModel(SqlCommands.Select_tngay_quahan(5), CmdLines.columnNames.PHIEUMUON);
					table.setModel(model);
				}
				else if (buttonGroup.getSelection()==null) {
					JOptionPane.showMessageDialog(null, "Chọn lấy một kiểu kiểm tra đi chứ", "Message", JOptionPane.ERROR_MESSAGE);
				}
				else if (buttonGroup.getSelection().getActionCommand().equals("theongay")) {
					try {
						if(cbBox.getSelectedItem().equals("Sách mượn")) {
							model = SqlCommands.GetTableModel(SqlCommands.Select_tngay_pm(dpTungay.toString(), dpDen.toString()), CmdLines.columnNames.PHIEUMUON);
							table.setModel(model);
						} else {
							model = SqlCommands.GetTableModel(SqlCommands.Select_tngay_pt(dpTungay.toString(), dpDen.toString()), CmdLines.columnNames.PHIEUMUON);
							table.setModel(model);
						}
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, "Lỗi rồi, chấp nhận", "Message", JOptionPane.ERROR_MESSAGE);
					}
				}
				else {
					try {
						if(cbBox.getSelectedItem().equals("Sách mượn")) {
							model = SqlCommands.GetTableModel(SqlCommands.Select_tthang_pm(jtThang.getText(), jtNam.getText()), CmdLines.columnNames.PHIEUMUON);
							table.setModel(model);
						} else {
							model = SqlCommands.GetTableModel(SqlCommands.Select_thang_pt(jtThang.getText(), jtNam.getText()), CmdLines.columnNames.PHIEUMUON);
							table.setModel(model);
						}
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, "Lỗi rồi, chấp nhận", "Message", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		cbBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (cbBox.getSelectedItem().equals("Quá Hạn")) {
					dpTungay.setText("");
					dpDen.setText("");
					jtThang.setText("");
					jtNam.setText("");
				}
			}
		});
	}
	JPanel jpanel;
	JButton jbXem;
	JLabel jlTungay,jlDen,jlTheothang,jlNam;
	ButtonGroup buttonGroup;
	JRadioButton jrTheongay, jrTheothang;
	JTextField jtThang,jtNam;
	DatePicker dpTungay,dpDen;
	
	JComboBox<String> cbBox;
	JTable table;
	DefaultTableModel model;
	JScrollPane jstable;
}
