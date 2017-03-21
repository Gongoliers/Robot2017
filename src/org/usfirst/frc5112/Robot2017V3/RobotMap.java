package org.usfirst.frc5112.Robot2017V3;

import com.kylecorry.geometry.Point;
import com.kylecorry.geometry.Pose;
import com.kylecorry.geometry.Quaternion;
import com.kylecorry.tf.TransformationMap;
import com.thegongoliers.hardware.Hardware;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	public static SpeedController drivetrainLeftRear;
	public static SpeedController drivetrainLeftMiddle;
	public static SpeedController drivetrainLeftFront;
	public static SpeedController drivetrainRightRear;
	public static SpeedController drivetrainRightMiddle;
	public static SpeedController drivetrainRightFront;
	public static RobotDrive drivetrainDrivetrain;
	public static SpeedController scalerScalerMotor;
	public static TransformationMap tf;
	public static AnalogGyro gyro;

	public static double inchesToMeters(double inches) {
		return inches * 0.0254;

	}

	public static void init() {
		drivetrainLeftRear = new VictorSP(3);
		LiveWindow.addActuator("Drivetrain", "LeftRear", (VictorSP) drivetrainLeftRear);

		drivetrainLeftMiddle = new VictorSP(4);
		LiveWindow.addActuator("Drivetrain", "LeftMiddle", (VictorSP) drivetrainLeftMiddle);

		drivetrainLeftFront = new VictorSP(2);
		LiveWindow.addActuator("Drivetrain", "LeftFront", (VictorSP) drivetrainLeftFront);

		drivetrainRightRear = new VictorSP(0);
		LiveWindow.addActuator("Drivetrain", "RightRear", (VictorSP) drivetrainRightRear);

		drivetrainRightMiddle = new VictorSP(5);
		LiveWindow.addActuator("Drivetrain", "RightMiddle", (VictorSP) drivetrainRightMiddle);

		drivetrainRightFront = new VictorSP(1);
		LiveWindow.addActuator("Drivetrain", "RightFront", (VictorSP) drivetrainRightFront);

		drivetrainDrivetrain = new RobotDrive(Hardware.joinMotors(drivetrainLeftFront, drivetrainLeftMiddle),
				drivetrainLeftRear, Hardware.joinMotors(drivetrainRightFront, drivetrainRightMiddle),
				drivetrainRightRear);

		drivetrainDrivetrain.setSafetyEnabled(true);
		drivetrainDrivetrain.setExpiration(0.1);
		drivetrainDrivetrain.setSensitivity(0.5);
		drivetrainDrivetrain.setMaxOutput(1.0);

		drivetrainDrivetrain.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);
		drivetrainDrivetrain.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);
		drivetrainDrivetrain.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, true);
		drivetrainDrivetrain.setInvertedMotor(RobotDrive.MotorType.kRearLeft, true);

		scalerScalerMotor = new Victor(6);
		LiveWindow.addActuator("Scaler", "ScalerMotor", (Victor) scalerScalerMotor);

		gyro = new AnalogGyro(0);
		gyro.initGyro();
		gyro.calibrate();

		tf = new TransformationMap();
		tf.put("PegCamera",
				new Pose(new Point(inchesToMeters(-11.25), inchesToMeters(16), inchesToMeters(12)), Quaternion.zero));
		tf.put("GearHolster",
				new Pose(new Point(inchesToMeters(0.5), inchesToMeters(14.75), inchesToMeters(14)), Quaternion.zero));

	}
}
