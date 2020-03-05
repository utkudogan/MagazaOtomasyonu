package com.udogan.magazayonetimi.ui;

import javax.swing.JFrame;
import javax.swing.JPanel;

import static javax.swing.JOptionPane.showMessageDialog;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import com.udogan.magazayonetimi.models.Beden;
import com.udogan.magazayonetimi.models.enums.Bedenler;
import com.udogan.magazayonetimi.models.enums.Cinsiyetler;
import com.udogan.magazayonetimi.utils.dao.DbServicessBase;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class BedenDegistirme extends JFrame {
	private JPanel panel;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JTextField txtBasen;
	private JTextField txtBel;
	private JTextField txtGogus;
	private JComboBox cmbCinsiyet;
	private JComboBox cmbBeden;
	private JButton btnKaydet;
	private JButton btnIptal;
	private Beden beden;
	public JComponent parentComponent;
	public BedenIslemleriPaneli parentFrame;
	private JButton btnSil;

	public BedenDegistirme(MouseEvent e, Beden beden) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				parentFrame.parentFrame.setEnabled(true);
				parentFrame.tabloyuDoldur();
				parentFrame.parentFrame.toFront();
			}
		});
		this.beden = beden;
		this.parentComponent = (JComponent) e.getSource();
		this.parentFrame = (BedenIslemleriPaneli) parentComponent.getParent().getParent().getParent().getParent();
		setTitle("Beden Bilgileri Deðiþtirme Ekraný");
		setSize(302, 281);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().add(getPanel(), BorderLayout.CENTER);
		alanlariDoldur();
	}

	private void alanlariDoldur() {
		cmbBeden.setModel(new DefaultComboBoxModel(Bedenler.values()));
		cmbBeden.setSelectedItem(beden.getBeden());
		cmbCinsiyet.setModel(new DefaultComboBoxModel(Cinsiyetler.values()));
		cmbCinsiyet.setSelectedItem(beden.getCinsiyet());
		txtBasen.setText(Integer.toString(beden.getBasen()));
		txtBel.setText(Integer.toString(beden.getBel()));
		txtGogus.setText(Integer.toString(beden.getGogus()));
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(null);
			panel.add(getLabel());
			panel.add(getLabel_1());
			panel.add(getLabel_2());
			panel.add(getLabel_3());
			panel.add(getLabel_4());
			panel.add(getTxtBasen());
			panel.add(getTxtBel());
			panel.add(getTxtGogus());
			panel.add(getCmbCinsiyet());
			panel.add(getCmbBeden());
			panel.add(getBtnKaydet());
			panel.add(getBtnIptal());
			panel.add(getBtnSil());
		}
		return panel;
	}

	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("Cinsiyet :");
			label.setHorizontalAlignment(SwingConstants.RIGHT);
			label.setBounds(26, 17, 64, 20);
		}
		return label;
	}

	private JLabel getLabel_1() {
		if (label_1 == null) {
			label_1 = new JLabel("Beden :");
			label_1.setHorizontalAlignment(SwingConstants.RIGHT);
			label_1.setBounds(26, 54, 64, 20);
		}
		return label_1;
	}

	private JLabel getLabel_2() {
		if (label_2 == null) {
			label_2 = new JLabel("Basen :");
			label_2.setHorizontalAlignment(SwingConstants.RIGHT);
			label_2.setBounds(26, 91, 64, 20);
		}
		return label_2;
	}

	private JLabel getLabel_3() {
		if (label_3 == null) {
			label_3 = new JLabel("Bel :");
			label_3.setHorizontalAlignment(SwingConstants.RIGHT);
			label_3.setBounds(26, 128, 64, 20);
		}
		return label_3;
	}

	private JLabel getLabel_4() {
		if (label_4 == null) {
			label_4 = new JLabel("G\u00F6\u011F\u00FCs :");
			label_4.setHorizontalAlignment(SwingConstants.RIGHT);
			label_4.setBounds(26, 165, 64, 20);
		}
		return label_4;
	}

	private JTextField getTxtBasen() {
		if (txtBasen == null) {
			txtBasen = new JTextField();
			txtBasen.setColumns(10);
			txtBasen.setBounds(108, 91, 135, 20);
		}
		return txtBasen;
	}

	private JTextField getTxtBel() {
		if (txtBel == null) {
			txtBel = new JTextField();
			txtBel.setColumns(10);
			txtBel.setBounds(108, 128, 135, 20);
		}
		return txtBel;
	}

	private JTextField getTxtGogus() {
		if (txtGogus == null) {
			txtGogus = new JTextField();
			txtGogus.setColumns(10);
			txtGogus.setBounds(108, 165, 135, 20);
		}
		return txtGogus;
	}

	private JComboBox getCmbCinsiyet() {
		if (cmbCinsiyet == null) {
			cmbCinsiyet = new JComboBox();
			cmbCinsiyet.setSelectedIndex(-1);
			cmbCinsiyet.setBounds(108, 17, 135, 20);
		}
		return cmbCinsiyet;
	}

	private JComboBox getCmbBeden() {
		if (cmbBeden == null) {
			cmbBeden = new JComboBox();
			cmbBeden.setSelectedIndex(-1);
			cmbBeden.setBounds(108, 54, 135, 20);
		}
		return cmbBeden;
	}

	private JButton getBtnKaydet() {
		if (btnKaydet == null) {
			btnKaydet = new JButton("KAYDET");
			btnKaydet.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					DbServicessBase<Beden> dao = new DbServicessBase<Beden>();
					Beden degisecekBeden = new Beden();
					degisecekBeden.setId(beden.getId());
					degisecekBeden.setCinsiyet((Cinsiyetler) cmbCinsiyet.getSelectedItem());
					degisecekBeden.setBeden((Bedenler) cmbBeden.getSelectedItem());
					degisecekBeden.setBasen(Integer.parseInt(txtBasen.getText()));
					degisecekBeden.setBel(Integer.parseInt(txtBel.getText()));
					degisecekBeden.setGogus(Integer.parseInt(txtGogus.getText()));

					if (dao.update(degisecekBeden)) {
						showMessageDialog(null, "Kaydetme Ýþlemi Baþarýlý!");
						BedenDegistirme.this.dispose();
					} else {
						showMessageDialog(null, "Kaydetme Ýþlemi Baþarýsýz Oldu!");
					}					
				}
			});
			btnKaydet.setBounds(13, 210, 80, 20);
		}

		return btnKaydet;
	}

	private JButton getBtnIptal() {
		if (btnIptal == null) {
			btnIptal = new JButton("\u0130PTAL");
			btnIptal.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					BedenDegistirme.this.dispose();
				}
			});
			btnIptal.setBounds(199, 210, 80, 20);
		}

		return btnIptal;
	}
	private JButton getBtnSil() {
		if (btnSil == null) {
			btnSil = new JButton("S\u0130L");
			btnSil.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					DbServicessBase<Beden> dao = new DbServicessBase<Beden>();
					if (dao.delete(beden)) {
						BedenDegistirme.this.dispose();
					} else {
						showMessageDialog(null, "Silme Ýþlemi Baþarýsýz Oldu!");
					}
				}
			});
			btnSil.setBounds(106, 210, 80, 20);
		}
		return btnSil;
	}
}
