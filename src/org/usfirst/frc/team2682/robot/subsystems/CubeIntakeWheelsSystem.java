package org.usfirst.frc.team2682.robot.subsystems;

import org.usfirst.frc.team2682.robot.RobotMap;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class CubeIntakeWheelsSystem extends Subsystem {

	Talon cubeIntakeWheelLeft = new Talon(RobotMap.leftCubeIntakeWheel);
	Talon cubeIntakeWheelRight = new Talon(RobotMap.rightCubeIntakeWheel);
	
	public void takeInCube() {
		cubeIntakeWheelLeft.set(RobotMap.wheelSpeed);
		cubeIntakeWheelRight.set(-RobotMap.wheelSpeed);
	}
	
	public void spitOutCube() {
		cubeIntakeWheelLeft.set(-RobotMap.wheelSpeed);
		cubeIntakeWheelRight.set(RobotMap.wheelSpeed);
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
