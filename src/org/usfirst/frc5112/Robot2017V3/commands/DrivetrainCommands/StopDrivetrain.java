package org.usfirst.frc5112.Robot2017V3.commands.DrivetrainCommands;

import org.usfirst.frc5112.Robot2017V3.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class StopDrivetrain extends Command {

	public StopDrivetrain() {
		requires(Robot.drivetrain);
	}

	/**
	 * Called just before this Command runs the first time
	 */
	protected void initialize() {
		end();
	}

	/**
	 * Called repeatedly when this Command is scheduled to run
	 */
	protected void execute() {
		end();
	}

	/**
	 * Make this return true when this Command no longer needs to run execute()
	 */
	protected boolean isFinished() {
		return true;
	}

	/**
	 * Called once after isFinished returns true
	 */
	protected void end() {
		Robot.drivetrain.stop();
	}

	/**
	 * Called when another command which requires one or more of the same
	 * subsystems is scheduled to run
	 */
	protected void interrupted() {
		end();
	}
}
