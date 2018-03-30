package org.usfirst.frc.team2682.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Pos2LLLAutoCommandGroup extends CommandGroup {

    public Pos2LLLAutoCommandGroup() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	addParallel(new HookMoveForwardCommand(true));
    	addParallel(new MastUpAutoDistance(20));
    	addSequential(new DriveByGyroCommand(false, 0, .5, 20, false));
    	addSequential(new TurnByGyroCommand(-25, .4, 2, false));
    	addSequential(new DriveByGyroCommand(false, -25, .5, 60, false));
    	addSequential(new TurnByGyroCommand(0, .4, 2, false));
    	addSequential(new DriveByGyroCommand(false, 0, .5, 50, false));
    	addSequential(new CubeOutCommand(true));
    }
}
