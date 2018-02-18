package org.usfirst.frc.team2682.robot.subsystems;

import org.usfirst.frc.team2682.robot.RobotMap;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class CubeIntakeWheelsSystem extends Subsystem {

	VictorSP cubeIntakeWheelLeft = new VictorSP(RobotMap.leftCubeIntakeWheel);
	VictorSP cubeIntakeWheelRight = new VictorSP(RobotMap.rightCubeIntakeWheel);
	
	public void takeInCube(double speed) {
		cubeIntakeWheelLeft.set(speed);
		cubeIntakeWheelRight.set(-speed);
	}
	
	public void spitOutCube(double speed) {
		cubeIntakeWheelLeft.set(-speed);
		cubeIntakeWheelRight.set(speed);
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

