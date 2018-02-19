package org.usfirst.frc.team2682.robot.subsystems;

import org.usfirst.frc.team2682.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class HookSystem extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	TalonSRX hookMotor = new TalonSRX(RobotMap.hookMotor);
	
	public HookSystem() {
		//PID -- Someone end my misery.
		hookMotor.selectProfileSlot(0, 0);
		hookMotor.config_kF(0, 0.2, 40);
		hookMotor.config_kP(0, 0.2, 40);
		hookMotor.config_kI(0, 0.0, 10);
		hookMotor.config_kD(0, 0.0, 10);
		
		//Add Encoder
		//hookMotor.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 255);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void moveAtSpeed(double speed) {
    	hookMotor.set(ControlMode.PercentOutput, speed);
    }
    
    public void stop() {
		hookMotor.set(ControlMode.PercentOutput, 0);
	}
    
    public void goToPosition(double position) {
    	hookMotor.set(ControlMode.Position, position);
    }
    
    public double getCurrentPosition() {
    	return hookMotor.getSelectedSensorPosition(0);
    }
}

