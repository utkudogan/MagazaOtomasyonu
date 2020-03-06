package com.udogan.magazayonetimi.ui;

import javax.swing.JFrame;
import javax.swing.JPanel;

import static javax.swing.JOptionPane.showMessageDialog;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;

import com.udogan.magazayonetimi.models.Marka;
import com.udogan.magazayonetimi.models.Urun;
import com.udogan.magazayonetimi.models.enums.Bedenler;
import com.udogan.magazayonetimi.models.enums.Cinsiyetler;
import com.udogan.magazayonetimi.models.enums.Renkler;
import com.udogan.magazayonetimi.utils.dao.DbServicessBase;

import javax.swing.JTextField;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.ParseException;
import java.util.List;

import javax.swing.JEditorPane;
import javax.swing.JComboBox;

public class UrunDegistirme extends JFrame {
	private JPanel panel;
	private JButton btnKaydet;
	private JButton btnIptal;
	private Urun urun;
	public JComponent parentComponent;
	public UrunIslemleriPaneli parentFrame;
	private JButton btnSil;
	private JComboBox cmbBeden;
	private JLabel lblBeden;
	private JLabel lblRenk;
	private JComboBox cmbRenk;
	private JTextField txtModel;
	private JLabel lblModel;
	private JLabel lblMarka;
	private JComboBox cmbMarka;
	private JTextField txtIsim;
	private JLabel lblIsim;
	private JLabel lblFiyat;
	private JTextField txtFiyat;
	private JComboBox cmbCinsiyet;
	private JLabel lblCinsiyet;

	public UrunDegistirme(MouseEvent e, Urun urun) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				parentFrame.parentFrame.setEnabled(true);
				parentFrame.tabloyuDoldur();
				parentFrame.parentFrame.toFront();
			}
		});
		this.urun = urun;
		this.parentComponent = (JComponent) e.getSource();
		this.parentFrame = (UrunIslemleriPaneli) parentComponent.getParent().getParent().getParent().getParent();
		setTitle("Urun Bilgileri Deðiþtirme Ekraný");
		setSize(340, 316);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().add(getPanel(), BorderLayout.CENTER);
		alanlariDoldur();
	}

	private void alanlariDoldur() {
		cmbBeden.setModel(new DefaultComboBoxModel(Bedenler.values()));
		cmbBeden.setSelectedItem(urun.getBeden());
		cmbCinsiyet.setModel(new DefaultComboBoxModel(Cinsiyetler.values()));
		cmbCinsiyet.setSelectedItem(urun.getCinsiyet());
		DbServicessBase<Marka> dao = new DbServicessBase<Marka>();
		Marka temp = new Marka();
		List<Marka> markaListesi = dao.getAllRows(temp);
		cmbMarka.setModel(new DefaultComboBoxModel(markaListesi.toArray()));
		for (Marka m : markaListesi) {
			if (m.getId() == urun.getMarkaId()) {
				cmbMarka.setSelectedItem(urun.getMarkaId());
			}
		}
		cmbRenk.setModel(new DefaultComboBoxModel(Renkler.values()));
		cmbRenk.setSelectedItem(urun.getBeden());
		txtFiyat.setText(urun.getFiyat().toString());
		txtIsim.setText(urun.getIsim());
		txtModel.setText(urun.getModel());
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(null);
			panel.add(getBtnKaydet());
			panel.add(getBtnIptal());
			panel.add(getBtnSil());
			panel.add(getCmbBeden());
			panel.add(getLblBeden());
			panel.add(getLblRenk());
			panel.add(getCmbRenk());
			panel.add(getTxtModel());
			panel.add(getLblModel());
			panel.add(getLblMarka());
			panel.add(getCmbMarka());
			panel.add(getTxtIsim());
			panel.add(getLblIsim());
			panel.add(getLblFiyat());
			panel.add(getTxtFiyat());
			panel.add(getCmbCinsiyet());
			panel.add(getLblCinsiyet());
		}
		return panel;
	}

	private JButton getBtnKaydet() {
		if (btnKaydet == null) {
			btnKaydet = new JButton("KAYDET");
			btnKaydet.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					DbServicessBase<Urun> dao = new DbServicessBase<Urun>();
					Urun degiseUrun = new Urun();
					degiseUrun.setCinsiyet((Cinsiyetler) cmbCinsiyet.getSelectedItem());
					degiseUrun.setFiyat(Double.parseDouble(txtFiyat.getText()));
					degiseUrun.setRenk((Renkler) cmbRenk.getSelectedItem());
					degiseUrun.setIsim(txtIsim.getText());
					degiseUrun.setMarkaId(((Marka) cmbMarka.getSelectedItem()).getId());
					degiseUrun.setModel(txtModel.getText());
					degiseUrun.setBeden((Bedenler) cmbBeden.getSelectedItem());

					if (dao.update(degiseUrun)) {
						showMessageDialog(null, "Kaydetme Ýþlemi Baþarýlý!");
						UrunDegistirme.this.dispose();
					} else {
						showMessageDialog(null, "Kaydetme Ýþlemi Baþarýsýz Oldu!");
					}
				}
			});
			btnKaydet.setBounds(45, 246, 80, 20);
		}

		return btnKaydet;
	}

	private JButton getBtnIptal() {
		if (btnIptal == null) {
			btnIptal = new JButton("\u0130PTAL");
			btnIptal.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					UrunDegistirme.this.dispose();
				}
			});
			btnIptal.setBounds(228, 246, 80, 20);
		}

		return btnIptal;
	}

	private JButton getBtnSil() {
		if (btnSil == null) {
			btnSil = new JButton("S\u0130L");
			btnSil.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					DbServicessBase<Urun> dao = new DbServicessBase<Urun>();
					if (dao.delete(urun)) {
						UrunDegistirme.this.dispose();
					} else {
						showMessageDialog(null, "Silme Ýþlemi Baþarýsýz Oldu!");
					}
				}
			});
			btnSil.setBounds(138, 246, 80, 20);
		}
		return btnSil;
	}

	private JComboBox getCmbBeden() {
		if (cmbBeden == null) {
			cmbBeden = new JComboBox();
			cmbBeden.setSelectedIndex(-1);
			cmbBeden.setBounds(80, 202, 228, 20);
		}
		return cmbBeden;
	}

	private JLabel getLblBeden() {
		if (lblBeden == null) {
			lblBeden = new JLabel("Beden :");
			lblBeden.setLabelFor(getCmbBeden());
			lblBeden.setHorizontalAlignment(SwingConstants.RIGHT);
			lblBeden.setBounds(24, 202, 46, 20);
		}
		return lblBeden;
	}

	private JLabel getLblRenk() {
		if (lblRenk == null) {
			lblRenk = new JLabel("Renk :");
			lblRenk.setLabelFor(getCmbRenk());
			lblRenk.setHorizontalAlignment(SwingConstants.RIGHT);
			lblRenk.setBounds(10, 171, 60, 20);
		}
		return lblRenk;
	}

	private JComboBox getCmbRenk() {
		if (cmbRenk == null) {
			cmbRenk = new JComboBox();
			cmbRenk.setSelectedIndex(-1);
			cmbRenk.setBounds(80, 171, 228, 20);
		}
		return cmbRenk;
	}

	private JTextField getTxtModel() {
		if (txtModel == null) {
			txtModel = new JTextField();
			txtModel.setText("");
			txtModel.setColumns(10);
			txtModel.setBounds(80, 139, 228, 20);
		}
		return txtModel;
	}

	private JLabel getLblModel() {
		if (lblModel == null) {
			lblModel = new JLabel("Model :");
			lblModel.setLabelFor(getTxtModel());
			lblModel.setHorizontalAlignment(SwingConstants.RIGHT);
			lblModel.setBounds(10, 139, 60, 20);
		}
		return lblModel;
	}

	private JLabel getLblMarka() {
		if (lblMarka == null) {
			lblMarka = new JLabel("Marka :");
			lblMarka.setLabelFor(getCmbMarka());
			lblMarka.setHorizontalAlignment(SwingConstants.RIGHT);
			lblMarka.setBounds(10, 107, 60, 20);
		}
		return lblMarka;
	}

	private JComboBox getCmbMarka() {
		if (cmbMarka == null) {
			cmbMarka = new JComboBox();
			cmbMarka.setSelectedIndex(-1);
			cmbMarka.setBounds(80, 107, 228, 20);
		}
		return cmbMarka;
	}

	private JTextField getTxtIsim() {
		if (txtIsim == null) {
			txtIsim = new JTextField();
			txtIsim.setColumns(10);
			txtIsim.setBounds(80, 75, 228, 20);
		}
		return txtIsim;
	}

	private JLabel getLblIsim() {
		if (lblIsim == null) {
			lblIsim = new JLabel("\u0130sim :");
			lblIsim.setLabelFor(getTxtIsim());
			lblIsim.setHorizontalAlignment(SwingConstants.RIGHT);
			lblIsim.setBounds(10, 75, 60, 20);
		}
		return lblIsim;
	}

	private JLabel getLblFiyat() {
		if (lblFiyat == null) {
			lblFiyat = new JLabel("Fiyat :");
			lblFiyat.setLabelFor(getTxtFiyat());
			lblFiyat.setHorizontalAlignment(SwingConstants.RIGHT);
			lblFiyat.setBounds(10, 43, 60, 20);
		}
		return lblFiyat;
	}

	private JTextField getTxtFiyat() {
		if (txtFiyat == null) {
			txtFiyat = new JTextField();
			txtFiyat.setColumns(10);
			txtFiyat.setBounds(80, 43, 228, 20);
		}
		return txtFiyat;
	}

	private JComboBox getCmbCinsiyet() {
		if (cmbCinsiyet == null) {
			cmbCinsiyet = new JComboBox();
			cmbCinsiyet.setSelectedIndex(-1);
			cmbCinsiyet.setBounds(80, 11, 228, 20);
		}
		return cmbCinsiyet;
	}

	private JLabel getLblCinsiyet() {
		if (lblCinsiyet == null) {
			lblCinsiyet = new JLabel("Cinsiyet :");
			lblCinsiyet.setLabelFor(getCmbCinsiyet());
			lblCinsiyet.setHorizontalAlignment(SwingConstants.RIGHT);
			lblCinsiyet.setBounds(10, 11, 60, 20);
		}
		return lblCinsiyet;
	}
}
