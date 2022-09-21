package jdbc;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

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

    public int getModelId() {
        return modelId;
    }

    public void setModelId(int modelId) {
        this.modelId = modelId;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public PlaneManufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(PlaneManufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }
}
