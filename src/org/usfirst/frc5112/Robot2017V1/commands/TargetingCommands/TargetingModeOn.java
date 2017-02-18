package org.usfirst.frc5112.Robot2017V1.commands.TargetingCommands;

import org.usfirst.frc5112.Robot2017V1.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TargetingModeOn extends Command {

	public TargetingModeOn() {
		requires(Robot.targetingSystem);
	}

	protected void initialize() {
		
	}

	protected void execute() {
		
	}

	protected boolean isFinished() {
		return true;
	}

	protected void end() {
		Robot.targetingSystem.enableTargetMode(null);
	}

	protected void interrupted() {
		end();
	}
}
