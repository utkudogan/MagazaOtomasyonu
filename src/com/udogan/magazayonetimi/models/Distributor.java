package com.udogan.magazayonetimi.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "distributor")
public class Distributor {
	private Long id;
	private String isim;
	private String yetkili;
	private String telefon;
	private String adres;
	
	@Id
	@SequenceGenerator(name = "seq_distributor", allocationSize = 1, sequenceName = "seq_distributor_id")
	@GeneratedValue(generator = "seq_distributor", strategy = GenerationType.SEQUENCE)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Column(length = 100)
	public String getIsim() {
		return isim;
	}	
	public void setIsim(String isim) {
		this.isim = isim;
	}
	@Column(length = 50)
	public String getYetkili() {
		return yetkili;
	}
	public void setYetkili(String yetkili) {
		this.yetkili = yetkili;
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
