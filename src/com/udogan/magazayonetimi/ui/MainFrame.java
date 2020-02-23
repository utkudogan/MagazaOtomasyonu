package com.udogan.magazayonetimi.ui;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;

public class MainFrame extends JFrame {
	private JPanel panel;
	private JPanel panel_1;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenuItem mn�tmNewMenuItem;
	private JMenuItem mn�tmNewMenuItem_1;
	public MainFrame() {
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
			mnNewMenu.add(getMn�tmNewMenuItem_1());
			mnNewMenu.add(getMn�tmNewMenuItem());
		}
		return mnNewMenu;
	}
	private JMenuItem getMn�tmNewMenuItem() {
		if (mn�tmNewMenuItem == null) {
			mn�tmNewMenuItem = new JMenuItem("New menu item");
		}
		return mn�tmNewMenuItem;
	}
	private JMenuItem getMn�tmNewMenuItem_1() {
		if (mn�tmNewMenuItem_1 == null) {
			mn�tmNewMenuItem_1 = new JMenuItem("New menu item");
		}
		return mn�tmNewMenuItem_1;
	}
}
