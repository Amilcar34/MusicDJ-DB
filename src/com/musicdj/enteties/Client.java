package com.musicdj.enteties;

public class Client {

	private int id;
	private String name;
	private String musicGen;
	
	public Client(int id, String name, String musicGen) {

		this.id = id;
		this.name = name;
		this.musicGen = musicGen;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getMusicGen() {
		return musicGen;
	}

	@Override
	public String toString(){
		return getId() + ", " + getName() + ", " + getMusicGen();
	}
}
