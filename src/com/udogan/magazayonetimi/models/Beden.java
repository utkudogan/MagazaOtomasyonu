package com.udogan.magazayonetimi.models;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.udogan.magazayonetimi.models.enums.Bedenler;
import com.udogan.magazayonetimi.models.enums.Cinsiyet;

@Entity
@Table(name = "beden")
public class Beden {
private Long id;
private Bedenler beden;
private int basen;
private int bel;
private int gogus;
private Cinsiyet cinsiyet;

@Id
@SequenceGenerator(name = "seq_beden", allocationSize = 1, sequenceName = "seq_beden_id")
@GeneratedValue(generator = "seq_beden", strategy = GenerationType.SEQUENCE)
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
@Enumerated
public Bedenler getBeden() {
	return beden;
}
public void setBeden(Bedenler beden) {
	this.beden = beden;
}
@Enumerated
public int getBasen() {
	return basen;
}
public void setBasen(int basen) {
	this.basen = basen;
}
@Enumerated
public int getBel() {
	return bel;
}
public void setBel(int bel) {
	this.bel = bel;
}
@Enumerated
public int getGogus() {
	return gogus;
}
public void setGogus(int gogus) {
	this.gogus = gogus;
}
@Enumerated
public Cinsiyet getCinsiyet() {
	return cinsiyet;
}
public void setCinsiyet(Cinsiyet cinsiyet) {
	this.cinsiyet = cinsiyet;
}

}
