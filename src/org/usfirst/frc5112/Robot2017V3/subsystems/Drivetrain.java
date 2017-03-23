package org.usfirst.frc5112.Robot2017V3.subsystems;

import org.usfirst.frc5112.Robot2017V3.RobotMap;
import org.usfirst.frc5112.Robot2017V3.commands.DrivetrainCommands.OperatorControl;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
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
	public double switchYSign = -1;
	
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
		drivetrain.arcadeDrive(-speed * switchYSign, -0.03*RobotMap.gyro.getAngle(), false);
	}

	/**
	 * Moves the robot backwards at a specific speed until the Drivetrain.stop()
	 * method is called.
	 * 
	 * @param speed
	 *            The specific speed to move the robot at.
	 */
	public void reverse(double speed) {
		drivetrain.arcadeDrive(speed * switchYSign, -0.03*RobotMap.gyro.getAngle(), false);
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
					drivetrain.arcadeDrive(((joystick.getY() + 0.1) * 10 / 9 * throttle) * switchYSign, joystick.getZ() * turningThrottle);
				}else {
					drivetrain.arcadeDrive(((joystick.getY() - 0.1) * 10 / 9 * throttle) * switchYSign, joystick.getZ() * turningThrottle);
				}
			} else {
				drivetrain.arcadeDrive(0, joystick.getZ() * turningThrottle);
			}
		} else {
			if (joystick.getY() < -0.1 || joystick.getY() > 0.1) {
				if (joystick.getY() <= -0.1){
					drivetrain.arcadeDrive(((joystick.getY() + 0.1) * 10 / 9 * throttle) * switchYSign, joystick.getZ()* -1 * turningThrottle);
				}else {
					drivetrain.arcadeDrive(((joystick.getY() - 0.1) * 10 / 9 * throttle) * switchYSign, joystick.getZ()* -1 * turningThrottle);
				}
			} else {
				drivetrain.arcadeDrive(0, joystick.getZ() * turningThrottle * -1);
			}
		}
	}
	
	public void invertMotors() {
        RobotMap.drivetrainLeft3.setInverted(false);
        RobotMap.drivetrainLeft2.setInverted(false);
        RobotMap.drivetrainLeft1.setInverted(false);
        RobotMap.drivetrainRight3.setInverted(false);
        RobotMap.drivetrainRight2.setInverted(false);
        RobotMap.drivetrainRight1.setInverted(false);
        invertedRotating = true;
	}
	
	public void resetMotorDirection(){
		RobotMap.drivetrainLeft3.setInverted(true);
        RobotMap.drivetrainLeft2.setInverted(true);
        RobotMap.drivetrainLeft1.setInverted(true);
        RobotMap.drivetrainRight3.setInverted(true);
        RobotMap.drivetrainRight2.setInverted(true);
        RobotMap.drivetrainRight1.setInverted(true);
        invertedRotating = false;
	}

	public void swtichYValue() {
		if (switchYSign == 1) {
			switchYSign = -1;
		} else {
			switchYSign = 1;
		}
	}
	
}