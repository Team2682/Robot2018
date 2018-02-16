package org.usfirst.frc.team2682.robot.subsystems;

import org.usfirst.frc.team2682.robot.RobotMap;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class CubeIntakeArms extends Subsystem {

	public TalonSRX cubeArmMotor = new TalonSRX(0);
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
	
	public void armTurnOpen(double value) {
		cubeArmMotor.set(ControlMode.PercentOutput, value);
	}
	
	public void armTurnClose(double value) {
		cubeArmMotor.set(ControlMode.PercentOutput, -value);
	}
	
	public void stop() {
		cubeArmMotor.set(ControlMode.PercentOutput, 0);
	}
}

