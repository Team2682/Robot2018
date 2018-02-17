package org.usfirst.frc.team2682.robot.subsystems;

import org.usfirst.frc.team2682.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class MastSystem extends Subsystem {

	public VictorSP mast = new VictorSP(RobotMap.mastMotorOne);
	
	DigitalInput limitSwitch = new DigitalInput(RobotMap.limitSwitch);
	
	DoubleSolenoid brake = new DoubleSolenoid(RobotMap.brakeForwardChannel, RobotMap.brakeReverseChannel);
	
	public void goUp() {
		mast.set(RobotMap.mastSpeed);
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

