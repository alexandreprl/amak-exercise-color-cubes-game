package fr.irit.smac.amak.exercises.colorcubesgame;

import java.awt.*;

public record SimulationParameters(int areas, int colors, int robots, int cubes) {
	public boolean isValid() {
		return areas > 0 && colors > 0 && robots > 0 && cubes > 0 && areas>=colors;
	}
}
