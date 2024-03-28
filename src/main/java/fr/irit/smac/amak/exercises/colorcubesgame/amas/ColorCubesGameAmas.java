package fr.irit.smac.amak.exercises.colorcubesgame.amas;

import fr.irit.smac.amak.Amas;
import fr.irit.smac.amak.exercises.colorcubesgame.domain.Warehouse;

public class ColorCubesGameAmas extends Amas<Warehouse> {
	public ColorCubesGameAmas(Warehouse environment) {
		super(environment, 1, ExecutionPolicy.TWO_PHASES);
	}

	@Override
	protected void onInitialAgentsCreation() {
		for (int i = 0; i < this.getEnvironment().getSimulationParameters().robots(); i++) {
			this.addAgent(new RobotAgent(this, this.getEnvironment().getRandomArea()));
		}
	}
}
