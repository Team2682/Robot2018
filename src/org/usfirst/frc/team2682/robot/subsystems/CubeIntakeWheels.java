package org.usfirst.frc.team2682.robot.subsystems;

import org.usfirst.frc.team2682.robot.RobotMap;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class CubeIntakeWheels extends Subsystem {

	Talon cubeIntakeWheelLeft = new Talon(RobotMap.cubeIntakeWheelLeft);
	Talon cubeIntakeWheelRight = new Talon(RobotMap.cubeIntakeWheelRight);
	
	public void takeInCube() {
		cubeIntakeWheelLeft.set(.5);
		cubeIntakeWheelRight.set(-.5);
	}
	
	public void spitOutCube() {
		cubeIntakeWheelLeft.set(-.5);
		cubeIntakeWheelRight.set(.5);
	}
	
	public void stop() {
		cubeIntakeWheelLeft.set(0);
		cubeIntakeWheelRight.set(0);
	}
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

