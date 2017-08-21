package org.usfirst.frc.team2175.command.single;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.command.BaseCommand;
import org.usfirst.frc.team2175.subsystem.GearIntakeSubsystem;

public class ActuateGearIntakeOutAndSpinCommand extends BaseCommand {

	GearIntakeSubsystem gearIntakeSubsystem;

	public ActuateGearIntakeOutAndSpinCommand() {
		gearIntakeSubsystem = ServiceLocator.get(GearIntakeSubsystem.class);
		requires(gearIntakeSubsystem);
	}

	@Override
	protected void initialize() {
		gearIntakeSubsystem.lower();
		gearIntakeSubsystem.runOut();
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		gearIntakeSubsystem.stop();
	}
}