package com.codingdojo.objectmaster;

public class HumanTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Human ahmad=new Human();
        Human loay=new Human();
        ahmad.attack(loay);
        loay.attack(ahmad);
        System.out.println(ahmad.getHealth());
        System.out.println(loay.getHealth());

	}

}
