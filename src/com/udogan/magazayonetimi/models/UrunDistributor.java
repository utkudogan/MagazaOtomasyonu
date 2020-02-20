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
@Table(name = "urun_distributor")
public class UrunDistributor {
	private Long id;
	private Urun urunId;
	private Distributor distributorId;
	
	@SequenceGenerator(name = "seq_urundistributor",initialValue = 1, sequenceName = "seq_urundistributor_id",allocationSize = 1)
	@GeneratedValue(generator = "seq_urundistributor",strategy = GenerationType.SEQUENCE)
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
    @JoinColumn(name = "distributor_id")
	public Distributor getDistributorId() {
		return distributorId;
	}
	public void setDistributorId(Distributor distributorId) {
		this.distributorId = distributorId;
	}
}
