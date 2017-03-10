package org.usfirst.frc5112.Robot2017V3.subsystems;

import java.util.List;

import org.opencv.core.Mat;
import org.usfirst.frc5112.Robot2017V3.Peg;
import org.usfirst.frc5112.Robot2017V3.PegRetroreflective;
import org.usfirst.frc5112.Robot2017V3.RobotMap;

import com.kylecorry.frc.vision.TargetGroup;
import com.kylecorry.frc.vision.TargetGroupDetector;
import com.kylecorry.geometry.Point;

import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.command.Subsystem;

public class TargetingSystem extends Subsystem {

	public static final String TARGET_LOCATED_KEY = "Target Located?";

	private TargetGroupDetector pegDetect;
	private CvSink sink;
	private Mat source;
	private UsbCamera camera;

	public TargetingSystem() {
		// Create camera instance
		camera = CameraServer.getInstance().startAutomaticCapture();
		camera.setResolution(160, 120);

		// Disable the targeting mode
		disableTargetMode();

		// Create peg detector
		pegDetect = new TargetGroupDetector(new PegRetroreflective(), new Peg());

		// Setup ability to get images from camera
		source = new Mat();
		sink = new CvSink("cam0");
		sink.setSource(camera);

	}

	public Point getPegPosition(int imageWidth, double cameraViewAngle, double targetActualWidth) {
		// Get the peg target
		TargetGroup point = getPegTarget();

		if (point == null) {
			// Target was not found
			return null;
		}
		// Get the angle of the target in radians
		double angle = Math.toRadians(90 - point.computeAngle(imageWidth, cameraViewAngle));

		// Get the distance to the target in meters
		double distance = point.computeDistance(imageWidth, targetActualWidth, cameraViewAngle);

		// Convert the target from polar to cartesian
		Point targetPoint = Point.fromCylindrical(distance, angle, 0);

		// Get the target with respect to the holster
		Point targetFromHolster = RobotMap.tf.transform(targetPoint, "PegCamera", "GearHolster");
		return targetFromHolster;
	}

	public static double getDistance(double x, double y) {
		return Math.sqrt(x * x + y * y);
	}

	public static double getAngle(double x, double y) {
		return Math.toDegrees(Math.atan2(y, x));
	}

	public void initDefaultCommand() {
		// setDefaultCommand(new TargetingModeOff());
	}

	public TargetGroup getPegTarget() {
		// Get the latest image from the camera
		sink.grabFrame(source);

		// Detect the peg target
		List<TargetGroup> targetGroups = pegDetect.detect(source);

		// Ensure that a target was found, return null if it was not
		if (!targetGroups.isEmpty()) {
			// Get the most confident target
			return targetGroups.get(0);
		}
		return null;
	}

	public void enableTargetMode() {
		// Camera settings of target mode
		camera.setBrightness(0);
		camera.setExposureManual(0);
		camera.setWhiteBalanceManual(10000);
	}

	public void disableTargetMode() {
		// Camera settings of normal mode
		camera.setBrightness(50);
		camera.setExposureAuto();
		camera.setWhiteBalanceAuto();
	}
}
