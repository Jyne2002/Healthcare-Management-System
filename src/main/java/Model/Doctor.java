package Model;

public class Doctor {
    private int id;
    private String name;
    private String specialization;
    private String availability;
    private String contactNumber;

    public Doctor(int id, String name, String specialization, String availability, String contactNumber) {
        this.id = id;
        this.name = name;
        this.specialization = specialization;
        this.availability = availability;
        this.contactNumber = contactNumber;
    }

    // Constructor without ID for new entries
    public Doctor(String name, String specialization, String availability, String contactNumber) {
        this.name = name;
        this.specialization = specialization;
        this.availability = availability;
        this.contactNumber = contactNumber;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
}
