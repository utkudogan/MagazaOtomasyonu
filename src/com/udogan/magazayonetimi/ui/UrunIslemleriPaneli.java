package com.udogan.magazayonetimi.ui;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class UrunIslemleriPaneli extends JPanel {
	private JPanel pnlDetay;
	private JPanel pnlTablo;
	private JTable table;
	private JScrollPane scrollPane;
	private JComboBox cmbCinsiyet;
	private JTextField txtFiyat;
	private JTextField txtIsim;
	private JComboBox cmbMarka;
	private JTextField txtModel;
	private JComboBox cmbRenk;
	private JLabel lblCinsiyet;
	private JLabel lblFiyat;
	private JLabel lblIsim;
	private JLabel lblMarka;
	private JLabel lblModel;
	private JLabel lblRenk;
	private JButton btnKaydet;
	public UrunIslemleriPaneli() {
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(getPnlTablo(), GroupLayout.PREFERRED_SIZE, 659, GroupLayout.PREFERRED_SIZE)
						.addComponent(getPnlDetay(), GroupLayout.PREFERRED_SIZE, 660, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addComponent(getPnlDetay(), GroupLayout.PREFERRED_SIZE, 242, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
					.addComponent(getPnlTablo(), GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE))
		);
		setLayout(groupLayout);
	}
	private JPanel getPnlDetay() {
		if (pnlDetay == null) {
			pnlDetay = new JPanel();
			pnlDetay.setLayout(null);
			pnlDetay.add(getCmbCinsiyet());
			pnlDetay.add(getTxtFiyat());
			pnlDetay.add(getTxtIsim());
			pnlDetay.add(getCmbMarka());
			pnlDetay.add(getTxtModel());
			pnlDetay.add(getCmbRenk());
			pnlDetay.add(getLblCinsiyet());
			pnlDetay.add(getLblFiyat());
			pnlDetay.add(getLblIsim());
			pnlDetay.add(getLblMarka());
			pnlDetay.add(getLblModel());
			pnlDetay.add(getLblRenk());
			pnlDetay.add(getBtnKaydet());
		}
		return pnlDetay;
	}
	private JPanel getPnlTablo() {
		if (pnlTablo == null) {
			pnlTablo = new JPanel();
			pnlTablo.setLayout(new BorderLayout(0, 0));
			pnlTablo.add(getScrollPane());
		}
		return pnlTablo;
	}
	private JTable getTable() {
		if (table == null) {
			table = new JTable();
		}
		return table;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getTable());
		}
		return scrollPane;
	}
	private JComboBox getCmbCinsiyet() {
		if (cmbCinsiyet == null) {
			cmbCinsiyet = new JComboBox();
			cmbCinsiyet.setBounds(80, 17, 228, 20);
		}
		return cmbCinsiyet;
	}
	private JTextField getTxtFiyat() {
		if (txtFiyat == null) {
			txtFiyat = new JTextField();
			txtFiyat.setBounds(80, 49, 228, 20);
			txtFiyat.setColumns(10);
		}
		return txtFiyat;
	}
	private JTextField getTxtIsim() {
		if (txtIsim == null) {
			txtIsim = new JTextField();
			txtIsim.setBounds(80, 81, 228, 20);
			txtIsim.setColumns(10);
		}
		return txtIsim;
	}
	private JComboBox getCmbMarka() {
		if (cmbMarka == null) {
			cmbMarka = new JComboBox();
			cmbMarka.setBounds(80, 113, 228, 20);
		}
		return cmbMarka;
	}
	private JTextField getTxtModel() {
		if (txtModel == null) {
			txtModel = new JTextField();
			txtModel.setText("");
			txtModel.setBounds(80, 145, 228, 20);
			txtModel.setColumns(10);
		}
		return txtModel;
	}
	private JComboBox getCmbRenk() {
		if (cmbRenk == null) {
			cmbRenk = new JComboBox();
			cmbRenk.setBounds(80, 177, 228, 20);
		}
		return cmbRenk;
	}
	private JLabel getLblCinsiyet() {
		if (lblCinsiyet == null) {
			lblCinsiyet = new JLabel("Cinsiyet :");
			lblCinsiyet.setHorizontalAlignment(SwingConstants.RIGHT);
			lblCinsiyet.setLabelFor(getCmbCinsiyet());
			lblCinsiyet.setBounds(10, 17, 60, 20);
		}
		return lblCinsiyet;
	}
	private JLabel getLblFiyat() {
		if (lblFiyat == null) {
			lblFiyat = new JLabel("Fiyat :");
			lblFiyat.setHorizontalAlignment(SwingConstants.RIGHT);
			lblFiyat.setLabelFor(getTxtFiyat());
			lblFiyat.setBounds(10, 49, 60, 20);
		}
		return lblFiyat;
	}
	private JLabel getLblIsim() {
		if (lblIsim == null) {
			lblIsim = new JLabel("\u0130sim :");
			lblIsim.setHorizontalAlignment(SwingConstants.RIGHT);
			lblIsim.setLabelFor(getTxtIsim());
			lblIsim.setBounds(10, 81, 60, 20);
		}
		return lblIsim;
	}
	private JLabel getLblMarka() {
		if (lblMarka == null) {
			lblMarka = new JLabel("Marka :");
			lblMarka.setHorizontalAlignment(SwingConstants.RIGHT);
			lblMarka.setLabelFor(getCmbMarka());
			lblMarka.setBounds(10, 113, 60, 20);
		}
		return lblMarka;
	}
	private JLabel getLblModel() {
		if (lblModel == null) {
			lblModel = new JLabel("Model :");
			lblModel.setHorizontalAlignment(SwingConstants.RIGHT);
			lblModel.setLabelFor(getTxtModel());
			lblModel.setBounds(10, 145, 60, 20);
		}
		return lblModel;
	}
	private JLabel getLblRenk() {
		if (lblRenk == null) {
			lblRenk = new JLabel("Renk :");
			lblRenk.setHorizontalAlignment(SwingConstants.RIGHT);
			lblRenk.setLabelFor(getCmbRenk());
			lblRenk.setBounds(10, 177, 60, 20);
		}
		return lblRenk;
	}
	private JButton getBtnKaydet() {
		if (btnKaydet == null) {
			btnKaydet = new JButton("Kaydet");
			btnKaydet.setBounds(219, 211, 89, 20);
		}
		return btnKaydet;
	}
}
