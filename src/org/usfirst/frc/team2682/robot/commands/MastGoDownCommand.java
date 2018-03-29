package org.usfirst.frc.team2682.robot.commands;

import org.usfirst.frc.team2682.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class MastGoDownCommand extends Command {

	boolean auxStick;
	
    public MastGoDownCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.mast);
    }
    
    public MastGoDownCommand(boolean auxStick) {
    	requires(Robot.mast);
    	this.auxStick = auxStick;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//Robot.mast.openBrake();
    	if (auxStick)
    		Robot.mast.goDown(Robot.oi.auxStick.getRawAxis(1)/1.2);
    	else
    		Robot.mast.goDown(.6);
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
    	//Robot.mast.closeBrake();
    	Robot.mast.stop();
    }
}
