package com.udogan.magazayonetimi.ui;

import javax.swing.JFrame;
import javax.swing.JPanel;

import static javax.swing.JOptionPane.showMessageDialog;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import com.udogan.magazayonetimi.models.Kategori;
import com.udogan.magazayonetimi.utils.dao.DbServicessBase;

import javax.swing.JTextField;
import javax.swing.JComponent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class KategoriDegistirme extends JFrame {
	private JPanel panel;
	private JButton btnKaydet;
	private JButton btnIptal;
	private JButton btnSil;
	private Kategori kategori;
	public JComponent parentComponent;
	public KategoriIslemleriPaneli parentFrame;
	private JTextField txtAnaKategori;
	private JTextField txtKategori;
	private JTextField txtAltKategori;
	private JLabel lblAnaKategori;
	private JLabel lblKategori;
	private JLabel lblAltKategori;
	

	public KategoriDegistirme(MouseEvent e, Kategori kategori) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				parentFrame.parentFrame.setEnabled(true);
				parentFrame.tabloyuDoldur();
				parentFrame.parentFrame.toFront();
			}
		});
		this.kategori = kategori;
		this.parentComponent = (JComponent) e.getSource();
		this.parentFrame = (KategoriIslemleriPaneli) parentComponent.getParent().getParent().getParent().getParent();
		setTitle("Distributor Bilgileri Deðiþtirme Ekraný");
		setSize(394, 174);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().add(getPanel(), BorderLayout.CENTER);
		alanlariDoldur();
	}

	private void alanlariDoldur() {
		txtAnaKategori.setText(kategori.getAnaKategori());
		txtKategori.setText(kategori.getKategori());
		txtAltKategori.setText(kategori.getAltKategori());
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(null);
			panel.add(getBtnKaydet());
			panel.add(getBtnIptal());
			panel.add(getBtnSil());
			panel.add(getTxtAnaKategori());
			panel.add(getTxtKategori());
			panel.add(getTxtAltKategori());
			panel.add(getLblAnaKategori());
			panel.add(getLblKategori());
			panel.add(getLblAltKategori());
		}
		return panel;
	}

	private JButton getBtnKaydet() {
		if (btnKaydet == null) {
			btnKaydet = new JButton("KAYDET");
			btnKaydet.setBounds(102, 104, 80, 20);
			btnKaydet.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					DbServicessBase<Kategori> dao = new DbServicessBase<Kategori>();
					Kategori degiseKategori = new Kategori();
					degiseKategori.setId(kategori.getId());;
					degiseKategori.setAnaKategori(txtAnaKategori.getText());
					degiseKategori.setKategori(txtKategori.getText());
					degiseKategori.setAltKategori(txtAltKategori.getText());
					
					if (dao.update(degiseKategori)) {
						showMessageDialog(null, "Kaydetme Ýþlemi Baþarýlý!");
						KategoriDegistirme.this.dispose();
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
			btnIptal.setBounds(288, 104, 80, 20);
			btnIptal.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					KategoriDegistirme.this.dispose();
				}
			});
		}

		return btnIptal;
	}
	private JButton getBtnSil() {
		if (btnSil == null) {
			btnSil = new JButton("S\u0130L");
			btnSil.setBounds(195, 104, 80, 20);
			btnSil.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					DbServicessBase<Kategori> dao = new DbServicessBase<Kategori>();
					if (dao.delete(kategori)) {
						KategoriDegistirme.this.dispose();
					} else {
						showMessageDialog(null, "Silme Ýþlemi Baþarýsýz Oldu!");
					}
				}
			});
		}
		return btnSil;
	}
	private JTextField getTxtAnaKategori() {
		if (txtAnaKategori == null) {
			txtAnaKategori = new JTextField();
			txtAnaKategori.setBounds(96, 11, 272, 20);
			txtAnaKategori.setColumns(10);
		}
		return txtAnaKategori;
	}
	private JTextField getTxtKategori() {
		if (txtKategori == null) {
			txtKategori = new JTextField();
			txtKategori.setBounds(96, 42, 272, 20);
			txtKategori.setColumns(10);
		}
		return txtKategori;
	}
	private JTextField getTxtAltKategori() {
		if (txtAltKategori == null) {
			txtAltKategori = new JTextField();
			txtAltKategori.setText("");
			txtAltKategori.setBounds(96, 73, 272, 20);
			txtAltKategori.setColumns(10);
		}
		return txtAltKategori;
	}
	private JLabel getLblAnaKategori() {
		if (lblAnaKategori == null) {
			lblAnaKategori = new JLabel("Ana Kategori :");
			lblAnaKategori.setHorizontalAlignment(SwingConstants.RIGHT);
			lblAnaKategori.setLabelFor(getTxtAnaKategori());
			lblAnaKategori.setBounds(10, 14, 76, 20);
		}
		return lblAnaKategori;
	}
	private JLabel getLblKategori() {
		if (lblKategori == null) {
			lblKategori = new JLabel("Kategori :");
			lblKategori.setHorizontalAlignment(SwingConstants.RIGHT);
			lblKategori.setLabelFor(getTxtKategori());
			lblKategori.setBounds(10, 45, 76, 20);
		}
		return lblKategori;
	}
	private JLabel getLblAltKategori() {
		if (lblAltKategori == null) {
			lblAltKategori = new JLabel("Alt Kategori :");
			lblAltKategori.setHorizontalAlignment(SwingConstants.RIGHT);
			lblAltKategori.setLabelFor(getTxtAltKategori());
			lblAltKategori.setBounds(10, 76, 76, 20);
		}
		return lblAltKategori;
	}
}
