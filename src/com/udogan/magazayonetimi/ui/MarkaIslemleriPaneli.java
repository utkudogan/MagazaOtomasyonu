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
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import com.udogan.magazayonetimi.models.Marka;
import com.udogan.magazayonetimi.utils.dao.DbServicessBase;

import static javax.swing.JOptionPane.showMessageDialog;

public class MarkaIslemleriPaneli extends JPanel {
	private JPanel pnlDetay;
	private JPanel pnlTablo;
	private JTable table;
	private JScrollPane scrollPane;
	private JButton btnKaydet;
	public MainFrame parentFrame;
	private JTextField txtIsim;
	private JLabel lblMarkaIsmi;

	public MarkaIslemleriPaneli(MainFrame parentFrame) {
		this.parentFrame = parentFrame;
		setSize(1000, 500);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(getPnlDetay(), GroupLayout.PREFERRED_SIZE, 452, GroupLayout.PREFERRED_SIZE)
						.addComponent(getPnlTablo(), GroupLayout.PREFERRED_SIZE, 450, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(548, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(getPnlDetay(), GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(getPnlTablo(), GroupLayout.PREFERRED_SIZE, 315, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		setLayout(groupLayout);
		tabloyuDoldur();
	}

	public void tabloyuDoldur() {

		try {
			DbServicessBase<Marka> dao = new DbServicessBase<Marka>();
			Marka temp = new Marka();
			List<Marka> markaListesi = dao.getAllRows(temp);

			String[] columnNames = { "id", "Marka Ýsmi" };
			Object[][] data = new Object[markaListesi.size()][columnNames.length];

			for (int i = 0; i < markaListesi.size(); i++) {

				data[i][0] = ((Marka) markaListesi.get(i)).getId();
				data[i][1] = ((Marka) markaListesi.get(i)).getIsim();
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
			pnlDetay.add(getBtnKaydet());
			pnlDetay.add(getTxtIsim());
			pnlDetay.add(getLblMarkaIsmi());
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
					Marka degistirilecekMarka = new Marka();
					degistirilecekMarka
							.setId(Long.parseLong(table.getModel().getValueAt(secilenSatir, 0).toString()));
					degistirilecekMarka.setIsim(table.getModel().getValueAt(secilenSatir, 1).toString());
					MarkaDegistirme frame = new MarkaDegistirme(e, degistirilecekMarka);
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
					DbServicessBase<Marka> dao = new DbServicessBase<Marka>();
					Marka eklenecekMarka = new Marka();
					eklenecekMarka.setIsim(txtIsim.getText());

					if (dao.save(eklenecekMarka)) {
						tabloyuDoldur();
						txtIsim.setText("");
					} else {
						showMessageDialog(null, "Kaydetme Ýþlemi Baþarýsýz Oldu!");
					}

				}
			});
			btnKaydet.setBounds(260, 66, 89, 20);
		}
		return btnKaydet;
	}
	private JTextField getTxtIsim() {
		if (txtIsim == null) {
			txtIsim = new JTextField();
			txtIsim.setBounds(113, 24, 236, 20);
			txtIsim.setColumns(10);
		}
		return txtIsim;
	}
	private JLabel getLblMarkaIsmi() {
		if (lblMarkaIsmi == null) {
			lblMarkaIsmi = new JLabel("Marka \u0130smi :");
			lblMarkaIsmi.setHorizontalAlignment(SwingConstants.RIGHT);
			lblMarkaIsmi.setLabelFor(getTxtIsim());
			lblMarkaIsmi.setBounds(10, 24, 93, 20);
		}
		return lblMarkaIsmi;
	}
}
