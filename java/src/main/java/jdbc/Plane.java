package jdbc;

public class Plane {

    public void setYear(int year) {
        this.year = year;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setManufacturer(PlaneManufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    private int year;
    private String model;
    private PlaneManufacturer manufacturer;
    private int planeId;

    public Plane() {

    }

    public Plane(int id, int year, String model, PlaneManufacturer manufacturer) {
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

    public PlaneManufacturer getManufacturer() {
        return manufacturer;
    }

    public void setModelId(int i) {
        this.model = String.valueOf(i);
    }
}
