package com.sp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Hero {
	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	private String superPowerName;
	private int superPowerValue;
	private String imgUrl;
	private Boolean owned;
	private int value;
	
	public Boolean getOwned() {
		return owned;
	}

	public void setOwned(Boolean owned) {
		this.owned = owned;
	}

	public Hero() {
	}

	public Hero(int id,String name, String superPowerName, int superPowerValue, String imgUrl) {
		super();
		this.id=id;
		this.name = name;
		this.superPowerName = superPowerName;
		this.superPowerValue = superPowerValue;
		this.imgUrl = imgUrl;
		this.owned = false;
		this.value=50;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSuperPowerName() {
		return superPowerName;
	}

	public void setSuperPowerName(String superPowerName) {
		this.superPowerName = superPowerName;
	}

	public int getSuperPowerValue() {
		return superPowerValue;
	}

	public void setSuperPowerValue(int superPowerValue) {
		this.superPowerValue = superPowerValue;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "HERO ["+this.id+"]: name:"+this.name+", superPowerName:"+this.superPowerName+", superPowerValue:"+this.superPowerValue+" imgUrl:"+this.imgUrl;
	}
}
