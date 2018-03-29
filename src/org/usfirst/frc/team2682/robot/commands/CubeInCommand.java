package org.usfirst.frc.team2682.robot.commands;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.usfirst.frc.team2682.robot.Robot;
import org.usfirst.frc.team2682.robot.RobotMap;
import org.usfirst.frc.team2682.robot.utilities.Miscellaneous;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CubeInCommand extends Command {
	
	boolean auto;
	Timer timer = new Timer();
	
    public CubeInCommand(boolean auto) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.wheels);
    	this.auto = auto;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	timer.reset();
    	timer.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double speed;
    	if(DriverStation.getInstance().isAutonomous()) {
    		Robot.wheels.spitOutCube();
    	}
    	else {
    		speed = Miscellaneous.map(-1, 1, 0, 1, Robot.oi.driveStick.getRawAxis(RobotMap.wheelsSpeedAxis));
    		Robot.wheels.spitOutCube(speed);
    	}
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
