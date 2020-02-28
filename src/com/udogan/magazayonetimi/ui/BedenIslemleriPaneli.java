package com.udogan.magazayonetimi.ui;

import java.awt.Dimension;
import java.awt.LayoutManager;
import java.util.List;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.text.TabExpander;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.udogan.magazayonetimi.models.Beden;
import com.udogan.magazayonetimi.models.enums.Bedenler;
import com.udogan.magazayonetimi.models.enums.Cinsiyet;
import com.udogan.magazayonetimi.utils.dao.DbServicessBase;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BedenIslemleriPaneli extends JPanel {
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblCinsiyet;
	private JLabel lblBeden;
	private JLabel lblBasen;
	private JLabel lblBel;
	private JLabel lblGogus;
	private JTextField txtBasen;
	private JTextField txtBel;
	private JTextField txtGogus;
	private JComboBox cmbCinsiyet;
	private JComboBox cmbBeden;
	private JButton btnKaydet;
	private JButton btnSil;
	private JTable tableBedenler;
	private JScrollPane scrollPane;

	public BedenIslemleriPaneli() {
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(getPanel(), GroupLayout.DEFAULT_SIZE, 565, Short.MAX_VALUE)
				.addComponent(getPanel_1(), GroupLayout.DEFAULT_SIZE, 565, Short.MAX_VALUE));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addGroup(Alignment.LEADING,
				groupLayout.createSequentialGroup()
						.addComponent(getPanel(), GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(getPanel_1(), GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)));
		setLayout(groupLayout);
		tabloyuDoldur();
		combolariDoldur();
	}

	public BedenIslemleriPaneli(LayoutManager layout) {
		super(layout);
		// TODO Auto-generated constructor stub
	}

	public BedenIslemleriPaneli(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

	public BedenIslemleriPaneli(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

	private void tabloyuDoldur() {

		try {
			DbServicessBase<Beden> dao = new DbServicessBase<Beden>();
			Beden temp = new Beden();
			List<Beden> bedenListesi = dao.getAllRows(temp);

			String[] columnNames = { "id", "Cinsiyet", "Beden", "Basen", "Bel", "Göðüs" };
			Object[][] data = new Object[bedenListesi.size()][columnNames.length];

			for (int i = 0; i < bedenListesi.size(); i++) {

				data[i][0] = ((Beden) bedenListesi.get(i)).getId();
				data[i][1] = ((Beden) bedenListesi.get(i)).getCinsiyet();
				data[i][2] = ((Beden) bedenListesi.get(i)).getBeden();
				data[i][3] = ((Beden) bedenListesi.get(i)).getBasen();
				data[i][4] = ((Beden) bedenListesi.get(i)).getBel();
				data[i][5] = ((Beden) bedenListesi.get(i)).getGogus();
			}

			tableBedenler.setModel(new DefaultTableModel(data, columnNames));
			tableBedenler.setPreferredScrollableViewportSize(new Dimension(500, 70));
			tableBedenler.setFillsViewportHeight(true);
			TableColumnModel tcm = tableBedenler.getColumnModel();
			tcm.removeColumn(tcm.getColumn(0));
		} catch (Exception e) {
			showMessageDialog(null, e.getMessage());
		}

	}

	private void combolariDoldur() {
		cmbBeden.setModel(new DefaultComboBoxModel(Bedenler.values()));
		cmbBeden.setSelectedIndex(-1);
		cmbCinsiyet.setModel(new DefaultComboBoxModel(Cinsiyet.values()));
		cmbCinsiyet.setSelectedIndex(-1);
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(null);
			panel.add(getLblCinsiyet());
			panel.add(getLblBeden());
			panel.add(getLblBasen());
			panel.add(getLblBel());
			panel.add(getLblGogus());
			panel.add(getTxtBasen());
			panel.add(getTxtBel());
			panel.add(getTxtGogus());
			panel.add(getCmbCinsiyet());
			panel.add(getCmbBeden());
			panel.add(getBtnKaydet());
			panel.add(getBtnSil());
		}
		return panel;
	}

	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setLayout(null);
			panel_1.add(getScrollPane());
		}
		return panel_1;
	}

	private JLabel getLblCinsiyet() {
		if (lblCinsiyet == null) {
			lblCinsiyet = new JLabel("Cinsiyet :");
			lblCinsiyet.setHorizontalAlignment(SwingConstants.RIGHT);
			lblCinsiyet.setLabelFor(lblCinsiyet);
			lblCinsiyet.setBounds(26, 17, 64, 20);
		}
		return lblCinsiyet;
	}

	private JLabel getLblBeden() {
		if (lblBeden == null) {
			lblBeden = new JLabel("Beden :");
			lblBeden.setHorizontalAlignment(SwingConstants.RIGHT);
			lblBeden.setLabelFor(lblBeden);
			lblBeden.setBounds(26, 54, 64, 20);
		}
		return lblBeden;
	}

	private JLabel getLblBasen() {
		if (lblBasen == null) {
			lblBasen = new JLabel("Basen :");
			lblBasen.setHorizontalAlignment(SwingConstants.RIGHT);
			lblBasen.setLabelFor(lblBasen);
			lblBasen.setBounds(26, 91, 64, 20);
		}
		return lblBasen;
	}

	private JLabel getLblBel() {
		if (lblBel == null) {
			lblBel = new JLabel("Bel :");
			lblBel.setHorizontalAlignment(SwingConstants.RIGHT);
			lblBel.setLabelFor(lblBel);
			lblBel.setBounds(26, 128, 64, 20);
		}
		return lblBel;
	}

	private JLabel getLblGogus() {
		if (lblGogus == null) {
			lblGogus = new JLabel("G\u00F6\u011F\u00FCs :");
			lblGogus.setHorizontalAlignment(SwingConstants.RIGHT);
			lblGogus.setLabelFor(lblGogus);
			lblGogus.setBounds(26, 165, 64, 20);
		}
		return lblGogus;
	}

	private JTextField getTxtBasen() {
		if (txtBasen == null) {
			txtBasen = new JTextField();
			txtBasen.setBounds(108, 91, 135, 20);
			txtBasen.setColumns(10);
		}
		return txtBasen;
	}

	private JTextField getTxtBel() {
		if (txtBel == null) {
			txtBel = new JTextField();
			txtBel.setBounds(108, 128, 135, 20);
			txtBel.setColumns(10);
		}
		return txtBel;
	}

	private JTextField getTxtGogus() {
		if (txtGogus == null) {
			txtGogus = new JTextField();
			txtGogus.setBounds(108, 165, 135, 20);
			txtGogus.setColumns(10);
		}
		return txtGogus;
	}

	private JComboBox getCmbCinsiyet() {
		if (cmbCinsiyet == null) {
			cmbCinsiyet = new JComboBox();
			cmbCinsiyet.setBounds(108, 17, 135, 20);
		}
		return cmbCinsiyet;
	}

	private JComboBox getCmbBeden() {
		if (cmbBeden == null) {
			cmbBeden = new JComboBox();
			cmbBeden.setBounds(108, 54, 135, 20);
		}
		return cmbBeden;
	}

	private JButton getBtnKaydet() {
		if (btnKaydet == null) {
			btnKaydet = new JButton("KAYDET");
			btnKaydet.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					DbServicessBase<Beden> dao = new DbServicessBase<Beden>();
					Beden eklenecekBeden = new Beden();
					eklenecekBeden.setCinsiyet((Cinsiyet) cmbCinsiyet.getSelectedItem());
					eklenecekBeden.setBeden((Bedenler) cmbBeden.getSelectedItem());
					eklenecekBeden.setBasen(Integer.parseInt(txtBasen.getText()));
					eklenecekBeden.setBel(Integer.parseInt(txtBel.getText()));
					eklenecekBeden.setGogus(Integer.parseInt(txtGogus.getText()));

					if (dao.save(eklenecekBeden)) {
						tabloyuDoldur();
						txtBasen.setText("");
						txtBel.setText("");
						txtGogus.setText("");
						cmbCinsiyet.setSelectedIndex(-1);
						cmbBeden.setSelectedIndex(-1);
					} else {
						showMessageDialog(null, "Kaydetme Ýþlemi Baþarýsýz Oldu!");
					}
				}
			});
			btnKaydet.setBounds(508, 17, 89, 20);
		}
		return btnKaydet;
	}

	private JButton getBtnSil() {
		if (btnSil == null) {
			btnSil = new JButton("S\u0130L");
			btnSil.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					DbServicessBase<Beden> dao = new DbServicessBase<Beden>();
					Beden silinecekBeden = new Beden();
					int secilenSatir = tableBedenler.getSelectedRow();
					String o = tableBedenler.getModel().getValueAt(secilenSatir, 0).toString();
					silinecekBeden.setId(Long.valueOf(o));
					if (dao.delete(silinecekBeden)) {
						tabloyuDoldur();
					} else {
						showMessageDialog(null, "Silme Ýþlemi Baþarýsýz Oldu!");
					}
				}
			});
			btnSil.setBounds(508, 54, 89, 20);
		}
		return btnSil;
	}

	private JTable getTableBedenler() {
		if (tableBedenler == null) {
			tableBedenler = new JTable();
			tableBedenler.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int secilenSatir = tableBedenler.getSelectedRow();
					Beden degistirilecekBeden = new Beden();
					degistirilecekBeden
							.setId(Long.parseLong(tableBedenler.getModel().getValueAt(secilenSatir, 0).toString()));
					String temp = tableBedenler.getModel().getValueAt(secilenSatir, 1).toString();
					if (temp.equals("erkek")) {
						degistirilecekBeden.setCinsiyet(Cinsiyet.erkek);
					} else if (temp.equals("kadin")) {
						degistirilecekBeden.setCinsiyet(Cinsiyet.kadin);
					} else if (temp.equals("unisex")) {
						degistirilecekBeden.setCinsiyet(Cinsiyet.unisex);
					}
					temp = tableBedenler.getModel().getValueAt(secilenSatir, 2).toString();
					if (temp.equals("XS")) {
						degistirilecekBeden.setBeden(Bedenler.XS);
					} else if (temp.equals("S")) {
						degistirilecekBeden.setBeden(Bedenler.S);
					} else if (temp.equals("M")) {
						degistirilecekBeden.setBeden(Bedenler.M);
					} else if (temp.equals("L")) {
						degistirilecekBeden.setBeden(Bedenler.L);
					} else if (temp.equals("XL")) {
						degistirilecekBeden.setBeden(Bedenler.XL);
					} else if (temp.equals("XXL")) {
						degistirilecekBeden.setBeden(Bedenler.XXL);
					} else if (temp.equals("XXXL")) {
						degistirilecekBeden.setBeden(Bedenler.XXXL);
					} else if (temp.equals("XXXXL")) {
						degistirilecekBeden.setBeden(Bedenler.XXXXL);
					} else if (temp.equals("XXXXXL")) {
						degistirilecekBeden.setBeden(Bedenler.XXXXXL);
					}
					degistirilecekBeden.setBasen(
							Integer.parseInt(tableBedenler.getModel().getValueAt(secilenSatir, 3).toString()));
					degistirilecekBeden
							.setBel(Integer.parseInt(tableBedenler.getModel().getValueAt(secilenSatir, 4).toString()));
					degistirilecekBeden.setGogus(
							Integer.parseInt(tableBedenler.getModel().getValueAt(secilenSatir, 5).toString()));
					BedenDegistirme frame = new BedenDegistirme(degistirilecekBeden);
					frame.setVisible(true);
				}
			});
		}
		return tableBedenler;

	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 11, 603, 217);
			scrollPane.setViewportView(getTableBedenler());
		}
		return scrollPane;
	}
}
