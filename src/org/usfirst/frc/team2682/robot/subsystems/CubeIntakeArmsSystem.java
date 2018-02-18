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
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
	
	public void armsTurnOpen(double value) {
		cubeArmMotor.set(ControlMode.PercentOutput, value);
	}
	
	public void armsTurnClosed(double value) {
		cubeArmMotor.set(ControlMode.PercentOutput, -value);
	}
	
	public void stop() {
		cubeArmMotor.set(ControlMode.PercentOutput, 0);
	}
}

