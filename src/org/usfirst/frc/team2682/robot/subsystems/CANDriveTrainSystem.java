package org.usfirst.frc.team2682.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 * Subsystem originally made by Grayson Amendt
 * If you edit this, put your name below
 * Edited By: ---
 */
public class CANDriveTrainSystem extends Subsystem {

	//All of the drive motors (thank god there are only 4)
	public WPI_TalonSRX driveMotorLeftFront = new WPI_TalonSRX(1);
	public WPI_TalonSRX driveMotorRightFront = new WPI_TalonSRX(2);
	public WPI_TalonSRX driveMotorLeftBack = new WPI_TalonSRX(3);
	public WPI_TalonSRX driveMotorRightBack = new WPI_TalonSRX(4);
	
	//Most likely i2c port
	public AHRS navX = new AHRS(I2C.Port.kOnboard);
	
	//Create a differential drive
	DifferentialDrive drive = new DifferentialDrive(driveMotorLeftFront, driveMotorRightFront);
	
	//Set the back motors to follow the front motors
	public CANDriveTrainSystem() {
		driveMotorLeftBack.follow(driveMotorLeftFront);
		driveMotorRightBack.follow(driveMotorRightFront);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    //Arcade Drive
    public void move(double moveValue, double rotateValue) {
    	drive.arcadeDrive(moveValue, rotateValue);
    }
    
    //Tank Drive
    public void tankMove(double leftValue, double rightValue) {
    	drive.tankDrive(leftValue, rightValue);
    }
    
    //Returns continuous angle
    public double getCurrentHeading() {
    	return navX.getAngle();
    }
    
    //Returns discontinuous angle
    public double getCurrentHeading180() {
    	return navX.getYaw();
    }
}

