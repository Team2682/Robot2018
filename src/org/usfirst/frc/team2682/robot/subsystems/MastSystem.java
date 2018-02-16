package org.usfirst.frc.team2682.robot.subsystems;

import org.usfirst.frc.team2682.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class MastSystem extends Subsystem {

	public TalonSRX mastOne = new TalonSRX(8);
	public TalonSRX mastTwo = new TalonSRX(27);
	
	DigitalInput limitSwitch = new DigitalInput(564);
	
	DoubleSolenoid brake = new DoubleSolenoid(RobotMap.brakeForwardChannel, RobotMap.brakeReverseChannel);
	
	public void goUp() {
		mastOne.set(ControlMode.PercentOutput, RobotMap.mastSpeed);
		mastTwo.set(ControlMode.PercentOutput, RobotMap.mastSpeed);
	}
	
	public void openBrake() {
		brake.set(Value.kForward);
	}
	
	public void closeBrake() {
		brake.set(Value.kReverse);
	}
	
	public void getLimitSwitchState() {
		limitSwitch.get();
	}
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

