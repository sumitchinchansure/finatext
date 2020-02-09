package com.finatext.recruit.dto;

import com.finatext.recruit.entity.CommentScore;

public class CommentScoreDto {

	private int id;

	private int type;

	private double value;

	public CommentScoreDto(final CommentScore score) {
		id = score.getId();
		type = score.getScoreType();
		value = score.getScore();
	}

	public int getId() {
		return id;
	}

	public void setId(final int id) {
		this.id = id;
	}

	public int getType() {
		return type;
	}

	public void setType(final int type) {
		this.type = type;
	}

	public double getValue() {
		return value;
	}

	public void setValue(final double value) {
		this.value = value;
	}

}
