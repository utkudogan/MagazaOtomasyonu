package com.udogan.magazayonetimi.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "musteri")
public class Musteri {
	private Long id;
	private String isim;
	private String telefon;
	private String adres;
	
	@SequenceGenerator(name = "seq_musteri",initialValue = 1, sequenceName = "seq_musteri_id",allocationSize = 1)
	@GeneratedValue(generator = "seq_musteri",strategy = GenerationType.SEQUENCE)
	@Id
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(length = 50)
	public String getIsim() {
		return isim;
	}
	public void setIsim(String isim) {
		this.isim = isim;
	}
	
	@Column(length = 15)
	public String getTelefon() {
		return telefon;
	}
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
	
	@Column(length = 100)
	public String getAdres() {
		return adres;
	}
	public void setAdres(String adres) {
		this.adres = adres;
	}
}
