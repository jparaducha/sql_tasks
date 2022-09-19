package jdbc;

public class PlaneModel {

    private int model_id;
    private String model_name;
    private PlaneManufacturer manufacturer;

    public PlaneModel() {

    }

    public PlaneModel(int model_id, String model_name, PlaneManufacturer manufacturer) {
        this.model_id = model_id;
        this.model_name = model_name;
        this.manufacturer = manufacturer;
    }

    public int getModel_id() {
        return model_id;
    }

    public void setModel_id(int model_id) {
        this.model_id = model_id;
    }

    public String getModel_name() {
        return model_name;
    }

    public void setModel_name(String model_name) {
        this.model_name = model_name;
    }

    public PlaneManufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(PlaneManufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }
}
