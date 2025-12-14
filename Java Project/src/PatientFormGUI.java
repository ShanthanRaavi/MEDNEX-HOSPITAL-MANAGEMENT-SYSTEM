package src;

import javax.swing.*;
import java.awt.*;

public class PatientFormGUI {

    public PatientFormGUI() {
        JFrame frame = new JFrame("Add Patient");
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(5,2,10,10));
        panel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));

        JTextField name = new JTextField();
        JTextField problem = new JTextField();
        JComboBox<String> dept = new JComboBox<>(
                new String[]{"Cardiology","Neurology","Orthopedics","Pediatrics"}
        );

        JButton save = new JButton("Save");

        panel.add(new JLabel("Name"));
        panel.add(name);
        panel.add(new JLabel("Problem"));
        panel.add(problem);
        panel.add(new JLabel("Department"));
        panel.add(dept);
        panel.add(new JLabel());
        panel.add(save);

        frame.add(panel);
        frame.setVisible(true);

        save.addActionListener(e -> {
            PatientServiceGUI.addPatientFromGUI(
                    name.getText(),
                    problem.getText(),
                    dept.getSelectedIndex()+1
            );
            JOptionPane.showMessageDialog(frame,"Patient Added Successfully");
            frame.dispose();
        });
    }
}
