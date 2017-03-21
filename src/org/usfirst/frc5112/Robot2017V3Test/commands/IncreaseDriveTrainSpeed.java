package org.usfirst.frc5112.Robot2017V3Test.commands;

import org.usfirst.frc5112.Robot2017V3Test.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class IncreaseDriveTrainSpeed extends Command {

    public IncreaseDriveTrainSpeed() {
    }

    protected void initialize() {
    	Robot.drivetrain.increaseDrivetrainSpeed();
    	Robot.drivetrain.updateSpeed();
    }

    protected void execute() {
    	end();
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    	Robot.drivetrain.stop();
    }

    protected void interrupted() {
    	end();
    }
}
