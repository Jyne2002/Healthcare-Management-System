package Model;

public class Doctor {
    private int id;
    private String name;
    private String specialization;
    private String availability;
    private double doctorFee;

    public Doctor(int id, String name, String specialization, String availability, double doctorFee) {
        this.id = id;
        this.name = name;
        this.specialization = specialization;
        this.availability = availability;
        this.doctorFee = doctorFee;
    }


    public Doctor(String name, String specialization, String availability, double doctorFee) {
        this.name = name;
        this.specialization = specialization;
        this.availability = availability;
        this.doctorFee = doctorFee;
    }


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

    public double getDoctorFee() {
        return doctorFee;
    }

    public void setDoctorFee(double doctorFee) {
        this.doctorFee = doctorFee;
    }
}
