package com.factory;

public class Main {

	public static void main(String[] args) {
		
		AnimalFactory animalFactory =new AnimalFactory();
		
		animalFactory.createAnimal("Dog").makeNoice();
		
		animalFactory.createAnimal("Cat").makeNoice();

	}

}
