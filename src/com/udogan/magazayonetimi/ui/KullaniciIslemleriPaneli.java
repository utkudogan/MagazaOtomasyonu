package com.udogan.magazayonetimi.ui;

import javax.swing.JPanel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.table.TableColumnModel;
import javax.swing.table.DefaultTableModel;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import com.udogan.magazayonetimi.models.Kullanici;
import com.udogan.magazayonetimi.models.enums.Yetkiler;
import com.udogan.magazayonetimi.utils.dao.DbServicessBase;

import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.JComboBox;

public class KullaniciIslemleriPaneli extends JPanel {
	private JPanel pnlDetay;
	private JPanel pnlTablo;
	private JTable table;
	private JScrollPane scrollPane;
	private JButton btnKaydet;
	public MainFrame parentFrame;
	private JTextField txtKullaniciAdi;
	private JTextField txtSifre;
	private JComboBox cmbYetki;
	private JLabel lblKullanciAdi;
	private JLabel lblSifre;
	private JLabel lblYetkiTuru;

	public KullaniciIslemleriPaneli(MainFrame parentFrame) {
		this.parentFrame = parentFrame;
		setSize(1000, 500);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup()
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(getPnlDetay(), GroupLayout.PREFERRED_SIZE, 452, GroupLayout.PREFERRED_SIZE)
						.addComponent(getPnlTablo(), GroupLayout.PREFERRED_SIZE, 450, GroupLayout.PREFERRED_SIZE))
				.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addComponent(getPnlDetay(), GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(getPnlTablo(), GroupLayout.PREFERRED_SIZE, 285, GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));
		setLayout(groupLayout);
		tabloyuDoldur();
		combolariDoldur();
	}

	public void tabloyuDoldur() {

		try {
			DbServicessBase<Kullanici> dao = new DbServicessBase<Kullanici>();
			Kullanici temp = new Kullanici();
			List<Kullanici> kullaniciListesi = dao.getAllRows(temp);

			String[] columnNames = { "id", "Kullanýcý Adý", "Þifre", "Yetki" };
			Object[][] data = new Object[kullaniciListesi.size()][columnNames.length];

			for (int i = 0; i < kullaniciListesi.size(); i++) {

				data[i][0] = ((Kullanici) kullaniciListesi.get(i)).getId();
				data[i][1] = ((Kullanici) kullaniciListesi.get(i)).getKullaniciAdi();
				data[i][2] = ((Kullanici) kullaniciListesi.get(i)).getSifre();
				data[i][3] = ((Kullanici) kullaniciListesi.get(i)).getYetki();
			}

			table.setModel(new DefaultTableModel(data, columnNames));
			table.setPreferredScrollableViewportSize(new Dimension(500, 70));
			table.setFillsViewportHeight(true);
			TableColumnModel tcm = table.getColumnModel();
			tcm.removeColumn(tcm.getColumn(0));
		} catch (Exception e) {
			showMessageDialog(null, e.getMessage());
		}
	}
	private void combolariDoldur() {
		cmbYetki.setModel(new DefaultComboBoxModel(Yetkiler.values()));
		cmbYetki.setSelectedIndex(-1);
	}

	private JPanel getPnlDetay() {
		if (pnlDetay == null) {
			pnlDetay = new JPanel();
			pnlDetay.setLayout(null);
			pnlDetay.add(getBtnKaydet());
			pnlDetay.add(getTxtKullaniciAdi());
			pnlDetay.add(getTxtSifre());
			pnlDetay.add(getCmbYetki());
			pnlDetay.add(getLblKullanciAdi());
			pnlDetay.add(getLblSifre());
			pnlDetay.add(getLblYetkiTuru());
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
			table.setAlignmentY(Component.TOP_ALIGNMENT);
			table.setAlignmentX(Component.LEFT_ALIGNMENT);
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int secilenSatir = table.getSelectedRow();
					Kullanici degistirilecekKullanici = new Kullanici();
					degistirilecekKullanici
							.setId(Long.parseLong(table.getModel().getValueAt(secilenSatir, 0).toString()));
					degistirilecekKullanici.setKullaniciAdi(table.getModel().getValueAt(secilenSatir, 1).toString());
					degistirilecekKullanici.setSifre(table.getModel().getValueAt(secilenSatir, 2).toString());
					String temp = "";
					if (table.getModel().getValueAt(secilenSatir, 3) != null) {
						temp = table.getModel().getValueAt(secilenSatir, 3).toString();
					}
					else {
						degistirilecekKullanici.setYetki(null);
					}
					if (temp.equals("Kasiyer")) {
						degistirilecekKullanici.setYetki(Yetkiler.Kasiyer);
					} else if (temp.equals("SatisTemsilcisi")) {
						degistirilecekKullanici.setYetki(Yetkiler.SatisTemsilcisi);
					} else if (temp.equals("SubeMuduru")) {
						degistirilecekKullanici.setYetki(Yetkiler.SubeMuduru);
					}else if (temp.equals("Yonetici")) {
						degistirilecekKullanici.setYetki(Yetkiler.Yonetici);
					}
					KullaniciDegistirme frame = new KullaniciDegistirme(e, degistirilecekKullanici);
					parentFrame.setEnabled(false);
					frame.setVisible(true);
				}
			});
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

	private JButton getBtnKaydet() {
		if (btnKaydet == null) {
			btnKaydet = new JButton("Kaydet");
			btnKaydet.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					DbServicessBase<Kullanici> dao = new DbServicessBase<Kullanici>();
					Kullanici eklenecekKullanici = new Kullanici();
					eklenecekKullanici.setKullaniciAdi(txtKullaniciAdi.getText());
					eklenecekKullanici.setSifre(txtSifre.getText());
					eklenecekKullanici.setYetki((Yetkiler)cmbYetki.getSelectedItem());

					if (dao.save(eklenecekKullanici)) {
						tabloyuDoldur();
						txtKullaniciAdi.setText("");
						txtSifre.setText("");
						cmbYetki.setSelectedIndex(-1);
					} else {
						showMessageDialog(null, "Kaydetme Ýþlemi Baþarýsýz Oldu!");
					}

				}
			});
			btnKaydet.setBounds(260, 100, 89, 20);
		}
		return btnKaydet;
	}
	private JTextField getTxtKullaniciAdi() {
		if (txtKullaniciAdi == null) {
			txtKullaniciAdi = new JTextField();
			txtKullaniciAdi.setBounds(101, 10, 245, 20);
			txtKullaniciAdi.setColumns(10);
		}
		return txtKullaniciAdi;
	}
	private JTextField getTxtSifre() {
		if (txtSifre == null) {
			txtSifre = new JTextField();
			txtSifre.setText("");
			txtSifre.setBounds(101, 40, 245, 20);
			txtSifre.setColumns(10);
		}
		return txtSifre;
	}
	private JComboBox getCmbYetki() {
		if (cmbYetki == null) {
			cmbYetki = new JComboBox();
			cmbYetki.setBounds(101, 70, 245, 20);
		}
		return cmbYetki;
	}
	private JLabel getLblKullanciAdi() {
		if (lblKullanciAdi == null) {
			lblKullanciAdi = new JLabel("Kullan\u0131c\u0131 Ad\u0131 :");
			lblKullanciAdi.setHorizontalAlignment(SwingConstants.RIGHT);
			lblKullanciAdi.setLabelFor(getTxtKullaniciAdi());
			lblKullanciAdi.setBounds(10, 10, 81, 20);
		}
		return lblKullanciAdi;
	}
	private JLabel getLblSifre() {
		if (lblSifre == null) {
			lblSifre = new JLabel("\u015Eifre :");
			lblSifre.setHorizontalAlignment(SwingConstants.RIGHT);
			lblSifre.setLabelFor(lblSifre);
			lblSifre.setBounds(10, 40, 81, 20);
		}
		return lblSifre;
	}
	private JLabel getLblYetkiTuru() {
		if (lblYetkiTuru == null) {
			lblYetkiTuru = new JLabel("Yetki T\u00FCr\u00FC :");
			lblYetkiTuru.setHorizontalAlignment(SwingConstants.RIGHT);
			lblYetkiTuru.setLabelFor(getCmbYetki());
			lblYetkiTuru.setBounds(10, 70, 81, 20);
		}
		return lblYetkiTuru;
	}
}
