package org.usfirst.frc.team2682.robot.commands;

import org.usfirst.frc.team2682.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class MastGoUpCommand extends Command {

	boolean auxStick;
	
    public MastGoUpCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.mast);
    }
    
    public MastGoUpCommand(boolean auxStick) {
    	requires(Robot.mast);
    	this.auxStick = auxStick;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//Robot.mast.openBrake();
    	if (auxStick) {
    		if (Robot.oi.auxStick.getRawAxis(1) > .3 || Robot.oi.auxStick.getRawAxis(1) < -.3) {
    			Robot.mast.goUp(Robot.oi.auxStick.getRawAxis(1));
    		} else {
    			Robot.mast.stop();
    		}
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	//Robot.mast.closeBrake();
    	Robot.mast.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
//    	/Robot.mast.closeBrake();
    	Robot.mast.stop();
    }
}
