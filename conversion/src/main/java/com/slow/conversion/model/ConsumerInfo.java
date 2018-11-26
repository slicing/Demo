package com.slow.conversion.model;

public class ConsumerInfo {
	private Float height;
	private Float bust;
	private Float waist;
	private Float hipline;

	public ConsumerInfo(Float height, Float bust, Float waist, Float hipline) {
		this.height = height;
		this.bust = bust;
		this.waist = waist;
		this.hipline = hipline;
	}

	public ConsumerInfo() {
	}

	public Float getHeight() {
		return height;
	}

	public void setHeight(Float height) {
		this.height = height;
	}

	public Float getBust() {
		return bust;
	}

	public void setBust(Float bust) {
		this.bust = bust;
	}

	public Float getWaist() {
		return waist;
	}

	public void setWaist(Float waist) {
		this.waist = waist;
	}

	public Float getHipline() {
		return hipline;
	}

	public void setHipline(Float hipline) {
		this.hipline = hipline;
	}

	@Override
	public String toString() {
		return "ConsumerInfo{" +
				"height=" + height +
				", bust=" + bust +
				", waist=" + waist +
				", hipline=" + hipline +
				'}';
	}
}
