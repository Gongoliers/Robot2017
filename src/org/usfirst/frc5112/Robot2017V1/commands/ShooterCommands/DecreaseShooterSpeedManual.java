package org.usfirst.frc5112.Robot2017V1.commands.ShooterCommands;

import org.usfirst.frc5112.Robot2017V1.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DecreaseShooterSpeedManual extends Command {

    public DecreaseShooterSpeedManual() {
        requires(Robot.shooter);
    }

    protected void initialize() {
    	Robot.shooter.decreaseShooterSpeed();
    }

    
    protected void execute() {
    }

    
    protected boolean isFinished() {
        return true;
    }

    
    protected void end() {
    	SmartDashboard.putNumber("ShooterSpeedDisplay", Robot.shooter.shooterSpeed);
    }

    
    protected void interrupted() {
    	end();
    }
}
