package org.usfirst.frc5112.Robot2017V1.subsystems;

import org.usfirst.frc5112.Robot2017V1.RobotMap;
import org.usfirst.frc5112.Robot2017V1.commands.DrivetrainCommands.OperatorControl;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Drivetrain extends Subsystem {

	// private final SpeedController leftRear = RobotMap.drivetrainLeftRear;
	// private final SpeedController rightRear = RobotMap.drivetrainRightRear;
	// private final SpeedController leftFront = RobotMap.drivetrainLeftFront;
	// private final SpeedController rightFront = RobotMap.drivetrainRightFront;
	private final RobotDrive drivetrain = RobotMap.drivetrainDrivetrain;
	
	private boolean invertedRotating = false;
	
	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	/**
	 * 
	 */
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		setDefaultCommand(new OperatorControl());
	}

	/**
	 * Moves the robot forward at a specific speed until the Drivetrain.stop()
	 * method is called.
	 * 
	 * @param speed
	 *            The specific speed to move the robot at.
	 */
	public void forward(double speed) {
		drivetrain.drive(-speed, 0);
	}

	/**
	 * Moves the robot backwards at a specific speed until the Drivetrain.stop()
	 * method is called.
	 * 
	 * @param speed
	 *            The specific speed to move the robot at.
	 */
	public void reverse(double speed) {
		drivetrain.drive(speed, 0);
	}

	/**
	 * Moves the robot forward at a specific speed until the Drivetrain.stop()
	 * method is called or until the time has expired.
	 * 
	 * @param speed
	 *            The specific speed to move the robot at.
	 * @param time
	 *            The time to move the robot for in seconds.
	 */
	public void forward(double speed, double time) {
		drivetrain.drive(-speed, 0);
		Timer.delay(time);
	}

	/**
	 * Moves the robot backwards at a specific speed until the Drivetrain.stop()
	 * method is called or until the time has expired.
	 * 
	 * @param speed
	 *            The specific speed to move the robot at.
	 * @param time
	 *            The time to move the robot for in seconds.
	 */
	public void reverse(double speed, double time) {
		drivetrain.drive(speed, 0);
		Timer.delay(time);
	}
	
	/**
	 * Rotates the robot in the clockwise direction (to the right).
	 * @param speed Specifies the speed to rotate the robot at.
	 */
	public void rotateClockwise(double speed) {
		drivetrain.arcadeDrive(0, speed);
	}
	
	/**
	 * Rotates the robot in the counterclockwise direction (to the left).
	 * @param speed Specifies the speed to rotate the robot at.
	 */
	public void rotateCounterclockwise(double speed) {
		drivetrain.arcadeDrive(0, -speed);
	}
	
	/**
	 * Stops all ongoing movements from the drivetrain.
	 */
	public void stop() {
		drivetrain.drive(0, 0);
	}

	public void operatorControl(Joystick joystick) {
//		drivetrain.arcadeDrive(joystick.getY(), joystick.getZ());
		if (!invertedRotating) {
			if (joystick.getY() < -0.1 || joystick.getY() > 0.1) {
				if (joystick.getY() <= -0.1){
					drivetrain.arcadeDrive(((joystick.getY() + 0.1) * 10 / 9), joystick.getZ()*0.75);
				}else {
					drivetrain.arcadeDrive(((joystick.getY() - 0.1) * 10 / 9), joystick.getZ()*0.75);
				}
			} else {
				drivetrain.arcadeDrive(0, joystick.getZ()*0.75);
			}
		} else {
			if (joystick.getY() < -0.1 || joystick.getY() > 0.1) {
				if (joystick.getY() <= -0.1){
					drivetrain.arcadeDrive(((joystick.getY() + 0.1) * 10 / 9), joystick.getZ()*0.75 * -1);
				}else {
					drivetrain.arcadeDrive(((joystick.getY() - 0.1) * 10 / 9), joystick.getZ()*0.75 * -1);
				}
			} else {
				drivetrain.arcadeDrive(0, joystick.getZ()*0.75 * -1);
			}
		}
	}
	
	public void invertMotors() {
		drivetrain.setInvertedMotor(RobotDrive.MotorType.kFrontRight, false);
		drivetrain.setInvertedMotor(RobotDrive.MotorType.kRearRight, false);
		drivetrain.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, false);
        drivetrain.setInvertedMotor(RobotDrive.MotorType.kRearLeft, false);
        invertedRotating = true;
	}
	
	public void resetMotorDirection(){
		drivetrain.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);
		drivetrain.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);
		drivetrain.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, true);
        drivetrain.setInvertedMotor(RobotDrive.MotorType.kRearLeft, true);
        invertedRotating = false;
	}
	
}