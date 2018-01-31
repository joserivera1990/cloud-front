package com.orange.viagging.builder;

import java.util.List;

public interface IPropertiesVariability {
   
	void changeProperties(String path,String key, boolean value);
	
	List<String> updateListProperties(List<String> lines, String key, boolean value);
	
	void writeFile(String path,List<String> lines);
}
