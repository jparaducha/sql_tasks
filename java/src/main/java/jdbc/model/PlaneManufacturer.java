package jdbc.model;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonSetter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@JsonRootName("planeManufacturer")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
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

    @JsonGetter("manufacturerId")
    public int getManufacturerId() {
        return manufacturerId;
    }

    @JsonSetter("manufacturerId")
    public void setManufacturerId(int manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    @JsonGetter("manufacturerName")
    public String getManufacturerName() {
        return manufacturerName;
    }

    @JsonSetter("manufacturerName")
    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }
}
