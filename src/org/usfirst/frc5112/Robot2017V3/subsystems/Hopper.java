package org.usfirst.frc5112.Robot2017V3.subsystems;

import org.usfirst.frc5112.Robot2017V3.RobotMap;
import org.usfirst.frc5112.Robot2017V3.commands.HopperCommands.StopHopper;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Hopper extends Subsystem {

	private final SpeedController hopperMotor = RobotMap.hopperHopperMotor;
	public double hopperSpeed = 0.25;
	
	public void initDefaultCommand() {
		setDefaultCommand(new StopHopper());
	}

	public void increaseHopperSpeed() {
		if (hopperSpeed <= 0.95) {
			hopperSpeed = hopperSpeed + 0.05;
		} else {
			hopperSpeed = 1.00;
		}
	}
	
	public void decreaseHopperSpeed() {
		if (hopperSpeed >= 0.05) {
			hopperSpeed = hopperSpeed - 0.05;
		} else {
			hopperSpeed = 0.00;
		}
	}
	
	public void stop() {
		hopperMotor.stopMotor();
	}

	public void spin(double speed) {
		hopperMotor.set(speed);

	}

	public void reverseSpin(double speed) {
		spin(-speed);

	}

}
