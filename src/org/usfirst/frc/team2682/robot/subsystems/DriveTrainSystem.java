package org.usfirst.frc.team2682.robot.subsystems;

import org.usfirst.frc.team2682.robot.RobotMap;
import org.usfirst.frc.team2682.robot.commands.DriveCommand;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 * Subsystem originally made by Grayson Amendt
 * If you edit this, put your name below
 * Edited By: ---
 */
public class DriveTrainSystem extends Subsystem {

	//All of the drive motors (thank god there are only 4)
<<<<<<< HEAD:src/org/usfirst/frc/team2682/robot/subsystems/PWMDriveTrainSystem.java
	public Talon PWMdriveMotorLeft = new Talon(RobotMap.driveMotorLeftFrontPort);
	public Talon PWMdriveMotorRight = new Talon(RobotMap.driveMotorRightFrontPort);
=======
	public Talon driveMotorLeftFront = new Talon(RobotMap.leftDriveMotor);
	public Talon driveMotorRightFront = new Talon(RobotMap.rightDriveMotor);
	//public Talon driveMotorLeftBack = new Talon(RobotMap.driveMotorLeftBackPort);
	//public Talon driveMotorRightBack = new Talon(RobotMap.driveMotorRightBackPort);
>>>>>>> origin/dev:src/org/usfirst/frc/team2682/robot/subsystems/DriveTrainSystem.java
	
	//Most likely i2c port
	public AHRS navX = new AHRS(I2C.Port.kOnboard);
	
	//Create a differential drive
	DifferentialDrive drive = new DifferentialDrive(PWMdriveMotorLeft, PWMdriveMotorRight);

	//Empty constructor, for other things later on maybe
	public DriveTrainSystem() {
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new DriveCommand());
    }
    
    //Arcade Drive
    public void move(double moveValue, double rotateValue) {
    	drive.arcadeDrive(moveValue, rotateValue);
    }
    
    //Tank Drive
    public void tankMove(double leftValue, double rightValue) {
    	drive.tankDrive(leftValue, rightValue);
    }
    
    public void stop() {
    	drive.arcadeDrive(0, 0);
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

