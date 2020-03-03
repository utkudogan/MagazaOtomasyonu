package com.udogan.magazayonetimi.ui;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.text.MaskFormatter;

import com.udogan.magazayonetimi.models.Distributor;
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

public class DistributorIslemleriPaneli extends JPanel {
	private JPanel pnlDetay;
	private JPanel panelTablo;
	private JTable table;
	private JLabel lblUnvan;
	private JTextField txtIsim;
	private JTextField txtYetkili;
	private JTextField txtTelefon;
	private JTextPane txtAdres;
	private JLabel lblYetkili;
	private JLabel lblTelefon;
	private JLabel lblAdres;
	private JButton btnKaydet;
	private JScrollPane scrollPane;
	public MainFrame parentFrame;
	public DistributorIslemleriPaneli(MainFrame parentFrame) {
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
			DbServicessBase<Distributor> dao = new DbServicessBase<Distributor>();
			Distributor temp = new Distributor();
			List<Distributor> distributorListesi = dao.getAllRows(temp);

			String[] columnNames = { "id", "Unvan", "Yetkili Kiþi", "Telefon", "Adres" };
			Object[][] data = new Object[distributorListesi.size()][columnNames.length];

			for (int i = 0; i < distributorListesi.size(); i++) {

				data[i][0] = ((Distributor) distributorListesi.get(i)).getId();
				data[i][1] = ((Distributor) distributorListesi.get(i)).getIsim();
				data[i][2] = ((Distributor) distributorListesi.get(i)).getYetkili();
				data[i][3] = ((Distributor) distributorListesi.get(i)).getTelefon();
				data[i][4] = ((Distributor) distributorListesi.get(i)).getAdres();
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
			pnlDetay.add(getLblUnvan());
			pnlDetay.add(getTxtIsim());
			pnlDetay.add(getTxtYetkili());
			pnlDetay.add(getTxtTelefon());
			pnlDetay.add(getTxtAdres());
			pnlDetay.add(getLblYetkili());
			pnlDetay.add(getLblTelefon());
			pnlDetay.add(getLblAdres());
			pnlDetay.add(getBtnKaydet());
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
					Distributor degistirilecekDistributor = new Distributor();
					degistirilecekDistributor.setId(Long.parseLong(table.getModel().getValueAt(secilenSatir, 0).toString()));
					degistirilecekDistributor.setIsim(table.getModel().getValueAt(secilenSatir, 1).toString());
					degistirilecekDistributor.setYetkili(table.getModel().getValueAt(secilenSatir, 2).toString());
					degistirilecekDistributor.setTelefon(table.getModel().getValueAt(secilenSatir, 3).toString());
					degistirilecekDistributor.setAdres(table.getModel().getValueAt(secilenSatir, 4).toString());
					DistributorDegistirme frame = new DistributorDegistirme(e, degistirilecekDistributor);
					parentFrame.setEnabled(false);
					frame.setVisible(true);
				}
			});
		}
		return table;
	}
	private JLabel getLblUnvan() {
		if (lblUnvan == null) {
			lblUnvan = new JLabel("Unvan :");
			lblUnvan.setHorizontalAlignment(SwingConstants.RIGHT);
			lblUnvan.setBounds(24, 13, 87, 20);
		}
		return lblUnvan;
	}
	private JTextField getTxtIsim() {
		if (txtIsim == null) {
			txtIsim = new JTextField();
			txtIsim.setBounds(121, 13, 176, 20);
			txtIsim.setColumns(10);
		}
		return txtIsim;
	}
	private JTextField getTxtYetkili() {
		if (txtYetkili == null) {
			txtYetkili = new JTextField();
			txtYetkili.setBounds(121, 46, 176, 20);
			txtYetkili.setColumns(10);
		}
		return txtYetkili;
	}
	private JTextField getTxtTelefon() {
		if (txtTelefon == null) {
			MaskFormatter fmt;
			try {
				fmt = new MaskFormatter("0###-###-####");
				txtTelefon = new JFormattedTextField(fmt);
				txtTelefon.setBounds(121, 79, 94, 20);
				txtTelefon.setColumns(10);
			} catch (ParseException e) {
				txtTelefon = new JTextField();
				txtTelefon.setBounds(108, 91, 135, 20);
				txtTelefon.setColumns(10);
			}
		}
		return txtTelefon;
	}
	private JTextPane getTxtAdres() {
		if (txtAdres == null) {
			txtAdres = new JTextPane();
			txtAdres.setBounds(121, 112, 176, 71);
		}
		return txtAdres;
	}
	private JLabel getLblYetkili() {
		if (lblYetkili == null) {
			lblYetkili = new JLabel("Yetkili Ki\u015Fi :");
			lblYetkili.setHorizontalAlignment(SwingConstants.RIGHT);
			lblYetkili.setBounds(24, 46, 87, 20);
		}
		return lblYetkili;
	}
	private JLabel getLblTelefon() {
		if (lblTelefon == null) {
			lblTelefon = new JLabel("Telefon :");
			lblTelefon.setHorizontalAlignment(SwingConstants.RIGHT);
			lblTelefon.setBounds(24, 79, 87, 20);
		}
		return lblTelefon;
	}
	private JLabel getLblAdres() {
		if (lblAdres == null) {
			lblAdres = new JLabel("Adres :");
			lblAdres.setHorizontalAlignment(SwingConstants.RIGHT);
			lblAdres.setBounds(24, 112, 87, 20);
		}
		return lblAdres;
	}
	private JButton getBtnKaydet() {
		if (btnKaydet == null) {
			btnKaydet = new JButton("Kaydet");
			btnKaydet.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					DbServicessBase<Distributor> dao = new DbServicessBase<Distributor>();
					Distributor eklenecekDistributor = new Distributor();
					eklenecekDistributor.setIsim(txtIsim.getText());
					eklenecekDistributor.setYetkili(txtYetkili.getText());
					eklenecekDistributor.setTelefon(txtTelefon.getText());
					eklenecekDistributor.setAdres(txtAdres.getText());
					
					if (dao.save(eklenecekDistributor)) {
						tabloyuDoldur();
						txtIsim.setText("");
						txtYetkili.setText("");
						txtTelefon.setText("");
						txtAdres.setText("");
					} else {
						showMessageDialog(null, "Kaydetme Ýþlemi Baþarýsýz Oldu!");
					}
					
				}
			});
			btnKaydet.setBounds(319, 160, 89, 23);
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
}
