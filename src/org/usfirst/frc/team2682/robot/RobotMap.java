/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2682.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
	
//Control System
	//USB
	public static int driveStickPort = 0;
	
//Driving System
	//PWM
	public static int leftDriveMotor = 0;
	public static int rightDriveMotor = 1;
	
	//public static int driveMotorLeftFrontPort = 0;
	//public static int driveMotorRightFrontPort = 1;
	//public static int driveMotorLeftBackPort = 2;
	//public static int driveMotorRightBackPort = 3;
	
//Cube Intake
	//PWM
	public static int cubeIntakeWheelLeft = 5,
					  cubeIntakeWheelRight = 6;
	
	
}
