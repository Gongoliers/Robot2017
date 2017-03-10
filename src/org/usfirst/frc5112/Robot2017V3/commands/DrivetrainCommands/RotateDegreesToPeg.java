package org.usfirst.frc5112.Robot2017V3.commands.DrivetrainCommands;

import org.usfirst.frc5112.Robot2017V3.Robot;
import org.usfirst.frc5112.Robot2017V3.RobotMap;
import org.usfirst.frc5112.Robot2017V3.commands.TargetingCommands.GetPegAngle;
import org.usfirst.frc5112.Robot2017V3.subsystems.TargetingSystem;

import com.thegongoliers.output.PID;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

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

		// If the robot is supposed to rotate to the target, set the target
		// angle to that of the target
		if (goal) {
			targetAngle = GetPegAngle.gyroAngle;
		}

		// If the target was not found, don't rotate - set the target angle to
		// the current angle
		if (!SmartDashboard.getBoolean(TargetingSystem.TARGET_LOCATED_KEY, false)) {
			targetAngle = RobotMap.gyro.getAngle();
		} else {
			// Else, add the current angle to the angle to the target
			targetAngle += RobotMap.gyro.getAngle();
		}

		// Create the PID controller for rotating to the target
		// TODO: The P value (first) may need to be tuned
		pidController = new PID(0.06, 0, 0.06, 0);

		// Display the target angle on the Smart Dashboard
		SmartDashboard.putNumber("Target angle", targetAngle);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		// Display the gyro heading on the Smart Dashboard
		SmartDashboard.putNumber("Heading", RobotMap.gyro.getAngle());

		// Rotate towards the target
		Robot.drivetrain.rotateClockwise(pidController.getOutput(RobotMap.gyro.getAngle(), targetAngle));
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		// Stop if timed out or aligned with the target
		return pidController.isAtTargetPosition(RobotMap.gyro.getAngle(), targetAngle) || isTimedOut();
	}

	// Called once after isFinished returns true
	protected void end() {
		// Stop rotating
		Robot.drivetrain.stop();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
