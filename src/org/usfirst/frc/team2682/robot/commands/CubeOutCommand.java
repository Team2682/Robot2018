package org.usfirst.frc.team2682.robot.commands;

import org.usfirst.frc.team2682.robot.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 * Written by Jeremy Ignatowitz
 * 
 * Edited by:
 * 
 */
public class CubeOutCommand extends Command {

	boolean auto;
	Timer timer = new Timer();
	
    public CubeOutCommand(boolean auto) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.wheels);
    	this.auto = auto;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.wheels.takeInCube();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if (DriverStation.getInstance().isAutonomous())
    		return timer.get()>=2;
    	else
    		return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.wheels.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.wheels.stop();
    }
}
