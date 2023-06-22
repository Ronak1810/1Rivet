package com.adapter;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 	Sparrow sparrow = new Sparrow();
	        ToyDuck toyDuck = new PlaToyDuck();//class up-casting 
	 
	        // Wrap a bird in a birdAdapter so that it
	        // behaves like toy duck
	        ToyDuck birdAdapter = new BirdAdapter(sparrow);//class up-casting 
	 
//	        System.out.println("Sparrow...");
//	        sparrow.fly();
//	        sparrow.makeSound();
//	 
	        System.out.println("ToyDuck...");
	        toyDuck.Squeak();
//	 
	        // toy duck behaving like a bird
	        System.out.println("BirdAdapter...");
	        birdAdapter.Squeak(); // chi chi
	}
}
