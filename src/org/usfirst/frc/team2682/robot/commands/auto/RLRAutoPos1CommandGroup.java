package org.usfirst.frc.team2682.robot.commands.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RLRAutoPos1CommandGroup extends CommandGroup {

    public RLRAutoPos1CommandGroup() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

    	addSequential(new AutoDriveCommand(false,0, .65, 225, false));
    	addSequential(new AutoDriveTurnCommand(160, .4, 2, false));
//    	addSequential(new WaitCommand(1));
    	addSequential(new AutoDriveCommand(false,160, .65, 12, false));
    	addSequential(new AutoDriveCommand(false,160, -.65, 12, false));
    	addSequential(new AutoDriveTurnCommand(0, .4, 2, false));
    	
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
    }
}
