package org.usfirst.frc5112.Robot2017V1.subsystems;

import org.usfirst.frc5112.Robot2017V1.RobotMap;
import org.usfirst.frc5112.Robot2017V1.commands.IntakeCommands.StopIntake;

import com.thegongoliers.output.interfaces.IntakeInterface;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Intake extends Subsystem implements IntakeInterface {

	private final SpeedController intakeMotor = RobotMap.intakeIntakeMotor;
	public double intakeSpeed = 0.25;
	
	public void initDefaultCommand() {
		setDefaultCommand(new StopIntake());
	}
	
	public void increaseIntakeSpeed() {
		if (intakeSpeed <= 0.95) {
			intakeSpeed = intakeSpeed + 0.05;
		} else {
			intakeSpeed = 1.00;
		}
	}
	
	public void decreaseIntakeSpeed() {
		if (intakeSpeed >= 0.05) {
			intakeSpeed = intakeSpeed - 0.05;
		} else {
			intakeSpeed = 0.00;
		}
	}
	@Override
	public void stop() {
		intakeMotor.stopMotor();

	}

	@Override
	public void in(double speed) {
		intakeMotor.set(speed);

	}

	@Override
	public void in() {
		in(0.1);

	}

	@Override
	public void out(double speed) {
		in(-speed);

	}

	@Override
	public void out() {
		out(0.1);

	}
}
