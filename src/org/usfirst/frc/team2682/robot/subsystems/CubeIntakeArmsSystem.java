package org.usfirst.frc.team2682.robot.subsystems;

import org.usfirst.frc.team2682.robot.RobotMap;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class CubeIntakeArmsSystem extends Subsystem {

	public TalonSRX cubeArmMotor = new TalonSRX(RobotMap.cubeIntakeArm);
	public TalonSRX cubeArmMotor2 = new TalonSRX(RobotMap.cubeIntakeArm2);
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
	
	public void armTurnOpen(double value) {
		cubeArmMotor.set(ControlMode.PercentOutput, -value);
		cubeArmMotor2.set(ControlMode.PercentOutput, -value);
	}
	
	public void arm1TurnOpen(double speed) {
		cubeArmMotor.set(ControlMode.PercentOutput, -speed);
	}
	
	public void arm1TurnClose(double speed) {
		cubeArmMotor.set(ControlMode.PercentOutput, speed);
	}
	
	public void arm2TurnOpen(double speed) {
		cubeArmMotor2.set(ControlMode.PercentOutput, -speed);
	}
	
	public void arm2TurnClose(double speed) {
		cubeArmMotor2.set(ControlMode.PercentOutput, speed);
	}
	
	public void armTurnClose(double value) {
		cubeArmMotor.set(ControlMode.PercentOutput, value);
		cubeArmMotor2.set(ControlMode.PercentOutput, value);
	}
	
	public void stop() {
		cubeArmMotor.set(ControlMode.PercentOutput, 0);
		cubeArmMotor2.set(ControlMode.PercentOutput, 0);
	}
}

