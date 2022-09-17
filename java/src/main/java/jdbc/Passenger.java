package jdbc;

public class Passenger {

    private int passenger_id;
    private String passenger_name;
    private int passenger_contact_number;

    public Passenger(int passenger_id, String passenger_name, int passenger_contact_number) {
        this.passenger_id = passenger_id;
        this.passenger_name = passenger_name;
        this.passenger_contact_number = passenger_contact_number;
    }

    public Passenger() {

    }

    public Passenger(int passenger_id, String passenger_name) {
        this.passenger_id = passenger_id;
        this.passenger_name = passenger_name;
    }

    @Override
    public String toString() {
        return "Passenger{" + "passenger_id=" + passenger_id + ", passenger_name='" + passenger_name + '\'' + ", passenger_contact_number=" + passenger_contact_number + '}';
    }

    public int getPassenger_id() {
        return passenger_id;
    }

    public void setPassenger_id(int passenger_id) {
        this.passenger_id = passenger_id;
    }

    public String getPassenger_name() {
        return passenger_name;
    }

    public void setPassenger_name(String passenger_name) {
        this.passenger_name = passenger_name;
    }
}
