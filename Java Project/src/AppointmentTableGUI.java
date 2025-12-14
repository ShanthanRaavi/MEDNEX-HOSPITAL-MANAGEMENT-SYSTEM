package src;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class AppointmentTableGUI {

    public AppointmentTableGUI() {
        JFrame frame = new JFrame("Appointments");
        frame.setSize(700,300);
        frame.setLocationRelativeTo(null);

        DefaultTableModel model = new DefaultTableModel(
                new String[]{"Appointment ID","Patient","Department","Doctor","Date","Time"},0
        );

        for (Appointment a : PatientServiceGUI.getAppointments()) {
            model.addRow(new Object[]{
                    a.getId(),
                    a.getPatient(),
                    a.getDepartment(),
                    a.getDoctor(),
                    a.getDate(),
                    a.getTime()
            });
        }

        JTable table = new JTable(model);
        JButton cancel = new JButton("Cancel Appointment");

        cancel.addActionListener(e -> {
            int row = table.getSelectedRow();
            int id = (int) model.getValueAt(row,0);
            PatientServiceGUI.cancelAppointmentFromGUI(id);
            model.removeRow(row);
        });

        frame.add(new JScrollPane(table),"Center");
        frame.add(cancel,"South");
        frame.setVisible(true);
    }
}
