package jdbc;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "planeManufacturer")
@XmlAccessorType(XmlAccessType.FIELD)
public class PlaneManufacturer {

    @XmlElement(name = "manufacturerId")
    private int manufacturerId;
    @XmlElement(name = "manufacturerName")
    private String manufacturerName;

    public PlaneManufacturer() {

    }

    public PlaneManufacturer(int manufacturerId, String manufacturerName) {
        this.manufacturerId = manufacturerId;
        this.manufacturerName = manufacturerName;
    }

    @Override
    public String toString() {
        return "Plane_Manufacturer{" + "manufacturer_id=" + manufacturerId + ", manufacturer_name='" + manufacturerName + '\'' + '}';
    }

    public int getManufacturerId() {
        return manufacturerId;
    }

    public void setManufacturerId(int manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }
}
