package com.udogan.magazayonetimi.ui;

import javax.swing.JFrame;
import javax.swing.JPanel;

import static javax.swing.JOptionPane.showMessageDialog;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;

import com.udogan.magazayonetimi.models.Musteri;
import com.udogan.magazayonetimi.utils.dao.DbServicessBase;

import javax.swing.JTextField;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.ParseException;

import javax.swing.JEditorPane;

public class MusteriDegistirme extends JFrame {
	private JPanel panel;
	private JButton btnKaydet;
	private JButton btnIptal;
	private Musteri musteri;
	public JComponent parentComponent;
	public MusteriIslemleriPaneli parentFrame;
	private JButton btnSil;
	private JLabel lblMusteriIsmi;
	private JLabel lblMusteriTelefonu;
	private JLabel lblMusteriAdresi;
	private JTextField txtMusteriIsmi;
	private JTextField txtMusteriTelefonu;
	private JEditorPane txtMusteriAdresi;

	public MusteriDegistirme(MouseEvent e, Musteri musteri) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				parentFrame.parentFrame.setEnabled(true);
				parentFrame.tabloyuDoldur();
				parentFrame.parentFrame.toFront();
			}
		});
		this.musteri = musteri;
		this.parentComponent = (JComponent) e.getSource();
		this.parentFrame = (MusteriIslemleriPaneli) parentComponent.getParent().getParent().getParent().getParent();
		setTitle("Musteri Bilgileri Deðiþtirme Ekraný");
		setSize(301, 281);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().add(getPanel(), BorderLayout.CENTER);
		alanlariDoldur();
	}

	private void alanlariDoldur() {
		txtMusteriIsmi.setText(musteri.getIsim());
		txtMusteriAdresi.setText(musteri.getAdres());
		txtMusteriTelefonu.setText(musteri.getTelefon().replaceAll("-", ""));
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(null);
			panel.add(getBtnKaydet());
			panel.add(getBtnIptal());
			panel.add(getBtnSil());
			panel.add(getLblMusteriIsmi());
			panel.add(getLblMusteriTelefonu());
			panel.add(getLblMusteriAdresi());
			panel.add(getTxtMusteriIsmi());
			panel.add(getTxtMusteriTelefonu());
			panel.add(getTxtMusteriAdresi());
		}
		return panel;
	}

	private JButton getBtnKaydet() {
		if (btnKaydet == null) {
			btnKaydet = new JButton("KAYDET");
			btnKaydet.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					DbServicessBase<Musteri> dao = new DbServicessBase<Musteri>();
					Musteri degiseMusteri = new Musteri();
					degiseMusteri.setId(musteri.getId());;
					degiseMusteri.setIsim(txtMusteriIsmi.getText());
					degiseMusteri.setTelefon(txtMusteriTelefonu.getText());
					degiseMusteri.setAdres(txtMusteriAdresi.getText());

					if (dao.update(degiseMusteri)) {
						showMessageDialog(null, "Kaydetme Ýþlemi Baþarýlý!");
						MusteriDegistirme.this.dispose();
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
					MusteriDegistirme.this.dispose();
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
					DbServicessBase<Musteri> dao = new DbServicessBase<Musteri>();
					if (dao.delete(musteri)) {
						MusteriDegistirme.this.dispose();
					} else {
						showMessageDialog(null, "Silme Ýþlemi Baþarýsýz Oldu!");
					}
				}
			});
			btnSil.setBounds(106, 210, 80, 20);
		}
		return btnSil;
	}
	private JLabel getLblMusteriIsmi() {
		if (lblMusteriIsmi == null) {
			lblMusteriIsmi = new JLabel("\u0130sim :");
			lblMusteriIsmi.setHorizontalAlignment(SwingConstants.RIGHT);
			lblMusteriIsmi.setBounds(13, 15, 46, 20);
		}
		return lblMusteriIsmi;
	}
	private JLabel getLblMusteriTelefonu() {
		if (lblMusteriTelefonu == null) {
			lblMusteriTelefonu = new JLabel("Telefon :");
			lblMusteriTelefonu.setHorizontalAlignment(SwingConstants.RIGHT);
			lblMusteriTelefonu.setBounds(13, 50, 46, 20);
		}
		return lblMusteriTelefonu;
	}
	private JLabel getLblMusteriAdresi() {
		if (lblMusteriAdresi == null) {
			lblMusteriAdresi = new JLabel("Adres :");
			lblMusteriAdresi.setHorizontalAlignment(SwingConstants.RIGHT);
			lblMusteriAdresi.setBounds(13, 85, 46, 20);
		}
		return lblMusteriAdresi;
	}
	private JTextField getTxtMusteriIsmi() {
		if (txtMusteriIsmi == null) {
			txtMusteriIsmi = new JTextField();
			txtMusteriIsmi.setBounds(69, 15, 210, 20);
			txtMusteriIsmi.setColumns(10);
		}
		return txtMusteriIsmi;
	}
	private JTextField getTxtMusteriTelefonu() {
		if (txtMusteriTelefonu == null) {
			 MaskFormatter fmt;
				try {
					fmt = new MaskFormatter("0###-###-####");
					txtMusteriTelefonu = new JFormattedTextField(fmt);
					txtMusteriTelefonu.setBounds(69, 50, 91, 20);
					txtMusteriTelefonu.setColumns(10);
				} catch (ParseException e) {
					txtMusteriTelefonu = new JTextField();
					txtMusteriTelefonu.setBounds(108, 91, 135, 20);
					txtMusteriTelefonu.setColumns(10);
				}
		}
		return txtMusteriTelefonu;
	}
	private JEditorPane getTxtMusteriAdresi() {
		if (txtMusteriAdresi == null) {
			txtMusteriAdresi = new JEditorPane();
			txtMusteriAdresi.setBounds(69, 85, 210, 105);
		}
		return txtMusteriAdresi;
	}
}
