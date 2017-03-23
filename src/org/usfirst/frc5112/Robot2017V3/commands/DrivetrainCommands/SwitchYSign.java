package org.usfirst.frc5112.Robot2017V3.commands.DrivetrainCommands;

import org.usfirst.frc5112.Robot2017V3.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class SwitchYSign extends Command {

    public SwitchYSign() {
    }

    protected void initialize() {
    	Robot.drivetrain.swtichYValue();
    }

    protected void execute() {
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
