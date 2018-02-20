package org.usfirst.frc.team2682.robot.commands;

import org.usfirst.frc.team2682.robot.Robot;
import org.usfirst.frc.team2682.robot.RobotMap;
import org.usfirst.frc.team2682.robot.utilities.PIDDriveTargeting;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoDriveCommand extends Command {

	PIDDriveTargeting pid = new PIDDriveTargeting(RobotMap.kP);
	double speed;
	double setpoint;
	double setAngle;
	
    public AutoDriveCommand(double speed, double setpoint, double setAngle) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drive);
    	this.speed = speed;
    	this.setpoint = setpoint;
    	this.setAngle = setAngle;
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
    		
    	if(setpoint > gyroHeading) {
    		leftSpeed -= correction;
   			rightSpeed += correction;
   		}
   		else if(setpoint < gyroHeading) {
   			leftSpeed += correction;
   			rightSpeed -= correction;
   		}
    	
    	Robot.drive.tankMove(leftSpeed, rightSpeed);
    }
    	
    	

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.drive.getLeftEncoderValue() >= setpoint || Robot.drive.getRightEncoderValue() >= setpoint;
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
