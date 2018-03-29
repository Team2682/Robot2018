package org.usfirst.frc.team2682.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Pos2LLLAuto extends CommandGroup {

    public Pos2LLLAuto() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	addParallel(new HookMoveForwardCommand(true));
    	addParallel(new MastUpAutoDistance(20));
    	addSequential(new DriveByGyro(false, 0, .5, 20, false));
    	addSequential(new TurnByGyro(-25, .4, 2, false));
    	addSequential(new DriveByGyro(false, -25, .5, 60, false));
    	addSequential(new TurnByGyro(0, .4, 2, false));
    	addSequential(new DriveByGyro(false, 0, .5, 50, false));
    	addSequential(new CubeOutCommand(true));
    }
}
