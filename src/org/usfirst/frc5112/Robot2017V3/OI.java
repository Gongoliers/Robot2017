package org.usfirst.frc5112.Robot2017V3;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import java.awt.DisplayMode;

import org.usfirst.frc5112.Robot2017V3.commands.*;
import org.usfirst.frc5112.Robot2017V3.commands.DrivetrainCommands.DriveBackwards;
import org.usfirst.frc5112.Robot2017V3.commands.DrivetrainCommands.DriveForward;
import org.usfirst.frc5112.Robot2017V3.commands.DrivetrainCommands.InvertMotors;
import org.usfirst.frc5112.Robot2017V3.commands.DrivetrainCommands.OperatorControl;
import org.usfirst.frc5112.Robot2017V3.commands.DrivetrainCommands.RestoreMotorDirection;
import org.usfirst.frc5112.Robot2017V3.commands.DrivetrainCommands.RotateClockwise;
import org.usfirst.frc5112.Robot2017V3.commands.DrivetrainCommands.RotateCounterclockwise;
import org.usfirst.frc5112.Robot2017V3.commands.DrivetrainCommands.StopDrivetrain;
import org.usfirst.frc5112.Robot2017V3.commands.HopperCommands.DecreaseHopperSpeedManual;
import org.usfirst.frc5112.Robot2017V3.commands.HopperCommands.IncreaseHopperSpeedManual;
import org.usfirst.frc5112.Robot2017V3.commands.HopperCommands.SpinHopperClockwise;
import org.usfirst.frc5112.Robot2017V3.commands.HopperCommands.SpinHopperCounterclockwise;
import org.usfirst.frc5112.Robot2017V3.commands.HopperCommands.StopHopper;
import org.usfirst.frc5112.Robot2017V3.commands.IntakeCommands.DecreaseIntakeSpeedManual;
import org.usfirst.frc5112.Robot2017V3.commands.IntakeCommands.IncreaseIntakeSpeedManual;
import org.usfirst.frc5112.Robot2017V3.commands.IntakeCommands.IntakeIn;
import org.usfirst.frc5112.Robot2017V3.commands.IntakeCommands.IntakeOut;
import org.usfirst.frc5112.Robot2017V3.commands.IntakeCommands.StopIntake;
import org.usfirst.frc5112.Robot2017V3.commands.ScalerCommands.DecreaseScalerSpeedManual;
import org.usfirst.frc5112.Robot2017V3.commands.ScalerCommands.IncreaseScalerSpeedManual;
import org.usfirst.frc5112.Robot2017V3.commands.ScalerCommands.ScalerUp;
import org.usfirst.frc5112.Robot2017V3.commands.ScalerCommands.StopScaler;
import org.usfirst.frc5112.Robot2017V3.commands.ShooterCommands.DecreaseShooterSpeedManual;
import org.usfirst.frc5112.Robot2017V3.commands.ShooterCommands.IncreaseShooterSpeedManual;
import org.usfirst.frc5112.Robot2017V3.commands.ShooterCommands.SpinShooterClockwise;
import org.usfirst.frc5112.Robot2017V3.commands.ShooterCommands.SpinShooterCounterclockwise;
import org.usfirst.frc5112.Robot2017V3.commands.ShooterCommands.StopShooter;
import org.usfirst.frc5112.Robot2017V3.commands.TargetingCommands.AlignWithHighGoal;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Sendable;
import edu.wpi.first.wpilibj.buttons.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	public JoystickButton joystickButton3;
	public JoystickButton joystickButton4;
	public JoystickButton joystickButton5;
	public JoystickButton joystickButton6;
	public JoystickButton joystickButton7;
	public JoystickButton joystickButton8;
	public JoystickButton joystickButton9;
	public Joystick joystick;

	public XboxController xbox;
	
	public OI() {
		xbox = new XboxController(1);
		joystick = new Joystick(0);

		//Joystick Buttons
//		joystickButton9 = new JoystickButton(joystick, 9);
//		joystickButton9.whileHeld(new RotateCounterclockwise());
//		joystickButton8 = new JoystickButton(joystick, 8);
//		joystickButton8.whileHeld(new RotateClockwise());
		joystickButton7 = new JoystickButton(joystick, 7);
		joystickButton7.whenPressed(new StopEverything());
//		joystickButton6 = new JoystickButton(joystick, 6);
//		joystickButton6.whenPressed(new DriveForward());
		joystickButton5 = new JoystickButton(joystick, 5);
		joystickButton5.whenPressed(new RestoreMotorDirection());
		joystickButton4 = new JoystickButton(joystick, 4);
		joystickButton4.whenPressed(new InvertMotors());
		joystickButton3 = new JoystickButton(joystick, 3);
		joystickButton3.whenPressed(new StopDrivetrain());

		// SmartDashboard - Drivetrain
		SmartDashboard.putData("OperatorControl", new OperatorControl());
		SmartDashboard.putData("InvertMotors", new InvertMotors());
		SmartDashboard.putData("RestoreMotorDirection", new RestoreMotorDirection());
		SmartDashboard.putData("Forward", new DriveForward());
		SmartDashboard.putData("Reverse", new DriveBackwards());
		SmartDashboard.putData("StopDrivetrain", new StopDrivetrain());
		SmartDashboard.putData("RotateClockwise", new RotateClockwise());
		SmartDashboard.putData("RotateCounterclockwise", new RotateCounterclockwise());

		
		// SmartDashboard - Intake
		SmartDashboard.putData("IntakeIn", new IntakeIn());
		SmartDashboard.putData("IntakeOut", new IntakeOut());
		SmartDashboard.putData("StopIntake", new StopIntake());
		SmartDashboard.putData("IncreaseIntakeSpeed", new IncreaseIntakeSpeedManual());
		SmartDashboard.putData("DecreaseIntakeSpeed", new DecreaseIntakeSpeedManual());
		SmartDashboard.putNumber("IntakeSpeedDisplay", Robot.intake.intakeSpeed);
    	
		// SmartDashboard - Hopper
		SmartDashboard.putData("SpinHopperClockwise", new SpinHopperClockwise());
		SmartDashboard.putData("SpinHopperCounterclockwise", new SpinHopperCounterclockwise());
		SmartDashboard.putData("StopHopper", new StopHopper());
		SmartDashboard.putData("IncreaseHopperSpeed", new IncreaseHopperSpeedManual());
		SmartDashboard.putData("DecreaseHopperSpeed", new DecreaseHopperSpeedManual());
		SmartDashboard.putNumber("HopperSpeedDisplay", Robot.hopper.hopperSpeed);
    	
		// SmartDashboard - Scaler
		SmartDashboard.putNumber("ScalerSpeedDisplay", Robot.scaler.scalerSpeed);
		SmartDashboard.putData("IncreaseScalerSpeed", new IncreaseScalerSpeedManual());
		SmartDashboard.putData("DecreaseScalerSpeed", new DecreaseScalerSpeedManual());
		SmartDashboard.putData("ScalerUp", new ScalerUp());
		SmartDashboard.putData("StopScaler", new StopScaler());
		
		// SmartDashboard - Shooter
		SmartDashboard.putData("SpinShooterClockwise", new SpinShooterClockwise());
		SmartDashboard.putData("SpinShooterCounterclockwise", new SpinShooterCounterclockwise());
		SmartDashboard.putData("StopShooter", new StopShooter());	
		SmartDashboard.putData("IncreaseShooterSpeed", new IncreaseShooterSpeedManual());
		SmartDashboard.putData("DecreaseShooterSpeed", new DecreaseShooterSpeedManual());
    	SmartDashboard.putNumber("ShooterSpeedDisplay", Robot.shooter.shooterSpeed);
    	
    	//Command Groups
		SmartDashboard.putData("Autonomous Command", new AutonomousCommand());
		SmartDashboard.putData("StopEverything", new StopEverything());
		SmartDashboard.putData("AlignWithHighGoal", new AlignWithHighGoal());
		//SmartDashboard.putData("Camera", (Sendable) Robot.targetingSystem.currentCamera.getPicture());
		
		// XBOX Controller Initialization
		xbox.RT.whenActive(new SpinShooterClockwise());				// SIDE TRIGGERS control the shooter direction
		xbox.LT.whenActive(new SpinShooterCounterclockwise());		//
		
		xbox.LB.whenPressed(new DecreaseShooterSpeedManual());		// SIDE BUTTONS control the shooter speed
		xbox.RB.whenPressed(new IncreaseShooterSpeedManual());		//
		
		xbox.START.toggleWhenPressed(new IntakeIn());				// START BUTTON toggles the inward intake
		xbox.BACK.whileHeld(new StopEverything());				    // BACK BUTTON stops all robot systems
		
		xbox.DPAD_UP.whileActive(new IntakeIn());					// UP BUTTON intakes fuel
		xbox.DPAD_DOWN.whileActive(new IntakeOut());				// DOWN BUTTON out-takes fuel
		xbox.DPAD_LEFT.whileActive(new ScalerUp());					// LEFT BUTTON climbs the rope
		xbox.DPAD_RIGHT.whileActive(new ScalerUp());				// RIGHT BUTTON climbs the rope
		
		xbox.Y.whenPressed(new StopIntake());						// Y BUTTON stops the intake
		xbox.A.whenPressed(new StopDrivetrain());					// A BUTTON stops the drivetrain
		xbox.X.whenPressed(new StopScaler());						// X BUTTON stops the scaler
		xbox.B.whenPressed(new StopShooter());						// B BUTTON stops the shooter

	}

	public Joystick getJoystick() {
		return joystick;
	}

}