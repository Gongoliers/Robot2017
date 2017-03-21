package org.usfirst.frc5112.Robot2017V3Test.commands;

import org.usfirst.frc5112.Robot2017V3Test.commands.DrivetrainCommands.StopDrivetrain;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class StopEverything extends CommandGroup {

    public StopEverything() {

    	addParallel(new StopDrivetrain());

    } 
}