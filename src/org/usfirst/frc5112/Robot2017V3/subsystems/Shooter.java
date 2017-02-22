package org.usfirst.frc5112.Robot2017V3.subsystems;

import org.usfirst.frc5112.Robot2017V3.RobotMap;
import org.usfirst.frc5112.Robot2017V3.commands.ShooterCommands.StopShooter;

import com.thegongoliers.output.interfaces.FlywheelInterface;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Shooter extends Subsystem implements FlywheelInterface {

	public double shooterSpeed = 0.25;
	public double shooterSpeedFinal = 0.425;
	
	private final SpeedController flywheel = RobotMap.shooterFlywheel;

	public void initDefaultCommand() {
		setDefaultCommand(new StopShooter());
	}

	@Override
	public void stop() {
		flywheel.stopMotor();

	}

	@Override
	public void spinOutward(double speed) {
		flywheel.set(speed);

	}

	public void increaseShooterSpeed() {
		if (shooterSpeed <= 0.975) {
			shooterSpeed = shooterSpeed + 0.025;
		} else {
			shooterSpeed = 1.00;
		}
	}

	public void decreaseShooterSpeed() {
		if (shooterSpeed >= 0.025) {
			shooterSpeed = shooterSpeed - 0.025;
		} else {
			shooterSpeed = 0.00;
		}
	}

	public double shooterSpeed() {
		return shooterSpeed;
	}

	@Override
	public void spinInward(double speed) {
		spinOutward(-speed);

	}
}
