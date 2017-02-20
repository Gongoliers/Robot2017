package org.usfirst.frc5112.Robot2017V3.commands.TargetingCommands;

import org.usfirst.frc5112.Robot2017V3.Robot;

import edu.wpi.first.wpilibj.command.Command;


public class BoilerCameraEnable extends Command {

	public BoilerCameraEnable() {
		requires(Robot.targetingSystem);
	}

	protected void initialize() {
		Robot.targetingSystem.enableBoilerCamera();
	}

	protected void execute() {
	}

	protected boolean isFinished() {
		return true;
	}

	protected void end() {
	}

	protected void interrupted() {
		end();
	}
}
