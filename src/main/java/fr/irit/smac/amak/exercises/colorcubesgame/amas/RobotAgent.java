package fr.irit.smac.amak.exercises.colorcubesgame.amas;

import fr.irit.smac.amak.Agent;
import fr.irit.smac.amak.exercises.colorcubesgame.domain.Area;
import fr.irit.smac.amak.exercises.colorcubesgame.domain.Cube;
import fr.irit.smac.amak.exercises.colorcubesgame.domain.Warehouse;

public class RobotAgent extends Agent<ColorCubesGameAmas, Warehouse> {
	private Area currentArea;
	private Cube pickedUpCube = null;

	protected RobotAgent(ColorCubesGameAmas amas, Area initialArea) {
		super(amas);
		this.currentArea = initialArea;
	}

	private boolean isHoldingACube() {
		return pickedUpCube != null;
	}

	private void dropCube() {
		if (pickedUpCube == null)
			return;
		currentArea.addCube(pickedUpCube);
		pickedUpCube = null;
	}


	private boolean canHoldACube() {
		return !isHoldingACube();
	}

	private void pickUpCube(int color) {
		if (pickedUpCube != null)
			return;
		pickedUpCube = currentArea.removeCube(color);
	}
}
