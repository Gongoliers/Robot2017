package org.usfirst.frc5112.Robot2017V3.commands.ScalerCommands;

import org.usfirst.frc5112.Robot2017V3.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class IncreaseScalerSpeedManual extends Command {

	    public IncreaseScalerSpeedManual() {
	        requires(Robot.scaler);
	    }

	    protected void initialize() {
	    	Robot.scaler.increaseScalerSpeed();
	    }

	    
	    protected void execute() {
	    }

	    
	    protected boolean isFinished() {
	        return true;
	    }

	    
	    protected void end() {
	    	SmartDashboard.putNumber("ScalerSpeedDisplay", Robot.scaler.scalerSpeed);
	    }

	    
	    protected void interrupted() {
	    	end();
	    }
	}