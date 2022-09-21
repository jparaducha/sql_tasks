package jdbc;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonSetter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@JsonRootName("planeModel")
@XmlRootElement(name = "planeModel")
@XmlAccessorType(XmlAccessType.FIELD)
public class PlaneModel {

    @XmlElement(name = "modelId")
    private int modelId;
    @XmlElement(name = "modelName")
    private String modelName;
    @XmlElement(name = "manufacturer")
    private PlaneManufacturer manufacturer;

    public PlaneModel() {

    }

    public PlaneModel(int modelId, String modelName, PlaneManufacturer manufacturer) {
        this.modelId = modelId;
        this.modelName = modelName;
        this.manufacturer = manufacturer;
    }

    @JsonGetter("modelId")
    public int getModelId() {
        return modelId;
    }

    @JsonSetter("modelId")
    public void setModelId(int modelId) {
        this.modelId = modelId;
    }

    @JsonGetter("modelName")
    public String getModelName() {
        return modelName;
    }

    @JsonSetter("modelName")
    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    @JsonGetter("manufacturer")
    public PlaneManufacturer getManufacturer() {
        return manufacturer;
    }

    @JsonSetter("manufacturer")
    public void setManufacturer(PlaneManufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }
}
