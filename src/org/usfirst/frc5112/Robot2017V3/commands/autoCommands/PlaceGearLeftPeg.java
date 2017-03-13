package org.usfirst.frc5112.Robot2017V3.commands.autoCommands;

import org.usfirst.frc5112.Robot2017V3.RobotMap;
import org.usfirst.frc5112.Robot2017V3.commands.DrivetrainCommands.DriveForward;
import org.usfirst.frc5112.Robot2017V3.commands.TargetingCommands.AlignWithPeg;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class PlaceGearLeftPeg extends CommandGroup {

	public PlaceGearLeftPeg() {
		RobotMap.gyro.reset();
		addSequential(new DriveForward(.25), 4);
		addSequential(new AlignWithPeg());
		addSequential(new DriveForward(.25), 4);

	}
}
