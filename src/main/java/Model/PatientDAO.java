package Model;
import javax.xml.crypto.Data;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PatientDAO {
    public void addPatient(Patient patient) throws SQLException {
        String query = "INSERT INTO patient_records (Name, Age, Gender, Contact, Email, VisitDate) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, patient.getName());
            stmt.setInt(2, patient.getAge());
            stmt.setInt(3, patient.getGender());
            stmt.setString(4, patient.getContact());
            stmt.setString(5, patient.getEmail());
            stmt.setString(6, patient.getVisitDate());
            stmt.executeUpdate();
        }
    }

    public void updatePatient(Patient patient) throws SQLException {
        String query = "UPDATE patient_records SET Name=?, Age=?, Gender=?, Contact=?, Email=?, VisitDate=? WHERE id=?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, patient.getName());
            stmt.setInt(2, patient.getAge());
            stmt.setInt(3, patient.getGender());
            stmt.setString(4, patient.getContact());
            stmt.setString(5, patient.getEmail());
            stmt.setString(6, patient.getVisitDate());
            stmt.setInt(7, patient.getId());
            stmt.executeUpdate();
        }
    }

    public void deletePatient(int id) throws SQLException {
        String query = "DELETE FROM patient_records WHERE id=?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    public List<Patient> getAllPatients() throws SQLException {
        List<Patient> patients = new ArrayList<>();
        String query = "SELECT * FROM patient_records";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                patients.add(new Patient(
                        rs.getInt("id"),
                        rs.getString("Name"),
                        rs.getInt("Age"),
                        rs.getInt("Gender"),
                        rs.getString("Contact"),
                        rs.getString("Email"),
                        rs.getString("VisitDate")
                ));
            }
        }
        return patients;
    }
}
