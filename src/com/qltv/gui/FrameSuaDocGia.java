package com.qltv.gui;

import java.awt.Color;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class FrameSuaDocGia extends JFrame{

	public FrameSuaDocGia() {
		setSize(680, 400);
		setResizable(false);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		getContentPane().setBackground(Color.BLACK);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}
