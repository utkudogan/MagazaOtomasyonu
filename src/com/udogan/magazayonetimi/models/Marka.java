package com.udogan.magazayonetimi.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "marka")
public class Marka {
	private Long id;
	private String isim;
	
	@SequenceGenerator(name = "seq_marka",initialValue = 1, sequenceName = "seq_marka_id",allocationSize = 1)
	@GeneratedValue(generator = "seq_marka",strategy = GenerationType.SEQUENCE)
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
	
	@Override
	public String toString() {
		return getIsim();
	}
}
