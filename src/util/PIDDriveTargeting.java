package util;

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
		error = setpoint - currentPoint;
		correctionValue = Math.abs(error) * pValue;	
		return correctionValue;
	}
		
}
