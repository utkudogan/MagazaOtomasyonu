package com.udogan.magazayonetimi.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.udogan.magazayonetimi.models.enums.Yetki;

@Entity
@Table(name = "kullanici")
public class Kullanici {
	private Long id;
	private String kullaniciAdi;
	transient private String sifre;
	private Yetki yetki;
	
	@Id
	@SequenceGenerator(name = "seq_kullanici", allocationSize = 1, sequenceName = "seq_kullanici_id")
	@GeneratedValue(generator = "seq_kullanici", strategy = GenerationType.SEQUENCE)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Column(length = 50)
	public String getKullaniciAdi() {
		return kullaniciAdi;
	}
	public void setKullaniciAdi(String kullaniciAdi) {
		this.kullaniciAdi = kullaniciAdi;
	}
	@Enumerated
	public Yetki getYetki() {
		return yetki;
	}
	public void setYetki(Yetki yetki) {
		this.yetki = yetki;
	}
	@Column(length = 100)
	public String getSifre() {
		return sifre;
	}
	public void setSifre(String sifre) {
		this.sifre = sifre;
	}

}
