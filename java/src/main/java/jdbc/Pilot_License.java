package jdbc;

public class Pilot_License {

    private int license_id;
    private String issued_on;
    private String expires;
    private int pilot_id;

    public Pilot_License() {

    }

    public Pilot_License(int id, String issued, String expires, int pilot_id) {
        this.license_id = id;
        this.issued_on = issued;
        this.expires = expires;
        this.pilot_id = pilot_id;
    }

    @Override
    public String toString() {
        return "Pilot_License{" + "license_id=" + license_id + ", issued_on='" + issued_on + '\'' + ", expires='" + expires + '\'' + ", pilot_id=" + pilot_id + '}';
    }

    public int getLicense_id() {
        return license_id;
    }

    public void setLicense_id(int license_id) {
        this.license_id = license_id;
    }

    public String getIssued_on() {
        return issued_on;
    }

    public void setIssued_on(String issued_on) {
        this.issued_on = issued_on;
    }

    public String getExpires() {
        return expires;
    }

    public void setExpires(String expires) {
        this.expires = expires;
    }

    public int getPilot_id() {
        return pilot_id;
    }

    public void setPilot_id(int pilot_id) {
        this.pilot_id = pilot_id;
    }
}
