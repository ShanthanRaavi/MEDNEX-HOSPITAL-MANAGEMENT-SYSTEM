package src;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Patient implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
    private String name;
    private String problem;
    private String department;
    private String doctor;
    private boolean admitted = true;
    private LocalDateTime dischargedTime;

    public Patient(int id, String name, String problem,
                   String department, String doctor) {
        this.id = id;
        this.name = name;
        this.problem = problem;
        this.department = department;
        this.doctor = doctor;
    }

    public int getId(){ return id; }
    public String getName(){ return name; }
    public String getDepartment(){ return department; }
    public String getDoctor(){ return doctor; }
    public boolean isAdmitted(){ return admitted; }

    public void discharge(){
        admitted = false;
        dischargedTime = LocalDateTime.now();
    }
}
