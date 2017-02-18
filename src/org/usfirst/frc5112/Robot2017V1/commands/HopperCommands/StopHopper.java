package org.usfirst.frc5112.Robot2017V1.commands.HopperCommands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc5112.Robot2017V1.Robot;

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