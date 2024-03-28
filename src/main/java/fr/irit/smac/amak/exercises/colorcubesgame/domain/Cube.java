package fr.irit.smac.amak.exercises.colorcubesgame.domain;

import lombok.Getter;

public class Cube {
	@Getter
	private final int color;

	public Cube(int color) {
		this.color = color;
	}
}
