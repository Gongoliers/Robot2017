package org.usfirst.frc5112.Robot2017V3.commands;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DoNothingAtAll extends Command {

    public DoNothingAtAll() {
    	
    }

    protected void initialize() {
    	end();
    }

    protected void execute() {
    	end();
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    	
    }

    protected void interrupted() {
    	end();
    }
}
