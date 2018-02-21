package org.usfirst.frc.team2682.robot.subsystems;

import org.usfirst.frc.team2682.robot.RobotMap;
import org.usfirst.frc.team2682.robot.commands.MastMoveByStickCommand;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class MastSystem extends Subsystem {

	public TalonSRX mastMotor1 = new TalonSRX(RobotMap.mastMotorOne);
	public TalonSRX mastMotor2 = new TalonSRX(RobotMap.mastMotorTwo);
	
	DigitalInput limitSwitch = new DigitalInput(RobotMap.limitSwitch);
	
	//DoubleSolenoid brake = new DoubleSolenoid(RobotMap.brakeForwardChannel, RobotMap.brakeReverseChannel);
	
	public void goUp(double speed) {
		mastMotor1.set(ControlMode.PercentOutput, speed);
		mastMotor2.set(ControlMode.PercentOutput, speed);
	}
	public void goDown(double speed) {
		mastMotor1.set(ControlMode.PercentOutput, -speed);
		mastMotor2.set(ControlMode.PercentOutput, -speed);
	}
	
	public void move(double speed) {
		mastMotor1.set(ControlMode.PercentOutput, speed);
		mastMotor2.set(ControlMode.PercentOutput, speed);
	}
	
	public void stop() {
		mastMotor1.set(ControlMode.PercentOutput, 0);
		mastMotor2.set(ControlMode.PercentOutput, 0);
	}
	
//	public void openBrake() {
//		brake.set(Value.kForward);
//	}
//
//	public void closeBrake() {
//		brake.set(Value.kReverse);
//	}
	
	public boolean getLimitSwitchState() {
		return limitSwitch.get();
}
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
    	setDefaultCommand(new MastMoveByStickCommand());
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

