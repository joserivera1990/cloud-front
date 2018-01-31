package com.viagging.weather.model;

import java.util.List;

public class WeatherObject {
	
	private Coordinate coor;
	private List<Weather> weather;
	private String base;
	private Main main;
	private Wind wind;
	private Clouds clouds;
	private String dt;
	private System sys;
	private String id;
	private String name;
	private String cod;
	
	public String getBase() {
		return base;
	}
	public void setBase(String base) {
		this.base = base;
	}
	public Main getMain() {
		return main;
	}
	public void setMain(Main main) {
		this.main = main;
	}
	public Wind getWind() {
		return wind;
	}
	public void setWind(Wind wind) {
		this.wind = wind;
	}
	public Clouds getClouds() {
		return clouds;
	}
	public void setClouds(Clouds clouds) {
		this.clouds = clouds;
	}
	public String getDt() {
		return dt;
	}
	public void setDt(String dt) {
		this.dt = dt;
	}
	public System getSys() {
		return sys;
	}
	public void setSys(System sys) {
		this.sys = sys;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCod() {
		return cod;
	}
	public void setCod(String cod) {
		this.cod = cod;
	}
	public Coordinate getCoor() {
		return coor;
	}
	public void setCoor(Coordinate coor) {
		this.coor = coor;
	}
	public List<Weather> getWeather() {
		return weather;
	}
	public void setWeather(List<Weather> weather) {
		this.weather = weather;
	}


}
