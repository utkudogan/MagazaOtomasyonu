package com.udogan.magazayonetimi.ui;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.text.TableView.TableRow;


import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.RowFilter;

import java.awt.Font;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.BoxLayout;
import javax.swing.LayoutStyle.ComponentPlacement;


public class KategoriIslemleri extends JFrame {
	private JScrollPane scrollPane;
	private JTable tblKurslar;	
	private Long selectedeItemId;
	public KategoriIslemleri() {
		initialize();
	}

	private void initialize() {
		//setTitle("Kategori Ýþlemleri -" + CourseUtils.loginedUser.getUserName()+" - "+CourseUtils.loginedUser.getRole());
		setBounds(400, 130, 871, 603);
		getContentPane().setName("Kurs Ýþlemleri");
		
		JPanel panel = new JPanel();
		
		JPanel panel_1 = new JPanel();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 855, Short.MAX_VALUE)
				.addComponent(panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 855, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE))
		);
		panel_1.setLayout(null);
		
		JLabel lblAnaKategori = new JLabel("Ana Kategori");
		lblAnaKategori.setBounds(23, 20, 129, 20);
		panel_1.add(lblAnaKategori);
		
		JLabel lblKategori = new JLabel("Kategori");
		lblKategori.setBounds(23, 60, 129, 20);
		panel_1.add(lblKategori);
		
		JLabel lblAltKategori = new JLabel("Alt Kategori");
		lblAltKategori.setBounds(23, 100, 129, 20);
		panel_1.add(lblAltKategori);
		
		txtAnaKategori = new JTextField();
		txtAnaKategori.setBounds(162, 20, 369, 20);
		panel_1.add(txtAnaKategori);
		txtAnaKategori.setColumns(10);
		
		txtKategori = new JTextField();
		txtKategori.setBounds(162, 60, 369, 20);
		panel_1.add(txtKategori);
		txtKategori.setColumns(10);
		
		txtAltKategori = new JTextField();
		txtAltKategori.setBounds(162, 100, 369, 20);
		panel_1.add(txtAltKategori);
		txtAltKategori.setColumns(10);
		
		JButton btnSil = new JButton("Sil");
		btnSil.setBounds(756, 100, 89, 20);
		panel_1.add(btnSil);
		
		JButton btnDuzenle = new JButton("D\u00FCzenle");
		btnDuzenle.setBounds(756, 60, 89, 20);
		panel_1.add(btnDuzenle);
		
		JButton btnKaydet = new JButton("Kaydet");
		btnKaydet.setBounds(756, 20, 89, 20);
		panel_1.add(btnKaydet);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		panel.add(getScrollPane());
		getContentPane().setLayout(groupLayout);
		//kursTablosuGoster();
	}
	DefaultTableModel model=new DefaultTableModel();
	private JTextField txtAnaKategori;
	private JTextField txtKategori;
	private JTextField txtAltKategori;

	//public void kursTablosuGoster() {
		
		
		//DbServicessBase<Courses> dao=new DbServicessBase<Courses>(); 
		//Courses temp=new Courses();
		//List<Courses> kurs_listesi=dao.getAllRows(temp);
		
		
	//String [] columnNames= {"ID","AD","FÝYAT","DURUM"};
		//String [][] data=new String [kurs_listesi.size()][columnNames.length];
		
		
		//for (int i = 0; i < kurs_listesi.size(); i++) {
			
		//data[i][0]=kurs_listesi.get(i).getId().toString();
		//data[i][1]=kurs_listesi.get(i).getAdi();
		//data[i][2]=kurs_listesi.get(i).getFiyat().toString();
		//data[i][3]=kurs_listesi.get(i).getDurum();
			
			
	//}
		
	//model=new DefaultTableModel(data,columnNames);
	//tblKurslar.setModel(model);
		
		
		
	//}
	
	public void arama(String ara) {
		
		TableRowSorter<DefaultTableModel> tr=new TableRowSorter<DefaultTableModel>(model);
		tblKurslar.setRowSorter(tr);
		
		tr.setRowFilter(RowFilter.regexFilter(ara));
		
		
		
		
		
	}
	
	
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getTblKurslar());
		}
		return scrollPane;
	}
	private JTable getTblKurslar() {
		if (tblKurslar == null) {
			tblKurslar = new JTable();
			tblKurslar.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					int row=tblKurslar.getSelectedRow();
					
					
					//txtKursAdi.setText(tblKurslar.getValueAt(row, 1).toString());
					//txtFiyat.setText(tblKurslar.getValueAt(row, 2).toString());
					//cmbDurum.setSelectedItem(tblKurslar.getValueAt(row, 3));
					selectedeItemId = Long.valueOf(tblKurslar.getValueAt(row, 0).toString());
					
					
					
					
				}
			});
			tblKurslar.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					
				}
			));
		}
		return tblKurslar;
	}
}
