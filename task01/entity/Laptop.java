package by.tc.task01.entity;

public class Laptop extends Appliance{
	// you may add your own code here
	private int batteryCapacity;
	private String oS;
	private int memoryRom;
	private int systemMemory;
	private double CPU;
	private int displayInch;
	
	public int getBatteryCapacity() {
		return batteryCapacity;
	}
	
	public void setBatteryCapacity(int batteryCapacity) {
		this.batteryCapacity = batteryCapacity;
	}
	
	public String getoS() {
		return oS;
	}
	
	public void setoS(String oS) {
		this.oS = oS;
	}
	
	public int getMemoryRom() {
		return memoryRom;
	}
	
	public void setMemoryRom(int memoryRom) {
		this.memoryRom = memoryRom;
	}
	
	public int getSystemMemory() {
		return systemMemory;
	}
	
	public void setSystemMemory(int systemMemory) {
		this.systemMemory = systemMemory;
	}
	
	public double getCPU() {
		return CPU;
	}
	
	public void setCPU(double cPU) {
		CPU = cPU;
	}
	
	public int getDisplayInch() {
		return displayInch;
	}
	
	public void setDisplayInch(int displayInch) {
		this.displayInch = displayInch;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(CPU);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + batteryCapacity;
		result = prime * result + displayInch;
		result = prime * result + memoryRom;
		result = prime * result + ((oS == null) ? 0 : oS.hashCode());
		result = prime * result + systemMemory;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Laptop other = (Laptop) obj;
		if (Double.doubleToLongBits(CPU) != Double.doubleToLongBits(other.CPU))
			return false;
		if (batteryCapacity != other.batteryCapacity)
			return false;
		if (displayInch != other.displayInch)
			return false;
		if (memoryRom != other.memoryRom)
			return false;
		if (oS == null) {
			if (other.oS != null)
				return false;
		} else if (!oS.equals(other.oS))
			return false;
		if (systemMemory != other.systemMemory)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Laptop [batteryCapacity=" + batteryCapacity + ", oS=" + oS + ", memoryRom=" + memoryRom
				+ ", systemMemory=" + systemMemory + ", CPU=" + CPU + ", displayInch=" + displayInch + "]";
	}
	

}
