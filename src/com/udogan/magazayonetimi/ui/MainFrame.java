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
	private JMenuItem mnýtmNewMenuItem;
	private JMenuItem mnýtmNewMenuItem_1;
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
			mnNewMenu.add(getMnýtmNewMenuItem_1());
			mnNewMenu.add(getMnýtmNewMenuItem());
		}
		return mnNewMenu;
	}
	private JMenuItem getMnýtmNewMenuItem() {
		if (mnýtmNewMenuItem == null) {
			mnýtmNewMenuItem = new JMenuItem("New menu item");
		}
		return mnýtmNewMenuItem;
	}
	private JMenuItem getMnýtmNewMenuItem_1() {
		if (mnýtmNewMenuItem_1 == null) {
			mnýtmNewMenuItem_1 = new JMenuItem("New menu item");
		}
		return mnýtmNewMenuItem_1;
	}
}
