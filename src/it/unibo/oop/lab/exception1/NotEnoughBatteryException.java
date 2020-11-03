package it.unibo.oop.lab.exception1;

public class NotEnoughBatteryException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5328592957171100503L;
	private final double batteryLevel;
	private final double batteryToConsume;
	
	public NotEnoughBatteryException(double batteryLevel, double batteryToConsume) {
		super();
		this.batteryLevel = batteryLevel;
		this.batteryToConsume = batteryToConsume;
	}
	
	public double necessaryBattery() {
		return (this.batteryToConsume - this.batteryLevel);
	}
	

    public String toString() {
        return "Can not move, needs " + this.necessaryBattery() + " more battery";
    }


    public String getMessage() {
        return this.toString();
    }

}
