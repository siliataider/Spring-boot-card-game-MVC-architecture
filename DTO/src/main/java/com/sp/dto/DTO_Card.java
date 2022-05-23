package com.sp.dto;

public class DTO_Card {
	private int id;
	private String name;
	private String description;
	private String family_name;
	private String img_src;
	private String affinity;
	private int hp;
	private int energy;
	private int attack;
	private int defense;
	private int price;
	
	public DTO_Card() {
	}

	public DTO_Card(int id,int price,String family_name, String img_src, String name, String description, int hp, int energy, int attack,int defense,String affinity) {
		super();
		this.id=id;
		this.name = name;
		this.description=description;
		this.family_name=family_name;
		this.img_src=img_src;
		this.hp=hp;
		this.energy=energy;
		this.attack=attack;
		this.defense=defense;
		this.price=price;
		this.affinity=affinity;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public String getFamily_name() {
		return family_name;
	}

	public String getImg_src() {
		return img_src;
	}

	public String getAffinity() {
		return affinity;
	}

	public int getHp() {
		return hp;
	}

	public int getEnergy() {
		return energy;
	}

	public int getAttack() {
		return attack;
	}

	public int getDefense() {
		return defense;
	}

	public int getPrice() {
		return price;
	}
	
	
}
