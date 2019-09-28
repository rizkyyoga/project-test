package com.yoga.bagian2;

import java.util.List;

public class Vertex {

	private String name;
	private int weight;
	private List<Vertex> connects;

	public Vertex(String name, int weight) {
		this.name = name;
		this.weight = weight;
	}

	public Vertex() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public List<Vertex> getConnects() {
		return connects;
	}

	public void setConnects(List<Vertex> connects) {
		this.connects = connects;
	}

}
