package com.udogan.magazayonetimi.ui;

import java.awt.Dimension;
import java.awt.LayoutManager;
import java.util.List;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.text.MaskFormatter;
import javax.swing.text.TabExpander;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.udogan.magazayonetimi.models.Distributor;
import com.udogan.magazayonetimi.utils.dao.DbServicessBase;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;

import javax.swing.JTextPane;

public class DistributorIslemleriPaneliEski extends JPanel {
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblIsým;
	private JLabel lblYetkili;
	private JLabel lblTelefon;
	private JTextField txtIsým;
	private JTextField txtYetkili;
	private JTextField txtTelefon;
	private JButton btnKaydet;
	private JTable tableBedenler;
	private JScrollPane scrollPane;
	public MainFrame parentFrame;
	private JLabel lblAdres;
	private JTextPane txtAdres;

	public DistributorIslemleriPaneliEski(MainFrame parentFrame) {
		this.parentFrame = parentFrame;
		setSize(1000, 500);
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
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(null);
			panel.add(getLblIsým());
			panel.add(getLblYetkili());
			panel.add(getLblTelefon());
			panel.add(getTxtIsým());
			panel.add(getTxtYetkili());
			panel.add(getTxtTelefon());
			panel.add(getBtnKaydet());
			panel.add(getLblAdres());
			panel.add(getTxtAdres());
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

	private JLabel getLblIsým() {
		if (lblIsým == null) {
			lblIsým = new JLabel("\u0130s\u0131m :");
			lblIsým.setLabelFor(getTxtIsým());
			lblIsým.setHorizontalAlignment(SwingConstants.RIGHT);
			lblIsým.setBounds(10, 13, 64, 20);
		}
		return lblIsým;
	}

	private JLabel getLblYetkili() {
		if (lblYetkili == null) {
			lblYetkili = new JLabel("Yetkili :");
			lblYetkili.setLabelFor(getTxtYetkili());
			lblYetkili.setHorizontalAlignment(SwingConstants.RIGHT);
			lblYetkili.setBounds(10, 46, 64, 20);
		}
		return lblYetkili;
	}

	private JLabel getLblTelefon() {
		if (lblTelefon == null) {
			lblTelefon = new JLabel("Telefon :");
			lblTelefon.setLabelFor(getTxtTelefon());
			lblTelefon.setHorizontalAlignment(SwingConstants.RIGHT);
			lblTelefon.setBounds(10, 79, 64, 20);
		}
		return lblTelefon;
	}

	private JTextField getTxtIsým() {
		if (txtIsým == null) {
			txtIsým = new JTextField();
			txtIsým.setBounds(92, 13, 178, 20);
			txtIsým.setColumns(10);
		}
		return txtIsým;
	}

	private JTextField getTxtYetkili() {
		if (txtYetkili == null) {
			txtYetkili = new JTextField();
			txtYetkili.setBounds(92, 46, 178, 20);
			txtYetkili.setColumns(10);
		}
		return txtYetkili;
	}

	private JTextField getTxtTelefon() {
		if (txtTelefon == null) {
			 MaskFormatter fmt;
				try {
					fmt = new MaskFormatter("###-###-####");
					txtTelefon = new JFormattedTextField(fmt);
					txtTelefon.setBounds(108, 91, 135, 20);
					txtTelefon.setColumns(10);
				} catch (ParseException e) {
					txtTelefon = new JTextField();
					txtTelefon.setBounds(108, 91, 135, 20);
					txtTelefon.setColumns(10);
				}
		}
		return txtTelefon;
	}

	private JButton getBtnKaydet() {
		if (btnKaydet == null) {
			btnKaydet = new JButton("KAYDET");
			btnKaydet.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					DbServicessBase<Distributor> dao = new DbServicessBase<Distributor>();
					Distributor eklenecekDistributor = new Distributor();
					eklenecekDistributor.setIsim(txtIsým.getText());
					eklenecekDistributor.setYetkili(txtYetkili.getText());
					eklenecekDistributor.setTelefon(txtTelefon.getText());
					eklenecekDistributor.setAdres(txtAdres.getText());
					
					if (dao.save(eklenecekDistributor)) {
						tabloyuDoldur();
						txtIsým.setText("");
						txtYetkili.setText("");
						txtTelefon.setText("");
						txtAdres.setText("");
					} else {
						showMessageDialog(null, "Kaydetme Ýþlemi Baþarýsýz Oldu!");
					}
				}
			});
			btnKaydet.setBounds(288, 188, 89, 20);
		}
		return btnKaydet;
	}

	private JTable getTableBedenler() {
		if (tableBedenler == null) {
			tableBedenler = new JTable();
			tableBedenler.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int secilenSatir = tableBedenler.getSelectedRow();
					Distributor degistirilecekDistributor = new Distributor();
					degistirilecekDistributor.setId(Long.parseLong(tableBedenler.getModel().getValueAt(secilenSatir, 0).toString()));
					degistirilecekDistributor.setIsim(tableBedenler.getModel().getValueAt(secilenSatir, 1).toString());
					degistirilecekDistributor.setYetkili(tableBedenler.getModel().getValueAt(secilenSatir, 2).toString());
					degistirilecekDistributor.setTelefon(tableBedenler.getModel().getValueAt(secilenSatir, 3).toString());
					degistirilecekDistributor.setAdres(tableBedenler.getModel().getValueAt(secilenSatir, 4).toString());
					DistributorDegistirme frame = new DistributorDegistirme(e, degistirilecekDistributor);
					parentFrame.setEnabled(false);
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
	private JLabel getLblAdres() {
		if (lblAdres == null) {
			lblAdres = new JLabel("Adres :");
			lblAdres.setHorizontalAlignment(SwingConstants.RIGHT);
			lblAdres.setLabelFor(getTxtAdres());
			lblAdres.setBounds(28, 112, 46, 14);
		}
		return lblAdres;
	}
	private JTextPane getTxtAdres() {
		if (txtAdres == null) {
			txtAdres = new JTextPane();
			txtAdres.setBounds(92, 112, 178, 92);
		}
		return txtAdres;
	}
}
