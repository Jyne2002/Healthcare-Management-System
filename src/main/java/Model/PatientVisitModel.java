package Model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import static Database.DatabaseConnection.*;



public class PatientVisitModel {


    public List<Object[]> getPatientDetails(int month, int year) {
        String query = "SELECT Name, Age, Address, Contact, DateAdded FROM patient_records WHERE MONTH(DateAdded) = ? AND YEAR(DateAdded) = ?";
        List<Object[]> patientDetails = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, month);
            stmt.setInt(2, year);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Object[] row = {
                        rs.getString("Name"),
                        rs.getInt("Age"),
                        rs.getString("Address"),
                        rs.getString("Contact"),
                        rs.getDate("DateAdded")
                };
                patientDetails.add(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return patientDetails;
    }
}
