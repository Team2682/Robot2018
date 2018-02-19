package org.usfirst.frc.team2682.robot.commands;

import org.usfirst.frc.team2682.robot.Robot;
import org.usfirst.frc.team2682.robot.RobotMap;
import org.usfirst.frc.team2682.robot.utilities.PIDDriveTargeting;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveTurnAutoCommand extends Command {
	
	PIDDriveTargeting pid = new PIDDriveTargeting(RobotMap.kP);
	double setAngle;
	double speed;
	double threshold;

    public DriveTurnAutoCommand(double setAngle, double speed, double threshold) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drive);
    	this.setAngle = setAngle;
    	this.speed = speed;
    	this.threshold = threshold;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double gyroHeading = Robot.drive.getCurrentHeading();
    	double correction = pid.calculateCorrection(setAngle, gyroHeading);
    	
    	double leftSpeed = speed;
    	double rightSpeed = speed;
    	
    	if(setAngle < gyroHeading) {
    		leftSpeed = 0 - correction;
    		rightSpeed = 0 + correction;
    	}
    	else if(setAngle > gyroHeading) {
    		leftSpeed = 0 + correction;
    		rightSpeed = 0 - correction;
    	}
    	else {
    		leftSpeed = speed;
    		rightSpeed = speed;
    	}
    	
    	Robot.drive.tankMove(leftSpeed, rightSpeed);
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (Robot.drive.getCurrentHeading() <= setAngle + threshold && Robot.drive.getCurrentHeading() >= setAngle - threshold);
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drive.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.drive.stop();
    }
}
