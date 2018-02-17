/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2682.robot;

import org.usfirst.frc.team2682.robot.commands.CloseArmsCommand;
import org.usfirst.frc.team2682.robot.commands.CubeIntakeCommand;
import org.usfirst.frc.team2682.robot.commands.CubeOuttakeCommand;
import org.usfirst.frc.team2682.robot.commands.FourBarMoveDownCommand;
import org.usfirst.frc.team2682.robot.commands.FourBarMoveUpCommand;
import org.usfirst.frc.team2682.robot.commands.HookMoveBackCommand;
import org.usfirst.frc.team2682.robot.commands.HookMoveForwardCommand;
import org.usfirst.frc.team2682.robot.commands.MastGoDownCommand;
import org.usfirst.frc.team2682.robot.commands.MastGoUpCommand;
import org.usfirst.frc.team2682.robot.commands.OpenArmsCommand;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
	
	public Joystick driveStick = new Joystick(RobotMap.driveStick);
	public Joystick auxStick = new Joystick(RobotMap.auxStick);
	
	public Button hookForwardButton = new JoystickButton(auxStick, RobotMap.hookForward);
	public Button hookBackwardButton = new JoystickButton(auxStick, RobotMap.hookBackward);
	public Button armOpenButton = new JoystickButton(auxStick, RobotMap.armsOpen);
	public Button armCloseButton = new JoystickButton(auxStick, RobotMap.armsClose);
	public Button wheelIntakeButton = new JoystickButton(auxStick, RobotMap.wheelsIntake);
	public Button wheelEjectButton = new JoystickButton(auxStick, RobotMap.wheelsEject);
	public Button linkageUpButton = new JoystickButton(auxStick, RobotMap.linkageUp);
	public Button linkageDownButton = new JoystickButton(auxStick, RobotMap.linkageDown);
	public Button mastUpButton = new JoystickButton(auxStick, RobotMap.mastUp);
	public Button mastDownButton = new JoystickButton(auxStick, RobotMap.mastDown);
	//CHANGE THESE VALUES LATER
	
	public Button altWheelEjectButton = new JoystickButton(driveStick, RobotMap.altWheelsEject);
	public Button altWheelIntakeButton = new JoystickButton(driveStick, RobotMap.altWheelsIntake);
	public Button altArmOpenButton = new JoystickButton(driveStick, RobotMap.altArmsOpen);
	public Button altArmCloseButton = new JoystickButton(driveStick, RobotMap.altArmsClose);
	public Button altHookForwardButton = new JoystickButton(driveStick, RobotMap.altHookForward);
	public Button altHookBackwardButton = new JoystickButton(driveStick, RobotMap.altHookBackward);
	public Button altLinkageUpButton = new JoystickButton(driveStick, RobotMap.altLinkageUp);
	public Button altLinkageDownButton = new JoystickButton(driveStick, RobotMap.altLinkageDown);
	public Button altMastUpButton = new JoystickButton(driveStick, RobotMap.altMastUp);
	public Button altMastDownButton = new JoystickButton(driveStick, RobotMap.altMastDown);
	
	
	public OI() {
		hookForwardButton.whileHeld(new HookMoveForwardCommand());
		hookBackwardButton.whileHeld(new HookMoveBackCommand());
		armOpenButton.whileHeld(new OpenArmsCommand());
		armCloseButton.whileHeld(new CloseArmsCommand());
		wheelIntakeButton.whileHeld(new CubeIntakeCommand());
		wheelEjectButton.whileHeld(new CubeOuttakeCommand());
		linkageUpButton.whileHeld(new FourBarMoveUpCommand());
		linkageDownButton.whileHeld(new FourBarMoveDownCommand());
		mastUpButton.whileHeld(new MastGoUpCommand());
		mastDownButton.whileHeld(new MastGoDownCommand());
		
		altHookForwardButton.whileHeld(new HookMoveForwardCommand());
		altHookBackwardButton.whileHeld(new HookMoveBackCommand());
		altArmOpenButton.whileHeld(new OpenArmsCommand());
		altArmCloseButton.whileHeld(new CloseArmsCommand());
		altWheelIntakeButton.whileHeld(new CubeIntakeCommand());
		altWheelEjectButton.whileHeld(new CubeOuttakeCommand());
		altLinkageUpButton.whileHeld(new FourBarMoveUpCommand());
		altLinkageDownButton.whileHeld(new FourBarMoveDownCommand());
		altMastUpButton.whileHeld(new MastGoUpCommand());
		altMastDownButton.whileHeld(new MastGoDownCommand());
	}
	
}
