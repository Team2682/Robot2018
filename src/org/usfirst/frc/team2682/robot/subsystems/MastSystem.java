package org.usfirst.frc.team2682.robot.subsystems;

import org.usfirst.frc.team2682.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.hal.CompressorJNI;

/**
 *
 */
public class MastSystem extends Subsystem {

	public TalonSRX mastMotor1 = new TalonSRX(RobotMap.mastMotorOne);
	public TalonSRX mastMotor2 = new TalonSRX(RobotMap.mastMotorTwo);
	
	DigitalInput limitSwitch = new DigitalInput(RobotMap.limitSwitch);
	
	DoubleSolenoid brake = new DoubleSolenoid(RobotMap.brakeForwardChannel, RobotMap.brakeReverseChannel);
	
	public void goUp() {
		mastMotor1.set(ControlMode.PercentOutput, RobotMap.mastSpeed);
		mastMotor2.set(ControlMode.PercentOutput, RobotMap.mastSpeed);
	}
	public void goDown() {
		mastMotor1.set(ControlMode.PercentOutput, -RobotMap.mastSpeed);
		mastMotor2.set(ControlMode.PercentOutput, -RobotMap.mastSpeed);
	}
	
	public void stop() {
		mastMotor1.set(ControlMode.PercentOutput, 0);
		mastMotor2.set(ControlMode.PercentOutput, 0);
	}
	
	public void openBrake() {
		brake.set(Value.kForward);
	}
	
	public void closeBrake() {
		brake.set(Value.kReverse);
	}
	
	public boolean getLimitSwitchState() {
		return limitSwitch.get();
	}
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

