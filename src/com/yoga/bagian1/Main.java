package com.yoga.bagian1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

	public static void main(String[] args) {
		List<HashMap<String, String>> a = new ArrayList<HashMap<String, String>>();
		String text;
		HashMap<String, String> row = new HashMap<String, String>();

		// initialize data
		row.put("11", "11");
		row.put("12", "12");
		row.put("13", "13");
		row.put("14", "14");
		row.put("15", "15");
		row.put("16", "16");
		row.put("17", "17");
		a.add(row);

		row = new HashMap<String, String>();
		row.put("21", "21");
		row.put("22", "22");
		row.put("23", "23");
		row.put("24", "24");
		row.put("25", "25");
		row.put("26", "26");
		row.put("27", "27");
		a.add(row);

		row = new HashMap<String, String>();
		row.put("31", "41");
		row.put("32", "42");
		row.put("33", "43");
		row.put("34", "44");
		row.put("35", "45");
		row.put("36", "46");
		row.put("37", "47");
		a.add(row);

		text = store(a);
		System.out.println(text);
		a = load(text);
		System.out.println(a);
	}

	private static String store(List<HashMap<String, String>> arr) {
		ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
		String data = new String();
		for (HashMap<String, String> row : arr) {
			List<Future<Dict>> futures = new ArrayList<Future<Dict>>();
			String map = new String();
			for (Map.Entry<String, String> col : row.entrySet()) {
				Future<Dict> future = executor.submit(new StoreCallable(col));
				futures.add(future);
			}

			for (Future<Dict> f : futures) {
				try {
					map += f.get().getKey() + "=" + f.get().getValue() + ";";
				} catch (InterruptedException | ExecutionException ex) {
					System.out.println(ex);
					f.cancel(true);
				}
			}
			map += "\n";
			data += map;
		}
		executor.shutdown();
		return data;
	}

	private static List<HashMap<String, String>> load(String arr) {
		ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
		List<HashMap<String, String>> data = new ArrayList<HashMap<String, String>>();
		String[] rows = arr.split("\n");
		for (String row : rows) {
			List<Future<Dict>> futures = new ArrayList<Future<Dict>>();
			HashMap<String, String> map = new HashMap<String, String>();
			String[] cols = row.split(";");
			for (String col : cols) {
				Future<Dict> future = executor.submit(new LoadCallable(col));
				futures.add(future);
			}

			for (Future<Dict> f : futures) {
				try {
					map.put(f.get().getKey(), f.get().getValue());
				} catch (InterruptedException | ExecutionException ex) {
					System.out.println(ex);
					f.cancel(true);
				}
			}
			data.add(map);
		}
		executor.shutdown();
		return data;
	}
}
