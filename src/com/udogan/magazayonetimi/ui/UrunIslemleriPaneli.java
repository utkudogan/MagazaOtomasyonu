package com.udogan.magazayonetimi.ui;

import javax.swing.JPanel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import com.udogan.magazayonetimi.models.Beden;
import com.udogan.magazayonetimi.models.Marka;
import com.udogan.magazayonetimi.models.Musteri;
import com.udogan.magazayonetimi.models.Urun;
import com.udogan.magazayonetimi.models.enums.Bedenler;
import com.udogan.magazayonetimi.models.enums.Cinsiyetler;
import com.udogan.magazayonetimi.models.enums.Renkler;
import com.udogan.magazayonetimi.utils.dao.DbServicessBase;

import javax.swing.JTable;
import javax.swing.JScrollPane;

import static javax.swing.JOptionPane.showMessageDialog;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class UrunIslemleriPaneli extends JPanel {
	private JPanel pnlDetay;
	private JPanel pnlTablo;
	private JTable table;
	private JScrollPane scrollPane;
	private JComboBox cmbCinsiyet;
	private JTextField txtFiyat;
	private JTextField txtIsim;
	private JComboBox cmbMarka;
	private JTextField txtModel;
	private JComboBox cmbRenk;
	private JLabel lblCinsiyet;
	private JLabel lblFiyat;
	private JLabel lblIsim;
	private JLabel lblMarka;
	private JLabel lblModel;
	private JLabel lblRenk;
	private JButton btnKaydet;
	public MainFrame parentFrame;
	private JLabel lblBeden;
	private JComboBox cmbBeden;
	public UrunIslemleriPaneli(MainFrame parentFrame) {
		this.parentFrame = parentFrame;
		setSize(1000, 532);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(getPnlTablo(), Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(getPnlDetay(), Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 795, Short.MAX_VALUE))
					.addContainerGap(205, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(getPnlDetay(), GroupLayout.PREFERRED_SIZE, 276, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(getPnlTablo(), GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE))
		);
		setLayout(groupLayout);
		tabloyuDoldur();
		combolariDoldur();
	}
	public void tabloyuDoldur() {

		try {
			DbServicessBase<Urun> dao = new DbServicessBase<Urun>();
			Urun temp = new Urun();
			List<Urun> urunListesi = dao.getAllRows(temp);

			String[] columnNames = { "id", "Cinsiyet", "Marka", "Model", "�sim", "Renk", "Beden", "Fiyat" };
			Object[][] data = new Object[urunListesi.size()][columnNames.length];

			for (int i = 0; i < urunListesi.size(); i++) {

				data[i][0] = ((Urun) urunListesi.get(i)).getId();
				data[i][1] = ((Urun) urunListesi.get(i)).getCinsiyet();
				long urunMarkasi = ((Urun) urunListesi.get(i)).getMarkaId();
				DbServicessBase<Marka> dao2 = new DbServicessBase<Marka>();
				Marka marka = new Marka();
				marka.setId(urunMarkasi);
				List<Marka> markaListesi = dao2.getAllRows(marka);
				data[i][2] = markaListesi.get(0).getIsim();
				data[i][3] = ((Urun) urunListesi.get(i)).getModel();
				data[i][4] = ((Urun) urunListesi.get(i)).getIsim();
				data[i][5] = ((Urun) urunListesi.get(i)).getRenk();
				data[i][6] = ((Urun) urunListesi.get(i)).getBeden();
				data[i][7] = ((Urun) urunListesi.get(i)).getFiyat();
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
		DbServicessBase<Marka> dao = new DbServicessBase<Marka>();
		Marka temp = new Marka();
		List<Marka> markaListesi = dao.getAllRows(temp);
		cmbMarka.setModel(new DefaultComboBoxModel(markaListesi.toArray()));
		cmbMarka.setSelectedIndex(-1);
		cmbCinsiyet.setModel(new DefaultComboBoxModel(Cinsiyetler.values()));
		cmbCinsiyet.setSelectedIndex(-1);
		cmbRenk.setModel(new DefaultComboBoxModel(Renkler.values()));
		cmbRenk.setSelectedIndex(-1);
		cmbBeden.setModel(new DefaultComboBoxModel(Bedenler.values()));
		cmbBeden.setSelectedIndex(-1);
	}
	private JPanel getPnlDetay() {
		if (pnlDetay == null) {
			pnlDetay = new JPanel();
			pnlDetay.setLayout(null);
			pnlDetay.add(getCmbCinsiyet());
			pnlDetay.add(getTxtFiyat());
			pnlDetay.add(getTxtIsim());
			pnlDetay.add(getCmbMarka());
			pnlDetay.add(getTxtModel());
			pnlDetay.add(getCmbRenk());
			pnlDetay.add(getLblCinsiyet());
			pnlDetay.add(getLblFiyat());
			pnlDetay.add(getLblIsim());
			pnlDetay.add(getLblMarka());
			pnlDetay.add(getLblModel());
			pnlDetay.add(getLblRenk());
			pnlDetay.add(getBtnKaydet());
			pnlDetay.add(getLblBeden());
			pnlDetay.add(getCmbBeden());
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
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int secilenSatir = table.getSelectedRow();
					Urun degistirilecekUrun = new Urun();
					degistirilecekUrun.setId(Long.parseLong(table.getModel().getValueAt(secilenSatir, 0).toString()));
					String temp = table.getModel().getValueAt(secilenSatir, 1).toString();
					if (temp.equals("erkek")) {
						degistirilecekUrun.setCinsiyet(Cinsiyetler.erkek);
					} else if (temp.equals("kadin")) {
						degistirilecekUrun.setCinsiyet(Cinsiyetler.kadin);
					} else if (temp.equals("unisex")) {
						degistirilecekUrun.setCinsiyet(Cinsiyetler.unisex);
					}
					
					DbServicessBase<Marka> dao = new DbServicessBase<Marka>();
					Marka marka = new Marka();
					marka.setIsim(table.getModel().getValueAt(secilenSatir, 2).toString());
					List<Marka> markaListesi = dao.getAllRows(marka);
					degistirilecekUrun.setMarkaId(marka.getId());
					
					degistirilecekUrun.setModel(table.getModel().getValueAt(secilenSatir, 3).toString());
					degistirilecekUrun.setIsim(table.getModel().getValueAt(secilenSatir, 4).toString());
					
					temp = table.getModel().getValueAt(secilenSatir, 5).toString();
					if (temp.equals("�ok_renkli")) {
						degistirilecekUrun.setRenk(Renkler.�ok_renkli);
					}else if (temp.equals("abanoz")) {
						degistirilecekUrun.setRenk(Renkler.abanoz);
					}else if (temp.equals("abbak")) {
						degistirilecekUrun.setRenk(Renkler.abbak);
					}else if (temp.equals("abba�")) {
						degistirilecekUrun.setRenk(Renkler.abba�);
					}else if (temp.equals("ac�")) {
						degistirilecekUrun.setRenk(Renkler.ac�);
					}else if (temp.equals("ak")) {
						degistirilecekUrun.setRenk(Renkler.ak);
					}else if (temp.equals("al")) {
						degistirilecekUrun.setRenk(Renkler.al);
					}else if (temp.equals("ala")) {
						degistirilecekUrun.setRenk(Renkler.ala);
					}else if (temp.equals("alaca")) {
						degistirilecekUrun.setRenk(Renkler.alaca);
					}else if (temp.equals("apak")) {
						degistirilecekUrun.setRenk(Renkler.apak);
					}else if (temp.equals("	a��k_gri")) {
						degistirilecekUrun.setRenk(Renkler.	a��k_gri);
					}else if (temp.equals("a��k_kestane")) {
						degistirilecekUrun.setRenk(Renkler.a��k_kestane);
					}else if (temp.equals("a��_ta��")) {
						degistirilecekUrun.setRenk(Renkler.a��_ta��);
					}else if (temp.equals("baklak�r�")) {
						degistirilecekUrun.setRenk(Renkler.baklak�r�);
					}else if (temp.equals("balk�p���")) {
						degistirilecekUrun.setRenk(Renkler.balk�p���);
					}else if (temp.equals("bembeyaz")) {
						degistirilecekUrun.setRenk(Renkler.bembeyaz);
					}else if (temp.equals("beniz")) {
						degistirilecekUrun.setRenk(Renkler.beniz);
					}else if (temp.equals("camg�be�i")) {
						degistirilecekUrun.setRenk(Renkler.camg�be�i);
					}else if (temp.equals("ceviz")) {
						degistirilecekUrun.setRenk(Renkler.ceviz);
					}else if (temp.equals("�ivit")) {
						degistirilecekUrun.setRenk(Renkler.�ivit);
					}else if (temp.equals("dalgal�")) {
						degistirilecekUrun.setRenk(Renkler.dalgal�);
					}else if (temp.equals("deniz_mavisi")) {
						degistirilecekUrun.setRenk(Renkler.deniz_mavisi);
					}else if (temp.equals("dore")) {
						degistirilecekUrun.setRenk(Renkler.dore);
					}else if (temp.equals("duman_rengi")) {
						degistirilecekUrun.setRenk(Renkler.duman_rengi);
					}else if (temp.equals("ebruli")) {
						degistirilecekUrun.setRenk(Renkler.ebruli);
					}else if (temp.equals("eflatun")) {
						degistirilecekUrun.setRenk(Renkler.eflatun);
					}else if (temp.equals("eflatuni")) {
						degistirilecekUrun.setRenk(Renkler.eflatuni);
					}else if (temp.equals("erguvani")) {
						degistirilecekUrun.setRenk(Renkler.erguvani);
					}else if (temp.equals("esmer")) {
						degistirilecekUrun.setRenk(Renkler.esmer);
					}else if (temp.equals("firuze")) {
						degistirilecekUrun.setRenk(Renkler.firuze);
					}else if (temp.equals("f�st�k")) {
						degistirilecekUrun.setRenk(Renkler.f�st�k);
					}else if (temp.equals("f�me")) {
						degistirilecekUrun.setRenk(Renkler.f�me);
					}else if (temp.equals("gri")) {
						degistirilecekUrun.setRenk(Renkler.gri);
					}else if (temp.equals("g�k")) {
						degistirilecekUrun.setRenk(Renkler.g�k);
					}else if (temp.equals("g�k_k�r")) {
						degistirilecekUrun.setRenk(Renkler.g�k_k�r);
					}else if (temp.equals("g�k��l")) {
						degistirilecekUrun.setRenk(Renkler.g�k��l);
					}else if (temp.equals("g�lkurusu")) {
						degistirilecekUrun.setRenk(Renkler.g�lkurusu);
					}else if (temp.equals("g�m��")) {
						degistirilecekUrun.setRenk(Renkler.g�m��);
					}else if (temp.equals("g�vez")) {
						degistirilecekUrun.setRenk(Renkler.g�vez);
					}else if (temp.equals("haki")) {
						degistirilecekUrun.setRenk(Renkler.haki);
					}else if (temp.equals("hardal")) {
						degistirilecekUrun.setRenk(Renkler.hardal);
					}else if (temp.equals("kahverengi")) {
						degistirilecekUrun.setRenk(Renkler.kahverengi);
					}else if (temp.equals("kara")) {
						degistirilecekUrun.setRenk(Renkler.kara);
					}else if (temp.equals("karag�k")) {
						degistirilecekUrun.setRenk(Renkler.karag�k);
					}else if (temp.equals("kavuni�i")) {
						degistirilecekUrun.setRenk(Renkler.kavuni�i);
					}else if (temp.equals("kestane")) {
						degistirilecekUrun.setRenk(Renkler.kestane);
					}else if (temp.equals("k�na")) {
						degistirilecekUrun.setRenk(Renkler.k�na);
					}else if (temp.equals("k�r")) {
						degistirilecekUrun.setRenk(Renkler.k�r);
					}else if (temp.equals("kiremit_k�rm�z�s�")) {
						degistirilecekUrun.setRenk(Renkler.kiremit_k�rm�z�s�);
					}else if (temp.equals("k�rm�z�")) {
						degistirilecekUrun.setRenk(Renkler.k�rm�z�);
					}else if (temp.equals("k�z�l")) {
						degistirilecekUrun.setRenk(Renkler.k�z�l);
					}else if (temp.equals("konur")) {
						degistirilecekUrun.setRenk(Renkler.konur);
					}else if (temp.equals("koyu_gri")) {
						degistirilecekUrun.setRenk(Renkler.koyu_gri);
					}else if (temp.equals("koyu_mavi")) {
						degistirilecekUrun.setRenk(Renkler.koyu_mavi);
					}else if (temp.equals("kur�un_rengi")) {
						degistirilecekUrun.setRenk(Renkler.kur�un_rengi);
					}else if (temp.equals("kur�uni")) {
						degistirilecekUrun.setRenk(Renkler.kur�uni);
					}
					
					temp = table.getModel().getValueAt(secilenSatir, 6).toString();
					if (temp.equals("XS")) {
						degistirilecekUrun.setBeden(Bedenler.XS);
					}else if (temp.equals("S")) {
						degistirilecekUrun.setBeden(Bedenler.S);
					}else if (temp.equals("M")) {
						degistirilecekUrun.setBeden(Bedenler.M);
					}else if (temp.equals("L")) {
						degistirilecekUrun.setBeden(Bedenler.L);
					}else if (temp.equals("XL")) {
						degistirilecekUrun.setBeden(Bedenler.XL);
					}else if (temp.equals("XXL")) {
						degistirilecekUrun.setBeden(Bedenler.XXL);
					}else if (temp.equals("XXXL")) {
						degistirilecekUrun.setBeden(Bedenler.XXXL);
					}else if (temp.equals("XXXXL")) {
						degistirilecekUrun.setBeden(Bedenler.XXXXL);
					}else if (temp.equals("XXXXXL")) {
						degistirilecekUrun.setBeden(Bedenler.XXXXXL);
					}
					degistirilecekUrun.setFiyat(Double.parseDouble(table.getModel().getValueAt(secilenSatir, 7).toString()));
					
					UrunDegistirme frame = new UrunDegistirme(e, degistirilecekUrun);
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
	private JComboBox getCmbCinsiyet() {
		if (cmbCinsiyet == null) {
			cmbCinsiyet = new JComboBox();
			cmbCinsiyet.setBounds(80, 12, 228, 20);
		}
		return cmbCinsiyet;
	}
	private JTextField getTxtFiyat() {
		if (txtFiyat == null) {
			txtFiyat = new JTextField();
			txtFiyat.setBounds(80, 44, 228, 20);
			txtFiyat.setColumns(10);
		}
		return txtFiyat;
	}
	private JTextField getTxtIsim() {
		if (txtIsim == null) {
			txtIsim = new JTextField();
			txtIsim.setBounds(80, 76, 228, 20);
			txtIsim.setColumns(10);
		}
		return txtIsim;
	}
	private JComboBox getCmbMarka() {
		if (cmbMarka == null) {
			cmbMarka = new JComboBox();
			cmbMarka.setBounds(80, 108, 228, 20);
		}
		return cmbMarka;
	}
	private JTextField getTxtModel() {
		if (txtModel == null) {
			txtModel = new JTextField();
			txtModel.setText("");
			txtModel.setBounds(80, 140, 228, 20);
			txtModel.setColumns(10);
		}
		return txtModel;
	}
	private JComboBox getCmbRenk() {
		if (cmbRenk == null) {
			cmbRenk = new JComboBox();
			cmbRenk.setBounds(80, 172, 228, 20);
		}
		return cmbRenk;
	}
	private JLabel getLblCinsiyet() {
		if (lblCinsiyet == null) {
			lblCinsiyet = new JLabel("Cinsiyet :");
			lblCinsiyet.setHorizontalAlignment(SwingConstants.RIGHT);
			lblCinsiyet.setLabelFor(getCmbCinsiyet());
			lblCinsiyet.setBounds(10, 12, 60, 20);
		}
		return lblCinsiyet;
	}
	private JLabel getLblFiyat() {
		if (lblFiyat == null) {
			lblFiyat = new JLabel("Fiyat :");
			lblFiyat.setHorizontalAlignment(SwingConstants.RIGHT);
			lblFiyat.setLabelFor(getTxtFiyat());
			lblFiyat.setBounds(10, 44, 60, 20);
		}
		return lblFiyat;
	}
	private JLabel getLblIsim() {
		if (lblIsim == null) {
			lblIsim = new JLabel("\u0130sim :");
			lblIsim.setHorizontalAlignment(SwingConstants.RIGHT);
			lblIsim.setLabelFor(getTxtIsim());
			lblIsim.setBounds(10, 76, 60, 20);
		}
		return lblIsim;
	}
	private JLabel getLblMarka() {
		if (lblMarka == null) {
			lblMarka = new JLabel("Marka :");
			lblMarka.setHorizontalAlignment(SwingConstants.RIGHT);
			lblMarka.setLabelFor(getCmbMarka());
			lblMarka.setBounds(10, 108, 60, 20);
		}
		return lblMarka;
	}
	private JLabel getLblModel() {
		if (lblModel == null) {
			lblModel = new JLabel("Model :");
			lblModel.setHorizontalAlignment(SwingConstants.RIGHT);
			lblModel.setLabelFor(getTxtModel());
			lblModel.setBounds(10, 140, 60, 20);
		}
		return lblModel;
	}
	private JLabel getLblRenk() {
		if (lblRenk == null) {
			lblRenk = new JLabel("Renk :");
			lblRenk.setHorizontalAlignment(SwingConstants.RIGHT);
			lblRenk.setLabelFor(getCmbRenk());
			lblRenk.setBounds(10, 172, 60, 20);
		}
		return lblRenk;
	}
	private JButton getBtnKaydet() {
		if (btnKaydet == null) {
			btnKaydet = new JButton("Kaydet");
			btnKaydet.addActionListener(new ActionListener() { 
				public void actionPerformed(ActionEvent e) {
					DbServicessBase<Urun> dao = new DbServicessBase<Urun>();
					Urun eklenecekUrun = new Urun();
					eklenecekUrun.setCinsiyet((Cinsiyetler) cmbCinsiyet.getSelectedItem());
					eklenecekUrun.setFiyat(Double.parseDouble(txtFiyat.getText()));
					eklenecekUrun.setRenk((Renkler) cmbRenk.getSelectedItem());
					eklenecekUrun.setIsim(txtIsim.getText());
					eklenecekUrun.setMarkaId(((Marka)cmbMarka.getSelectedItem()).getId());
					eklenecekUrun.setModel(txtModel.getText());		
					eklenecekUrun.setBeden((Bedenler)cmbBeden.getSelectedItem());

					if (dao.save(eklenecekUrun)) {
						tabloyuDoldur();
						txtFiyat.setText("");
						txtIsim.setText("");
						txtModel.setText("");
						cmbMarka.setSelectedIndex(-1);
						cmbBeden.setSelectedIndex(-1);
						cmbCinsiyet.setSelectedIndex(-1);
						cmbRenk.setSelectedIndex(-1);
					} else {
						showMessageDialog(null, "Kaydetme ��lemi Ba�ar�s�z Oldu!");
					}
				}
			});
			btnKaydet.setBounds(219, 245, 89, 20);
		}
		return btnKaydet;
	}
	private JLabel getLblBeden() {
		if (lblBeden == null) {
			lblBeden = new JLabel("Beden :");
			lblBeden.setHorizontalAlignment(SwingConstants.RIGHT);
			lblBeden.setLabelFor(getCmbBeden());
			lblBeden.setBounds(24, 203, 46, 20);
		}
		return lblBeden;
	}
	private JComboBox getCmbBeden() {
		if (cmbBeden == null) {
			cmbBeden = new JComboBox();
			cmbBeden.setBounds(80, 203, 228, 20);
		}
		return cmbBeden;
	}
}
