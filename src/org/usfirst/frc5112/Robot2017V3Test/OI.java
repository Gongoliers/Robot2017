package org.usfirst.frc5112.Robot2017V3Test;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc5112.Robot2017V3Test.commands.*;
import org.usfirst.frc5112.Robot2017V3Test.commands.DrivetrainCommands.DriveBackwards;
import org.usfirst.frc5112.Robot2017V3Test.commands.DrivetrainCommands.DriveForward;
import org.usfirst.frc5112.Robot2017V3Test.commands.DrivetrainCommands.StopDrivetrain;

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
		joystickButton7 = new JoystickButton(joystick, 7);
		joystickButton7.whenPressed(new DecreaseDriveTrainSpeed());
		joystickButton6 = new JoystickButton(joystick, 6);
		joystickButton6.whenPressed(new IncreaseDriveTrainSpeed());
		joystickButton5 = new JoystickButton(joystick, 5);
		joystickButton5.whenPressed(new DriveBackwards(Robot.drivetrain.drivetrainSpeed));
		joystickButton4 = new JoystickButton(joystick, 4);
		joystickButton4.whenPressed(new DriveForward(Robot.drivetrain.drivetrainSpeed));
		joystickButton3 = new JoystickButton(joystick, 3);
		joystickButton3.whenPressed(new StopDrivetrain());

		// SmartDashboard - Drivetrain
		SmartDashboard.putData("Forward", new DriveForward(Robot.drivetrain.drivetrainSpeed));
		SmartDashboard.putData("Reverse", new DriveBackwards(Robot.drivetrain.drivetrainSpeed));
		SmartDashboard.putData("StopDrivetrain", new StopDrivetrain());
		SmartDashboard.putData("Increase Drivetrain Speed", new IncreaseDriveTrainSpeed());
		SmartDashboard.putData("Decrease Drivetrain Speed", new DecreaseDriveTrainSpeed());
		Robot.drivetrain.updateSpeed();
		
		
    	//Command Groups
		SmartDashboard.putData("StopEverything", new StopEverything());
		
	}

	public Joystick getJoystick() {
		return joystick;
	}

}