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
import java.awt.ComponentOrientation;
import java.awt.event.MouseWheelListener;
import java.awt.event.MouseWheelEvent;

public class MainFrame extends JFrame {
	private JPanel panel;
	private JPanel panel_1;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenuItem mnýtmDistributorIslemleri;
	private JMenuItem mnýtmBedenIslemleri;
	private JTabbedPane tabbedPane;
	private JTabbedPane anaTabbedPane;
	public MainFrame() {
		initialize();		
	}
	
	private void initialize() {
		setTitle("Kullanýcý Giriþ Ekraný");
		setSize(1000, 1000);
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
			panel_1.add(getAnaTabbedPane(), BorderLayout.CENTER);
			
		}
		return panel_1;
	}
	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMnNewMenu());
		}
		return menuBar;
	}
	private JMenu getMnNewMenu() {
		if (mnNewMenu == null) {
			mnNewMenu = new JMenu("New menu");
			mnNewMenu.add(getMnýtmBedenIslemleri());
			mnNewMenu.add(getMnýtmDistributorIslemleri());
		}
		return mnNewMenu;
	}
	private JMenuItem getMnýtmDistributorIslemleri() {
		if (mnýtmDistributorIslemleri == null) {
			mnýtmDistributorIslemleri = new JMenuItem("Distrib\u00FCtor \u0130\u015Flemleri");
			mnýtmDistributorIslemleri.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					yeniTabEkle(e);
				}
			});
		}
		return mnýtmDistributorIslemleri;
	}
	private JMenuItem getMnýtmBedenIslemleri() {
		if (mnýtmBedenIslemleri == null) {
			mnýtmBedenIslemleri = new JMenuItem("Beden \u0130\u015Flemleri");
			mnýtmBedenIslemleri.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					yeniTabEkle(e);
				}
			});
		}
		return mnýtmBedenIslemleri;
	}
	private JTabbedPane getTabbedPane() {
		if (tabbedPane == null) {
			tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		}
		return tabbedPane;
	}
	
	private void yeniTabEkle(ActionEvent e) {
			String tetiklenenMenuIsmi = e.getActionCommand();
			JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
			switch (tetiklenenMenuIsmi) {
			case "Beden Ýþlemleri":				
				if (anaTabbedPane.getTabCount() == 0) {
					anaTabbedPane.setVisible(true);
					anaTabbedPane.setSize(panel_1.getWidth(), panel_1.getHeight());					
					anaTabbedPane.add(tetiklenenMenuIsmi, new BedenIslemleriPaneli(MainFrame.this));
				}
				else {
					anaTabbedPane.insertTab(tetiklenenMenuIsmi, null, new BedenIslemleriPaneli(this),null, anaTabbedPane.getTabCount());
				}
				break;
			case "Distribütor Ýþlemleri":
				if (anaTabbedPane.getTabCount() == 0) {
					anaTabbedPane.setVisible(true);
					anaTabbedPane.setSize(panel_1.getWidth(), panel_1.getHeight());					
					anaTabbedPane.add(tetiklenenMenuIsmi, new DistributorIslemleriPaneliEski(this));
				}
				else {
					anaTabbedPane.insertTab(tetiklenenMenuIsmi, null, new DistributorIslemleriPaneliEski(this),null, anaTabbedPane.getTabCount());
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
	}

