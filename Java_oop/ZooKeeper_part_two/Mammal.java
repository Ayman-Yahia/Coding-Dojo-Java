package com.codingdojo.zoo;

public class Mammal {
    protected int energyLevel;
	public Mammal(){
		this.energyLevel=100;
	}
	public Mammal(int energyLevel) {
		super();
		this.energyLevel = energyLevel;
	}

	public int getEnergyLevel() {
		return energyLevel;
	}

	public void setEnergyLevel(int energyLevel) {
		if (energyLevel>=0) {
			this.energyLevel = energyLevel;
		}
		
	}

	public int displayEnergy() {
		System.out.println(this.energyLevel);
		return this.energyLevel;
	}

}
