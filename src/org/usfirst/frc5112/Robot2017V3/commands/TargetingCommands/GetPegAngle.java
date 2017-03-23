package org.usfirst.frc5112.Robot2017V3.commands.TargetingCommands;

import org.usfirst.frc5112.Robot2017V3.Peg;
import org.usfirst.frc5112.Robot2017V3.Robot;
import com.kylecorry.frc.vision.CameraSpecs;
import edu.wpi.first.wpilibj.command.Command;

public class GetPegAngle extends Command {

	public static double gyroAngle = 0;

	public GetPegAngle() {
		requires(Robot.targetingSystem);
	}

	// Called just before this Command runs the first time
	protected void initialize() {

		gyroAngle = Robot.targetingSystem.getPegPosition(160, CameraSpecs.MicrosoftLifeCam.HORIZONTAL_VIEW_ANGLE,
				new Peg().getGroupWidth());

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
