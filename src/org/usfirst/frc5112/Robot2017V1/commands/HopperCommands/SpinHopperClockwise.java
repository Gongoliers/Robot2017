package org.usfirst.frc5112.Robot2017V1.commands.HopperCommands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc5112.Robot2017V1.Robot;

/**
 *
 */
public class SpinHopperClockwise extends Command {
	public SpinHopperClockwise() {
		requires(Robot.hopper);
	}

	/**
	 * Called just before this Command runs the first time
	 */
	protected void initialize() {
	}

	/**
	 * Called repeatedly when this Command is scheduled to run
	 */
	protected void execute() {
		Robot.hopper.spin(0.25);
	}

	/**
	 * Make this return true when this Command no longer needs to run execute()
	 */
	protected boolean isFinished() {
		return false;
	}

	/**
	 * Called once after isFinished returns true
	 */
	protected void end() {
		Robot.hopper.stop();
	}

	/**
	 * Called when another command which requires one or more of the same
	 * subsystems is scheduled to run.
	 */
	protected void interrupted() {
	}
}
