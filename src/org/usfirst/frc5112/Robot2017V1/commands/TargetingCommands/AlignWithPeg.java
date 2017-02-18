package org.usfirst.frc5112.Robot2017V1.commands.TargetingCommands;

import org.usfirst.frc5112.Robot2017V1.commands.DrivetrainCommands.RotateDegreesToHighGoal;
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
