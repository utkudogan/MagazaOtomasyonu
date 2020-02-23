package com.udogan.magazayonetimi.ui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.udogan.magazayonetimi.models.Kullanici;
import com.udogan.magazayonetimi.ui.LoginFrame;
import com.udogan.magazayonetimi.ui.MainFrameEski;
import com.udogan.magazayonetimi.utils.dao.DbServicessBase;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class LoginFrame extends JFrame {
	public static Kullanici oturumAcanKullanici;
	private JTextField txtKullaniciAdi;
	private JPasswordField passwordSifre;
	private JLabel lblKullaniciAdi;
	private JLabel lblSifre;
	private JButton btnGiris;
	private JButton btnIptal;

	public LoginFrame() {
		initialize();
	}

	private void initialize() {
		setTitle("Kullanýcý Giriþ Ekraný");
		setSize(302, 214);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		getContentPane().add(getLblKullaniciAdi());
		getContentPane().add(getLblSifre());
		getContentPane().add(getTxtKullaniciAdi());
		getContentPane().add(getPasswordSifre());
		getContentPane().add(getBtnGiris());
		getContentPane().add(getBtnIptal());
	}

	public JTextField getTxtKullaniciAdi() {
		if (txtKullaniciAdi == null) {
			txtKullaniciAdi = new JTextField();
			txtKullaniciAdi.setBounds(108, 50, 142, 20);
			txtKullaniciAdi.setColumns(10);
		}
		return txtKullaniciAdi;
	}

	public JPasswordField getPasswordSifre() {
		if (passwordSifre == null) {
			passwordSifre = new JPasswordField();
			passwordSifre.setBounds(108, 82, 142, 20);
		}
		return passwordSifre;
	}

	public JLabel getLblKullaniciAdi() {
		if (lblKullaniciAdi == null) {
			lblKullaniciAdi = new JLabel("Kullan\u0131c\u0131 Ad\u0131 :");
			lblKullaniciAdi.setBounds(24, 46, 74, 28);
		}
		return lblKullaniciAdi;
	}

	public JLabel getLblSifre() {
		if (lblSifre == null) {
			lblSifre = new JLabel("\u015Eifre :");
			lblSifre.setBounds(24, 85, 46, 14);
		}
		return lblSifre;
	}

	public JButton getBtnGiris() {
		if (btnGiris == null) {
			btnGiris = new JButton("Giri\u015F");
			btnGiris.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					DbServicessBase<Kullanici> dao = new DbServicessBase<Kullanici>();
					Kullanici temp = new Kullanici();
					temp.setKullaniciAdi(txtKullaniciAdi.getText());
					temp.setSifre(passwordSifre.getText().toString());
					List<Kullanici> liste = dao.search(temp);
					if (liste.size() > 0) {
						oturumAcanKullanici = liste.get(0);
						new MainFrameEski().setVisible(true);
						LoginFrame.this.dispose();
					}

					else {
						JOptionPane.showMessageDialog(LoginFrame.this, "Giriþ Baþarýsýz");
					}
				}
			});
			btnGiris.setBounds(24, 131, 99, 23);
		}
		return btnGiris;
	}

	public JButton getBtnIptal() {
		if (btnIptal == null) {
			btnIptal = new JButton("\u0130ptal");
			btnIptal.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					LoginFrame.this.dispose();
				}
			});
			btnIptal.setBounds(151, 131, 99, 23);
		}
		return btnIptal;
	}
}
