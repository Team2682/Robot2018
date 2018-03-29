/* 2682's 2018 Prayer to the FIRST Robotics Gods 
 * 
 * We pray first to the Founder, the President, and the Gracious Professional.
 * Dean, bless us with your mind. May we innovate and strategize, borne to victory.
 * Don, may we beat all odds against us, and find success in all aspects, not just in matches.
 * Woodie, give us the strength to act with kindness, and let others act such towards us.
 * 
 * We pray to the great teams of years past, Champions and Hall of Famers alike.
 * Grant us the programming prowess of the Cheesy Poofs,
 * The engineering brilliance of the Robowranglers,
 * And the success of the Robonauts.
 * 
 * We pray to National Instruments, though they be a violent and unpredictable pantheon.
 * Let us not fry our RoboRIO when we attempt to image it.
 * Let us be successful in all attempts to push code.
 * Let us always maintain contact between our driver station and our robot.
 * 
 * We pray to all volunteers, no matter their role or impact on our competitions.
 * May our judges be fair, and our queuers understanding.
 * May our ambassadors ambass, and our FTAs keep matches going.
 * We thank you for your tireless efforts to make every match run smoothly.
 * 
 * We pray to the Lords of all Video Gaming.
 * May Howard grant us immersion, may Kojima make even spectating enjoyable.
 * May Persson shows us how to use cubes, may Fils-Aime keep us prepared.
 * May Miyamoto bring us the fun, may Kaplan keep us "balanced".
 *  
 * May Iwata grant us his undying passion, his heart of a gamer.
 * 
 * In the name of our founder,
 * Kamen.
 */

/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
//The reasons I'm leaving this in are legal, not moral

package org.usfirst.frc.team2682.robot;

import org.usfirst.frc.team2682.robot.commands.DriveByGyro;
import org.usfirst.frc.team2682.robot.commands.HookMoveForwardCommand;
import org.usfirst.frc.team2682.robot.commands.Pos1And3AutoLineCommandGroup;
import org.usfirst.frc.team2682.robot.commands.Pos1LLLAuto;
import org.usfirst.frc.team2682.robot.commands.Pos2LLLAuto;
import org.usfirst.frc.team2682.robot.commands.Pos2RRRAuto;
import org.usfirst.frc.team2682.robot.commands.Pos3RRRAuto;
import org.usfirst.frc.team2682.robot.subsystems.CubeIntakeArmsSystem;
import org.usfirst.frc.team2682.robot.subsystems.CubeIntakeWheelsSystem;
import org.usfirst.frc.team2682.robot.subsystems.DriveTrainSystem;
import org.usfirst.frc.team2682.robot.subsystems.FourBarLinkageSystem;
import org.usfirst.frc.team2682.robot.subsystems.HookSystem;
import org.usfirst.frc.team2682.robot.subsystems.MastSystem;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends TimedRobot {
	public static OI oi;

	Command autonomousCommand;
	public static final HookSystem hook = new HookSystem();
	public static final DriveTrainSystem drive = new DriveTrainSystem();
	public static final CubeIntakeWheelsSystem wheels = new CubeIntakeWheelsSystem();
	public static final MastSystem mast = new MastSystem();
	public static final CubeIntakeArmsSystem arms = new CubeIntakeArmsSystem();
	public static final FourBarLinkageSystem linkage = new FourBarLinkageSystem();
	
	public static AnalogInput ultraSonicSensor = new AnalogInput(0);	

	public static double backTrackEncoder1;
	public static double backTrackAngle1;
	public static double backTrackEncoder2;
	public static double backTrackAngle2;
	
	public static AnalogInput cubeX = new AnalogInput(1);
	
	CameraServer server = CameraServer.getInstance();
	
	Timer timer = new Timer();
	
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		oi = new OI();
		// chooser.addObject("My Auto", new MyAutoCommand());
		server.startAutomaticCapture();
		
		SmartDashboard.putNumber("Auto Position", 1);
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {
		drive.resetEncoders();
		
		drive.navX.reset();

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
		SmartDashboard.putNumber("gyro yaw", drive.getCurrentHeading());
	
		SmartDashboard.putNumber("enc", drive.getDistance());
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * <p>You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
	drive.navX.reset();
	drive.resetEncoders();
	mast.resetDistance();
	timer.reset();
	timer.start();
	
	int startingPos = (int) SmartDashboard.getNumber("Auto Position", 1);
	
	String gameData = DriverStation.getInstance().getGameSpecificMessage();
	
	switch (startingPos) {
	case 1:
		if (gameData.toUpperCase().charAt(0) == 'R' && gameData.toUpperCase().charAt(1) == 'R') {
			autonomousCommand = new Pos1And3AutoLineCommandGroup();
		} else if (gameData.toUpperCase().charAt(0) == 'L') {
			autonomousCommand = new Pos1LLLAuto();
		} else if (gameData.toUpperCase().charAt(0) == 'R' && gameData.toUpperCase().charAt(1) == 'L') {
			autonomousCommand = new Pos1And3AutoLineCommandGroup();
		} else if (gameData.toUpperCase().charAt(0) == 'L' && gameData.toUpperCase().charAt(1) == 'R') {
			autonomousCommand = new Pos1And3AutoLineCommandGroup();
		}
		break;
	case 2:
		if (gameData.toUpperCase().charAt(0) == 'R') {
			autonomousCommand = new Pos2RRRAuto();
		} else if (gameData.toUpperCase().charAt(0) == 'L') {
			autonomousCommand = new Pos2LLLAuto();
			
		}
		break;
	case 3:
		if (gameData.toUpperCase().charAt(0) == 'R') {
			autonomousCommand = new Pos3RRRAuto();
		} else if (gameData.toUpperCase().charAt(0) == 'L' && gameData.toUpperCase().charAt(1) == 'L') {
			autonomousCommand = new Pos1And3AutoLineCommandGroup();
		} else if (gameData.toUpperCase().charAt(0) == 'R' && gameData.toUpperCase().charAt(1) == 'L') {
			autonomousCommand = new Pos1And3AutoLineCommandGroup();
		} else if (gameData.toUpperCase().charAt(0) == 'L' && gameData.toUpperCase().charAt(1) == 'R') {
			autonomousCommand = new Pos1And3AutoLineCommandGroup();
		}
		break;
	default:
		autonomousCommand = new Pos1And3AutoLineCommandGroup();
	}

		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */
		
		//autonomousCommand = new Pos1And3AutoLineCommandGroup();
	
		// schedule the autonomous command (example)
		if (autonomousCommand != null) {
			autonomousCommand.start();
		}
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {  

		SmartDashboard.putNumber("gyro yaw", drive.getCurrentHeading());
		SmartDashboard.putNumber("correction", DriveByGyro.correction);
		SmartDashboard.putNumber("error", DriveByGyro.error);
		
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null) {
			autonomousCommand.cancel();
		}
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		SmartDashboard.putNumber("mast", mast.getDistance());
		SmartDashboard.putString("GameData", DriverStation.getInstance().getGameSpecificMessage());
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
	

	public static double getBackTrackEncoder1() {
		return backTrackEncoder1;
	}

	public static void setBackTrackEncoder1(double backTrackEncoder1) {
		Robot.backTrackEncoder1 = backTrackEncoder1;
	}

	public static double getBackTrackAngle1() {
		return backTrackAngle1;
	}

	public static void setBackTrackAngle1(double backTrackAngle1) {
		Robot.backTrackAngle1 = backTrackAngle1;
	}

	public static double getBackTrackEncoder2() {
		return backTrackEncoder2;
	}

	public static void setBackTrackEncoder2(double backTrackEncoder2) {
		Robot.backTrackEncoder2 = backTrackEncoder2;
	}

	public static double getBackTrackAngle2() {
		return backTrackAngle2;
	}

	public static void setBackTrackAngle2(double backTrackAngle2) {
		Robot.backTrackAngle2 = backTrackAngle2;
	}

}
