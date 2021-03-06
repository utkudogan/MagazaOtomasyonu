package com.udogan.magazayonetimi.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.udogan.magazayonetimi.models.enums.Bedenler;
import com.udogan.magazayonetimi.models.enums.Cinsiyetler;
import com.udogan.magazayonetimi.models.enums.Renkler;

@Entity
@Table(name="urun")
public class Urun {
	private Long id;
	private String isim;
	private String model;
	private Renkler renk;
	private Cinsiyetler cinsiyet;
	private Double fiyat;
	private Long markaId;
	private Bedenler beden;
	
	@SequenceGenerator(name = "seq_urun",initialValue = 1, sequenceName = "seq_urun_id",allocationSize = 1)
	@GeneratedValue(generator = "seq_urun",strategy = GenerationType.SEQUENCE)
	@Id
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getIsim() {
		return isim;
	}
	public Bedenler getBeden() {
		return beden;
	}
	public void setBeden(Bedenler beden) {
		this.beden = beden;
	}
	public void setIsim(String isim) {
		this.isim = isim;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public Renkler getRenk() {
		return renk;
	}
	public void setRenk(Renkler renk) {
		this.renk = renk;
	}
	public Cinsiyetler getCinsiyet() {
		return cinsiyet;
	}
	public void setCinsiyet(Cinsiyetler cinsiyet) {
		this.cinsiyet = cinsiyet;
	}
	public Double getFiyat() {
		return fiyat;
	}
	public void setFiyat(Double fiyat) {
		this.fiyat = fiyat;
	}
	public Long getMarkaId() {
		return markaId;
	}
	public void setMarkaId(Long markaId) {
		this.markaId = markaId;
	}
}
