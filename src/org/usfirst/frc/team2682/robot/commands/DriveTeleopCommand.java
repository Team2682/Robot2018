package org.usfirst.frc.team2682.robot.commands;

import org.usfirst.frc.team2682.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Command originally created by Grayson Amendt
 * Edited By: ---
 */
public class DriveTeleopCommand extends Command {

    public DriveTeleopCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.driveTrainSystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//Basic Driving
    	
    	//Move Axis (y-axis)
    	double yAxis = Robot.oi.driveStick.getRawAxis(1);
    	//Rotate Axis (x-axis)
    	double xAxis = Robot.oi.driveStick.getRawAxis(0);
    	Robot.driveTrainSystem.move(yAxis, xAxis);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	//stops robot
    	Robot.driveTrainSystem.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	//stops robot
    	Robot.driveTrainSystem.stop();
    }
}
