package org.usfirst.frc.team2682.robot.subsystems;

import org.usfirst.frc.team2682.robot.RobotMap;

import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class BARLinkageSystem extends Subsystem {
	
	public Talon rightBARLift = new Talon(RobotMap.rightBARLinkage);
	public Talon leftBARLift = new Talon(RobotMap.leftBARLinkage);
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	Encoder BAREncoder = new Encoder(RobotMap.rightBARLinkage, RobotMap.leftBARLinkage, false, EncodingType.k4X);
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void BARLiftUp(double speed) {
    	leftBARLift.set(speed);
    	rightBARLift.set(-speed);
    }
    
    public void BARLiftDown(double speed) {
    	leftBARLift.set(-speed);
    	rightBARLift.set(speed);
    }
    
    public void stop() {
    	rightBARLift.set(0);
    	leftBARLift.set(0);
    }
}

