package src;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

public class Appointment implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
    private String patient;
    private String department;
    private String doctor;
    private LocalDate date;
    private LocalTime time;

    public Appointment(int id, String patient,
                       String department, String doctor,
                       LocalDate date, LocalTime time) {
        this.id = id;
        this.patient = patient;
        this.department = department;
        this.doctor = doctor;
        this.date = date;
        this.time = time;
    }

    public int getId(){ return id; }
    public String getPatient(){ return patient; }
    public String getDepartment(){ return department; }
    public String getDoctor(){ return doctor; }
    public LocalDate getDate(){ return date; }
    public LocalTime getTime(){ return time; }
}
