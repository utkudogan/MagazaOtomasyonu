package com.udogan.magazayonetimi.ui;

import javax.swing.JFrame;
import javax.swing.JToolBar;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTree;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JTable;

public class MainFrameEski extends JFrame {
	public MainFrameEski() {
		setBounds(500, 500, 700, 700);
		
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnIslemler = new JMenu("\u0130\u015ELEMLER");
		mnIslemler.setIcon(null);
		menuBar.add(mnIslemler);
		
		JMenuItem mntmBedenIslemleri = new JMenuItem("BEDEN \u0130\u015ELEMLER\u0130");
		mntmBedenIslemleri.setIcon(null);
		mnIslemler.add(mntmBedenIslemleri);
		
		JMenuItem mntmDistributorIslemleri = new JMenuItem("D\u0130STR\u0130B\u00DCT\u00D6R \u0130\u015ELEMLER\u0130");
		mntmDistributorIslemleri.setIcon(null);
		mnIslemler.add(mntmDistributorIslemleri);
		
		JMenuItem mn�tmKategoriIslemleri = new JMenuItem("KATEGOR\u0130 \u0130\u015ELEMLER\u0130");
		mnIslemler.add(mn�tmKategoriIslemleri);
		
		JMenuItem mn�tmKullaniciIslemleri = new JMenuItem("KULLANICI \u0130\u015ELEMLER\u0130");
		mnIslemler.add(mn�tmKullaniciIslemleri);
		
		JMenuItem mn�tmMarkaIslemleri = new JMenuItem("MARKA \u0130\u015ELEMLER\u0130");
		mnIslemler.add(mn�tmMarkaIslemleri);
		
		JMenuItem mn�tmMusteriIslemleri = new JMenuItem("M\u00DC\u015ETER\u0130 \u0130\u015ELEMLER\u0130");
		mnIslemler.add(mn�tmMusteriIslemleri);
		
		JMenuItem mn�tmUrunIslemleri = new JMenuItem("\u00DCR\u00DCN \u0130\u015ELEMLER\u0130");
		mnIslemler.add(mn�tmUrunIslemleri);
		
		JMenu mnNewMenu = new JMenu("Ayarlar");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Renk Se\u00E7imi");
		mnNewMenu.add(mntmNewMenuItem_2);
	}

}
