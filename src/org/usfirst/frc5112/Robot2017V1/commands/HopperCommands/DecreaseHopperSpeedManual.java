package org.usfirst.frc5112.Robot2017V1.commands.HopperCommands;

import org.usfirst.frc5112.Robot2017V1.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DecreaseHopperSpeedManual extends Command {

    public DecreaseHopperSpeedManual() {
        requires(Robot.hopper);
    }

    protected void initialize() {
    	Robot.hopper.decreaseHopperSpeed();
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
