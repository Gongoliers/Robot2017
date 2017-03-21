package org.usfirst.frc5112.Robot2017V3Test;

import com.kylecorry.geometry.Point;
import com.kylecorry.geometry.Pose;
import com.kylecorry.geometry.Quaternion;
import com.kylecorry.tf.TransformationMap;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	public static SpeedController drivetrainLeftMiddle;
	public static SpeedController drivetrainRightMiddle;
	public static SpeedController drivetrainLeftRear;
	public static SpeedController drivetrainRightRear;
	public static SpeedController drivetrainLeftFront;
	public static SpeedController drivetrainRightFront;
	public static SpeedController intakeIntakeMotor;
	public static SpeedController hopperHopperMotor;
	public static SpeedController scalerScalerMotor;
	public static SpeedController shooterFlywheel;
	public static TransformationMap tf;
	
	public static double inchesToMeters(double inches) {
		return inches*0.0254;
		
	}
	public static void init() {
		drivetrainLeftRear = new Jaguar(5);
		LiveWindow.addActuator("Drivetrain", "LeftRear", (Jaguar) drivetrainLeftRear);

		drivetrainRightRear = new Jaguar(0);
		LiveWindow.addActuator("Drivetrain", "RightRear", (Jaguar) drivetrainRightRear);

		drivetrainLeftFront = new Jaguar(3);
		LiveWindow.addActuator("Drivetrain", "LeftFront", (Jaguar) drivetrainLeftFront);

		drivetrainRightFront = new Jaguar(1);
		LiveWindow.addActuator("Drivetrain", "RightFront", (Jaguar) drivetrainRightFront);

		drivetrainLeftMiddle = new Jaguar(4);
		LiveWindow.addActuator("Drivetrain", "LeftMiddle", (Jaguar) drivetrainLeftMiddle);
		
		drivetrainRightMiddle = new Jaguar(2);
		LiveWindow.addActuator("Drivetrain", "RightMiddle", (Jaguar) drivetrainRightMiddle);

	}
}
