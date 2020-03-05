package com.udogan.magazayonetimi.ui;

import com.udogan.magazayonetimi.models.enums.Bedenler;

public class Beden {
	Bedenler beden;

	public Bedenler getBeden() {
		return beden;
	}

	public void setBeden(Bedenler beden) {
		this.beden = (Bedenler)beden;
	} 
	
	@Override
	public String toString() {
		return this.beden.toString();		
	}
}
