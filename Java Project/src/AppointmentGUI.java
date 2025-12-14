package src;

import javax.swing.*;

public class AppointmentGUI {

    public AppointmentGUI() {
        JFrame frame = new JFrame("Add Appointment");
        frame.setSize(300,200);
        frame.setLocationRelativeTo(null);

        JTextField name = new JTextField();
        JComboBox<String> dept = new JComboBox<>(
                new String[]{"Cardiology","Neurology","Orthopedics","Pediatrics"}
        );
        JButton book = new JButton("Book Appointment");

        frame.setLayout(new BoxLayout(frame.getContentPane(),BoxLayout.Y_AXIS));
        frame.add(new JLabel("Patient Name"));
        frame.add(name);
        frame.add(dept);
        frame.add(book);
        frame.setVisible(true);

        book.addActionListener(e -> {
            PatientServiceGUI.addAppointmentFromGUI(
                    name.getText(), dept.getSelectedIndex()+1
            );
            JOptionPane.showMessageDialog(frame,"Appointment Booked");
            frame.dispose();
            new AppointmentTableGUI();
        });
    }
}
