package com.ronit.urlshortner.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity  
@Table 

public class Shortened {

	
	 
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;  
	@Column  
	private String longid;
	@Id
	@Column 
	//@Getter @Setter
	private String shortid; 
	@Column
	//@Getter @Setter
	private int hitcount;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLongid() {
		return longid;
	}
	public void setLongid(String longid) {
		this.longid = longid;
	}
	public String getShortid() {
		return shortid;
	}
	public void setShortid(String shortid) {
		this.shortid = shortid;
	}
	public int getHitcount() {
		return hitcount;
	}
	
	public void setHitcount(int hitcount) {
		this.hitcount = hitcount;
		
	}
	public Shortened(int id, String longid, String shortid, int hitcount) {
		super();
		this.id = id;
		this.longid = longid;
		this.shortid = shortid;
		this.hitcount = hitcount;
	}
	public Shortened() {
		super();
	}  
	
	
	
}
