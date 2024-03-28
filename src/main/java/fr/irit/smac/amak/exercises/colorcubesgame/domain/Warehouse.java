package fr.irit.smac.amak.exercises.colorcubesgame.domain;

import fr.irit.smac.amak.Environment;
import fr.irit.smac.amak.exercises.colorcubesgame.SimulationParameters;
import fr.irit.smac.lxplot.interfaces.ILxPlotChart;
import lombok.Getter;

public class Warehouse extends Environment {
	@Getter
	private final SimulationParameters simulationParameters;
	private Area[] areas;

	public Warehouse(SimulationParameters simulationParameters) {
		this.simulationParameters = simulationParameters;
		this.areas = new Area[simulationParameters.areas()];
		for (int i = 0; i < simulationParameters.areas(); i++) {
			areas[i] = new Area(i, simulationParameters);
		}

		for (int i = 0; i < simulationParameters.cubes(); i++) {
			areas[(int) (Math.random() * simulationParameters.areas())].addCube(new Cube(getRandom().nextInt(simulationParameters.colors())));
		}
	}

	@Override
	public void onCycle() {
		for (int i = 0; i < areas.length; i++) {
			ILxPlotChart chart = areas[i].getChart();
			for (int j = 0; j < simulationParameters.colors(); j++) {
				long cubesCountFromColor = areas[i].getCubesCountFromColor(j);
				chart.add("Color: " + j, 0.0, cubesCountFromColor);
			}
		}
	}

	public Area getRandomArea() {
		return areas[getRandom().nextInt(areas.length)];
	}
}
