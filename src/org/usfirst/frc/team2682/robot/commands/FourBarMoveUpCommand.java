package org.usfirst.frc.team2682.robot.commands;

import org.usfirst.frc.team2682.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class FourBarMoveUpCommand extends Command {

	Timer timer = new Timer();
	boolean timeout;
	
    public FourBarMoveUpCommand(boolean timeout) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.linkage);
    	this.timeout = timeout;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	timer.reset();
    	timer.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.linkage.goUp();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if (timeout)
    		return timer.get() > 1.5;
    	else
    		return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.linkage.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.linkage.stop();
    }
}
