package org.usfirst.frc5112.Robot2017V3.commands.ScalerCommands;

import org.usfirst.frc5112.Robot2017V3.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class StopScaler extends Command {

	public StopScaler() {
		requires(Robot.scaler);
	}

	protected void initialize() {
	}

	protected void execute() {
		Robot.scaler.stop();
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		Robot.scaler.stop();
	}

	protected void interrupted() {
		end();
	}
}
