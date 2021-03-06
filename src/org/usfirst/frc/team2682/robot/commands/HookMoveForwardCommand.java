package org.usfirst.frc.team2682.robot.commands;

import org.usfirst.frc.team2682.robot.Robot;
import org.usfirst.frc.team2682.robot.RobotMap;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class HookMoveForwardCommand extends Command {

	Timer timer = new Timer();
	boolean autoTimer;
	
    public HookMoveForwardCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.hook);
    }
    public HookMoveForwardCommand(boolean autoTimer) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.hook);
    	this.autoTimer = autoTimer;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	if (autoTimer) {
    		timer.reset();
    		timer.start();
    	}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.hook.moveAtSpeed(RobotMap.hookSpeed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if (autoTimer)
    		return timer.get() >= 5;
    	else
    		return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.hook.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.hook.stop();
    }
}
