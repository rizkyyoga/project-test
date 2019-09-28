package com.yoga.bagian2;

import java.util.ArrayList;
import java.util.List;

public class Main {
	private static List<List<Vertex>> successPath = new ArrayList<List<Vertex>>();

	public static void main(String[] args) {
		// initialize vertex
		Vertex a = new Vertex("A", 1);
		List<Vertex> aEdge = new ArrayList<Vertex>();
		Vertex b = new Vertex("B", 2);
		List<Vertex> bEdge = new ArrayList<Vertex>();
		Vertex c = new Vertex("C", 2);
		List<Vertex> cEdge = new ArrayList<Vertex>();

		// initialize edge
		aEdge.add(b);
		aEdge.add(c);
		a.setConnects(aEdge);
		bEdge.add(c);
		b.setConnects(bEdge);
		cEdge.add(a);
		c.setConnects(cEdge);

		// origin vertex
		Vertex start = a;
		// destination vertex
		Vertex end = c;

		List<Vertex> path = new ArrayList<Vertex>();
		path.add(start);
		search(path, start, end, start, true);

		int i = 1;
		List<Vertex> optimizedPath = new ArrayList<Vertex>();
		int optimzedSumPath = -1;
		int sum;
		for (List<Vertex> lv : successPath) {
			sum = 0;
			System.out.print("Path " + i + " : ");
			for (Vertex v : lv) {
				sum += v.getWeight();
				System.out.print(v.getName() + " -> ");
			}
			System.out.println("(Total weight " + sum + ")");
			if (sum < optimzedSumPath || optimzedSumPath < 0) {
				optimizedPath = lv;
				optimzedSumPath = sum;
			}
			i++;
		}
		if(successPath.size()>0) {
			System.out.print("\n\nOptimized path is : ");
			sum = 0;
			for (Vertex v : optimizedPath) {
				sum += v.getWeight();
				System.out.print(v.getName() + " -> ");
			}
			System.out.print("(Total weight " + sum + ")");
		}else {
			System.out.println("There's no succes path");
		}
	}

	private static void search(List<Vertex> path, Vertex start, Vertex end, Vertex current, boolean isFirst) {
		if (current.equals(end)) {
			successPath.add(path);
			return;
		} else if (current.equals(start) && !isFirst) {
			return;
		} else if (current.getConnects() == null) {
			return;
		}

		for (Vertex v : current.getConnects()) {
			List<Vertex> temp = new ArrayList<Vertex>();
			for (Vertex ver : path) {
				temp.add(ver);
			}
			temp.add(v);
			search(temp, start, end, v, false);
		}
	}
}
