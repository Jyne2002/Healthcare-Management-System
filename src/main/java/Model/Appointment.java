package Model;

import java.sql.Date;
import java.sql.Time;

public class Appointment {
    private int id;  // Updated field name from appointmentId to id
    private int patientId;
    private int doctorId;
    private Date appointmentDate;  // Use java.sql.Date
    private Time appointmentTime;  // Use java.sql.Time
    private double fees;

    // Constructor
    public Appointment(int id, int patientId, int doctorId, Date appointmentDate, Time appointmentTime, double fees) {
        this.id = id;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.fees = fees;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public Time getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(Time appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public double getFees() {
        return fees;
    }

    public void setFees(double fees) {
        this.fees = fees;
    }

    @Override
    public String toString() {
        return "Appointment [id=" + id + ", patientId=" + patientId + ", doctorId=" + doctorId
                + ", appointmentDate=" + appointmentDate + ", appointmentTime=" + appointmentTime + ", fees=" + fees + "]";
    }
}
