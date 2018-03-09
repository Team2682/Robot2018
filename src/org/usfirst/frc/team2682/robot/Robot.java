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

import org.usfirst.frc.team2682.robot.commands.auto.LAutoPos2CommandGroup;
import org.usfirst.frc.team2682.robot.commands.auto.LLLAutoPos1CommandGroup;
import org.usfirst.frc.team2682.robot.commands.auto.LLLAutoPos3CommandGroup;
import org.usfirst.frc.team2682.robot.commands.auto.LRLAutoPos1CommandGroup;
import org.usfirst.frc.team2682.robot.commands.auto.LRLAutoPos3CommandGroup;
import org.usfirst.frc.team2682.robot.commands.auto.Pos1And3AutoLineCommandGroup;
import org.usfirst.frc.team2682.robot.commands.auto.RAutoPos2CommandGroup;
import org.usfirst.frc.team2682.robot.commands.auto.RLRAutoPos1CommandGroup;
import org.usfirst.frc.team2682.robot.commands.auto.RLRAutoPos3CommandGroup;
import org.usfirst.frc.team2682.robot.commands.auto.RRRAutoPos1CommandGroup;
import org.usfirst.frc.team2682.robot.commands.auto.RRRAutoPos3CommandGroup;

/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
//The reasons I'm leaving this in are legal, not moral

import org.usfirst.frc.team2682.robot.subsystems.CubeIntakeArmsSystem;
import org.usfirst.frc.team2682.robot.subsystems.CubeIntakeWheelsSystem;
import org.usfirst.frc.team2682.robot.subsystems.DriveTrainSystem;
import org.usfirst.frc.team2682.robot.subsystems.FourBarLinkageSystem;
import org.usfirst.frc.team2682.robot.subsystems.HookSystem;
import org.usfirst.frc.team2682.robot.subsystems.MastSystem;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.I2C;
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
	public static final HookSystem hook = new HookSystem();
	public static final DriveTrainSystem drive = new DriveTrainSystem();
	public static final CubeIntakeWheelsSystem wheels = new CubeIntakeWheelsSystem();
	public static final MastSystem mast = new MastSystem();
	public static final CubeIntakeArmsSystem arms = new CubeIntakeArmsSystem();
	public static final FourBarLinkageSystem linkage = new FourBarLinkageSystem();
	
	public static final String USBName = "/dev/ttyUSB0";

	//CameraServer cameraServer = CameraServer.getInstance();
	//UsbCamera camera;
	
	public static DigitalInput isObjectSeen = new DigitalInput(RobotMap.pixyCamDIOPin);
	public static AnalogInput objectX = new AnalogInput(RobotMap.pixyCamAnalogPin);
	
	public static AnalogInput ultraSonicSensor = new AnalogInput(1);
	
	public static int startingPos = 1;
	
	static double backTrackEncoder;
	static double backTrackAngle;
	
	static double backTrackEncoder2;
	static double backTrackAngle2;
	
	double[] backTrackVector1 = {0,0};
	double[] backTrackFinalVector = {0,0};
	
	public static double magnitude = 0.0;
	public static double angle = 0.0;
	
	public static double displaceXMeters;
	public static double displaceYMeters;
	
	boolean added = false;

	int powercubeX;
	byte[] powerCubeData;
	
//	Accelerometer accel = new BuiltInAccelerometer(Accelerometer.Range.k4G);
	
	//VisionThread turnDownForWhatVision;
	public static I2C comPort;
	
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		oi = new OI();
		// chooser.addObject("My Auto", new MyAutoCommand());
		CameraServer.getInstance().startAutomaticCapture();
		SmartDashboard.putNumber("Starting position", 1);
		
		comPort = new I2C(I2C.Port.kOnboard, 0x54);
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
		
		drive.navX.reset();
		drive.resetEncoders();
		startingPos = (int) SmartDashboard.getNumber("starting position", 1);
		
		String gameData = DriverStation.getInstance().getGameSpecificMessage();
		
		switch (startingPos) {
		case 1:

			if (gameData.toUpperCase().charAt(0) == 'R' && gameData.toUpperCase().charAt(1) == 'R') {
				autonomousCommand = new RRRAutoPos1CommandGroup();
			} else if (gameData.toUpperCase().charAt(0) == 'L' && gameData.toUpperCase().charAt(1) == 'L') {
				autonomousCommand = new LLLAutoPos1CommandGroup();
			} else if (gameData.toUpperCase().charAt(0) == 'R' && gameData.toUpperCase().charAt(1) == 'L') {
				autonomousCommand = new RLRAutoPos1CommandGroup();
			} else if (gameData.toUpperCase().charAt(0) == 'L' && gameData.toUpperCase().charAt(1) == 'R') {
				autonomousCommand = new LRLAutoPos1CommandGroup();
			}
			break;
		case 2:
			if (gameData.toUpperCase().charAt(0) == 'R') {
				autonomousCommand = new RAutoPos2CommandGroup();
			} else if (gameData.toUpperCase().charAt(0) == 'L') {
				autonomousCommand = new LAutoPos2CommandGroup();
				
			}
			break;
		case 3:
			if (gameData.toUpperCase().charAt(0) == 'R' && gameData.toUpperCase().charAt(1) == 'R') {
				autonomousCommand = new RRRAutoPos3CommandGroup();
			} else if (gameData.toUpperCase().charAt(0) == 'L' && gameData.toUpperCase().charAt(1) == 'L') {
				autonomousCommand = new LLLAutoPos3CommandGroup();
			} else if (gameData.toUpperCase().charAt(0) == 'R' && gameData.toUpperCase().charAt(1) == 'L') {
				autonomousCommand = new RLRAutoPos3CommandGroup();
			} else if (gameData.toUpperCase().charAt(0) == 'L' && gameData.toUpperCase().charAt(1) == 'R') {
				autonomousCommand = new LRLAutoPos3CommandGroup();
			}
			break;
		default:
			autonomousCommand = new Pos1And3AutoLineCommandGroup();
		}

		
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

	public static double getBackTrackEncoder() {
		return backTrackEncoder;
	}

	public static void setBackTrackEncoder(double backTrackEncoder) {
		Robot.backTrackEncoder = backTrackEncoder;
	}

	public static double getBackTrackAngle() {
		return backTrackAngle;
	}

	public static void setBackTrackAngle(double backTrackAngle) {
		Robot.backTrackAngle = backTrackAngle;
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
