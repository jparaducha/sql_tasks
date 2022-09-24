package jdbc.model;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonSetter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@JsonRootName("pilot")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@XmlRootElement(name = "pilot")
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

    @JsonGetter("pilotId")
    public int getPilotId() {
        return pilotId;
    }

    @JsonSetter("pilotId")
    public void setPilotId(int pilotId) {
        this.pilotId = pilotId;
    }

    @JsonGetter("pilotName")
    public String getPilotName() {
        return pilotName;
    }

    @JsonSetter("pilotName")
    public void setPilotName(String pilotName) {
        this.pilotName = pilotName;
    }

    @JsonGetter("pilotAge")
    public int getPilotAge() {
        return pilotAge;
    }

    @JsonSetter("pilotAge")
    public void setPilotAge(int pilotAge) {
        this.pilotAge = pilotAge;
    }

    @JsonGetter("license")
    public PilotLicense getLicense() {
        return license;
    }

    @JsonSetter("license")
    public void setLicense(PilotLicense license) {
        this.license = license;
    }
}
