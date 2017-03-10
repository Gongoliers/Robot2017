package org.usfirst.frc5112.Robot2017V3.commands.autoCommands;

import org.usfirst.frc5112.Robot2017V3.commands.DrivetrainCommands.DriveForward;
import org.usfirst.frc5112.Robot2017V3.commands.DrivetrainCommands.RotateDegreesToPeg;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class PlaceGearRightPeg extends CommandGroup {

	public PlaceGearRightPeg() {
		addSequential(new DriveForward(), 5);
		addSequential(new RotateDegreesToPeg());
		addSequential(new DriveForward(), 4);
	}
}
