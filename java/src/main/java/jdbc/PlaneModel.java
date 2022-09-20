package jdbc;

public class PlaneModel {

    private int modelId;
    private String modelName;
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
