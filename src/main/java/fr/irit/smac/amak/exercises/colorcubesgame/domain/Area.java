package fr.irit.smac.amak.exercises.colorcubesgame.domain;

import fr.irit.smac.amak.exercises.colorcubesgame.SimulationParameters;
import fr.irit.smac.lxplot.LxPlot;
import fr.irit.smac.lxplot.commons.ChartType;
import fr.irit.smac.lxplot.interfaces.ILxPlotChart;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class Area {
	private final List<Cube> cubes = new ArrayList<>();
	@Getter
	private final int id;
	private final SimulationParameters simulationParameters;
	private final ILxPlotChart chart;

	public Area(int id, SimulationParameters simulationParameters) {
		this.id = id;
		this.simulationParameters = simulationParameters;
		this.chart = LxPlot.getChart("Area " + id, ChartType.BAR);
	}

	public void addCube(Cube cube) {
		this.cubes.add(cube);
	}

	public Cube removeCube(int color) {
		for (Cube cube : cubes) {
			if (cube.getColor() == color) {
				cubes.remove(cube);
				return cube;
			}
		}
		return null;
	}

	public long getCubesCountFromColor(int color) {
		return cubes.stream().filter(c -> c.getColor() == color).count();
	}

	public int minorityColor() {
		int[] colors = new int[simulationParameters.colors()];
		for (Cube cube : cubes) {
			colors[cube.getColor()]++;
		}
		int min = Integer.MAX_VALUE;
		int color = -1;
		for (int i = 0; i < colors.length; i++) {
			if (colors[i] < min && colors[i] > 0) {
				min = colors[i];
				color = i;
			}
		}
		return color;
	}

	public int getDifferentColorsCount() {
		return (int) cubes.stream().map(Cube::getColor).distinct().count();
	}

	public int majorityColor() {
		int[] colors = new int[simulationParameters.colors()];
		for (Cube cube : cubes) {
			colors[cube.getColor()]++;
		}
		int max = Integer.MIN_VALUE;
		int color = -1;
		for (int i = 0; i < colors.length; i++) {
			if (colors[i] > max) {
				max = colors[i];
				color = i;
			}
		}
		return color;
	}

	public int getCubesCount() {
		return cubes.size();
	}

	public ILxPlotChart getChart() {
		return chart;
	}
}
