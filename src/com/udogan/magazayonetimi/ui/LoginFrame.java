package com.udogan.magazayonetimi.ui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.udogan.magazayonetimi.models.Kullanici;
import com.udogan.magazayonetimi.ui.LoginFrame;
import com.udogan.magazayonetimi.ui.MainFrame;
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
	public LoginFrame() {
		initialize();
	}

	private void initialize() {
		setTitle("Kullanýcý Giriþ Ekraný");
		setSize(302, 214);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblKullaniciAdi = new JLabel("Kullan\u0131c\u0131 Ad\u0131 :");
		lblKullaniciAdi.setBounds(24, 46, 74, 28);
		getContentPane().add(lblKullaniciAdi);
		
		JLabel lblSifre = new JLabel("\u015Eifre :");
		lblSifre.setBounds(24, 85, 46, 14);
		getContentPane().add(lblSifre);
		
		txtKullaniciAdi = new JTextField();
		txtKullaniciAdi.setBounds(108, 50, 142, 20);
		getContentPane().add(txtKullaniciAdi);
		txtKullaniciAdi.setColumns(10);
		
		passwordSifre = new JPasswordField();
		passwordSifre.setBounds(108, 82, 142, 20);
		getContentPane().add(passwordSifre);
		
		JButton btnGiris = new JButton("Giri\u015F");
		btnGiris.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DbServicessBase<Kullanici> dao = new DbServicessBase<Kullanici>();
				Kullanici temp = new Kullanici();
				temp.setKullaniciAdi(txtKullaniciAdi.getText());
				temp.setSifre(passwordSifre.getText().toString());
				List<Kullanici> liste = dao.search(temp);
				if(liste.size() > 0)
				{
					oturumAcanKullanici = liste.get(0);
					new MainFrame().setVisible(true);
					LoginFrame.this.dispose();
				}
					
				else {
					JOptionPane.showMessageDialog(LoginFrame.this, "Giriþ Baþarýsýz");
				}
			}
		});
		btnGiris.setBounds(24, 131, 99, 23);
		getContentPane().add(btnGiris);
		
		JButton btnIptal = new JButton("\u0130ptal");
		btnIptal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginFrame.this.dispose();
			}
		});
		btnIptal.setBounds(151, 131, 99, 23);
		getContentPane().add(btnIptal);
	}
}
