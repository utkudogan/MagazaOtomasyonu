package com.udogan.magazayonetimi.ui;

import javax.swing.JFrame;
import javax.swing.JPanel;

import static javax.swing.JOptionPane.showMessageDialog;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import com.udogan.magazayonetimi.models.Marka;
import com.udogan.magazayonetimi.utils.dao.DbServicessBase;

import javax.swing.JTextField;
import javax.swing.JComponent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MarkaDegistirme extends JFrame {
	private JPanel panel;
	private JButton btnKaydet;
	private JButton btnIptal;
	private JButton btnSil;
	private Marka marka;
	public JComponent parentComponent;
	public MarkaIslemleriPaneli parentFrame;
	private JTextField txtIsim;
	private JLabel lblMarkaIsmi;
	

	public MarkaDegistirme(MouseEvent e, Marka marka) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				parentFrame.parentFrame.setEnabled(true);
				parentFrame.tabloyuDoldur();
				parentFrame.parentFrame.toFront();
			}
		});
		this.marka = marka;
		this.parentComponent = (JComponent) e.getSource();
		this.parentFrame = (MarkaIslemleriPaneli) parentComponent.getParent().getParent().getParent().getParent();
		setTitle("Distributor Bilgileri Deðiþtirme Ekraný");
		setSize(394, 145);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().add(getPanel(), BorderLayout.CENTER);
		alanlariDoldur();
	}

	private void alanlariDoldur() {
		txtIsim.setText(marka.getIsim());
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(null);
			panel.add(getBtnKaydet());
			panel.add(getBtnIptal());
			panel.add(getBtnSil());
			panel.add(getTxtIsim());
			panel.add(getLblMarkaIsmi());
		}
		return panel;
	}

	private JButton getBtnKaydet() {
		if (btnKaydet == null) {
			btnKaydet = new JButton("KAYDET");
			btnKaydet.setBounds(102, 76, 80, 20);
			btnKaydet.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					DbServicessBase<Marka> dao = new DbServicessBase<Marka>();
					Marka degiseMarka = new Marka();
					degiseMarka.setId(marka.getId());;
					degiseMarka.setIsim(txtIsim.getText());
					
					if (dao.update(degiseMarka)) {
						showMessageDialog(null, "Kaydetme Ýþlemi Baþarýlý!");
						MarkaDegistirme.this.dispose();
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
			btnIptal.setBounds(288, 76, 80, 20);
			btnIptal.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					MarkaDegistirme.this.dispose();
				}
			});
		}

		return btnIptal;
	}
	private JButton getBtnSil() {
		if (btnSil == null) {
			btnSil = new JButton("S\u0130L");
			btnSil.setBounds(195, 76, 80, 20);
			btnSil.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					DbServicessBase<Marka> dao = new DbServicessBase<Marka>();
					if (dao.delete(marka)) {
						MarkaDegistirme.this.dispose();
					} else {
						showMessageDialog(null, "Silme Ýþlemi Baþarýsýz Oldu!");
					}
				}
			});
		}
		return btnSil;
	}
	private JTextField getTxtIsim() {
		if (txtIsim == null) {
			txtIsim = new JTextField();
			txtIsim.setBounds(118, 24, 250, 20);
			txtIsim.setColumns(10);
		}
		return txtIsim;
	}
	private JLabel getLblMarkaIsmi() {
		if (lblMarkaIsmi == null) {
			lblMarkaIsmi = new JLabel("Marka \u0130smi :");
			lblMarkaIsmi.setHorizontalAlignment(SwingConstants.RIGHT);
			lblMarkaIsmi.setBounds(10, 24, 98, 20);
		}
		return lblMarkaIsmi;
	}
}
