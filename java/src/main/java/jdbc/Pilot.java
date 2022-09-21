package jdbc;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "passenger")
@XmlAccessorType(XmlAccessType.FIELD)
public class Pilot {

    @XmlElement(name = "pilotId")
    private int pilotId;
    @XmlElement(name = "pilotName")
    private String pilotName;
    @XmlElement(name = "pilotAge")
    private int pilotAge;
    @XmlElement(name = "license")
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
