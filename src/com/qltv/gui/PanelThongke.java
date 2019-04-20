package com.qltv.gui;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class PanelThongke extends JTabbedPane{
	private static final long serialVersionUID = 1L;

	public PanelThongke() {
		setBorder(BorderFactory.createLineBorder(Color.BLACK,0));
		setBackground(new Color(0f,0f,0f,0f));

		panelMuonSach = new JPanel();
		panelQuaHan = new JPanel();
		
		
		
		
		
		
		
		
		add("Độc giả mượn sách",panelMuonSach);
		add("Quá hạn",panelQuaHan);
		
		panelMuonSach.setLayout(null);
		panelQuaHan.setLayout(null);
		jlbgr1 = new JLabel(new ImageIcon("rec\\img\\main\\muontrabgr.png"));
		jlbgr2 = new JLabel(new ImageIcon("rec\\img\\main\\muontrabgr.png"));
		panelMuonSach.add(jlbgr1);
		panelQuaHan.add(jlbgr2);
		jlbgr1.setBounds(0, 0, 900, 310);
		jlbgr2.setBounds(0, 0, 900, 310);
	}
	JPanel panelMuonSach, panelQuaHan;
	JLabel jlbgr1, jlbgr2;
}
