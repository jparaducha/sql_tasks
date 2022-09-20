package jdbc;

public class PilotLicense {

    private int licenseId;
    private String issuedOn;
    private String expires;
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

    public int getLicenseId() {
        return licenseId;
    }

    public void setLicenseId(int licenseId) {
        this.licenseId = licenseId;
    }

    public String getIssuedOn() {
        return issuedOn;
    }

    public void setIssuedOn(String issuedOn) {
        this.issuedOn = issuedOn;
    }

    public String getExpires() {
        return expires;
    }

    public void setExpires(String expires) {
        this.expires = expires;
    }

    public int getPilotId() {
        return pilotId;
    }

    public void setPilotId(int pilotId) {
        this.pilotId = pilotId;
    }
}
