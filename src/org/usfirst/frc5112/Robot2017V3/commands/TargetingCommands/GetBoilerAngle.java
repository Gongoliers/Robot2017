package org.usfirst.frc5112.Robot2017V3.commands.TargetingCommands;

import org.usfirst.frc5112.Robot2017V3.BoilerRetroSpecs;
import org.usfirst.frc5112.Robot2017V3.Robot;
import org.usfirst.frc5112.Robot2017V3.subsystems.TargetingSystem;

import com.kylecorry.frc.vision.CameraSpecs;
import com.kylecorry.geometry.Point;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class GetBoilerAngle extends Command {

	public static double gyroAngle = 0;

	public GetBoilerAngle() {
		requires(Robot.targetingSystem);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		Robot.targetingSystem.enableBoilerCamera();
		Point gyroPoint = Robot.targetingSystem.getBoilerPosition(640, CameraSpecs.MicrosoftLifeCam.HORIZONTAL_VIEW_ANGLE,
				new BoilerRetroSpecs().getWidth());
		if (gyroPoint != null) {
			gyroAngle = TargetingSystem.getAngle(gyroPoint.x, gyroPoint.y) - 90;
		}
		else{
			gyroAngle = Double.MAX_VALUE;
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
