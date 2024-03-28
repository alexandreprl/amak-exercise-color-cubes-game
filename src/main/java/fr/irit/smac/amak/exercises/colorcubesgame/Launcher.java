package fr.irit.smac.amak.exercises.colorcubesgame;

import fr.irit.smac.amak.exercises.colorcubesgame.amas.ColorCubesGameAmas;
import fr.irit.smac.amak.exercises.colorcubesgame.domain.Warehouse;
import fr.irit.smac.amak.scheduling.Scheduler;

public class Launcher {
	public static void main(String[] args) {
		var simulationParameters = new SimulationParameters(10,
		                                                    8,
		                                                    3,
		                                                    100);

		if (!simulationParameters.isValid()) {
			System.err.println("Invalid parameters");
			System.exit(1);
		}

		var warehouse = new Warehouse(simulationParameters);
		var amas = new ColorCubesGameAmas(warehouse);
		var scheduler = new Scheduler(amas, warehouse);
		scheduler.startWithSleep(100);
	}
}
