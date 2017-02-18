package org.usfirst.frc5112.Robot2017V3.commands.DrivetrainCommands;

import org.usfirst.frc5112.Robot2017V3.Robot;
import org.usfirst.frc5112.Robot2017V3.RobotMap;

import com.thegongoliers.output.PID;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class RotateDegreesToPeg extends Command {

	private PID pidController;
	private double targetAngle;
	private boolean goal = false;

	public RotateDegreesToPeg(double targetAngle) {
		requires(Robot.drivetrain);
		this.targetAngle = targetAngle;
		setTimeout(3);
	}

	public RotateDegreesToPeg() {
		requires(Robot.drivetrain);
		goal = true;
		setTimeout(4);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		if (goal) {
			targetAngle = org.usfirst.frc5112.Robot2017V3.commands.TargetingCommands.GetPegAngle.gyroAngle;
		}

		targetAngle += RobotMap.gyro.getAngle();
		pidController = new PID(0.12/2, 0, 0.06, 0);// RobotMap.robotCamera.getViewAngle()/2*0.02);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		//SmartDashboard.putNumber("Heading", RobotMap.gyro.getAngle());
		Robot.drivetrain.rotateClockwise(pidController.getOutput(RobotMap.gyro.getAngle(), targetAngle));
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return pidController.isAtTargetPosition(RobotMap.gyro.getAngle(), targetAngle) || isTimedOut();
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.drivetrain.stop();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
