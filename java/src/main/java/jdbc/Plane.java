package jdbc;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "plane")
@XmlAccessorType(XmlAccessType.FIELD)
public class Plane {

    public void setYear(int year) {
        this.year = year;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setManufacturer(PlaneManufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    @XmlElement(name = "year")
    private int year;
    @XmlElement(name = "model")
    private String model;
    @XmlElement(name = "manufacturer")
    private PlaneManufacturer manufacturer;
    @XmlElement(name = "planeId")
    private int planeId;

    public Plane() {

    }

    public Plane(int id, int year, String model, PlaneManufacturer manufacturer) {
        this.planeId = id;
        this.year = year;
        this.model = model;
        this.manufacturer = manufacturer;
    }

    @Override
    public String toString() {
        return "Plane{" + "year=" + year + ", model='" + model + '\'' + ", manufacturer='" + manufacturer + '\'' + ", planeId=" + planeId + '}';
    }

    public int getPlaneId() {
        return planeId;
    }

    public void setPlaneId(int planeId) {
        this.planeId = planeId;
    }

    public int getYear() {
        return year;
    }

    public String getModel() {
        return model;
    }

    public int getModelId() {
        return Integer.parseInt(this.model);
    }

    public PlaneManufacturer getManufacturer() {
        return manufacturer;
    }

    public void setModelId(int i) {
        this.model = String.valueOf(i);
    }
}
