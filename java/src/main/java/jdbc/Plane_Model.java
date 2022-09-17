package jdbc;

public class Plane_Model {

    private int model_id;
    private String model_name;
    private Plane_Manufacturer manufacturer;

    public Plane_Model() {

    }

    public Plane_Model(int model_id, String model_name, Plane_Manufacturer manufacturer) {
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

    public Plane_Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Plane_Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }
}
