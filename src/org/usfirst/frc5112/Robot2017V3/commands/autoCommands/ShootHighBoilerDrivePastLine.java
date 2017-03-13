package org.usfirst.frc5112.Robot2017V3.commands.autoCommands;

import org.usfirst.frc5112.Robot2017V3.commands.StopEverything;
import org.usfirst.frc5112.Robot2017V3.commands.DrivetrainCommands.DriveBackwards;
import org.usfirst.frc5112.Robot2017V3.commands.DrivetrainCommands.DriveForward;
import org.usfirst.frc5112.Robot2017V3.commands.ScalerCommands.SpinCamCam;
import org.usfirst.frc5112.Robot2017V3.commands.ShooterCommands.SpinShooterClockwise;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class ShootHighBoilerDrivePastLine extends CommandGroup {

    public ShootHighBoilerDrivePastLine() {
        addSequential(new DriveForward(.4), 3);
        addSequential(new StopEverything());
        addParallel(new SpinCamCam(), 5);
        addParallel(new SpinShooterClockwise(), 5);
        addSequential(new StopEverything());
        addSequential(new DriveBackwards(0.25), 7);
        addSequential(new StopEverything());
    }
}
