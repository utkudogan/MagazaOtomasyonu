package com.udogan.magazayonetimi.ui;

import javax.swing.JFrame;
import javax.swing.JPanel;

import static javax.swing.JOptionPane.showMessageDialog;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;

import com.udogan.magazayonetimi.models.Distributor;
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

import javax.swing.JTextPane;

public class DistributorDegistirme extends JFrame {
	private JPanel panel;
	private JLabel labelUnvan;
	private JLabel lblYetkiliKii;
	private JLabel lblTelefon;
	private JLabel lblAdres;
	private JTextField txtTelefon;
	private JButton btnKaydet;
	private JButton btnIptal;
	private Distributor distributor;
	public JComponent parentComponent;
	public BedenIslemleriPaneli parentFrame;
	private JButton btnSil;
	private JTextField txttUnvan;
	private JTextField txtYetkili;
	private JTextPane txtAdres;

	public DistributorDegistirme(MouseEvent e, Distributor distributor) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				parentFrame.parentFrame.setEnabled(true);
				parentFrame.tabloyuDoldur();
			}
		});
		this.distributor = distributor;
		this.parentComponent = (JComponent) e.getSource();
		this.parentFrame = (BedenIslemleriPaneli) parentComponent.getParent().getParent().getParent().getParent();
		setTitle("Distributor Bilgileri Deðiþtirme Ekraný");
		setSize(302, 281);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().add(getPanel(), BorderLayout.CENTER);
		alanlariDoldur();
	}

	private void alanlariDoldur() {
		txttUnvan.setText(distributor.getIsim());
		txtYetkili.setText(distributor.getYetkili());
		txtTelefon.setText(distributor.getTelefon());
		txtAdres.setText(distributor.getAdres());
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(null);
			panel.add(getLabelUnvan());
			panel.add(getLblYetkiliKii());
			panel.add(getLblTelefon());
			panel.add(getLblAdres());
			panel.add(getTxtTelefon());
			panel.add(getBtnKaydet());
			panel.add(getBtnIptal());
			panel.add(getBtnSil());
			panel.add(getTxttUnvan());
			panel.add(getTxtYetkili());
			panel.add(getTxtAdres());
		}
		return panel;
	}

	private JLabel getLabelUnvan() {
		if (labelUnvan == null) {
			labelUnvan = new JLabel("Unvan :");
			labelUnvan.setLabelFor(getTxttUnvan());
			labelUnvan.setHorizontalAlignment(SwingConstants.RIGHT);
			labelUnvan.setBounds(26, 17, 64, 20);
		}
		return labelUnvan;
	}

	private JLabel getLblYetkiliKii() {
		if (lblYetkiliKii == null) {
			lblYetkiliKii = new JLabel("Yetkili Ki\u015Fi :");
			lblYetkiliKii.setLabelFor(getTxtYetkili());
			lblYetkiliKii.setHorizontalAlignment(SwingConstants.RIGHT);
			lblYetkiliKii.setBounds(26, 54, 64, 20);
		}
		return lblYetkiliKii;
	}

	private JLabel getLblTelefon() {
		if (lblTelefon == null) {
			lblTelefon = new JLabel("Telefon :");
			lblTelefon.setHorizontalAlignment(SwingConstants.RIGHT);
			lblTelefon.setBounds(26, 91, 64, 20);
		}
		return lblTelefon;
	}

	private JLabel getLblAdres() {
		if (lblAdres == null) {
			lblAdres = new JLabel("Adres :");
			lblAdres.setLabelFor(lblAdres);
			lblAdres.setHorizontalAlignment(SwingConstants.RIGHT);
			lblAdres.setBounds(26, 128, 64, 20);
		}
		return lblAdres;
	}

	private JTextField getTxtTelefon() {
		if (txtTelefon == null) {
			 MaskFormatter fmt;
				try {
					fmt = new MaskFormatter("###-###-####");
					txtTelefon = new JFormattedTextField(fmt);
					txtTelefon.setBounds(108, 91, 135, 20);
					txtTelefon.setColumns(10);
				} catch (ParseException e) {
					txtTelefon = new JTextField();
					txtTelefon.setBounds(108, 91, 135, 20);
					txtTelefon.setColumns(10);
				}
		}
		return txtTelefon;
	}

	private JButton getBtnKaydet() {
		if (btnKaydet == null) {
			btnKaydet = new JButton("KAYDET");
			btnKaydet.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					DbServicessBase<Distributor> dao = new DbServicessBase<Distributor>();
					Distributor degiseDistributor = new Distributor();
					degiseDistributor.setIsim(txttUnvan.getText());
					degiseDistributor.setYetkili(txtYetkili.getText());
					degiseDistributor.setTelefon(txtTelefon.getText());
					degiseDistributor.setAdres(txtAdres.getText());


					if (dao.update(degiseDistributor)) {
						showMessageDialog(null, "Kaydetme Ýþlemi Baþarýlý!");
						DistributorDegistirme.this.dispose();
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
					DistributorDegistirme.this.dispose();
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
					DbServicessBase<Distributor> dao = new DbServicessBase<Distributor>();
					if (dao.delete(distributor)) {
						DistributorDegistirme.this.dispose();
					} else {
						showMessageDialog(null, "Silme Ýþlemi Baþarýsýz Oldu!");
					}
				}
			});
			btnSil.setBounds(106, 210, 80, 20);
		}
		return btnSil;
	}
	private JTextField getTxttUnvan() {
		if (txttUnvan == null) {
			txttUnvan = new JTextField();
			txttUnvan.setText((String) null);
			txttUnvan.setColumns(10);
			txttUnvan.setBounds(108, 17, 143, 20);
		}
		return txttUnvan;
	}
	private JTextField getTxtYetkili() {
		if (txtYetkili == null) {
			txtYetkili = new JTextField();
			txtYetkili.setText((String) null);
			txtYetkili.setColumns(10);
			txtYetkili.setBounds(108, 54, 143, 20);
		}
		return txtYetkili;
	}
	private JTextPane getTxtAdres() {
		if (txtAdres == null) {
			txtAdres = new JTextPane();
			txtAdres.setBounds(108, 128, 143, 71);
		}
		return txtAdres;
	}
}
