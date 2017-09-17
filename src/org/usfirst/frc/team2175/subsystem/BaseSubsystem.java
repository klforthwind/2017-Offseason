package org.usfirst.frc.team2175.subsystem;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.info.InfoLocator;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;

public class BaseSubsystem extends Subsystem {
	InfoLocator infoLocator;
	public BaseSubsystem() {
		infoLocator = ServiceLocator.get(InfoLocator.class);

		ServiceLocator.register(this);
	}

	protected CANTalon makeMotor(String id) {
		String[] info = infoLocator.getWiringInfo(id).split(",");
		CANTalon motor = new CANTalon(Integer.parseInt(info[0].trim()));
		motor.reverseOutput(info[1].trim().contains("true"));
		return motor;
	}

	protected double getSpeed(String id) {
		return infoLocator.getBehaviorInfo(id);
	}

	@Override
	public void setDefaultCommand(final Command command) {
		super.setDefaultCommand(command);
	}

	@Override
	protected void initDefaultCommand() {
	}
}
