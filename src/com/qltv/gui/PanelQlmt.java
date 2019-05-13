package com.qltv.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import com.qltv.bll.CmdLines;
import com.qltv.bll.SqlCommands;
import com.qltv.bll.MyMatchet;

public class PanelQlmt extends JTabbedPane{
	private static final long serialVersionUID = 1L;

	public PanelQlmt() {
		setBorder(BorderFactory.createLineBorder(Color.BLACK,0));
		setBackground(new Color(0f,0f,0f,0f));

		panelMuon = new JPanel();
		panelTra = new JPanel();
		jpML = new JPanel();
		jpMC = new JPanel();
		jpMR = new JPanel();
		jpTL = new JPanel();
		jpTR = new JPanel();
		
		panelMuon.add(jpML);
		panelMuon.add(jpMC);
		panelMuon.add(jpMR);
		panelTra.add(jpTL);
		panelTra.add(jpTR);
		
		jpML.setBounds(50, 20, 150, 250);
		jpML.setLayout(null);
		jpML.setBorder(BorderFactory.createLineBorder(Color.GREEN,3));
		jpML.setBackground(new Color(0f,0f,0f,0.4f));
		jpMC.setBounds(220, 20, 150, 250);
		jpMC.setLayout(null);
		jpMC.setBorder(BorderFactory.createLineBorder(Color.GREEN,3));
		jpMC.setBackground(new Color(0f,0f,0f,0.4f));
		jpMR.setBounds(390, 20, 460, 250);
		jpMR.setLayout(null);
		jpMR.setBorder(BorderFactory.createLineBorder(Color.GREEN,3));
		jpMR.setBackground(new Color(0f,0f,0f,0.4f));
		
		jpTL.setBounds(70, 20, 170, 250);
		jpTL.setLayout(null);
		jpTL.setBorder(BorderFactory.createLineBorder(Color.GREEN,3));
		jpTL.setBackground(new Color(0f,0f,0f,0.4f));
		jpTR.setBounds(260, 20, 580, 250);
		jpTR.setLayout(null);
		jpTR.setBorder(BorderFactory.createLineBorder(Color.GREEN,3));
		jpTR.setBackground(new Color(0f,0f,0f,0.4f));
		
		add("Mượn sách",panelMuon);
		add("Trả sách",panelTra);
		
		panelMuon.setLayout(null);
		panelTra.setLayout(null);
		
		jlbgr1 = new JLabel(new ImageIcon("rec\\img\\main\\muontrabgr.png"));
		jlbgr2 = new JLabel(new ImageIcon("rec\\img\\main\\muontrabgr.png"));
		panelMuon.add(jlbgr1);
		panelTra.add(jlbgr2);
		jlbgr1.setBounds(0, 0, 900, 310);
		jlbgr2.setBounds(0, 0, 900, 310);
		
		// --panelMuon--//
			// --ML-- //
		jlMLmdg = new JLabel("*Mã độc giả");
		jlMLtdg = new JLabel("Tên độc giả");
		jlMLslsdm = new JLabel("Lượng sách đang mượn");
		jlMLtn = new JLabel("Tiền nợ");
		jtMLmdg = new JTextField();
		jtMLtdg = new JTextField();
		jtMLslsdm = new JTextField();
		jtMLtn = new JTextField();
		jbMLkt = new JButton("Kiểm tra");
		jpML.add(jlMLmdg);
		jpML.add(jlMLtdg);
		jpML.add(jlMLslsdm);
		jpML.add(jlMLtn);
		jpML.add(jtMLmdg);
		jpML.add(jtMLtdg);
		jpML.add(jtMLslsdm);
		jpML.add(jtMLtn);
		jpML.add(jbMLkt); 
		
		setFone(jlMLmdg);
		setFone(jlMLslsdm);
		setFone(jlMLtdg);
		setFone(jlMLtn);
		
		jtMLtdg.setEditable(false);
		jtMLslsdm.setEditable(false);
		jtMLtn.setEditable(false);
		jtMLtdg.setBackground(Color.GREEN);
		jtMLslsdm.setBackground(Color.GREEN);
		jtMLtn.setBackground(Color.GREEN);
		
		jlMLmdg.setBounds(10, 5, 100, 30);
		jlMLtdg.setBounds(10, 84, 100, 30);
		jlMLslsdm.setBounds(10, 131, 200, 30);
		jlMLtn.setBounds(10, 178, 100, 30);
		jtMLmdg.setBounds(10, 30, 132, 25);
		jtMLtdg.setBounds(10, 109, 132, 25);
		jtMLslsdm.setBounds(10, 156, 132, 25);
		jtMLtn.setBounds(10, 203, 132, 25);
		jbMLkt.setBounds(35, 62, 82, 25);
			// --Mc-- //
		jlMCms = new JLabel("*Mã sách");
		jtMCms = new JTextField();
		jtMCselect = new JTextArea();
		jsMCselect = new JScrollPane();
		jsMCselect.setViewportView(jtMCselect);
		jtMCselect.setEditable(false);
		jtMCselect.setBackground(Color.GREEN);
		jtMCselect.setLineWrap(true);
		jtMCselect.setWrapStyleWord(true);
		jsMCselect.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		jsMCselect.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		jbMCkt = new JButton("Kiểm tra");
		jbMCthem = new JButton("Thêm");
		jbMCms = new JButton("Mượn");
		jbMchuy = new JButton("Hủy");
		jpMC.add(jlMCms);
		jpMC.add(jtMCms);
		jpMC.add(jsMCselect);
		jpMC.add(jbMCkt);
		jpMC.add(jbMCthem);
		jpMC.add(jbMCms);
		jpMC.add(jbMchuy);
		
		setFone(jlMCms);
		jlMCms.setBounds(10, 5, 100, 30);
		jtMCms.setBounds(10, 28, 132, 25);
		jsMCselect.setBounds(10, 121, 132, 60);
		jbMCkt.setBounds(35, 60, 82, 25);
		jbMCthem.setBounds(35, 90, 82, 25);
		jbMCms.setBounds(35, 187, 82, 25);
		jbMchuy.setBounds(35, 217, 82, 25);
			// --MR--//
		Mtable = new JTable();
		jsMtable = new JScrollPane();
		jsMtable.setViewportView(Mtable);
		jpMR.add(jsMtable);
		Mmodel = SqlCommands.GetTableModel(SqlCommands.SelectCommands(CmdLines.selectTable.PHIEUMUON), CmdLines.columnNames.PHIEUMUON);
		Mtable.setModel(Mmodel);
		jsMtable.setBounds(5, 5, 450, 240);
		
		sachmuon = new LinkedList<String>();
		// --endMuon--//
		
		// --panelTra--//
			// --TL-- //
		jlTLmdg = new JLabel("*Mã độc giả");
		jlTLms = new JLabel("*Mã sách");
		jlTLtp = new JLabel("Tiền phạt");
		jtTLmdg = new JTextField();
		jtTLms = new JTextField();
		jtTLtp = new JTextField();
		jbTLkt = new JButton("Kiểm tra");
		jbTLtra = new JButton("Trả");
		jbTLmat = new JButton("Mất");
		jbTLhuy = new JButton("Hủy");
		jpTL.add(jlTLmdg);
		jpTL.add(jlTLms);
		jpTL.add(jlTLtp);
		jpTL.add(jtTLmdg);
		jpTL.add(jtTLms);
		jpTL.add(jtTLtp);
		jpTL.add(jbTLkt);
		jpTL.add(jbTLtra);
		jpTL.add(jbTLmat);
		jpTL.add(jbTLhuy);
		setFone(jlTLmdg);
		setFone(jlTLms);
		setFone(jlTLtp);
		jtTLtp.setEditable(false);
		jtTLtp.setBackground(Color.GREEN);
		
		jlTLmdg.setBounds(10, 5, 100, 30);
		jlTLms.setBounds(10, 81, 100, 30);
		jlTLtp.setBounds(10, 160, 100, 30);
		jtTLmdg.setBounds(10, 28, 148, 25);
		jtTLms.setBounds(10, 104, 148, 25);
		jtTLtp.setBounds(10, 183, 148, 25);
		jbTLkt.setBounds(39, 59, 86, 25);
		jbTLtra.setBounds(17, 136, 65, 25);
		jbTLmat.setBounds(90, 136, 65, 25);
		jbTLhuy.setBounds(39, 215, 86, 25);
			
			// --TR--//
		Ttable = new JTable();
		jsTtable = new JScrollPane();
		jsTtable.setViewportView(Ttable);
		jpTR.add(jsTtable);
		Tmodel = SqlCommands.GetTableModel(SqlCommands.SelectCommands(CmdLines.selectTable.PHIEUTRA), CmdLines.columnNames.PHIEUTRA);
		Ttable.setModel(Tmodel);
		jsTtable.setBounds(5, 5, 570, 240);
		// --endTra--//
		addListener();
	}
	private void setFone(JLabel jl) {
		jl.setBorder(null);
		jl.setFont(new Font("", Font.PLAIN, 12));
		jl.setOpaque(false);
		jl.setForeground(Color.WHITE);
	}
	private void addListener() {
		//ML
		jbMLkt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int mathe ;
				ResultSet rs = null;
				if (MyMatchet.Chet(MyMatchet.Myregex.MATHE, jtMLmdg.getText())) {
					mathe = MyMatchet.ConvertMathe(jtMLmdg.getText());
					Mmodel = SqlCommands.GetTableModel(SqlCommands.SelectPM_mdg(mathe), CmdLines.columnNames.PHIEUMUON);
					Mtable.setModel(Mmodel);
					rs = SqlCommands.SelectDG_mathe(mathe);
					try {
						if (rs.next()) {
							jtMLtdg.setText(rs.getString(2));
							jtMLslsdm.setText(rs.getString(8));
							jtMLtn.setText(rs.getString(7));
						}
						else {
							JOptionPane.showMessageDialog(null, "Không tìm thấy độc giả", "Message", JOptionPane.ERROR_MESSAGE);
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Điền đúng mã thẻ đi!!!", "Message", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		//MC
		jbMCkt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int masach ;
				if (MyMatchet.Chet(MyMatchet.Myregex.MASACH, jtMCms.getText())) {
					try {
						masach = MyMatchet.ConvertMasach(jtMCms.getText());
						if (SqlCommands.SelectSach_ms(masach).next()) {
							Mmodel = SqlCommands.GetTableModel(SqlCommands.SelectSach_ms(masach), CmdLines.columnNames.SACH);
							Mtable.setModel(Mmodel);
						}
						else JOptionPane.showMessageDialog(null, "Không có quyển sách đó rồi !!!", "Message", JOptionPane.WARNING_MESSAGE);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Đây không phải mã sách rồi!!!", "Message", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		jbMCthem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int sl = sachmuon.size();
				try {
					sl += Integer.parseInt(jtMLslsdm.getText());
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "chưa khai tên nữa đòi mượn giề !!", "Message", JOptionPane.ERROR_MESSAGE);
				}
				if (sl>=SqlCommands.sosachduocmuon){ 
					JOptionPane.showMessageDialog(null, "Mượn nhiều lắm rồi thôi đê!!!!!!", "Message", JOptionPane.ERROR_MESSAGE);
				}
				else if(Mtable.getRowCount()==1) {
					sachmuon.add(jtMCms.getText());
					if (sachmuon.size()<3)
						jtMCselect.setText(jtMCselect.getText() + jtMCms.getText() + "\n");
					else jtMCselect.setText(jtMCselect.getText() + jtMCms.getText());
				}
			}
		});
		jbMCms.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				for (String sach: sachmuon) {
					if (SqlCommands.Muonsach(MyMatchet.ConvertMathe(jtMLmdg.getText()), MyMatchet.ConvertMasach(sach))) {
						JOptionPane.showMessageDialog(null, "Mượn thành công sách mã:" + sach );
					}
					else JOptionPane.showMessageDialog(null, "Không mượn được sách mã:" + sach, "Message", JOptionPane.ERROR_MESSAGE);
				}
				jtMCselect.setText("");
				sachmuon = new LinkedList<String>();
				int mathe = MyMatchet.ConvertMathe(jtMLmdg.getText());
				Mmodel = SqlCommands.GetTableModel(SqlCommands.SelectPM_mdg(mathe), CmdLines.columnNames.PHIEUMUON);
				Mtable.setModel(Mmodel);
				ResultSet rs = SqlCommands.SelectDG_mathe(mathe);
				try {
					if (rs.next()) {
						jtMLtdg.setText(rs.getString(2));
						jtMLslsdm.setText(rs.getString(8));
						jtMLtn.setText(rs.getString(7));
					}
					else {
						JOptionPane.showMessageDialog(null, "Không tìm thấy độc giả", "Message", JOptionPane.ERROR_MESSAGE);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}); 
		jbMchuy.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jtMLmdg.setText("");
				jtMLslsdm.setText("");
				jtMLtdg.setText("");
				jtMLtn.setText("");
				jtMCselect.setText("");
				jtMCms.setText("");
				sachmuon = new LinkedList<String>();
				Mmodel = SqlCommands.GetTableModel(SqlCommands.SelectCommands(CmdLines.selectTable.PHIEUMUON), CmdLines.columnNames.PHIEUMUON);
				Mtable.setModel(Mmodel);
			}
		}); 
		//TL
		jbTLkt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int mathe ;
				if (MyMatchet.Chet(MyMatchet.Myregex.MATHE, jtTLmdg.getText())) {
					mathe = MyMatchet.ConvertMathe(jtTLmdg.getText());
					Tmodel = SqlCommands.GetTableModel(SqlCommands.SelectPM_mdg(mathe), CmdLines.columnNames.PHIEUMUON);
					Ttable.setModel(Tmodel);
				}
				else {
					JOptionPane.showMessageDialog(null, "Điền đúng mã thẻ đi!!!", "Message", JOptionPane.ERROR_MESSAGE);
				}
			}
		}); 
		jbTLtra.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(MyMatchet.Chet(MyMatchet.Myregex.MATHE, jtTLmdg.getText())&&MyMatchet.Chet(MyMatchet.Myregex.MASACH, jtTLms.getText())) {
					int mathe = MyMatchet.ConvertMathe(jtTLmdg.getText());
					int masach = MyMatchet.ConvertMasach(jtTLms.getText());
					int tienphat = 0;
					if (SqlCommands.Datediff(mathe, masach)> SqlCommands.songayduocmuon) { 
						tienphat = (SqlCommands.Datediff(mathe, masach) - SqlCommands.songayduocmuon) * SqlCommands.tienphatmotngay;
					}
					try {
						if (SqlCommands.Trasach(mathe, masach, tienphat)) {
							JOptionPane.showMessageDialog(null, "Trả thành công!!!", "Message", JOptionPane.PLAIN_MESSAGE);
							jtTLtp.setText(tienphat+" VND");
						}
						else JOptionPane.showMessageDialog(null, "Lỗi Lỗi!!!", "Message", JOptionPane.ERROR_MESSAGE);
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, "Lỗi rồi :v!!!", "Message", JOptionPane.ERROR_MESSAGE);
					}
				}
				else JOptionPane.showMessageDialog(null, "Sai mã sách!!!", "Message", JOptionPane.ERROR_MESSAGE);
			}
		}); 
		jbTLmat.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(MyMatchet.Chet(MyMatchet.Myregex.MATHE, jtTLmdg.getText())&&MyMatchet.Chet(MyMatchet.Myregex.MASACH, jtTLms.getText())) {
					int mathe = MyMatchet.ConvertMathe(jtTLmdg.getText());
					int masach = MyMatchet.ConvertMasach(jtTLms.getText());
					int tienphat = 0;
					if (SqlCommands.Datediff(mathe, masach)> SqlCommands.songayduocmuon) { 
						tienphat = (SqlCommands.Datediff(mathe, masach) - SqlCommands.songayduocmuon) * SqlCommands.tienphatmotngay + SqlCommands.Giasach(masach) * SqlCommands.mucphat;
					}
					try {
						if (SqlCommands.Matsach(mathe, masach, tienphat)) {
							JOptionPane.showMessageDialog(null, "Mất rồi, hix!!!", "Message", JOptionPane.PLAIN_MESSAGE);
							jtTLtp.setText(tienphat+" VND");
						}
						else JOptionPane.showMessageDialog(null, "Lỗi Lỗi!!!", "Message", JOptionPane.ERROR_MESSAGE);
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, "Lỗi rồi :v!!!", "Message", JOptionPane.ERROR_MESSAGE);
					}
				}
				else JOptionPane.showMessageDialog(null, "Sai mã sách!!!", "Message", JOptionPane.ERROR_MESSAGE);
			}
		}); 
		jbTLhuy.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jtTLmdg.setText("");
				jtTLms.setText("");
				jtTLtp.setText("");
				Tmodel = SqlCommands.GetTableModel(SqlCommands.SelectCommands(CmdLines.selectTable.PHIEUTRA), CmdLines.columnNames.PHIEUTRA);
				Ttable.setModel(Tmodel);
			}
		}); 
	}
	JPanel panelMuon, panelTra;
	JLabel jlbgr1, jlbgr2;
	JPanel jpML,jpMC,jpMR;
	JPanel jpTL,jpTR;
	// ML
	JLabel jlMLmdg, jlMLtdg, jlMLslsdm, jlMLtn;
	JTextField jtMLmdg, jtMLtdg, jtMLslsdm, jtMLtn;
	JButton jbMLkt;
	// MC
	JLabel jlMCms;
	JTextField jtMCms;
	JTextArea jtMCselect;
	JScrollPane jsMCselect;
	JButton jbMCkt, jbMCthem, jbMCms, jbMchuy;
	
	LinkedList<String> sachmuon;
	// MR
	JTable Mtable;
	DefaultTableModel Mmodel;
	JScrollPane jsMtable;
	// TL
	JLabel jlTLmdg, jlTLms, jlTLtp;
	JTextField jtTLmdg, jtTLms, jtTLtp;
	JButton jbTLkt, jbTLtra, jbTLmat, jbTLhuy;
	// TR
	JTable Ttable;
	DefaultTableModel Tmodel;
	JScrollPane jsTtable;
}
