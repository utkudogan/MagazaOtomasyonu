package com.udogan.magazayonetimi.ui;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.text.MaskFormatter;

import com.udogan.magazayonetimi.models.Musteri;
import com.udogan.magazayonetimi.utils.dao.DbServicessBase;

import javax.swing.SwingConstants;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.util.List;

import static javax.swing.JOptionPane.showMessageDialog;

import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JScrollPane;
import javax.swing.JEditorPane;

public class MusteriIslemleriPaneli extends JPanel {
	private JPanel pnlDetay;
	private JPanel panelTablo;
	private JTable table;
	private JButton btnKaydet;
	private JScrollPane scrollPane;
	public MainFrame parentFrame;
	private JTextField txtIsim;
	private JTextField txtTelefon;
	private JEditorPane txtAdres;
	private JLabel lblIsim;
	private JLabel lblTelefon;
	private JLabel lblAdres;
	public MusteriIslemleriPaneli(MainFrame parentFrame) {
		this.parentFrame = parentFrame;
		setSize(1000, 500);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(getPanelTablo(), GroupLayout.PREFERRED_SIZE, 748, GroupLayout.PREFERRED_SIZE)
						.addComponent(getPnlDetay(), GroupLayout.PREFERRED_SIZE, 745, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(getPnlDetay(), GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(getPanelTablo(), GroupLayout.PREFERRED_SIZE, 213, GroupLayout.PREFERRED_SIZE)
					.addGap(0, 0, Short.MAX_VALUE))
		);
		groupLayout.linkSize(SwingConstants.HORIZONTAL, new Component[] {getPnlDetay(), getPanelTablo()});
		setLayout(groupLayout);
		tabloyuDoldur();
	}
	public void tabloyuDoldur() {

		try {
			DbServicessBase<Musteri> dao = new DbServicessBase<Musteri>();
			Musteri temp = new Musteri();
			List<Musteri> musteriListesi = dao.getAllRows(temp);

			String[] columnNames = { "id", "Ýsim", "Telefon", "Adres" };
			Object[][] data = new Object[musteriListesi.size()][columnNames.length];

			for (int i = 0; i < musteriListesi.size(); i++) {

				data[i][0] = ((Musteri) musteriListesi.get(i)).getId();
				data[i][1] = ((Musteri) musteriListesi.get(i)).getIsim();
				data[i][2] = ((Musteri) musteriListesi.get(i)).getTelefon();
				data[i][3] = ((Musteri) musteriListesi.get(i)).getAdres();
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
	private JPanel getPnlDetay() {
		if (pnlDetay == null) {
			pnlDetay = new JPanel();
			pnlDetay.setAlignmentY(Component.TOP_ALIGNMENT);
			pnlDetay.setAlignmentX(Component.LEFT_ALIGNMENT);
			pnlDetay.setLayout(null);
			pnlDetay.add(getBtnKaydet());
			pnlDetay.add(getTxtIsim());
			pnlDetay.add(getTxtTelefon());
			pnlDetay.add(getTxtAdres());
			pnlDetay.add(getLblIsim());
			pnlDetay.add(getLblTelefon());
			pnlDetay.add(getLblAdres());
		}
		return pnlDetay;
	}
	private JPanel getPanelTablo() {
		if (panelTablo == null) {
			panelTablo = new JPanel();
			panelTablo.setAlignmentY(Component.TOP_ALIGNMENT);
			panelTablo.setAlignmentX(Component.LEFT_ALIGNMENT);
			panelTablo.setLayout(new BorderLayout(0, 0));
			panelTablo.add(getScrollPane());
		}
		return panelTablo;
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
					Musteri degistirilecekMusteri = new Musteri();
					degistirilecekMusteri.setId(Long.parseLong(table.getModel().getValueAt(secilenSatir, 0).toString()));
					degistirilecekMusteri.setIsim(table.getModel().getValueAt(secilenSatir, 1).toString());
					degistirilecekMusteri.setTelefon(table.getModel().getValueAt(secilenSatir, 2).toString());
					degistirilecekMusteri.setAdres(table.getModel().getValueAt(secilenSatir, 3).toString());
					MusteriDegistirme frame = new MusteriDegistirme(e, degistirilecekMusteri);
					parentFrame.setEnabled(false);
					frame.setVisible(true);
				}
			});
		}
		return table;
	}
	private JButton getBtnKaydet() {
		if (btnKaydet == null) {
			btnKaydet = new JButton("Kaydet");
			btnKaydet.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					DbServicessBase<Musteri> dao = new DbServicessBase<Musteri>();
					Musteri eklenecekMusteri = new Musteri();
					eklenecekMusteri.setIsim(txtIsim.getText());
					eklenecekMusteri.setTelefon(txtTelefon.getText());
					eklenecekMusteri.setAdres(txtAdres.getText());
					
					if (dao.save(eklenecekMusteri)) {
						tabloyuDoldur();
						txtIsim.setText("");
						txtTelefon.setText("");
						txtAdres.setText("");
					} else {
						showMessageDialog(null, "Kaydetme Ýþlemi Baþarýsýz Oldu!");
					}
					
				}
			});
			btnKaydet.setBounds(236, 164, 89, 23);
		}
		return btnKaydet;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setAlignmentY(Component.TOP_ALIGNMENT);
			scrollPane.setAlignmentX(Component.LEFT_ALIGNMENT);
			scrollPane.setViewportView(getTable());
		}
		return scrollPane;
	}
	private JTextField getTxtIsim() {
		if (txtIsim == null) {
			txtIsim = new JTextField();
			txtIsim.setBounds(115, 12, 210, 20);
			txtIsim.setColumns(10);
		}
		return txtIsim;
	}
	private JTextField getTxtTelefon() {
		if (txtTelefon == null) {
			 MaskFormatter fmt;
				try {
					fmt = new MaskFormatter("0###-###-####");
					txtTelefon = new JFormattedTextField(fmt);
					txtTelefon.setBounds(115, 44, 91, 20);
					txtTelefon.setColumns(10);
				} catch (ParseException e) {
					txtTelefon = new JTextField();
					txtTelefon.setBounds(108, 91, 135, 20);
					txtTelefon.setColumns(10);
				}
		}
		return txtTelefon;
	}
	private JEditorPane getTxtAdres() {
		if (txtAdres == null) {
			txtAdres = new JEditorPane();
			txtAdres.setBounds(115, 76, 211, 76);
		}
		return txtAdres;
	}
	private JLabel getLblIsim() {
		if (lblIsim == null) {
			lblIsim = new JLabel("\u0130sim :");
			lblIsim.setHorizontalAlignment(SwingConstants.RIGHT);
			lblIsim.setLabelFor(getTxtIsim());
			lblIsim.setBounds(59, 12, 46, 20);
		}
		return lblIsim;
	}
	private JLabel getLblTelefon() {
		if (lblTelefon == null) {
			lblTelefon = new JLabel("Telefon :");
			lblTelefon.setHorizontalAlignment(SwingConstants.RIGHT);
			lblTelefon.setLabelFor(getTxtTelefon());
			lblTelefon.setBounds(59, 44, 46, 20);
		}
		return lblTelefon;
	}
	private JLabel getLblAdres() {
		if (lblAdres == null) {
			lblAdres = new JLabel("Adres :");
			lblAdres.setHorizontalAlignment(SwingConstants.RIGHT);
			lblAdres.setLabelFor(getTxtAdres());
			lblAdres.setBounds(59, 76, 46, 20);
		}
		return lblAdres;
	}
}
