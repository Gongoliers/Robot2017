package org.usfirst.frc5112.Robot2017V3.commands.HopperCommands;

import org.usfirst.frc5112.Robot2017V3.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class IncreaseHopperSpeedManual extends Command {

    public IncreaseHopperSpeedManual() {
        requires(Robot.hopper);
    }

    protected void initialize() {
    	Robot.hopper.increaseHopperSpeed();
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    	SmartDashboard.putNumber("HopperSpeedDisplay", Robot.hopper.hopperSpeed);
    }

    protected void interrupted() {
    	end();
    }
}
