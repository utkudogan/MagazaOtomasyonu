package com.udogan.magazayonetimi.ui;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JTabbedPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame {
	private JPanel panel;
	private JPanel panel_1;
	private JMenuBar menuBar;
	private JMenu mnIslemler;
	private JMenuItem mntmDistributorIslemleri;
	private JMenuItem mntmBedenIslemleri;
	private JTabbedPane anaTabbedPane;
	private JMenuItem mntmKategoriIslemleri;
	private JMenuItem mntmKullaniciIislemleri;
	private JMenuItem mntmNewMarkaIslemleri;
	private JMenuItem mntmMüþteriIslemleri;
	private JMenu mnUrunler;
	private JMenuItem mntmUrunIslemleri;
	public MainFrame() {
		initialize();		
	}
	
	private void initialize() {
		setTitle("Kullanýcý Giriþ Ekraný");
		setSize(789, 788);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(0, 0));
		getContentPane().add(getPanel(), BorderLayout.NORTH);
		getContentPane().add(getPanel_1(), BorderLayout.CENTER);
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(new BorderLayout(0, 0));
			panel.add(getMenuBar_1(), BorderLayout.WEST);
		}
		return panel;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setLayout(new BorderLayout(0, 0));
			panel_1.add(getAnaTabbedPane());
			
		}
		return panel_1;
	}
	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMnIslemler());
			menuBar.add(getMnUrunler());
		}
		return menuBar;
	}
	private JMenu getMnIslemler() {
		if (mnIslemler == null) {
			mnIslemler = new JMenu("\u0130\u015Flemler");
			mnIslemler.add(getMntmBedenIslemleri());
			mnIslemler.add(getMntmDistributorIslemleri());
			mnIslemler.add(getMntmKategoriIslemleri());
			mnIslemler.add(getMntmKullaniciIislemleri());
			mnIslemler.add(getMntmNewMarkaIslemleri());
			mnIslemler.add(getMntmMüþteriIslemleri());
		}
		return mnIslemler;
	}
	private JMenuItem getMntmDistributorIslemleri() {
		if (mntmDistributorIslemleri == null) {
			mntmDistributorIslemleri = new JMenuItem("Distrib\u00FCt\u00F6r \u0130\u015Flemleri");
			mntmDistributorIslemleri.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					yeniTabEkle(e);
				}
			});
		}
		return mntmDistributorIslemleri;
	}
	private JMenuItem getMntmBedenIslemleri() {
		if (mntmBedenIslemleri == null) {
			mntmBedenIslemleri = new JMenuItem("Beden \u0130\u015Flemleri");
			mntmBedenIslemleri.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					yeniTabEkle(e);
				}
			});
		}
		return mntmBedenIslemleri;
	}
	private JMenuItem getMntmKategoriIslemleri() {
		if (mntmKategoriIslemleri == null) {
			mntmKategoriIslemleri = new JMenuItem("Kategori \u0130\u015Flemleri");
			mntmKategoriIslemleri.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					yeniTabEkle(e);					
				}
			});
			
		}
		return mntmKategoriIslemleri;
	}
	
	private JMenuItem getMntmKullaniciIislemleri() {
		if (mntmKullaniciIislemleri == null) {
			mntmKullaniciIislemleri = new JMenuItem("Kullanici \u0130\u015Flemleri");
			mntmKullaniciIislemleri.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					yeniTabEkle(e);	
				}
			});
		}
		return mntmKullaniciIislemleri;
	}
	private JMenuItem getMntmNewMarkaIslemleri() {
		if (mntmNewMarkaIslemleri == null) {
			mntmNewMarkaIslemleri = new JMenuItem("Marka \u0130\u015Flemleri");
			mntmNewMarkaIslemleri.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					yeniTabEkle(e);	
				}
			});
		}
		return mntmNewMarkaIslemleri;
	}
	
	private JMenuItem getMntmMüþteriIslemleri() {
		if (mntmMüþteriIslemleri == null) {
			mntmMüþteriIslemleri = new JMenuItem("M\u00FC\u015Fteri \u0130\u015Flemleri");
			mntmMüþteriIslemleri.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					yeniTabEkle(e);	
				}
			});
		}
		return mntmMüþteriIslemleri;
	}
	private void yeniTabEkle(ActionEvent e) {
			String tetiklenenMenuIsmi = e.getActionCommand();
			switch (tetiklenenMenuIsmi) {
			case "Beden Ýþlemleri":				
				if (anaTabbedPane.getTabCount() == 0) {
					anaTabbedPane.setVisible(true);				
					anaTabbedPane.add(tetiklenenMenuIsmi, new BedenIslemleriPaneli(MainFrame.this));
				}
				else {
					anaTabbedPane.insertTab(tetiklenenMenuIsmi, null, new BedenIslemleriPaneli(this),null, anaTabbedPane.getTabCount());
				}
				break;
			case "Distribütör Ýþlemleri":
				if (anaTabbedPane.getTabCount() == 0) {
					anaTabbedPane.setVisible(true);				
					anaTabbedPane.add(tetiklenenMenuIsmi, new DistributorIslemleriPaneli(this));
				}
				else {
					anaTabbedPane.insertTab(tetiklenenMenuIsmi, null, new DistributorIslemleriPaneli(this),null, anaTabbedPane.getTabCount());
				}
				break;
			case "Kategori Ýþlemleri":
				if (anaTabbedPane.getTabCount() == 0) {
					anaTabbedPane.setVisible(true);				
					anaTabbedPane.add(tetiklenenMenuIsmi, new KategoriIslemleriPaneli(this));
				}
				else {
					anaTabbedPane.insertTab(tetiklenenMenuIsmi, null, new KategoriIslemleriPaneli(this),null, anaTabbedPane.getTabCount());
				}
				break;
			case "Kullanici Ýþlemleri":
			if (anaTabbedPane.getTabCount() == 0) {
				anaTabbedPane.setVisible(true);				
				anaTabbedPane.add(tetiklenenMenuIsmi, new KullaniciIslemleriPaneli(this));
			}
			else {
				anaTabbedPane.insertTab(tetiklenenMenuIsmi, null, new KullaniciIslemleriPaneli(this),null, anaTabbedPane.getTabCount());
			}
			break;
			case "Marka Ýþlemleri":
				if (anaTabbedPane.getTabCount() == 0) {
					anaTabbedPane.setVisible(true);				
					anaTabbedPane.add(tetiklenenMenuIsmi, new MarkaIslemleriPaneli(this));
				}
				else {
					anaTabbedPane.insertTab(tetiklenenMenuIsmi, null, new MarkaIslemleriPaneli(this),null, anaTabbedPane.getTabCount());
				}
				break;
			case "Müþteri Ýþlemleri":
				if (anaTabbedPane.getTabCount() == 0) {
					anaTabbedPane.setVisible(true);				
					anaTabbedPane.add(tetiklenenMenuIsmi, new MusteriIslemleriPaneli(this));
				}
				else {
					anaTabbedPane.insertTab(tetiklenenMenuIsmi, null, new MusteriIslemleriPaneli(this),null, anaTabbedPane.getTabCount());
				}
				break;
			default:
				break;
			}
		}
	private JTabbedPane getAnaTabbedPane() {
		if (anaTabbedPane == null) {
			anaTabbedPane = new JTabbedPane(JTabbedPane.TOP);
			anaTabbedPane.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int i = e.getButton();
					if (i == 2) {
						anaTabbedPane.remove(anaTabbedPane.getSelectedComponent());
					}
				}
			});
		}
		return anaTabbedPane;
	}
	
	
	
	
	private JMenu getMnUrunler() {
		if (mnUrunler == null) {
			mnUrunler = new JMenu("\u00DCr\u00FCnler");
			mnUrunler.add(getMntmUrunIslemleri());
		}
		return mnUrunler;
	}
	private JMenuItem getMntmUrunIslemleri() {
		if (mntmUrunIslemleri == null) {
			mntmUrunIslemleri = new JMenuItem("\u00DCr\u00FCn \u0130\u015Flemleri");
		}
		return mntmUrunIslemleri;
	}
	}

