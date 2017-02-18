package org.usfirst.frc5112.Robot2017V1.commands.DrivetrainCommands;

import org.usfirst.frc5112.Robot2017V1.Robot;
import org.usfirst.frc5112.Robot2017V1.RobotMap;

import com.thegongoliers.output.PID;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class RotateDegreesToHighGoal extends Command {

	private PID pidController;
	private double targetAngle;
	private boolean goal = false;

	public RotateDegreesToHighGoal(double targetAngle) {
		requires(Robot.drivetrain);
		this.targetAngle = targetAngle;
		setTimeout(3);
	}

	public RotateDegreesToHighGoal() {
		requires(Robot.drivetrain);
		goal = true;
		setTimeout(4);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		if (goal) {
			targetAngle = org.usfirst.frc5112.Robot2017V1.commands.TargetingCommands.GetBoilerAngle.gyroAngle;
		}

		targetAngle += RobotMap.gyro.getAngle();
		pidController = new PID(0.12/2, 0, 0.06, 0);
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
