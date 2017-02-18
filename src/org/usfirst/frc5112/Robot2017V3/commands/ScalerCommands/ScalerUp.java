package org.usfirst.frc5112.Robot2017V3.commands.ScalerCommands;

import org.usfirst.frc5112.Robot2017V3.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ScalerUp extends Command {

	public ScalerUp() {
		requires(Robot.scaler);
	}

	protected void initialize() {

	}

	protected void execute() {
		Robot.scaler.up(Robot.scaler.scalerSpeed);
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
