package Controller;

import Model.Doctor;
import Database.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DoctorController {


    public List<Doctor> getDoctors() {
        List<Doctor> doctors = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM doctors")) {

            while (rs.next()) {
                doctors.add(new Doctor(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("specialization"),
                        rs.getString("availability"),
                        rs.getDouble("doctor_fee")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return doctors;
    }


    public void addDoctor(Doctor doctor) {
        String query = "INSERT INTO doctors (id, name, specialization, availability, doctor_fee) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, doctor.getId());
            pstmt.setString(2, doctor.getName());
            pstmt.setString(3, doctor.getSpecialization());
            pstmt.setString(4, doctor.getAvailability());
            pstmt.setDouble(5, doctor.getDoctorFee());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void updateDoctor(int id, Doctor doctor) {
        String query = "UPDATE doctors SET name = ?, specialization = ?, availability = ?, doctor_fee = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, doctor.getName());
            pstmt.setString(2, doctor.getSpecialization());
            pstmt.setString(3, doctor.getAvailability());
            pstmt.setDouble(4, doctor.getDoctorFee());
            pstmt.setInt(5, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void removeDoctor(int id) {
        String query = "DELETE FROM doctors WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
