package org.usfirst.frc5112.Robot2017V1.commands.TargetingCommands;

import org.usfirst.frc5112.Robot2017V1.commands.DrivetrainCommands.RotateDegreesToPeg;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AlignWithHighGoal extends CommandGroup {

    public AlignWithHighGoal() {
        addSequential(new GetPegAngle());
        addSequential(new RotateDegreesToPeg());
        
    }
}
