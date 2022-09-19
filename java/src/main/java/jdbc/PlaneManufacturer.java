package jdbc;

public class PlaneManufacturer {

    private int manufacturer_id;
    private String manufacturer_name;

    public PlaneManufacturer() {

    }

    public PlaneManufacturer(int manufacturer_id, String manufacturer_name) {
        this.manufacturer_id = manufacturer_id;
        this.manufacturer_name = manufacturer_name;
    }

    @Override
    public String toString() {
        return "Plane_Manufacturer{" + "manufacturer_id=" + manufacturer_id + ", manufacturer_name='" + manufacturer_name + '\'' + '}';
    }

    public int getManufacturer_id() {
        return manufacturer_id;
    }

    public void setManufacturer_id(int manufacturer_id) {
        this.manufacturer_id = manufacturer_id;
    }

    public String getManufacturer_name() {
        return manufacturer_name;
    }

    public void setManufacturer_name(String manufacturer_name) {
        this.manufacturer_name = manufacturer_name;
    }
}
