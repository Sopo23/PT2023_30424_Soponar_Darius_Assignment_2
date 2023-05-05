package View;

import javax.swing.*;
import java.awt.*;

public class SimulationGUI {


    private JFrame frmLastRunStats;
    private JTextField txtAverageWaitingTime;
    private JTextField txtAverageServiceTime;
    private JTextField txtPeakHour;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private int peakHour, averageWaitingTime, averageServiceTime;

    public JFrame getFrame()
    {
        return this.frmLastRunStats;
    }
    /**
     * Create the application.
     */
    public SimulationGUI(int peakHour, int averageWaitingTime, int averageServiceTime) {
        peakHour = peakHour;
        averageServiceTime = averageServiceTime;
        averageWaitingTime = averageWaitingTime;
        initialize();
        textField.setText(averageWaitingTime + "");
        textField_1.setText(averageServiceTime + "");
        textField_2.setText(peakHour + "");

    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frmLastRunStats = new JFrame();
        frmLastRunStats.setResizable(false);
        frmLastRunStats.setTitle("Last run stats");
        frmLastRunStats.setBounds(100, 100, 277, 158);
        frmLastRunStats.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        frmLastRunStats.getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        txtAverageWaitingTime = new JTextField();
        txtAverageWaitingTime.setBorder(null);
        txtAverageWaitingTime.setBackground(Color.WHITE);
        txtAverageWaitingTime.setFont(new Font("Mongolian Baiti", Font.PLAIN, 13));
        txtAverageWaitingTime.setFocusTraversalKeysEnabled(false);
        txtAverageWaitingTime.setFocusable(false);
        txtAverageWaitingTime.setEditable(false);
        txtAverageWaitingTime.setText("Average waiting time");
        txtAverageWaitingTime.setBounds(10, 27, 124, 20);
        panel.add(txtAverageWaitingTime);
        txtAverageWaitingTime.setColumns(10);

        txtAverageServiceTime = new JTextField();
        txtAverageServiceTime.setText("Average service time");
        txtAverageServiceTime.setFont(new Font("Mongolian Baiti", Font.PLAIN, 13));
        txtAverageServiceTime.setFocusable(false);
        txtAverageServiceTime.setFocusTraversalKeysEnabled(false);
        txtAverageServiceTime.setEditable(false);
        txtAverageServiceTime.setColumns(10);
        txtAverageServiceTime.setBorder(null);
        txtAverageServiceTime.setBackground(Color.WHITE);
        txtAverageServiceTime.setBounds(10, 58, 124, 20);
        panel.add(txtAverageServiceTime);

        txtPeakHour = new JTextField();
        txtPeakHour.setText("Peak hour");
        txtPeakHour.setFont(new Font("Mongolian Baiti", Font.PLAIN, 13));
        txtPeakHour.setFocusable(false);
        txtPeakHour.setFocusTraversalKeysEnabled(false);
        txtPeakHour.setEditable(false);
        txtPeakHour.setColumns(10);
        txtPeakHour.setBorder(null);
        txtPeakHour.setBackground(Color.WHITE);
        txtPeakHour.setBounds(10, 89, 124, 20);
        panel.add(txtPeakHour);

        textField = new JTextField();
        textField.setBounds(144, 26, 86, 20);
        panel.add(textField);
        textField.setColumns(10);

        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(144, 57, 86, 20);
        panel.add(textField_1);

        textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setBounds(144, 88, 86, 20);
        panel.add(textField_2);
    }

}
