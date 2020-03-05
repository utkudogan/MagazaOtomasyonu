package com.udogan.magazayonetimi.ui;

import com.udogan.magazayonetimi.models.enums.Yetkiler;

public class Yetki {
	Yetkiler yetki;

	public Yetkiler getYetki() {
		return yetki;
	}

	public void setYetki(Yetkiler yetki) {
		this.yetki = (Yetkiler)yetki;
	} 
	
	@Override
	public String toString() {
		return this.yetki.toString();		
	}
}
