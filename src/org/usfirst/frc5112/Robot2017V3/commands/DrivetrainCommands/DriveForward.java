package org.usfirst.frc5112.Robot2017V3.commands.DrivetrainCommands;

import org.usfirst.frc5112.Robot2017V3.Robot;
import org.usfirst.frc5112.Robot2017V3.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveForward extends Command {

	private double y;
	public DriveForward(double x) {
		requires(Robot.drivetrain);
		y = x;
	}

	/**
	 * Called just before this Command runs the first time
	 */
	protected void initialize() {
		RobotMap.gyro.reset();
	}

	/**
	 * Called repeatedly when this Command is scheduled to run
	 */
	protected void execute() {
		Robot.drivetrain.forward(y);
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