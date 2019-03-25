package com.example.core.collections;

import java.util.Vector;

public class VectorList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vector countries = new Vector();
		countries.add("India");
		countries.add("USA");
		countries.add("UK");
		countries.add("Africa");
		countries.add("Russia");
		countries.add("Europe");

		System.out.println(countries);
		System.out.println(countries.size());
		System.out.println(countries.get(1));
		//System.out.println(countries.);
		countries.remove(3);
		for(Object country:countries)
		{
			System.out.println(country);
		}
		

	}

}
