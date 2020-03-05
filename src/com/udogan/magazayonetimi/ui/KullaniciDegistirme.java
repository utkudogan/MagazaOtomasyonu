package com.udogan.magazayonetimi.ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JComponent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import static javax.swing.JOptionPane.showMessageDialog;

import com.udogan.magazayonetimi.models.Kullanici;
import com.udogan.magazayonetimi.models.enums.Yetkiler;
import com.udogan.magazayonetimi.utils.dao.DbServicessBase;

import java.awt.BorderLayout;

import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JComboBox;

public class KullaniciDegistirme extends JFrame {
	private JPanel panel;
	private JButton btnKaydet;
	private JButton btnIptal;
	private JButton btnSil;
	private Kullanici kullanici;
	public JComponent parentComponent;
	public KullaniciIslemleriPaneli parentFrame;
	private JTextField txtKullaniciAdi;
	private JTextField txtSifre;
	private JComboBox cmbYetki;
	private JLabel lblKullanciAdi;
	private JLabel lblSifre;
	private JLabel lblYetki;

	public KullaniciDegistirme(MouseEvent e, Kullanici kullanici) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				parentFrame.parentFrame.setEnabled(true);
				parentFrame.tabloyuDoldur();
				parentFrame.parentFrame.toFront();
			}
		});
		this.kullanici = kullanici;
		this.parentComponent = (JComponent) e.getSource();
		this.parentFrame = (KullaniciIslemleriPaneli) parentComponent.getParent().getParent().getParent().getParent();
		setTitle("Distributor Bilgileri Deðiþtirme Ekraný");
		setSize(332, 186);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().add(getPanel(), BorderLayout.CENTER);
		alanlariDoldur();
	}

	private void alanlariDoldur() {
		txtKullaniciAdi.setText(kullanici.getKullaniciAdi());
		txtSifre.setText(kullanici.getSifre());
		cmbYetki.setModel(new DefaultComboBoxModel(Yetkiler.values()));
		if (kullanici.getYetki() != null) {
			cmbYetki.setSelectedItem(kullanici.getYetki());
		} else {
			cmbYetki.setSelectedIndex(-1);
		}
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(null);
			panel.add(getBtnKaydet());
			panel.add(getBtnIptal());
			panel.add(getBtnSil());
			panel.add(getTxtKullaniciAdi());
			panel.add(getTxtSifre());
			panel.add(getCmbYetki());
			panel.add(getLblKullanciAdi());
			panel.add(getLblSifre());
			panel.add(getLblYetki());
		}
		return panel;
	}

	private JButton getBtnKaydet() {
		if (btnKaydet == null) {
			btnKaydet = new JButton("KAYDET");
			btnKaydet.setBounds(36, 110, 80, 20);
			btnKaydet.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					DbServicessBase<Kullanici> dao = new DbServicessBase<Kullanici>();
					Kullanici degiseKullanici = new Kullanici();
					degiseKullanici.setId(kullanici.getId());
					;
					degiseKullanici.setKullaniciAdi(txtKullaniciAdi.getText());
					degiseKullanici.setSifre(txtSifre.getText());
					degiseKullanici.setYetki((Yetkiler) cmbYetki.getSelectedItem());

					if (dao.update(degiseKullanici)) {
						showMessageDialog(null, "Kaydetme Ýþlemi Baþarýlý!");
						KullaniciDegistirme.this.dispose();
					} else {
						showMessageDialog(null, "Kaydetme Ýþlemi Baþarýsýz Oldu!");
					}
				}
			});
		}

		return btnKaydet;
	}

	private JButton getBtnIptal() {
		if (btnIptal == null) {
			btnIptal = new JButton("\u0130PTAL");
			btnIptal.setBounds(222, 110, 80, 20);
			btnIptal.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					KullaniciDegistirme.this.dispose();
				}
			});
		}

		return btnIptal;
	}

	private JButton getBtnSil() {
		if (btnSil == null) {
			btnSil = new JButton("S\u0130L");
			btnSil.setBounds(129, 110, 80, 20);
			btnSil.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					DbServicessBase<Kullanici> dao = new DbServicessBase<Kullanici>();
					if (dao.delete(kullanici)) {
						KullaniciDegistirme.this.dispose();
					} else {
						showMessageDialog(null, "Silme Ýþlemi Baþarýsýz Oldu!");
					}
				}
			});
		}
		return btnSil;
	}

	private JTextField getTxtKullaniciAdi() {
		if (txtKullaniciAdi == null) {
			txtKullaniciAdi = new JTextField();
			txtKullaniciAdi.setBounds(90, 13, 212, 20);
			txtKullaniciAdi.setColumns(10);
		}
		return txtKullaniciAdi;
	}

	private JTextField getTxtSifre() {
		if (txtSifre == null) {
			txtSifre = new JTextField();
			txtSifre.setText("");
			txtSifre.setBounds(90, 46, 212, 20);
			txtSifre.setColumns(10);
		}
		return txtSifre;
	}

	private JComboBox getCmbYetki() {
		if (cmbYetki == null) {
			cmbYetki = new JComboBox();
			cmbYetki.setBounds(90, 79, 212, 20);
		}
		return cmbYetki;
	}

	private JLabel getLblKullanciAdi() {
		if (lblKullanciAdi == null) {
			lblKullanciAdi = new JLabel("Kullan\u0131c\u0131 Ad\u0131 :");
			lblKullanciAdi.setHorizontalAlignment(SwingConstants.RIGHT);
			lblKullanciAdi.setLabelFor(getTxtKullaniciAdi());
			lblKullanciAdi.setBounds(10, 13, 70, 20);
		}
		return lblKullanciAdi;
	}

	private JLabel getLblSifre() {
		if (lblSifre == null) {
			lblSifre = new JLabel("\u015Eifre :");
			lblSifre.setHorizontalAlignment(SwingConstants.RIGHT);
			lblSifre.setLabelFor(getTxtSifre());
			lblSifre.setBounds(10, 46, 70, 20);
		}
		return lblSifre;
	}

	private JLabel getLblYetki() {
		if (lblYetki == null) {
			lblYetki = new JLabel("Yetki :");
			lblYetki.setHorizontalAlignment(SwingConstants.RIGHT);
			lblYetki.setLabelFor(getCmbYetki());
			lblYetki.setBounds(10, 79, 70, 20);
		}
		return lblYetki;
	}
}
