package org.usfirst.frc5112.Robot2017V3.commands.HopperCommands;

import org.usfirst.frc5112.Robot2017V3.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class StopHopper extends Command {

	public StopHopper() {
		requires(Robot.hopper);
	}

	protected void initialize() {
		end();
	}

	protected void execute() {
		end();
		
	}

	protected boolean isFinished() {
		return true;
	}

	protected void end() {
		Robot.hopper.stop();
	}

	protected void interrupted() {
		end();
	}
}