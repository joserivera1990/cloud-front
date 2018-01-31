package com.orange.viagging.builder.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import com.orange.viagging.builder.IFeatureReader;

/**
 * Lee las caracteristicas en un archivo plano
 * @author karenvega
 *
 */
public class FeatureTxtReader implements IFeatureReader {

	@Override
	public List<String> readFeatures(String filePath) {
		List<String> features = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			String line = br.readLine();
			while (line != null) {
				features.add(line);
				line = br.readLine();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return features;
	}
}
