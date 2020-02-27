package com.udogan.magazayonetimi.ui;

import java.awt.LayoutManager;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;

public class DistributorIslemleriPaneli extends JPanel {
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblDistribtrIlemleriPaneli;

	public DistributorIslemleriPaneli() {
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(getPanel(), GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
				.addComponent(getPanel_1(), GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(getPanel(), GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(getPanel_1(), GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
		// TODO Auto-generated constructor stub
	}

	public DistributorIslemleriPaneli(LayoutManager layout) {
		super(layout);
		// TODO Auto-generated constructor stub
	}

	public DistributorIslemleriPaneli(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

	public DistributorIslemleriPaneli(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(null);
			panel.add(getLblDistribtrIlemleriPaneli());
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
	private JLabel getLblDistribtrIlemleriPaneli() {
		if (lblDistribtrIlemleriPaneli == null) {
			lblDistribtrIlemleriPaneli = new JLabel("Distrib\u00FCt\u00F6r \u0130\u015Flemleri Paneli");
			lblDistribtrIlemleriPaneli.setBounds(31, 39, 214, 14);
		}
		return lblDistribtrIlemleriPaneli;
	}
}
