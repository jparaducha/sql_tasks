package jdbc.model;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonSetter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@JsonRootName("pilotLicense")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@XmlRootElement(name = "pilotLicense")
@XmlAccessorType(XmlAccessType.FIELD)
public class PilotLicense {

    @XmlElement(name = "licenseId")
    private int licenseId;
    @XmlElement(name = "issuedOn")
    private String issuedOn;
    @XmlElement(name = "expires")
    private String expires;
    @XmlElement(name = "pilotId")
    private int pilotId;

    public PilotLicense() {

    }

    public PilotLicense(int id, String issued, String expires, int pilotId) {
        this.licenseId = id;
        this.issuedOn = issued;
        this.expires = expires;
        this.pilotId = pilotId;
    }

    @Override
    public String toString() {
        return "Pilot_License{" + "license_id=" + licenseId + ", issued_on='" + issuedOn + '\'' + ", expires='" + expires + '\'' + ", pilot_id=" + pilotId + '}';
    }

    @JsonGetter("licenseId")
    public int getLicenseId() {
        return licenseId;
    }

    @JsonSetter("licenseId")
    public void setLicenseId(int licenseId) {
        this.licenseId = licenseId;
    }

    @JsonGetter("issuedOn")
    public String getIssuedOn() {
        return issuedOn;
    }

    @JsonSetter("issuedOn")
    public void setIssuedOn(String issuedOn) {
        this.issuedOn = issuedOn;
    }

    @JsonGetter("expires")
    public String getExpires() {
        return expires;
    }

    @JsonSetter("expires")
    public void setExpires(String expires) {
        this.expires = expires;
    }

    @JsonGetter("pilotId")
    public int getPilotId() {
        return pilotId;
    }

    @JsonSetter("pilotId")
    public void setPilotId(int pilotId) {
        this.pilotId = pilotId;
    }
}
