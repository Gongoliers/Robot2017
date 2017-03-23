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
	public static SpeedController drivetrainLeft1;
	public static SpeedController drivetrainLeft2;
	public static SpeedController drivetrainLeft3;
	public static SpeedController drivetrainRight1;
	public static SpeedController drivetrainRight2;
	public static SpeedController drivetrainRight3;
	public static RobotDrive drivetrainDrivetrain;
	public static SpeedController scalerScalerMotor;
	public static TransformationMap tf;
	public static AnalogGyro gyro;

	private final static int BLACK_PORT = 0;
	private final static int BROWN_PORT = 1;
	private final static int RED_PORT = 2;
	private final static int ORANGE_PORT = 3;
	private final static int YELLOW_PORT = 4;
	private final static int PURPLE_PORT = 5;
	private final static int GREEN_PORT = 6;
//	private final static int BLUE_PORT = 7;
	private final static int GREY_PORT = 0;

	public static double inchesToMeters(double inches) {
		return inches * 0.0254;

	}

	public static void init() {
		drivetrainLeft1 = new VictorSP(ORANGE_PORT);
		LiveWindow.addActuator("Drivetrain", "Left1", (VictorSP) drivetrainLeft1);

		drivetrainLeft2 = new VictorSP(RED_PORT);
		LiveWindow.addActuator("Drivetrain", "Left2", (VictorSP) drivetrainLeft2);

		drivetrainLeft3 = new Victor(YELLOW_PORT);
		LiveWindow.addActuator("Drivetrain", "Left3", (Victor) drivetrainLeft3);

		drivetrainRight1 = new VictorSP(BROWN_PORT);
		LiveWindow.addActuator("Drivetrain", "Right1", (VictorSP) drivetrainRight1);

		drivetrainRight2 = new VictorSP(BLACK_PORT);
		LiveWindow.addActuator("Drivetrain", "Right2", (VictorSP) drivetrainRight2);

		drivetrainRight3 = new Victor(PURPLE_PORT);
		LiveWindow.addActuator("Drivetrain", "Right3", (Victor) drivetrainRight3);

		SpeedController drivetrainLeft = Hardware.joinMotors(drivetrainLeft1, drivetrainLeft2, drivetrainLeft3);
		SpeedController drivetrainRight = Hardware.joinMotors(drivetrainRight1, drivetrainRight2, drivetrainRight3);

		drivetrainDrivetrain = new RobotDrive(drivetrainLeft, drivetrainRight);

		drivetrainDrivetrain.setSafetyEnabled(true);
		drivetrainDrivetrain.setExpiration(0.1);
		drivetrainDrivetrain.setSensitivity(0.5);
		drivetrainDrivetrain.setMaxOutput(1.0);

		drivetrainLeft.setInverted(true);
		drivetrainRight.setInverted(true);
		
		scalerScalerMotor = new Victor(GREEN_PORT);
		LiveWindow.addActuator("Scaler", "ScalerMotor", (Victor) scalerScalerMotor);

		gyro = new AnalogGyro(GREY_PORT);
		gyro.initGyro();
		gyro.calibrate();

		tf = new TransformationMap();
		tf.put("PegCamera",
				new Pose(new Point(inchesToMeters(-11.25), inchesToMeters(16), inchesToMeters(12)), Quaternion.zero));
		tf.put("GearHolster",
				new Pose(new Point(inchesToMeters(0.5), inchesToMeters(14.75), inchesToMeters(14)), Quaternion.zero));

	}
}
