package util;

public class PIDCorrection {
	
	private double pValue;
	private double correctionValue;
	//private double newCurrentPoint;
	double error;
	
	public PIDCorrection(double pValue) {
		this.pValue = pValue;
	}
	
	public double getpValue() {
		return pValue;
	}
	
	public void setpValue(double pValue) {
		this.pValue = pValue;
	}
	
	public double calculateCorrection(double setPoint, double currentPoint) {

		error = setPoint - currentPoint;
    	correctionValue = Math.abs(error) * pValue;
        return correctionValue;

    }
	
}
