package jdbc;

public class Pilot {

    private int pilot_id;
    private String pilot_name;
    private int pilot_age;
    private Pilot_License license;

    public Pilot() {

    }

    public Pilot(int id, String name, int age, Pilot_License license) {
        this.pilot_id = id;
        this.pilot_name = name;
        this.pilot_age = age;
        this.license = license;
    }

    @Override
    public String toString() {
        return "Pilot{" + "pilot_id=" + pilot_id + ", pilot_name='" + pilot_name + '\'' + ", pilot_age=" + pilot_age + ", license=" + license + '}';
    }

    public int getPilot_id() {
        return pilot_id;
    }

    public void setPilot_id(int pilot_id) {
        this.pilot_id = pilot_id;
    }

    public String getPilot_name() {
        return pilot_name;
    }

    public void setPilot_name(String pilot_name) {
        this.pilot_name = pilot_name;
    }

    public int getPilot_age() {
        return pilot_age;
    }

    public void setPilot_age(int pilot_age) {
        this.pilot_age = pilot_age;
    }

    public Pilot_License getLicense() {
        return license;
    }

    public void setLicense(Pilot_License license) {
        this.license = license;
    }
}
