package com.qltv.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

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
		jtMCselect.setBackground(new Color(1f,1f,1f,0.2f));
		jtMCselect.setLineWrap(true);
		jtMCselect.setWrapStyleWord(true);
		jsMCselect.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
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
		Mtable.setModel(new DefaultTableModel(
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
		jsMtable.setBounds(5, 5, 450, 240);
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
		Ttable.setModel(new DefaultTableModel(
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
				// TODO Auto-generated method stub
				
			}
		});
		//MC
		jbMCkt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		jbMCthem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		jbMCms.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		}); 
		jbMchuy.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		}); 
		//TL
		jbTLkt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		}); 
		jbTLtra.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		}); 
		jbTLmat.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		}); 
		jbTLhuy.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
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
	// MR
	JTable Mtable;
	JScrollPane jsMtable;
	// TL
	JLabel jlTLmdg, jlTLms, jlTLtp;
	JTextField jtTLmdg, jtTLms, jtTLtp;
	JButton jbTLkt, jbTLtra, jbTLmat, jbTLhuy;
	// TR
	JTable Ttable;
	JScrollPane jsTtable;
}
