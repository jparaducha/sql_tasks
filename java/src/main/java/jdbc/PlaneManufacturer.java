package jdbc;

public class PlaneManufacturer {

    private int manufacturerId;
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
