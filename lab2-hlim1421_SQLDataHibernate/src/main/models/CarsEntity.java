package main.models;

import javax.persistence.*;

/**
 * Created by Hanko on 12/12/2016.
 */

@Entity
@Table(name = "cars", schema = "kornyezetek")//, catalog = "")
public class CarsEntity {
    private int carId;
    private String brand;
    private String model;
    private String fabricationYear;
    private String cilinderCapacity;

    @Id
    @Column(name = "CarID")
    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    @Basic
    @Column(name = "Brand")
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Basic
    @Column(name = "Model")
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Basic
    @Column(name = "FabricationYear")
    public String getFabricationYear() {
        return fabricationYear;
    }

    public void setFabricationYear(String fabricationYear) {
        this.fabricationYear = fabricationYear;
    }

    @Basic
    @Column(name = "CilinderCapacity")
    public String getCilinderCapacity() {
        return cilinderCapacity;
    }

    public void setCilinderCapacity(String cilinderCapacity) {
        this.cilinderCapacity = cilinderCapacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CarsEntity that = (CarsEntity) o;

        if (carId != that.carId) return false;
        if (brand != null ? !brand.equals(that.brand) : that.brand != null) return false;
        if (model != null ? !model.equals(that.model) : that.model != null) return false;
        if (fabricationYear != null ? !fabricationYear.equals(that.fabricationYear) : that.fabricationYear != null)
            return false;
        if (cilinderCapacity != null ? !cilinderCapacity.equals(that.cilinderCapacity) : that.cilinderCapacity != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = carId;
        result = 31 * result + (brand != null ? brand.hashCode() : 0);
        result = 31 * result + (model != null ? model.hashCode() : 0);
        result = 31 * result + (fabricationYear != null ? fabricationYear.hashCode() : 0);
        result = 31 * result + (cilinderCapacity != null ? cilinderCapacity.hashCode() : 0);
        return result;
    }
}
