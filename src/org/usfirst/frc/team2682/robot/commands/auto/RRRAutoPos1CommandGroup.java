package org.usfirst.frc.team2682.robot.commands.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RRRAutoPos1CommandGroup extends CommandGroup {

    public RRRAutoPos1CommandGroup() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.
    	
    	addSequential(new AutoDriveCommand(false,0, .75, 215, false));
    	addSequential(new AutoDriveTurnCommand(90, .5, 1.5, false));
    	addSequential(new AutoDriveCommand(false,90, .75, 70, false));
    	addSequential(new AutoDriveCommand(false,90, .55, 50, false));
    	addSequential(new AutoDriveCommand(false,90, .75, 55, false));
    	addSequential(new AutoDriveTurnCommand(180, .5, 1.5, false));
    	addSequential(new AutoDriveCommand(true,180, .5, 30, false));
//    	addSequential(new WaitCommand(.5));
    	addSequential(new AutoDriveCommand(false, 180, -.65,10, false));
    	addSequential(new DriveToPowerCubeCommand(false, .5));
//    	addSequential(new WaitCommand(.5));
    	addSequential(new AutoDriveCommand(true, false, -.65, false));
//    	addSequential(new WaitCommand(.5));
    	addSequential(new AutoDriveTurnCommand(0, .5, 2, false));
    	addSequential(new AutoDriveCommand(false, 0, .55,10,false));

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
