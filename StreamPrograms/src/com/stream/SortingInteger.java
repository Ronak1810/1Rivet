package com.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class SortingInteger {

	public static void main(String[] args) {
//		List <Integer> list = List.of(23, 34, 21, 567, 54, 7890, 657, 45645, 900, 23, 34, 21);
//		List <Integer> list1 = list.stream().sorted().collect(Collectors.toList());
//		System.out.println(list1);
		
//		List <String> list = List.of("Ronak", "Jaykrishn", "Gracy", "Harsh", "Deep","Abhisek","Ashish");
//		List <String> list1 = list.stream().sorted().collect(Collectors.toList());
//		System.out.println(list1);
		
//		List <String> list2 = list.stream().filter(e->e.startsWith("A")).collect(Collectors.toList());
//		System.out.println("Name starts with 'A' is : " + list2);
		
		Set <Integer> set1= new HashSet<Integer>();
	
		List <Integer> list= new ArrayList<Integer>();
		list.add(23);
		list.add(34);
		list.add(6);
		list.add(23);
		list.add(2433);
		list.add(33);
		list.add(24);
		list.add(24);
		list.add(2433);

		List <Integer> list1 = list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		System.out.println(list1);
//		List <Integer> set12 = list.stream().filter(e->!(set1.add(e))).collect(Collectors.toList());
//		System.out.println(set12);
	}

}
