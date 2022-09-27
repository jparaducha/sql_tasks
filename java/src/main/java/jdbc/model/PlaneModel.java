package jdbc.model;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonSetter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@JsonRootName("planeModel")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@XmlRootElement(name = "planeModel")
@XmlAccessorType(XmlAccessType.FIELD)
public class PlaneModel {

    @XmlElement(name = "modelId")
    private int modelId;
    @XmlElement(name = "modelName")
    private String model_name;
    @XmlElement(name = "manufacturer")
    private PlaneManufacturer manufacturer;

    public PlaneModel() {

    }

    @Override
    public String toString() {
        return "PlaneModel{" + "modelId=" + modelId + ", model_name='" + model_name + '\'' + ", manufacturer=" + manufacturer + '}';
    }

    public PlaneModel(int modelId, String model_name, PlaneManufacturer manufacturer) {
        this.modelId = modelId;
        this.model_name = model_name;
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
    public String getModel_name() {
        return model_name;
    }

    @JsonSetter("modelName")
    public void setModel_name(String model_name) {
        this.model_name = model_name;
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
