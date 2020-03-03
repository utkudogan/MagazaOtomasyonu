package com.udogan.magazayonetimi.ui;

import javax.swing.JPanel;
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
import javax.swing.text.MaskFormatter;
import javax.swing.JFormattedTextField;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.util.List;

import com.udogan.magazayonetimi.models.Kategori;
import com.udogan.magazayonetimi.utils.dao.DbServicessBase;

import static javax.swing.JOptionPane.showMessageDialog;

public class KategoriIslemleriPaneli extends JPanel {
	private JPanel pnlDetay;
	private JPanel pnlTablo;
	private JTable table;
	private JScrollPane scrollPane;
	private JTextField txtAnaKategori;
	private JTextField txtKategori;
	private JTextField txtAltKategori;
	private JLabel lblAnaKategori;
	private JLabel lblKategori;
	private JLabel lblAltKategori;
	private JButton btnKaydet;
	public MainFrame parentFrame;

	public KategoriIslemleriPaneli(MainFrame parentFrame) {
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
	}

	public void tabloyuDoldur() {

		try {
			DbServicessBase<Kategori> dao = new DbServicessBase<Kategori>();
			Kategori temp = new Kategori();
			List<Kategori> kategoriListesi = dao.getAllRows(temp);

			String[] columnNames = { "id", "Ana Kategori", "Kategori", "Alt Kategori" };
			Object[][] data = new Object[kategoriListesi.size()][columnNames.length];

			for (int i = 0; i < kategoriListesi.size(); i++) {

				data[i][0] = ((Kategori) kategoriListesi.get(i)).getId();
				data[i][1] = ((Kategori) kategoriListesi.get(i)).getAnaKategori();
				data[i][2] = ((Kategori) kategoriListesi.get(i)).getKategori();
				data[i][3] = ((Kategori) kategoriListesi.get(i)).getAltKategori();
			}

			table.setModel(new DefaultTableModel(data, columnNames));
			table.setPreferredScrollableViewportSize(new Dimension(500, 70));
			table.setFillsViewportHeight(true);
			TableColumnModel tcm = table.getColumnModel();
			tcm.removeColumn(tcm.getColumn(0));
			parentFrame.setSize(this.getWidth(), this.getHeight());
		} catch (Exception e) {
			showMessageDialog(null, e.getMessage());
		}

	}

	private JPanel getPnlDetay() {
		if (pnlDetay == null) {
			pnlDetay = new JPanel();
			pnlDetay.setLayout(null);
			pnlDetay.add(getTxtAnaKategori());
			pnlDetay.add(getTxtKategori());
			pnlDetay.add(getTxtAltKategori());
			pnlDetay.add(getLblAnaKategori());
			pnlDetay.add(getLblKategori());
			pnlDetay.add(getLblAltKategori());
			pnlDetay.add(getBtnKaydet());
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
					Kategori degistirilecekKategori = new Kategori();
					degistirilecekKategori
							.setId(Long.parseLong(table.getModel().getValueAt(secilenSatir, 0).toString()));
					degistirilecekKategori.setAnaKategori(table.getModel().getValueAt(secilenSatir, 1).toString());
					degistirilecekKategori.setKategori(table.getModel().getValueAt(secilenSatir, 2).toString());
					degistirilecekKategori.setAltKategori(table.getModel().getValueAt(secilenSatir, 3).toString());
					KategoriDegistirme frame = new KategoriDegistirme(e, degistirilecekKategori);
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

	private JTextField getTxtAnaKategori() {
		if (txtAnaKategori == null) {
			txtAnaKategori = new JTextField();
			txtAnaKategori.setBounds(89, 17, 161, 20);
			txtAnaKategori.setColumns(10);
		}
		return txtAnaKategori;
	}

	private JTextField getTxtKategori() {
		if (txtKategori == null) {
			txtKategori = new JTextField();
			txtKategori.setBounds(89, 54, 161, 20);
			txtKategori.setColumns(10);
		}
		return txtKategori;
	}

	private JTextField getTxtAltKategori() {
		if (txtAltKategori == null) {
			txtAltKategori = new JTextField();
			txtAltKategori.setBounds(89, 91, 161, 20);
			txtAltKategori.setColumns(10);
		}
		return txtAltKategori;
	}

	private JLabel getLblAnaKategori() {
		if (lblAnaKategori == null) {
			lblAnaKategori = new JLabel("Ana Kategori :");
			lblAnaKategori.setHorizontalAlignment(SwingConstants.RIGHT);
			lblAnaKategori.setLabelFor(getTxtAnaKategori());
			lblAnaKategori.setBounds(10, 17, 77, 20);
		}
		return lblAnaKategori;
	}

	private JLabel getLblKategori() {
		if (lblKategori == null) {
			lblKategori = new JLabel("Kategori :");
			lblKategori.setHorizontalAlignment(SwingConstants.RIGHT);
			lblKategori.setLabelFor(getTxtKategori());
			lblKategori.setBounds(10, 54, 77, 20);
		}
		return lblKategori;
	}

	private JLabel getLblAltKategori() {
		if (lblAltKategori == null) {
			lblAltKategori = new JLabel("Alt Kategori :");
			lblAltKategori.setHorizontalAlignment(SwingConstants.RIGHT);
			lblAltKategori.setLabelFor(lblAltKategori);
			lblAltKategori.setBounds(10, 91, 77, 20);
		}
		return lblAltKategori;
	}

	private JButton getBtnKaydet() {
		if (btnKaydet == null) {
			btnKaydet = new JButton("Kaydet");
			btnKaydet.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					DbServicessBase<Kategori> dao = new DbServicessBase<Kategori>();
					Kategori eklenecekDistributor = new Kategori();
					eklenecekDistributor.setAnaKategori(txtAnaKategori.getText());
					eklenecekDistributor.setKategori(txtKategori.getText());
					eklenecekDistributor.setAltKategori(txtAltKategori.getText());

					if (dao.save(eklenecekDistributor)) {
						tabloyuDoldur();
						txtAnaKategori.setText("");
						txtKategori.setText("");
						txtAltKategori.setText("");
					} else {
						showMessageDialog(null, "Kaydetme Ýþlemi Baþarýsýz Oldu!");
					}

				}
			});
			btnKaydet.setBounds(260, 91, 89, 20);
		}
		return btnKaydet;
	}
}
