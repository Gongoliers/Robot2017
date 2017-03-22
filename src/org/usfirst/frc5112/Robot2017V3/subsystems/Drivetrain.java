package org.usfirst.frc5112.Robot2017V3.subsystems;

import org.usfirst.frc5112.Robot2017V3.RobotMap;
import org.usfirst.frc5112.Robot2017V3.commands.DrivetrainCommands.OperatorControl;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Drivetrain extends Subsystem {

	private final RobotDrive drivetrain = RobotMap.drivetrainDrivetrain;
	
	private boolean invertedRotating = false;
	private double throttle = 0.7;
	private double turningThrottle = 0.7;
	private final double INITIAL_THROTTLE = 0.7;
	private final double FINAL_THROTTLE = 1.0;
	
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
		drivetrain.arcadeDrive(-speed, -0.03*RobotMap.gyro.getAngle(), false);
	}

	/**
	 * Moves the robot backwards at a specific speed until the Drivetrain.stop()
	 * method is called.
	 * 
	 * @param speed
	 *            The specific speed to move the robot at.
	 */
	public void reverse(double speed) {
		drivetrain.arcadeDrive(speed, -0.03*RobotMap.gyro.getAngle(), false);
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
		if (joystick.getRawButton(1)) {
			throttle = FINAL_THROTTLE;
		} else {
			throttle = INITIAL_THROTTLE;
		}
		if (!invertedRotating) {
			if (joystick.getY() < -0.1 || joystick.getY() > 0.1) {
				if (joystick.getY() <= -0.1){
					drivetrain.arcadeDrive(((joystick.getY() + 0.1) * 10 / 9 * throttle), joystick.getZ() * turningThrottle);
				}else {
					drivetrain.arcadeDrive(((joystick.getY() - 0.1) * 10 / 9 * throttle), joystick.getZ() * turningThrottle);
				}
			} else {
				drivetrain.arcadeDrive(0, joystick.getZ() * turningThrottle);
			}
		} else {
			if (joystick.getY() < -0.1 || joystick.getY() > 0.1) {
				if (joystick.getY() <= -0.1){
					drivetrain.arcadeDrive(((joystick.getY() + 0.1) * 10 / 9 * throttle), joystick.getZ()* -1 * turningThrottle);
				}else {
					drivetrain.arcadeDrive(((joystick.getY() - 0.1) * 10 / 9 * throttle), joystick.getZ()* -1 * turningThrottle);
				}
			} else {
				drivetrain.arcadeDrive(0, joystick.getZ() * turningThrottle * -1);
			}
		}
	}
	
	public void invertMotors() {
        RobotMap.drivetrainLeftFront.setInverted(false);
        RobotMap.drivetrainLeftMiddle.setInverted(false);
        RobotMap.drivetrainLeftRear.setInverted(false);
        RobotMap.drivetrainRightFront.setInverted(false);
        RobotMap.drivetrainRightMiddle.setInverted(false);
        RobotMap.drivetrainRightRear.setInverted(false);
        invertedRotating = true;
	}
	
	public void resetMotorDirection(){
		RobotMap.drivetrainLeftFront.setInverted(true);
        RobotMap.drivetrainLeftMiddle.setInverted(true);
        RobotMap.drivetrainLeftRear.setInverted(true);
        RobotMap.drivetrainRightFront.setInverted(true);
        RobotMap.drivetrainRightMiddle.setInverted(true);
        RobotMap.drivetrainRightRear.setInverted(true);
        invertedRotating = false;
	}
	
}