package com.udogan.magazayonetimi.ui;

import com.udogan.magazayonetimi.models.enums.Renkler;

public class Renk {
	Renkler renk;

	public Renkler getRenk() {
		return renk;
	}

	public void setRenk(Renkler renk) {
		this.renk = (Renkler)renk;
	} 
	
	@Override
	public String toString() {
		return this.renk.toString();		
	}
}
