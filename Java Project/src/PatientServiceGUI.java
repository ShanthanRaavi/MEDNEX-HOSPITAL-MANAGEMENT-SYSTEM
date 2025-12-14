package src;

import java.util.List;

public class PatientServiceGUI {

    public static void addPatientFromGUI(String n,String p,int d){
        PatientService.addPatientFromGUI(n,p,d);
    }

    public static List<Patient> getPatients(){
        return PatientService.getAllPatients();
    }

    public static void addAppointmentFromGUI(String n,int d){
        PatientService.addAppointmentFromGUI(n,d);
    }

    public static List<Appointment> getAppointments(){
        return PatientService.getAllAppointments();
    }

    public static void cancelAppointmentFromGUI(int id){
        PatientService.cancelAppointmentById(id);
    }

    public static void dischargeFromGUI(int id){
        PatientService.dischargePatientById(id);
    }
}
