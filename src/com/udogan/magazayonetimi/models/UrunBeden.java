package com.udogan.magazayonetimi.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.udogan.magazayonetimi.ui.Beden;

@Entity
@Table(name = "urun_beden")
public class UrunBeden {
	private Long id;
	private Urun urunId;
	private Beden bedenId;
	
	@SequenceGenerator(name = "seq_urunbeden",initialValue = 1, sequenceName = "seq_urunbeden_id",allocationSize = 1)
	@GeneratedValue(generator = "seq_urunbeden",strategy = GenerationType.SEQUENCE)
	@Id
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
    @JoinColumn(name = "beden_id")
	public Beden getBedenId() {
		return bedenId;
	}
	public void setBedenId(Beden bedenId) {
		this.bedenId = bedenId;
	}
}
