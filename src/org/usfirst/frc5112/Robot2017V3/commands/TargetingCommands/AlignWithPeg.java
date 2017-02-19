package org.usfirst.frc5112.Robot2017V3.commands.TargetingCommands;

import org.usfirst.frc5112.Robot2017V3.commands.DrivetrainCommands.RotateDegreesToHighGoal;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AlignWithPeg extends CommandGroup {

    public AlignWithPeg() {
        addSequential(new GetBoilerAngle());
        addSequential(new RotateDegreesToHighGoal());
        
    }
}
