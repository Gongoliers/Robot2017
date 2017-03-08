package org.usfirst.frc5112.Robot2017V3.subsystems;

import java.util.List;

import org.opencv.core.Mat;
import org.usfirst.frc5112.Robot2017V3.Peg;
import org.usfirst.frc5112.Robot2017V3.PegRetroreflective;
import org.usfirst.frc5112.Robot2017V3.RobotMap;

/*import org.usfirst.frc5112.Robot2017V3.Boiler;
import org.usfirst.frc5112.Robot2017V3.BoilerRetroSpecs;
import org.usfirst.frc5112.Robot2017V3.Peg;
import org.usfirst.frc5112.Robot2017V3.PegRetroreflective;*/
//import org.usfirst.frc5112.Robot2017V3.commands.TargetingCommands.TargetingModeOff;

import com.kylecorry.frc.vision.CameraSource;
import com.kylecorry.frc.vision.TargetGroup;
import com.kylecorry.frc.vision.TargetGroupDetector;
import com.kylecorry.geometry.Point;

import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.cscore.VideoCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.command.Subsystem;


public class TargetingSystem extends Subsystem {

	private TargetGroupDetector pegDetect;
	private CvSink sink;
	private Mat output;
	private Mat source;
	
	
	// TODO: Put methods for controlling this subsystem
	// here. Call these from Commands.
	public TargetingSystem() {
		UsbCamera camera = CameraServer.getInstance().startAutomaticCapture();
		camera.setResolution(160, 120);
		camera.setBrightness(50);
		camera.setExposureAuto();
		camera.setWhiteBalanceAuto();
//		camera.setBrightness(0);
//		camera.setExposureManual(0);
//		camera.setWhiteBalanceManual(10000);
		pegDetect = new TargetGroupDetector(new PegRetroreflective(), new Peg());
		output = new Mat();
		source = new Mat();
		sink = new CvSink("cam0");
		sink.setSource(camera);


	}
	
	public double getPegPosition(int imageWidth, double cameraViewAngle, double targetActualWidth) {
		TargetGroup point = getPegTarget();
		if(point == null){
			return 0;
		}
		double angle = point.computeAngle(imageWidth, cameraViewAngle);
		double distance = point.computeDistance(imageWidth, targetActualWidth, cameraViewAngle);
		return angle;
//		Point targetPoint = Point.fromCylindrical(distance, angle, 0);
//		Point targetFromShooter = RobotMap.tf.transform(targetPoint, "PegCamera", "GearHolster");
//		return targetPoint;
	}

	public static double getDistance(double x, double y) {
		return Math.sqrt(x * x + y * y);
	}

	public static double getAngle(double x, double y) {
		return Math.toDegrees(Math.atan2(y, x));
	}

	public void initDefaultCommand() {
		//setDefaultCommand(new TargetingModeOff());
	}

	public TargetGroup getPegTarget() {
		sink.grabFrame(source);
		List<TargetGroup> targetGroups = pegDetect.detect(source);
		if (!targetGroups.isEmpty()) {
			return targetGroups.get(0);
		}
		return null;
	}
}
