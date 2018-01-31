package com.viagging.util;

import java.util.ArrayList;
import java.util.List;

public enum TransportEnum {

	AIRPLANE("Avión"), 
	BUS("Bus"), 
	VANS("Van"),
	CRUCERO("Crucero"),
	BARCO("Barco"),
	HELICOPTERO("Helicoptero");
	private String name;

	private TransportEnum(String name) {
		this.name = name;
	}

	public String getName(){
		return name;
	}
	
	public static List<String> getValues() {
		List<String> values = new ArrayList<>();
		System.out.println(" lista");
		for (TransportEnum topicEnum : TransportEnum.values()) {
			System.out.println(topicEnum.name + "name.");
			values.add(topicEnum.name);
		}
		return values;
	}
}
