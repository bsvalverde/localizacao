package models;

public class ObjetoGeografico {
	protected double latitude;
	protected double longitude;
	
	public ObjetoGeografico(double latitude, double longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	public double getLatitude() {
		return this.latitude;
	}
	
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	
	public double getLongitude() {
		return this.longitude;
	}
	
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

}
