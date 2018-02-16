/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
//The reasons I'm leaving this in are legal, not moral

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

package org.usfirst.frc.team2682.robot;

import org.usfirst.frc.team2682.robot.subsystems.CubeIntakeArmsSystem;
import org.usfirst.frc.team2682.robot.subsystems.CubeIntakeWheelsSystem;
import org.usfirst.frc.team2682.robot.subsystems.DriveTrainSystem;
import org.usfirst.frc.team2682.robot.subsystems.MastSystem;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
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
	SendableChooser<Command> chooser = new SendableChooser<>();

	public static final DriveTrainSystem drive = new DriveTrainSystem();
	public static final CubeIntakeWheelsSystem intakeWheels = new CubeIntakeWheelsSystem();
	public static final MastSystem mast = new MastSystem();
	public static final CubeIntakeArmsSystem cubearmcontrol = new CubeIntakeArmsSystem();


	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		oi = new OI();
		// chooser.addObject("My Auto", new MyAutoCommand());
		SmartDashboard.putData("Auto mode", chooser);
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
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
		autonomousCommand = chooser.getSelected();

		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

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
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
}
