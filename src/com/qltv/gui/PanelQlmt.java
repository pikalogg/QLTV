package com.qltv.gui;

import java.awt.Color;

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
			
			// --Mc-- //
		
			// --MR--//
		
		// --endMuon--//
		// --panelTra--//
			// --TL-- //
			
			// --TR--//
		
		// --endTra--//
	}
	JPanel panelMuon, panelTra;
	JLabel jlbgr1, jlbgr2;
	JPanel jpML,jpMC,jpMR;
	JPanel jpTL,jpTR;
	// ML
	JLabel jlMLmdg, jlMLtdg, jlMLslsdm, jlMLtn;
	JTextField jtMLmdg, jtMLtdg, jtMLslsdm, jtMLtn;
	JButton jbMTkt;
	// MC
	JLabel jlMCms;
	JTextField jtMCms;
	JTextArea jtMCselect;
	JScrollPane jsMCselect;
	JButton jbMCkt, jbMCthem, jbMCms, jbMchuy;
	// MR
	JTable Mtable;
	// TL
	JLabel jlTLmdg, jlTLms, jlTLtp;
	JTextField jtTLmdg, jtTLms, jtTLtp;
	JButton jbTLkt, jbTLtra, jbTLmuon, jbTLhuy;
}
