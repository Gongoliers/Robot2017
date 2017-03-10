package org.usfirst.frc5112.Robot2017V3.commands.TargetingCommands;

import org.usfirst.frc5112.Robot2017V3.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class TargetingModeOn extends Command {

	public TargetingModeOn() {
		requires(Robot.targetingSystem);
		setTimeout(1);
	}

	protected void initialize() {
		
	}

	protected void execute() {
		
	}

	protected boolean isFinished() {
		return isTimedOut();
	}

	protected void end() {
		Robot.targetingSystem.enableTargetMode();
	}

	protected void interrupted() {
		end();
	}
}
