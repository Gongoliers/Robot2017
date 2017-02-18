package org.usfirst.frc5112.Robot2017V3.commands.autoCommands;

import org.usfirst.frc5112.Robot2017V3.commands.DoNothingAtAll;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class DoNothing extends CommandGroup {

    public DoNothing() {
        addSequential(new DoNothingAtAll());
    }
}
