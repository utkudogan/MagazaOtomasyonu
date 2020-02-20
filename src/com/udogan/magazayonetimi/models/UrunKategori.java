package com.udogan.magazayonetimi.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "urun_kategori")
public class UrunKategori {
	private Long id;
	private Urun urunId;
	private Kategori kategoriId;
	
	@Id
    @SequenceGenerator(name = "seq_urunkategori", allocationSize = 1, sequenceName = "seq_urunkategori_group")
    @GeneratedValue(generator = "seq_urunkategori", strategy = GenerationType.SEQUENCE)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@ManyToOne
    @JoinColumn(name = "urun_id")
	public Urun getUrunId() {
		return urunId;
	}
	public void setUrunId(Urun urunId) {
		this.urunId = urunId;
	}
	
	@ManyToOne
    @JoinColumn(name = "kategori_id")
	public Kategori getKategoriId() {
		return kategoriId;
	}
	public void setKategoriId(Kategori kategoriId) {
		this.kategoriId = kategoriId;
	}
}
