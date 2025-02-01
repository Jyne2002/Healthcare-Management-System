package main;
import Controller.*;
import Model.*;
import View.*;

public class PatientMain {
    public static void main(String[] args) {
        PatientView view = new PatientView();
        PatientDAO dao = new PatientDAO();
        new PatientController(view, dao);
        view.setVisible(true);
    }
//eifepgpdgnss99

}
