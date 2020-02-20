package com.udogan.magazayonetimi.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "kategori")
public class Kategori {
	private Long id;
	private String anaKategori;
	private String kategori;
	private String altKategori;
	
	@Id
	@SequenceGenerator(name = "seq_kategori", allocationSize = 1, sequenceName = "seq_kategori_id")
	@GeneratedValue(generator = "seq_kategori", strategy = GenerationType.SEQUENCE)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getAnaKategori() {
		return anaKategori;
	}
	public void setAnaKategori(String anaKategori) {
		this.anaKategori = anaKategori;
	}
	public String getKategori() {
		return kategori;
	}
	public void setKategori(String kategori) {
		this.kategori = kategori;
	}
	public String getAltKategori() {
		return altKategori;
	}
	public void setAltKategori(String altKategori) {
		this.altKategori = altKategori;
	}	
	
}
