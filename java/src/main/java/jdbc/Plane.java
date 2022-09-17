package jdbc;

public class Plane {

    private int year;
    private String model;
    private Plane_Manufacturer manufacturer;
    private int planeId;

    public Plane() {

    }

    public Plane(int id, int year, String model, Plane_Manufacturer manufacturer) {
        this.planeId = id;
        this.year = year;
        this.model = model;
        this.manufacturer = manufacturer;
    }

    @Override
    public String toString() {
        return "Plane{" + "year=" + year + ", model='" + model + '\'' + ", manufacturer='" + manufacturer + '\'' + ", planeId=" + planeId + '}';
    }

    public int getPlaneId() {
        return planeId;
    }

    public void setPlaneId(int planeId) {
        this.planeId = planeId;
    }

    public int getYear() {
        return year;
    }

    public String getModel() {
        return model;
    }

    public int getModelId() {
        return Integer.parseInt(this.model);
    }

    public Plane_Manufacturer getManufacturer() {
        return manufacturer;
    }
}
