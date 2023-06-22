package com.adapter;

public class BirdAdapter implements ToyDuck {

	Bird bird;
	public BirdAdapter(Bird bird)
	    {
	        this.bird = bird;
	    }
	 
	
	@Override
	public void Squeak() {
		// TODO Auto-generated method stub
		bird.makeSound();
	}

}

//public class BirdAdapter implements Bird {
//
//	ToyDuck toyDuck;
//	public BirdAdapter(ToyDuck toyDuck)
//	    {
//	        this.toyDuck = toyDuck;
//	    }
//	 
//	
//	
//
//	@Override
//	public void fly() {
//		// TODO Auto-generated method stub
//		toyDuck.Squeak();
//	}
//
//
//	@Override
//	public void makeSound() {
//		// TODO Auto-generated method stub
//		toyDuck.Squeak();
//	}
//
//}
