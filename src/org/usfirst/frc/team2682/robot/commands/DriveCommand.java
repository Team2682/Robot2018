package org.usfirst.frc.team2682.robot.commands;

import org.usfirst.frc.team2682.robot.Robot;
import org.usfirst.frc.team2682.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Command originally created by Grayson Amendt
 * Edited By: ---
 */
public class DriveCommand extends Command {

    public DriveCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drive);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double modifier;
    	
    	//Basic Driving
    	
    	//Move Axis (y-axis)
    	double yAxis = Robot.oi.driveStick.getRawAxis(1);
    	//Rotate Axis (x-axis)
    	double xAxis = Robot.oi.driveStick.getRawAxis(0);
    	
    	if(Robot.oi.driveStick.getRawButton(RobotMap.driveFullSpeed)) {
    		modifier = 1;
    	}
    	else if(Robot.oi.driveStick.getRawButton(RobotMap.driveHalfSpeed)) {
    		modifier = .5;
    	}
    	else {
    		modifier = .75;
    	}
    	
    	Robot.drive.move(yAxis * modifier, xAxis * modifier);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	//stops robot
    	Robot.drive.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	//stops robot
    	Robot.drive.stop();
    }
}
