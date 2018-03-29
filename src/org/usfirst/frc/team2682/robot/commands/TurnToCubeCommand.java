package org.usfirst.frc.team2682.robot.commands;

import org.usfirst.frc.team2682.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import util.Misc;

/**
 *
 */
public class TurnToCubeCommand extends Command {

	double basePower;
	int powercubeX;
	
    public TurnToCubeCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drive);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {

    	powercubeX = (int) Misc.map(Robot.cubeX.getVoltage(),0,3.3,0,320);
		
		if (powercubeX > 170) {
			Robot.drive.tankMove(-.45, .45);
		} else if (powercubeX < 150) {
			Robot.drive.tankMove(.45, -.45);
		} else {
			Robot.drive.stop();
		}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return powercubeX < 170 && powercubeX > 150;
    	//return false;
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
