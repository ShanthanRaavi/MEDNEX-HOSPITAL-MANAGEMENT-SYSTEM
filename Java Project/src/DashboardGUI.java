package src;

import javax.swing.*;
import java.awt.*;

public class DashboardGUI {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(DashboardGUI::new);
    }

    public DashboardGUI() {
        JFrame frame = new JFrame("MedNex Hospital Management System");
        frame.setSize(520, 420);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(7,1,10,10));
        panel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));

        panel.add(new JLabel("MedNex Hospital Management System", JLabel.CENTER));

        JButton addPatient = new JButton("Add Patient");
        JButton viewPatients = new JButton("View Patients");
        JButton discharge = new JButton("Discharge Patient");
        JButton addAppointment = new JButton("Add Appointment");
        JButton viewAppointments = new JButton("View Appointments");
        JButton exit = new JButton("Exit");

        panel.add(addPatient);
        panel.add(viewPatients);
        panel.add(discharge);
        panel.add(addAppointment);
        panel.add(viewAppointments);
        panel.add(exit);

        frame.add(panel);
        frame.setVisible(true);

        addPatient.addActionListener(e -> new PatientFormGUI());
        viewPatients.addActionListener(e -> new PatientTableGUI());
        discharge.addActionListener(e -> new DischargePatientGUI());
        addAppointment.addActionListener(e -> new AppointmentGUI());
        viewAppointments.addActionListener(e -> new AppointmentTableGUI());
        exit.addActionListener(e -> System.exit(0));
    }
}
