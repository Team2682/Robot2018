package org.usfirst.frc.team2682.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Pos2RRRAutoCommandGroup extends CommandGroup {

    public Pos2RRRAutoCommandGroup() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    	addParallel(new HookMoveForwardCommand(true));
    	addParallel(new MastUpAutoDistance(20));
    	addSequential(new DriveByGyroCommand(false, 0, .5, 20, false));
    	addSequential(new TurnByGyroCommand(30, .4, 2, false));
    	addSequential(new DriveByGyroCommand(false, 30, .5, 60, false));
    	addSequential(new TurnByGyroCommand(0, .4, 2, false));
    	addSequential(new DriveByGyroCommand(false, 0, .5, 50, false));
    	addSequential(new CubeOutCommand(true));
    }
}
