package src;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

public class PatientService {

    private static ArrayList<Patient> patients = loadPatients();
    private static ArrayList<Appointment> appointments = loadAppointments();

    private static final String PF = "patients.dat";
    private static final String AF = "appointments.dat";

    // ===== RANDOM PATIENT ID =====
    private static int generatePatientId() {
        Random r = new Random();
        int id;
        do {
            id = r.nextInt(900000) + 100000; // 6-digit
        } while (patientIdExists(id));
        return id;
    }

    private static boolean patientIdExists(int id) {
        for (Patient p : patients) {
            if (p.getId() == id) return true;
        }
        return false;
    }

    // ===== ADD PATIENT =====
    public static void addPatientFromGUI(String name,String problem,int d){
        String dept="", doc="";
        if(d==1){dept="Cardiology";doc="Dr. Alice";}
        if(d==2){dept="Neurology";doc="Dr. Bob";}
        if(d==3){dept="Orthopedics";doc="Dr. Kumar";}
        if(d==4){dept="Pediatrics";doc="Dr. Riya";}

        int newId = generatePatientId();
        patients.add(new Patient(newId,name,problem,dept,doc));
        savePatients();
    }

    // ===== APPOINTMENTS =====
    public static void addAppointmentFromGUI(String name,int d){
        String dept="", doc="";
        if(d==1){dept="Cardiology";doc="Dr. Alice";}
        if(d==2){dept="Neurology";doc="Dr. Bob";}
        if(d==3){dept="Orthopedics";doc="Dr. Kumar";}
        if(d==4){dept="Pediatrics";doc="Dr. Riya";}

        appointments.add(new Appointment(
                appointments.size()+1,
                name,dept,doc,
                LocalDate.now(), LocalTime.now()
        ));
        saveAppointments();
    }

    public static ArrayList<Patient> getAllPatients(){ return patients; }
    public static ArrayList<Appointment> getAllAppointments(){ return appointments; }

    public static void cancelAppointmentById(int id){
        appointments.removeIf(a -> a.getId()==id);
        saveAppointments();
    }

    public static void dischargePatientById(int id){
        for(Patient p:patients){
            if(p.getId()==id && p.isAdmitted()){
                p.discharge();
                savePatients();
                break;
            }
        }
    }

    // ===== FILE HANDLING =====
    private static void savePatients(){ save(PF,patients); }
    private static void saveAppointments(){ save(AF,appointments); }

    @SuppressWarnings("unchecked")
    private static ArrayList<Patient> loadPatients(){
        return (ArrayList<Patient>) load(PF);
    }

    @SuppressWarnings("unchecked")
    private static ArrayList<Appointment> loadAppointments(){
        return (ArrayList<Appointment>) load(AF);
    }

    private static Object load(String f){
        try(ObjectInputStream o=new ObjectInputStream(new FileInputStream(f))){
            return o.readObject();
        }catch(Exception e){ return new ArrayList<>(); }
    }

    private static void save(String f,Object o){
        try(ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(f))){
            out.writeObject(o);
        }catch(Exception e){}
    }
}
