package org.usfirst.frc5112.Robot2017V3.subsystems;

import java.util.List;

import org.usfirst.frc5112.Robot2017V3.Peg;
import org.usfirst.frc5112.Robot2017V3.PegRetroreflective;
import org.usfirst.frc5112.Robot2017V3.RobotMap;
import org.usfirst.frc5112.Robot2017V3.commands.TargetingCommands.TargetingModeOff;

import com.kylecorry.frc.vision.CameraSource;
import com.kylecorry.frc.vision.TargetGroup;
import com.kylecorry.frc.vision.TargetGroupDetector;
import com.kylecorry.geometry.Point;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.cscore.VideoCamera;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class TargetingSystem extends Subsystem {

	private TargetGroupDetector boilerDetector, pegDetector;
	private CameraSource currentCamera, pegCamera, boilerCamera;

	// TODO: Put methods for controlling this subsystem
	// here. Call these from Commands.
	public TargetingSystem() {
		boilerDetector = new TargetGroupDetector(null, null);
		pegDetector = new TargetGroupDetector(new PegRetroreflective(), new Peg());
		VideoCamera cam0 = new UsbCamera("peg", 0);
		cam0.setResolution(640, 480);
		VideoCamera cam1 = new UsbCamera("boiler", 1);
		cam1.setResolution(640, 480);
		pegCamera = new CameraSource(cam0);
		boilerCamera = new CameraSource(cam1);	
		enableTargetMode(pegCamera);
		enableTargetMode(boilerCamera);
		enablePegCamera();
	}
	
	public void enablePegCamera() {
		boilerCamera.stop();
		pegCamera.start();
		currentCamera = pegCamera;
	}
	
	public void enableBoilerCamera() {
		pegCamera.stop();
		boilerCamera.start();
		currentCamera = boilerCamera;
	}
	
	public Point getBoilerPosition(int imageWidth, double cameraViewAngle, double targetActualWidth) {
		TargetGroup point = getBoilerTarget();
		if(point == null){
			return null;
		}
		double angle = Math.toRadians(90 - point.computeAngle(imageWidth, cameraViewAngle));
		double distance = point.computeDistance(imageWidth, targetActualWidth, cameraViewAngle);
		Point targetPoint = Point.fromCylindrical(distance, angle, 0);
		Point targetFromShooter = RobotMap.tf.transform(targetPoint, "BoilerCamera", "Shooter");
		return targetFromShooter;
	}
	
	public Point getPegPosition(int imageWidth, double cameraViewAngle, double targetActualWidth) {
		TargetGroup point = getPegTarget();
		if(point == null){
			return null;
		}
		double angle = Math.toRadians(90 - point.computeAngle(imageWidth, cameraViewAngle));
		double distance = point.computeDistance(imageWidth, targetActualWidth, cameraViewAngle);
		Point targetPoint = Point.fromCylindrical(distance, angle, 0);
		Point targetFromShooter = RobotMap.tf.transform(targetPoint, "PegCamera", "Shooter");
		return targetFromShooter;
	}

	public static double getDistance(double x, double y) {
		return Math.sqrt(x * x + y * y);
	}

	public static double getAngle(double x, double y) {
		return Math.toDegrees(Math.atan2(y, x));
	}

	public void initDefaultCommand() {
		setDefaultCommand(new TargetingModeOff());
	}

	public TargetGroup getBoilerTarget() {
		List<TargetGroup> targetGroups = boilerDetector.detect(currentCamera.getPicture());
		if (!targetGroups.isEmpty()) {
			return targetGroups.get(0);
		}
		return null;
	}

	public TargetGroup getPegTarget() {
		List<TargetGroup> targetGroups = pegDetector.detect(currentCamera.getPicture());
		if (!targetGroups.isEmpty()) {
			return targetGroups.get(0);
		}
		return null;
	}

	public void enableTargetMode(CameraSource camera) {
		camera.setBrightness(0);
		camera.setExposure(0);
	}

	public void disableTargetMode(CameraSource camera) {
		camera.setBrightness(50);
		camera.setExposure(20);
	}
}