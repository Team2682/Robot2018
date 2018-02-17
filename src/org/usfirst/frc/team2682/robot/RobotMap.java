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
	public static int auxStick = 0;
	
	//AuxStick Buttons
	public static int armsOpen = 0,
					  armsClose = 1;
	public static int wheelsIntake = 2,
					  wheelsEject = 3;
	public static int linkageUp = 4,
					  linkageDown = 5;
	public static int hookForward = 6,
					  hookBackward = 7;
	public static int mastUp = 8,
					  mastDown = 9;
	
	//DriveStick Buttons
	public static int driveFullSpeed = 0, 
					  driveHalfSpeed = 1; 
	public static int altArmsOpen = 2,
					  altArmsClose = 4;
	public static int altWheelsIntake = 3,
					  altWheelsEject = 5;
	public static int altHookForward = 6,
					  altHookBackward = 7;
	public static int altLinkageUp = 8,
					  altLinkageDown = 9;
	public static int altMastUp = 10,
					  altMastDown = 11;
	
	//DriveStick Axes
	public static int moveAxis = 1,
					  turnAxis = 0;
	public static int wheelsSpeedAxis = 3;
	
	
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
	//CAN
	public static int leftCubeIntakeLinkage = 5,
					  rightCubeIntakeLinkage = 6;
	public static int cubeIntakeArm = 1;
	//Speed
	public static double wheelSpeed = .5;
	public static double linkageSpeed = .35;
	public static double armSpeed = .5;
	
//Climbing/Mast
	//CAN
	public static int mastMotorOne = 2,
					  mastMotorTwo = 3;
	public static int hookMotor = 4;
	//DIO
	public static int limitSwitch = 0;
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
