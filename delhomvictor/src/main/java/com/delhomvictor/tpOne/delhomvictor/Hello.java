package com.delhomvictor.tpOne.delhomvictor;

public class Hello {
	private final long id;
	private final String name;

	public Hello(long id, String name) {
		this.id = id;
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}
}