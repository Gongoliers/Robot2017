package org.usfirst.frc5112.Robot2017V3.commands.autoCommands;

import org.usfirst.frc5112.Robot2017V3.commands.DrivetrainCommands.DriveForward;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class PlaceGearMiddlePeg extends CommandGroup {

	public PlaceGearMiddlePeg() {
		addSequential(new DriveForward(), 5);
	
	}
}
