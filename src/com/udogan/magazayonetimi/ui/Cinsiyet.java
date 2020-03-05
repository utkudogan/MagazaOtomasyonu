package com.udogan.magazayonetimi.ui;

import com.udogan.magazayonetimi.models.enums.Cinsiyetler;

public class Cinsiyet {
	Cinsiyetler cinsiyet;

	public Cinsiyetler getCinsiyet() {
		return cinsiyet;
	}

	public void setCinsiyet(Cinsiyetler cinsiyet) {
		this.cinsiyet = (Cinsiyetler)cinsiyet;
	} 
	
	@Override
	public String toString() {
		return this.cinsiyet.toString();		
	}
}
