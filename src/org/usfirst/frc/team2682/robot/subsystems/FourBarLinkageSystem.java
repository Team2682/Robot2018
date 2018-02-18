package org.usfirst.frc.team2682.robot.subsystems;

import org.usfirst.frc.team2682.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class FourBarLinkageSystem extends Subsystem {
	
	TalonSRX linkageLeft = new TalonSRX(RobotMap.leftCubeIntakeLinkage);
	TalonSRX linkageRight = new TalonSRX(RobotMap.rightCubeIntakeLinkage);
	
	DigitalInput limitSwitchTop = new DigitalInput(1);
	DigitalInput limitSwitchBottom = new DigitalInput(2);
	
	public FourBarLinkageSystem() {
		//linkageLeft.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 255);
		//linkageRight.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 255);
	}

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	public void goUp(double speed) {
		linkageLeft.set(ControlMode.PercentOutput, speed);
		linkageRight.set(ControlMode.PercentOutput, -speed);
	}
	
	public void goDown(double speed) {
		linkageLeft.set(ControlMode.PercentOutput, -speed);
		linkageRight.set(ControlMode.PercentOutput, speed);		
	}
	
	public void stop() {
		linkageLeft.set(ControlMode.PercentOutput, 0);
		linkageRight.set(ControlMode.PercentOutput, 0);	
	}
	
	/*public double getCurrentPositionLeft() {
    	return linkageLeft.getSelectedSensorPosition(0);
    }
	
	public double getCurrentPositionRight() {
		return linkageRight.getSelectedSensorPosition(0);
	}*/
	
	public boolean isLimitSwitchTop() {
		return limitSwitchTop.get();
	}
	
	public boolean isLimitSwitchBottom() {
		return limitSwitchBottom.get();
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

