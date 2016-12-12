package edu.ubb.cs.idde.SQLDataCollectingHibernate.Model;


public class CarData {
	int ID;
	String brand;
	String model;
	int fabricationYear;
	int cilinderCapacity;
	
	public CarData(int ID, String brand, String model, int fabricationYear, int cilinderCapacity){
		this.ID = ID;
		this.brand = brand;
		this.model = model;
		this.fabricationYear = fabricationYear;
		this.cilinderCapacity = cilinderCapacity;
	}

	public int getCilCap() {
		return this.cilinderCapacity;
	}

	public int getFabYear() {
		return this.fabricationYear;
	}

	public String getModel() {
		return this.model;
	}

	public String getBrand() {
		return this.brand;
	}
}
