package org.usfirst.frc5112.Robot2017V3.commands.TargetingCommands;

import org.usfirst.frc5112.Robot2017V3.Peg;
import org.usfirst.frc5112.Robot2017V3.Robot;
import org.usfirst.frc5112.Robot2017V3.subsystems.TargetingSystem;

import com.kylecorry.frc.vision.CameraSpecs;
import com.kylecorry.geometry.Point;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class GetPegAngle extends Command {

	public static double gyroAngle = 0;

	public GetPegAngle() {
		requires(Robot.targetingSystem);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		// Get the position of the peg in X Y coordinates
		Point gyroPoint = Robot.targetingSystem.getPegPosition(160, CameraSpecs.MicrosoftLifeCam.HORIZONTAL_VIEW_ANGLE,
				new Peg().getGroupWidth());

		// If the target was found, set the angle to the target and put on the
		// Smart Dashboard that it was found
		if (gyroPoint != null) {
			gyroAngle = 90 - TargetingSystem.getAngle(gyroPoint.x, gyroPoint.y);
			SmartDashboard.putBoolean("Target Located?", true);
		} else {
			// If the target was not found, set the angle to something
			// unreasonable and put on
			// the Smart Dashboard that it was not found
			gyroAngle = Double.MAX_VALUE;
			SmartDashboard.putBoolean("Target Located?", false);
		}

	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {

	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return true;
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
