package com.yoga.bagian1;

import java.util.concurrent.Callable;

public class LoadCallable implements Callable<Dict> {

	private String data;

	public LoadCallable(String data) {
		this.data = data;
	}

	@Override
	public Dict call() throws Exception {
		String key = data.substring(0, data.indexOf('='));
		String value = data.substring(data.indexOf('=') + 1, data.length());
		return new Dict(key, value);
	}
}