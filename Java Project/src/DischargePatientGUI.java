package src;

import javax.swing.*;

public class DischargePatientGUI {

    public DischargePatientGUI() {
        JFrame frame = new JFrame("Discharge Patient");
        frame.setSize(400,200);
        frame.setLocationRelativeTo(null);

        JComboBox<String> box = new JComboBox<>();

        for (Patient p : PatientServiceGUI.getPatients()) {
            if (p.isAdmitted()) {
                box.addItem(p.getId()+" - "+p.getName());
            }
        }

        JButton discharge = new JButton("Discharge");

        frame.setLayout(new BoxLayout(frame.getContentPane(),BoxLayout.Y_AXIS));
        frame.add(box);
        frame.add(discharge);
        frame.setVisible(true);

        discharge.addActionListener(e -> {
            int id = Integer.parseInt(
                    box.getSelectedItem().toString().split(" - ")[0]
            );
            PatientServiceGUI.dischargeFromGUI(id);
            JOptionPane.showMessageDialog(frame,"Patient Discharged");
            frame.dispose();
        });
    }
}
