package org.usfirst.frc5112.Robot2017V3Test;

import org.usfirst.frc5112.Robot2017V3Test.commands.DrivetrainCommands.DriveForward;
import org.usfirst.frc5112.Robot2017V3Test.commands.DrivetrainCommands.StopDrivetrain;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Drivetrain extends Subsystem {

	private final SpeedController drivetrainLeftMiddle = RobotMap.drivetrainLeftMiddle;
	private final SpeedController drivetrainRightMiddle = RobotMap.drivetrainRightMiddle;
	private final SpeedController drivetrainLeftRear = RobotMap.drivetrainLeftRear;
	private final SpeedController drivetrainRightRear = RobotMap.drivetrainRightRear;
	private final SpeedController drivetrainLeftFront = RobotMap.drivetrainLeftFront;
	private final SpeedController drivetrainRightFront = RobotMap.drivetrainRightFront;

	public double drivetrainSpeed = 0.2;
	
	public void initDefaultCommand() {
		setDefaultCommand(new DriveForward(.25));
	}
	
	public void reverse() {
		drivetrainLeftFront.set(.25);
		drivetrainLeftMiddle.set(.25);
		drivetrainLeftRear.set(.25);
		drivetrainRightFront.set(-.25);
		drivetrainRightMiddle.set(-.25);
		drivetrainRightRear.set(-.25);
	}
	
	public void forward(double speed) {
		reverse();
	}

	public void stop() {
		reverse();
	}
	
	public void increaseDrivetrainSpeed() {
		if (drivetrainSpeed <= 0.95) {
			drivetrainSpeed = drivetrainSpeed + 0.05;
		} else {

		}
	}
	
	public void decreaseDrivetrainSpeed() {
		if (drivetrainSpeed >= 0.05) {
			drivetrainSpeed = drivetrainSpeed - 0.05;
		} else {

		}
	}
	
	public void updateSpeed() {
		SmartDashboard.putNumber("Drivetrain Speed: ", drivetrainSpeed);
	}
	
}