package org.usfirst.frc5112.Robot2017V1.commands.autoCommands;

import org.usfirst.frc5112.Robot2017V1.commands.DoNothingAtAll;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class DoNothing extends CommandGroup {

    public DoNothing() {
        addSequential(new DoNothingAtAll());
    }
}
