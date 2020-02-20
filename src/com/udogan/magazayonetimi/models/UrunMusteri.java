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
@Table(name = "urun_musteri")
public class UrunMusteri {
	private Long id;
	private Urun urunId;
	private Musteri musteriId;
	
	 @Id
	    @SequenceGenerator(name = "seq_urunmusteri", allocationSize = 1, sequenceName = "seq_urunmusteri_id")
	    @GeneratedValue(generator = "seq_urunmusteri", strategy = GenerationType.SEQUENCE)
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
    @JoinColumn(name = "musteri_id")
	public Musteri getMusteriId() {
		return musteriId;
	}
	public void setMusteriId(Musteri musteriId) {
		this.musteriId = musteriId;
	}
}
