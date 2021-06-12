package com.codingdojo.zoo;

public class Gorilla extends Mammal{

	public Gorilla() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Gorilla(int energyLevel) {
		super(energyLevel);
		// TODO Auto-generated constructor stub
	}
    public void throwSomething() {
    	this.energyLevel-=5;
    	System.out.println("Gorilla throw something");
    }
    public void eatBananas() {
    	this.energyLevel+=10;
    	System.out.println("Gorilla is Happy");
    }
    public void climb() {
    	this.energyLevel-=10;
    	System.out.println(" Gorilla has climbed a tree");    	
    }
}
