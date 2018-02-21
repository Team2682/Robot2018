/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2682.robot;

import org.usfirst.frc.team2682.robot.commands.ArmsCloseCommand;
import org.usfirst.frc.team2682.robot.commands.CubeIntakeCommand;
import org.usfirst.frc.team2682.robot.commands.CubeOuttakeCommand;
import org.usfirst.frc.team2682.robot.commands.LinkageMoveDownCommand;
import org.usfirst.frc.team2682.robot.commands.LinkageMoveUpCommand;
import org.usfirst.frc.team2682.robot.commands.HookMoveBackCommand;
import org.usfirst.frc.team2682.robot.commands.HookMoveForwardCommand;
import org.usfirst.frc.team2682.robot.commands.MastGoDownCommand;
import org.usfirst.frc.team2682.robot.commands.MastGoUpCommand;
import org.usfirst.frc.team2682.robot.commands.ArmsOpenCommand;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
		
	public Joystick driveStick = new Joystick(RobotMap.driveStick);
	public Joystick auxStick = new Joystick(RobotMap.auxStick);
	
	public Button hookForwardButton = new JoystickButton(auxStick, RobotMap.hookForward);
	public Button hookBackwardButton = new JoystickButton(auxStick, RobotMap.hookBackward);
//	public Button armOpenButton = new JoystickButton(auxStick, RobotMap.armsOpen);
//	public Button armCloseButton = new JoystickButton(auxStick, RobotMap.armsClose);
//	public Button wheelIntakeButton = new JoystickButton(auxStick, RobotMap.wheelsIntake);
//	public Button wheelEjectButton = new JoystickButton(auxStick, RobotMap.wheelsEject);
	public Button linkageUpButton = new JoystickButton(auxStick, RobotMap.linkageUp);
	public Button linkageDownButton = new JoystickButton(auxStick, RobotMap.linkageDown);
//	public Button mastUpButton = new JoystickButton(auxStick, RobotMap.mastUp);
//	public Button mastDownButton = new JoystickButton(auxStick, RobotMap.mastDown);
	
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
//		armOpenButton.whileHeld(new ArmsOpenCommand());
//		armCloseButton.whileHeld(new ArmsCloseCommand());
//		wheelIntakeButton.whileHeld(new CubeIntakeCommand());
//		wheelEjectButton.whileHeld(new CubeOuttakeCommand());
		linkageUpButton.whileHeld(new LinkageMoveUpCommand());
		linkageDownButton.whileHeld(new LinkageMoveDownCommand());
//		mastUpButton.whileHeld(new MastGoUpCommand());
//		mastDownButton.whileHeld(new MastGoDownCommand());
		
		altHookForwardButton.whileHeld(new HookMoveForwardCommand());
		altHookBackwardButton.whileHeld(new HookMoveBackCommand());
		altArmOpenButton.whileHeld(new ArmsOpenCommand());
		altArmCloseButton.whileHeld(new ArmsCloseCommand());
		altWheelIntakeButton.whileHeld(new CubeIntakeCommand());
		altWheelEjectButton.whileHeld(new CubeOuttakeCommand());
		altLinkageUpButton.whileHeld(new LinkageMoveUpCommand());
		altLinkageDownButton.whileHeld(new LinkageMoveDownCommand());
		altMastUpButton.whileHeld(new MastGoUpCommand());
		altMastDownButton.whileHeld(new MastGoDownCommand());
	}
	
}
