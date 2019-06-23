package za.co.avaj.weather;

public class Coordinates {
	private int		longitude;		//- in UML means private?
	private int		latitude;
	private int		height;

	//Need to make this public for some reason?
	public Coordinates(int longitude, int latitude, int height) {
		this.longitude = longitude;
		this.latitude = latitude;
		this.height = height;
	}
	
	public int		getLongitude(){
		return (this.longitude);
	}

	public int		getLatitude(){
		return (this.latitude);
	}

	public int		getHeight(){
		return (this.height);
	}
}