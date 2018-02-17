package org.usfirst.frc.team2682.robot.subsystems;

import org.usfirst.frc.team2682.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class FourBarLinkageSystem extends Subsystem {
	
	TalonSRX linkageLeft = new TalonSRX(RobotMap.leftCubeIntakeLinkage);
	TalonSRX linkageRight = new TalonSRX(RobotMap.rightCubeIntakeLinkage);
	
	public FourBarLinkageSystem() {
		linkageLeft.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 255);
		linkageRight.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 255);
	}

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	public void goUp() {
		linkageLeft.set(ControlMode.PercentOutput, .35);
		linkageRight.set(ControlMode.PercentOutput, -.35);
	}
	
	public void goDown() {
		linkageLeft.set(ControlMode.PercentOutput, -.35);
		linkageRight.set(ControlMode.PercentOutput, .35);		
	}
	
	public void stop() {
		linkageLeft.set(ControlMode.PercentOutput, 0);
		linkageRight.set(ControlMode.PercentOutput, 0);	
	}
	
	public double getCurrentPositionLeft() {
    	return linkageLeft.getSelectedSensorPosition(0);
    }
	
	public double getCurrentPositionRight() {
		return linkageRight.getSelectedSensorPosition(0);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

