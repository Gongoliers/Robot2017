package org.usfirst.frc5112.Robot2017V3.commands.ScalerCommands;

import org.usfirst.frc5112.Robot2017V3.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DecreaseScalerSpeedManual extends Command {

	    public DecreaseScalerSpeedManual() {
	        requires(Robot.scaler);
	    }

	    protected void initialize() {
	    	Robot.scaler.decreaseScalerSpeed();
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