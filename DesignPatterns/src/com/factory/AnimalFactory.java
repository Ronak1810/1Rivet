package com.factory;

public class AnimalFactory {
	
	public Animal createAnimal(String type) {
		if(type.equals("Dog")) {
			return new Dog();
		}
		else if(type.equals("Cat")) {
			return new Cat();
		}
		else
			return null;
	}

}
