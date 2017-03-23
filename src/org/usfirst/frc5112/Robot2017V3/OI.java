package org.usfirst.frc5112.Robot2017V3;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc5112.Robot2017V3.commands.*;
import org.usfirst.frc5112.Robot2017V3.commands.DrivetrainCommands.DriveBackwards;
import org.usfirst.frc5112.Robot2017V3.commands.DrivetrainCommands.DriveForward;
import org.usfirst.frc5112.Robot2017V3.commands.DrivetrainCommands.InvertMotors;
import org.usfirst.frc5112.Robot2017V3.commands.DrivetrainCommands.OperatorControl;
import org.usfirst.frc5112.Robot2017V3.commands.DrivetrainCommands.RestoreMotorDirection;
import org.usfirst.frc5112.Robot2017V3.commands.DrivetrainCommands.RotateClockwise;
import org.usfirst.frc5112.Robot2017V3.commands.DrivetrainCommands.RotateCounterclockwise;
import org.usfirst.frc5112.Robot2017V3.commands.DrivetrainCommands.StopDrivetrain;
import org.usfirst.frc5112.Robot2017V3.commands.DrivetrainCommands.SwitchYSign;
import org.usfirst.frc5112.Robot2017V3.commands.ScalerCommands.DecreaseScalerSpeedManual;
import org.usfirst.frc5112.Robot2017V3.commands.ScalerCommands.IncreaseScalerSpeedManual;
import org.usfirst.frc5112.Robot2017V3.commands.ScalerCommands.ScalerUp;
import org.usfirst.frc5112.Robot2017V3.commands.ScalerCommands.StopScaler;
import org.usfirst.frc5112.Robot2017V3.commands.TargetingCommands.AlignWithPeg;
import org.usfirst.frc5112.Robot2017V3.commands.autoCommands.DriveForwardLine;

/*import org.usfirst.frc5112.Robot2017V3.commands.TargetingCommands.BoilerCameraEnable;
import org.usfirst.frc5112.Robot2017V3.commands.TargetingCommands.PegCameraEnable;
import org.usfirst.frc5112.Robot2017V3.commands.TargetingCommands.TargetingModeOff;
import org.usfirst.frc5112.Robot2017V3.commands.TargetingCommands.TargetingModeOn;*/
import edu.wpi.first.wpilibj.Joystick;
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
		SmartDashboard.putData("Forward", new DriveForward(.25));
		SmartDashboard.putData("Reverse", new DriveBackwards(.25));
		SmartDashboard.putData("StopDrivetrain", new StopDrivetrain());
		SmartDashboard.putData("RotateClockwise", new RotateClockwise());
		SmartDashboard.putData("RotateCounterclockwise", new RotateCounterclockwise());
		SmartDashboard.putData("Switch Y Sign", new SwitchYSign());
		
		//SmartDashboard - Targeting System
//		SmartDashboard.putData("TargetingModeOff", new TargetingModeOff());
//		SmartDashboard.putData("TargetingModeOn", new TargetingModeOn());
//		SmartDashboard.putData("EnableBoilerCam", new BoilerCameraEnable());
//		SmartDashboard.putData("EnablePegCam", new PegCameraEnable());
    	
		// SmartDashboard - Scaler
		SmartDashboard.putNumber("ScalerSpeedDisplay", Robot.scaler.scalerSpeed);
		SmartDashboard.putData("IncreaseScalerSpeed", new IncreaseScalerSpeedManual());
		SmartDashboard.putData("DecreaseScalerSpeed", new DecreaseScalerSpeedManual());
		SmartDashboard.putData("ScalerUp", new ScalerUp(0));
		SmartDashboard.putData("StopScaler", new StopScaler());
		
    	//Command Groups
		SmartDashboard.putData("Autonomous Command", new DriveForwardLine());
		SmartDashboard.putData("StopEverything", new StopEverything());
		SmartDashboard.putData("AlignWithPeg", new AlignWithPeg());
		
		// XBOX Controller Initialization
//		xbox.RT.whenActive(new SpinShooterClockwise());				// SIDE TRIGGERS control the shooter direction
//		xbox.LT.whenActive(new SpinShooterCounterclockwise());		//
		
//		xbox.LB.whenPressed(new DecreaseShooterSpeedManual());		// SIDE BUTTONS control the shooter speed
//		xbox.RB.whenPressed(new IncreaseShooterSpeedManual());		//
		
//		xbox.START.toggleWhenPressed(new IntakeIn());				// START BUTTON toggles the inward intake
		xbox.BACK.whileHeld(new StopEverything());				    // BACK BUTTON stops all robot systems
		
//		xbox.DPAD_UP.whileActive(new IntakeIn());					// UP BUTTON intakes fuel
//		xbox.DPAD_DOWN.whileActive(new IntakeOut());				// DOWN BUTTON out-takes fuel
//		xbox.DPAD_LEFT.whileActive(new ScalerUp());					// LEFT BUTTON climbs the rope
//		xbox.DPAD_RIGHT.whileActive(new AlignWithPeg());				// RIGHT BUTTON climbs the rope
		
		xbox.Y.whileHeld(new ScalerUp(.35));						// Y BUTTON stops the intake
		xbox.A.whileHeld(new ScalerUp(1.0));					// A BUTTON stops the drivetrain
		xbox.X.whenPressed(new StopScaler());						// X BUTTON stops the scaler

	}

	public Joystick getJoystick() {
		return joystick;
	}

}