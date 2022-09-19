package jdbc;

public class Pilot {

    private int pilotId;
    private String pilotName;
    private int pilotAge;
    private PilotLicense license;

    public Pilot() {

    }

    public Pilot(int id, String name, int age, PilotLicense license) {
        this.pilotId = id;
        this.pilotName = name;
        this.pilotAge = age;
        this.license = license;
    }

    @Override
    public String toString() {
        return "Pilot{" + "pilot_id=" + pilotId + ", pilot_name='" + pilotName + '\'' + ", pilot_age=" + pilotAge + ", license=" + license + '}';
    }

    public int getPilotId() {
        return pilotId;
    }

    public void setPilotId(int pilotId) {
        this.pilotId = pilotId;
    }

    public String getPilotName() {
        return pilotName;
    }

    public void setPilotName(String pilotName) {
        this.pilotName = pilotName;
    }

    public int getPilotAge() {
        return pilotAge;
    }

    public void setPilotAge(int pilotAge) {
        this.pilotAge = pilotAge;
    }

    public PilotLicense getLicense() {
        return license;
    }

    public void setLicense(PilotLicense license) {
        this.license = license;
    }
}
