package com.viagging.core.constant;

import java.util.ArrayList;
import java.util.List;

import com.viagging.util.Range;

public enum PriceRange {

	PRECIO_1(0, 100000),
	
	PRECIO_2(100000, 500000),
	
	PRECIO_3(500000, 1000000),
	
	PRECIO_4(1000000, 5000000),
	
	PRECIO_5(5000000, -1);
	
	int low;
	
	int high;
	
	private PriceRange(int low, int high){
		this.low = low;
		this.high = high;
	}
	
	private int getLow(){
		return this.low;
	}
	
	private int getHigh(){
		return this.high;
	}
	
	public static List<Range> getKeyValues() {
		List<Range> prices = new ArrayList<>();
		for(PriceRange priceRange : PriceRange.values()){
			Range range = new Range();
			range.setLow(priceRange.getLow());
			range.setHigh(priceRange.getHigh());
			prices.add(range);
		}
		return prices;
	}
	
}
