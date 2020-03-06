package com.udogan.magazayonetimi.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.udogan.magazayonetimi.ui.Renk;

@Entity
@Table(name = "urun_renk")
public class UrunRenk {
	private Long id;
	private Urun urunId;
	private Renk renkId;
	
	@SequenceGenerator(name = "seq_urunrenk",initialValue = 1, sequenceName = "seq_urunrenk_id",allocationSize = 1)
	@GeneratedValue(generator = "seq_urunrenk",strategy = GenerationType.SEQUENCE)
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
    @JoinColumn(name = "renk_id")
	public Renk getRenkId() {
		return renkId;
	}
	public void setRenkId(Renk renkId) {
		this.renkId = renkId;
	}
}
