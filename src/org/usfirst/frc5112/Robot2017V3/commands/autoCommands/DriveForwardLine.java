package org.usfirst.frc5112.Robot2017V3.commands.autoCommands;

import org.usfirst.frc5112.Robot2017V3.commands.DrivetrainCommands.DriveForward;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class DriveForwardLine extends CommandGroup {

	public DriveForwardLine() {
		addSequential(new DriveForward(.25), 5);
	
	}
}
