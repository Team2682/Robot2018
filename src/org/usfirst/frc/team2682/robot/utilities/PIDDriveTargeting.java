package org.usfirst.frc.team2682.robot.utilities;

import org.usfirst.frc.team2682.robot.RobotMap;

public class PIDDriveTargeting {

	private double pValue;
	private double correctionValue;
	private double error;
	
	public PIDDriveTargeting(double pValue) {
		this.pValue = pValue;
	}
	
	public double getPValue() {
		return pValue;
	}
	
	public void setPValue(double pValue) {
		this.pValue = pValue;
	}

	public double calculateCorrection(double setpoint, double currentPoint) {
		if(RobotMap.isGyroContinuous) {
			error = setpoint - currentPoint;		}
		else {
			if(setpoint < 0) {
				setpoint += 360;
			}
			if(currentPoint < 0) {
				currentPoint += 360;
			}
			
			error = Math.abs(setpoint - currentPoint);
			
			if(error > 180) {
				error = 360 - error;
			}
		}
		correctionValue = Math.abs(error) * pValue;	
		return correctionValue;
	}
		
}
