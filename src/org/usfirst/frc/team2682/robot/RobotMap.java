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
	public static int driveStick = 0;
	
//Driving System
	//PWM
	public static int leftDriveMotor = 0;
	public static int rightDriveMotor = 1;
	
	//public static int driveMotorLeftFrontPort = 0;
	//public static int driveMotorRightFrontPort = 1;
	//public static int driveMotorLeftBackPort = 2;
	//public static int driveMotorRightBackPort = 3;
	
	//Settings
	public static boolean isGyroContinuous = true;
	
//Cube Intake
	//PWM
	public static int leftCubeIntakeWheel = 2,
					  rightCubeIntakeWheel = 3;
	public static int leftCubeIntakeLinkage = 4,
					  rightCubeIntakeLinkage = 5;
	//CAN
	public static int cubeIntakeArm = 1;
	//Speed
	public static double wheelSpeed = .5;
	public static double linkageSpeed = .5;
	public static double armSpeed = .5;
	
//Climbing/Mast
	//CAN
	public static int mastMotorOne = 2,
					  mastMotorTwo = 3;
	public static int hookMotor = 4;
	//Speed
	public static double mastSpeed = .5;
	public static double hookSpeed = .375;
	//Pneumatics
	public static int brakeForwardChannel = 0,
					  brakeReverseChannel = 1;

//Miscellaneous
	//Logging
	public static String logDirectory = "/home/lvuser/";
	public static String logFilename = "log.txt";
}
