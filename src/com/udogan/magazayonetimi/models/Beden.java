package com.udogan.magazayonetimi.models;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.udogan.magazayonetimi.models.enums.Bedenler;
import com.udogan.magazayonetimi.models.enums.Cinsiyetler;

@Entity
@Table(name = "beden")
public class Beden {
private Long id;
private Bedenler beden;
private int basen;
private int bel;
private int gogus;
private Cinsiyetler cinsiyet;

@Id
@SequenceGenerator(name = "seq_beden", allocationSize = 1, sequenceName = "seq_beden_id")
@GeneratedValue(generator = "seq_beden", strategy = GenerationType.SEQUENCE)
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}

public Bedenler getBeden() {
	return beden;
}
public void setBeden(Bedenler beden) {
	this.beden = beden;
}

public int getBasen() {
	return basen;
}
public void setBasen(int basen) {
	this.basen = basen;
}

public int getBel() {
	return bel;
}
public void setBel(int bel) {
	this.bel = bel;
}

public int getGogus() {
	return gogus;
}
public void setGogus(int gogus) {
	this.gogus = gogus;
}

public Cinsiyetler getCinsiyet() {
	return cinsiyet;
}
public void setCinsiyet(Cinsiyetler cinsiyet) {
	this.cinsiyet = cinsiyet;
}

}
