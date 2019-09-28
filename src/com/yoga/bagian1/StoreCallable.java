package com.yoga.bagian1;

import java.util.Map;
import java.util.concurrent.Callable;

public class StoreCallable implements Callable<Dict> {

	private Map.Entry<String, String> data;

	public StoreCallable(Map.Entry<String, String> data) {
		this.data = data;
	}

	@Override
	public Dict call() throws Exception {
		return new Dict(data.getKey(), data.getValue());
	}
}