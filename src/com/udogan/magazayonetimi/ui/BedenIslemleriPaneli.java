package com.udogan.magazayonetimi.ui;

import java.awt.LayoutManager;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;

public class BedenIslemleriPaneli extends JPanel {
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblBedenIlemleriPaneli;

	public BedenIslemleriPaneli() {
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(getPanel(), Alignment.LEADING, 0, 0, Short.MAX_VALUE)
						.addComponent(getPanel_1(), Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 451, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addComponent(getPanel(), GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(getPanel_1(), GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE))
		);
		setLayout(groupLayout);
		// TODO Auto-generated constructor stub
	}

	public BedenIslemleriPaneli(LayoutManager layout) {
		super(layout);
		// TODO Auto-generated constructor stub
	}

	public BedenIslemleriPaneli(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

	public BedenIslemleriPaneli(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(null);
			panel.add(getLblBedenIlemleriPaneli());
		}
		return panel;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setLayout(null);
		}
		return panel_1;
	}
	private JLabel getLblBedenIlemleriPaneli() {
		if (lblBedenIlemleriPaneli == null) {
			lblBedenIlemleriPaneli = new JLabel("Beden \u0130\u015Flemleri Paneli");
			lblBedenIlemleriPaneli.setBounds(26, 28, 208, 14);
		}
		return lblBedenIlemleriPaneli;
	}
}
