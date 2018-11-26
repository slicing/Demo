package com.slow.conversion.model;

public class Consumer {
	private String name;
	private Long number;
	public Consumer() {
	}

	public Consumer(String name, Long number) {
		this.name = name;
		this.number = number;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "Consumer{" +
				"name='" + name + '\'' +
				", number=" + number +
				'}';
	}
}
