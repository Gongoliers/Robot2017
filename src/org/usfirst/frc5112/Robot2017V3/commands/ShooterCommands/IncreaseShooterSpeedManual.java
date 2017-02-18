package org.usfirst.frc5112.Robot2017V3.commands.ShooterCommands;

import org.usfirst.frc5112.Robot2017V3.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class IncreaseShooterSpeedManual extends Command {

    public IncreaseShooterSpeedManual() {
        requires(Robot.shooter);
    }

    protected void initialize() {
    	Robot.shooter.increaseShooterSpeed();
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
