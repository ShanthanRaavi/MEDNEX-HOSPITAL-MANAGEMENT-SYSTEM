package src;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class PatientTableGUI {

    public PatientTableGUI() {
        JFrame frame = new JFrame("Admitted Patients");
        frame.setSize(700, 300);
        frame.setLocationRelativeTo(null);

        DefaultTableModel model = new DefaultTableModel(
                new String[]{"Patient ID","Name","Department","Doctor","Status"},0
        );

        for (Patient p : PatientServiceGUI.getPatients()) {
            if (p.isAdmitted()) {
                model.addRow(new Object[]{
                        p.getId(),
                        p.getName(),
                        p.getDepartment(),
                        p.getDoctor(),
                        "Admitted"
                });
            }
        }

        frame.add(new JScrollPane(new JTable(model)));
        frame.setVisible(true);
    }
}
