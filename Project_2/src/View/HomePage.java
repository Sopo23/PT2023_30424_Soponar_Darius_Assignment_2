package View;

import businessModel.SelectionPolicy;
import businessModel.SimulationManager;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JSeparator;
import java.awt.FlowLayout;
import javax.swing.JScrollPane;
import java.awt.CardLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HomePage {

    private JFrame frame;
    private JTextField txtNumberTasks;
    private JTextField textField_1;
    private JTextField txtNumberServers;
    private JTextField textField_2;
    private JTextField textField;
    private JTextField txtSimulationTime;
    private JTextField textField_3;
    private JTextField txtMinArrival;
    private JTextField textField_4;
    private JTextField txtMaxArrival;
    private JTextField textField_5;
    private JTextField txtMinService;
    private JTextField textField_6;
    private JTextField txtMaxService;
    private JPanel panel_1;
    private JTextField txtQ;
    private int logged;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    HomePage window = new HomePage();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public HomePage() {
        initialize();
        logged = 0;
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 716, 412);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Queue management application");
        frame.setResizable(false);

        JPanel panel = new JPanel();
        panel.setBackground(Color.GRAY);
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        txtNumberTasks = new JTextField();
        txtNumberTasks.setBounds(25, 90, 101, 20);
        txtNumberTasks.setForeground(Color.WHITE);
        txtNumberTasks.setText("Number of Tasks");
        txtNumberTasks.setBorder(null);
        txtNumberTasks.setFont(new Font("Times New Roman", Font.BOLD, 15));
        txtNumberTasks.setHorizontalAlignment(SwingConstants.CENTER);
        txtNumberTasks.setBackground(Color.GRAY);
        txtNumberTasks.setEditable(false);
        panel.add(txtNumberTasks);
        txtNumberTasks.setColumns(10);

        textField_1 = new JTextField();
        textField_1.setHorizontalAlignment(SwingConstants.CENTER);
        textField_1.setBorder(null);
        textField_1.setFont(new Font("Mongolian Baiti", Font.PLAIN, 13));
        textField_1.setBounds(125, 91, 86, 20);
        textField_1.setBackground(Color.WHITE);
        panel.add(textField_1);
        textField_1.setColumns(10);

        txtNumberServers = new JTextField();
        txtNumberServers.setBounds(25, 121, 101, 20);
        txtNumberServers.setText("Number of Serers");
        txtNumberServers.setHorizontalAlignment(SwingConstants.CENTER);
        txtNumberServers.setForeground(Color.WHITE);
        txtNumberServers.setFont(new Font("Times New Roman", Font.BOLD, 15));
        txtNumberServers.setEditable(false);
        txtNumberServers.setColumns(10);
        txtNumberServers.setBorder(null);
        txtNumberServers.setBackground(Color.GRAY);
        panel.add(txtNumberServers);

        textField_2 = new JTextField();
        textField_2.setHorizontalAlignment(SwingConstants.CENTER);
        textField_2.setBorder(null);
        textField_2.setFont(new Font("Mongolian Baiti", Font.PLAIN, 13));
        textField_2.setBounds(125, 122, 86, 20);
        textField_2.setColumns(10);
        textField_2.setBackground(Color.WHITE);
        panel.add(textField_2);

        textField = new JTextField();
        textField.setHorizontalAlignment(SwingConstants.CENTER);
        textField.setBorder(null);
        textField.setFont(new Font("Mongolian Baiti", Font.PLAIN, 13));
        textField.setBounds(125, 153, 86, 20);
        textField.setColumns(10);
        textField.setBackground(Color.WHITE);
        panel.add(textField);

        txtSimulationTime = new JTextField();
        txtSimulationTime.setBounds(25, 152, 101, 20);
        txtSimulationTime.setText("Simulation Time");
        txtSimulationTime.setHorizontalAlignment(SwingConstants.CENTER);
        txtSimulationTime.setForeground(Color.WHITE);
        txtSimulationTime.setFont(new Font("Times New Roman", Font.BOLD, 15));
        txtSimulationTime.setEditable(false);
        txtSimulationTime.setColumns(10);
        txtSimulationTime.setBorder(null);
        txtSimulationTime.setBackground(Color.GRAY);
        panel.add(txtSimulationTime);

        textField_3 = new JTextField();
        textField_3.setHorizontalAlignment(SwingConstants.CENTER);
        textField_3.setBorder(null);
        textField_3.setFont(new Font("Mongolian Baiti", Font.PLAIN, 13));
        textField_3.setBounds(125, 185, 86, 20);
        textField_3.setColumns(10);
        textField_3.setBackground(Color.WHITE);
        panel.add(textField_3);

        txtMinArrival = new JTextField();
        txtMinArrival.setBounds(25, 184, 101, 20);
        txtMinArrival.setText("Min arrival");
        txtMinArrival.setHorizontalAlignment(SwingConstants.CENTER);
        txtMinArrival.setForeground(Color.WHITE);
        txtMinArrival.setFont(new Font("Times New Roman", Font.BOLD, 15));
        txtMinArrival.setEditable(false);
        txtMinArrival.setColumns(10);
        txtMinArrival.setBorder(null);
        txtMinArrival.setBackground(Color.GRAY);
        panel.add(txtMinArrival);

        textField_4 = new JTextField();
        textField_4.setHorizontalAlignment(SwingConstants.CENTER);
        textField_4.setBorder(null);
        textField_4.setFont(new Font("Mongolian Baiti", Font.PLAIN, 13));
        textField_4.setBounds(125, 217, 86, 20);
        textField_4.setColumns(10);
        textField_4.setBackground(Color.WHITE);
        panel.add(textField_4);

        txtMaxArrival = new JTextField();
        txtMaxArrival.setBounds(25, 216, 101, 20);
        txtMaxArrival.setText("Max arrival");
        txtMaxArrival.setHorizontalAlignment(SwingConstants.CENTER);
        txtMaxArrival.setForeground(Color.WHITE);
        txtMaxArrival.setFont(new Font("Times New Roman", Font.BOLD, 15));
        txtMaxArrival.setEditable(false);
        txtMaxArrival.setColumns(10);
        txtMaxArrival.setBorder(null);
        txtMaxArrival.setBackground(Color.GRAY);
        panel.add(txtMaxArrival);

        textField_5 = new JTextField();
        textField_5.setHorizontalAlignment(SwingConstants.CENTER);
        textField_5.setBorder(null);
        textField_5.setFont(new Font("Mongolian Baiti", Font.PLAIN, 13));
        textField_5.setBounds(125, 249, 86, 20);
        textField_5.setColumns(10);
        textField_5.setBackground(Color.WHITE);
        panel.add(textField_5);

        txtMinService = new JTextField();
        txtMinService.setBounds(25, 248, 101, 20);
        txtMinService.setText("Min service");
        txtMinService.setHorizontalAlignment(SwingConstants.CENTER);
        txtMinService.setForeground(Color.WHITE);
        txtMinService.setFont(new Font("Times New Roman", Font.BOLD, 15));
        txtMinService.setEditable(false);
        txtMinService.setColumns(10);
        txtMinService.setBorder(null);
        txtMinService.setBackground(Color.GRAY);
        panel.add(txtMinService);

        textField_6 = new JTextField();
        textField_6.setHorizontalAlignment(SwingConstants.CENTER);
        textField_6.setBorder(null);
        textField_6.setFont(new Font("Mongolian Baiti", Font.PLAIN, 13));
        textField_6.setBounds(125, 281, 86, 20);
        textField_6.setColumns(10);
        textField_6.setBackground(Color.WHITE);
        panel.add(textField_6);

        txtMaxService = new JTextField();
        txtMaxService.setBounds(25, 280, 101, 20);
        txtMaxService.setText("Max service");
        txtMaxService.setHorizontalAlignment(SwingConstants.CENTER);
        txtMaxService.setForeground(Color.WHITE);
        txtMaxService.setFont(new Font("Times New Roman", Font.BOLD, 15));
        txtMaxService.setEditable(false);
        txtMaxService.setColumns(10);
        txtMaxService.setBorder(null);
        txtMaxService.setBackground(Color.GRAY);
        panel.add(txtMaxService);

        panel_1 = new JPanel();
        panel_1.setBounds(221, 11, 2, 351);
        panel.add(panel_1);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(233, 11, 457, 351);
        panel.add(scrollPane);

        JTextArea txtrDa = new JTextArea();
        txtrDa.setEditable(false);
        txtrDa.setFont(new Font("Mongolian Baiti", Font.PLAIN, 13));
        scrollPane.setViewportView(txtrDa);

        JButton btnNewButton = new JButton("Start");
        btnNewButton.setDoubleBuffered(true);
        btnNewButton.setRolloverEnabled(false);
        btnNewButton.setBackground(Color.WHITE);
        btnNewButton.setFocusable(false);
        btnNewButton.setFocusTraversalKeysEnabled(false);
        btnNewButton.setRequestFocusEnabled(false);
        btnNewButton.setFont(new Font("Mongolian Baiti", Font.PLAIN, 21));
        btnNewButton.setBorder(new LineBorder(Color.RED, 1, true));
        btnNewButton.setBounds(122, 339, 89, 23);
        panel.add(btnNewButton);

        txtQ = new JTextField();
        txtQ.setForeground(Color.WHITE);
        txtQ.setBackground(Color.GRAY);
        txtQ.setFocusable(false);
        txtQ.setEditable(false);
        txtQ.setFocusTraversalKeysEnabled(false);
        txtQ.setText("Queue Management");
        txtQ.setFont(new Font("Mongolian Baiti", Font.ITALIC, 21));
        txtQ.setBorder(null);
        txtQ.setBounds(34, 11, 177, 68);
        panel.add(txtQ);
        txtQ.setColumns(10);

        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                logged++;
                txtrDa.setText("");
                int timeLimit = Integer.parseInt(textField.getText());
                int maxProcessingTime = Integer.parseInt(textField_6.getText());
                int minProcessingTime = Integer.parseInt(textField_5.getText());
                int numberOfServers = Integer.parseInt(textField_2.getText());
                int numberOfClients = Integer.parseInt(textField_1.getText());
                int minArrival = Integer.parseInt(textField_3.getText());
                int maxArrival = Integer.parseInt(textField_4.getText());
                SelectionPolicy selectionPolicy;
                if (true) selectionPolicy = SelectionPolicy.SHORTEST_QUEUE;
                else selectionPolicy = SelectionPolicy.SHORTEST_TIME;
                SimulationManager gen = new SimulationManager(timeLimit, maxProcessingTime, minProcessingTime, numberOfServers, numberOfClients, selectionPolicy, minArrival, maxArrival, txtrDa, logged);
                Thread t = new Thread(gen);
                t.start();
            }
        });

    }
}
