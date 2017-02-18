package org.usfirst.frc5112.Robot2017V3.commands.DrivetrainCommands;
import org.usfirst.frc5112.Robot2017V3.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class RestoreMotorDirection extends Command {

    public RestoreMotorDirection() {
        requires(Robot.drivetrain);
    }

    /**
     *  Called just before this Command runs the first time
     */
    protected void initialize() {
    	Robot.drivetrain.resetMotorDirection();
    }

    /**
     *  Called repeatedly when this Command is scheduled to run
     */
    protected void execute() {
    }

    /**
     *  Make this return true when this Command no longer needs to run execute()
     */
    protected boolean isFinished() {
        return true;
    }

    /**
     *  Called once after isFinished returns true
     */
    protected void end() {
    }

    /** Called when another command which requires one or more of the same
     * subsystems is scheduled to run
     */
    protected void interrupted() {
    	end();
    }
}