package jdbc.model;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonSetter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@JsonRootName("plane")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@XmlRootElement(name = "plane")
@XmlAccessorType(XmlAccessType.FIELD)
public class Plane {

    @XmlElement(name = "year")
    private int year;
    @XmlElement(name = "modelId")
    private String modelId;
    @XmlElement(name = "manufacturer")
    private PlaneManufacturer manufacturer;
    @XmlElement(name = "planeId")
    private int planeId;

    public Plane() {

    }

    public Plane(int id, int year, String modelId, PlaneManufacturer manufacturer) {
        this.planeId = id;
        this.year = year;
        this.modelId = modelId;
        this.manufacturer = manufacturer;
    }

    @Override
    public String toString() {
        return "Plane{" + "year=" + year + ", model='" + modelId + '\'' + ", manufacturer='" + manufacturer + '\'' + ", planeId=" + planeId + '}';
    }

    @JsonGetter("planeId")
    public int getPlaneId() {
        return planeId;
    }

    @JsonSetter("planeId")
    public void setPlaneId(int planeId) {
        this.planeId = planeId;
    }

    @JsonGetter("year")
    public int getYear() {
        return year;
    }

    @JsonGetter("modelId")
    public String getModelId() {
        return modelId;
    }

    /*
    @JsonGetter("modelId")
    public int getModelId() {
        return Integer.parseInt(this.model);
    }
*/
    @JsonGetter("manufacturer")
    public PlaneManufacturer getManufacturer() {
        return manufacturer;
    }

    @JsonSetter("modelId")
    public void setModelId(int i) {
        this.modelId = String.valueOf(i);
    }

    @JsonSetter("year")
    public void setYear(int year) {
        this.year = year;
    }

    @JsonSetter("modelId")
    public void setModelId(String modelId) {
        this.modelId = modelId;
    }

    @JsonSetter("manufacturer")
    public void setManufacturer(PlaneManufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }
}
