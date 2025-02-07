package Controller;

import Model.PatientVisitModel;
import java.util.List;

public class PatientVisitReportController {
    private PatientVisitModel model;

    public PatientVisitReportController() {
        model = new PatientVisitModel();
    }

    public Object[][] getPatientDetailsForReport(int month, int year) {
        List<Object[]> patientDetails = model.getPatientDetails(month, year);

        // Convert List to objectsss
        Object[][] data = new Object[patientDetails.size()][];
        for (int i = 0; i < patientDetails.size(); i++) {
            data[i] = patientDetails.get(i);
        }
        return data;
    }
}
