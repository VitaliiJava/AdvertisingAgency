package com.lviv.advertisingagency;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CreateJButtonExample extends JFrame {
    AdvertisingAgency advertisingAgency = new AdvertisingAgency();
    private static final long serialVersionUID = 1L;
    private JTextField textField;

    public CreateJButtonExample() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        // set flow layout for the frame
        this.getContentPane().setLayout(new FlowLayout());
        JButton button1 = new JButton("1) Post reclame on the screen.");
        button1.setActionCommand("1) Post reclame on the screen.");
        JButton button2 = new JButton("2) Change reclame on screen.");
        button2.setActionCommand("2) Change reclame on screen.");
        JButton button3 = new JButton("3) Create new platform.");
        button3.setActionCommand("3) Create new platform.");
        JButton button4 = new JButton("4) Create new reclame screen.");
        button4.setActionCommand("4) Create new reclame screen.");
        JButton button5 = new JButton("5) Delete platform with all screens.");
        button5.setActionCommand("5) Delete platform with all screens.");
        JButton button6 = new JButton("6) Delete all screens from the platform.");
        button6.setActionCommand("6) Delete all screens from the platform.");
        JButton button7 = new JButton("7) Add screen to the platform.");
        button7.setActionCommand("7) Add screen to the platform.");
        JButton button8 = new JButton("8) Show screen from the platform.");
        button8.setActionCommand("8) Show screen from the platform.");
        JButton button9 = new JButton("9) Show all screens from the platform.");
        button9.setActionCommand("9) Show all screens from the platform.");
        JButton button10 = new JButton("10) Show info about platform.");
        button10.setActionCommand("10) Show info about platform.");
        JButton button11 = new JButton("11) Count the screens from platform.");
        button11.setActionCommand("11) Count the screens from platform.");
        JButton button12 = new JButton("12) Show all from Platform.");
        button12.setActionCommand("12) Show all from Platform.");
        JButton button14 = new JButton("14) Exit.");
        button14.setActionCommand("14) Exit.");


        // add buttons to frame
        add(button1);
        add(button2);
        add(button3);
        add(button4);
        add(button5);
        add(button6);
        add(button7);
        add(button8);
        add(button9);
        add(button10);
        add(button11);
        add(button12);
        add(button14);
        textField = new JTextField();
        textField.setColumns(23);
        add(textField);
        ActionListener actionListener = new CreateJButtonExample.TestActionListener();

        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                advertisingAgency.postAdvertisingOnScreen();
            }
        });
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                advertisingAgency.changeAdvertisingOnScreen();
            }
        });
        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                advertisingAgency.createNewPlatform();
            }
        });
        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                advertisingAgency.showAllFromPlatform();
            }
        });
        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                advertisingAgency.showAllFromPlatform();
            }
        });
        button4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                advertisingAgency.createNewAdvertisingScreen();
            }
        });
        button5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                advertisingAgency.deletePlatformWithAllScreens();
            }
        });
        button6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                advertisingAgency.deleteAllScreensFromPlatform();
            }
        });
        button7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                advertisingAgency.addScreenToPlatform();
            }
        });
        button8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                advertisingAgency.showScreenFromPlatform();
            }
        });
        button9.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                advertisingAgency.showAllScreensFromPlatform();
            }
        });
        button10.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                advertisingAgency.serializatorOut();
            }
        });


        button11.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println(advertisingAgency.countAllScreensFromPlatform());
            }
        });
        button12.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                advertisingAgency.showAllFromPlatform();
            }
        });
        button14.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                return;
            }
        });
        getContentPane().add(panel);
        setPreferredSize(new Dimension(333, 533));


    }

    private static void createAndShowGUI() {

        //Create and set up the window.

        JFrame frame = new CreateJButtonExample();

        //Display the window.

        frame.pack();

        frame.setVisible(true);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    class TestActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            textField.setText(e.getActionCommand());
        }
    }

    public static void main(String[] args) {

        //Schedule a job for the event-dispatching thread:

        //creating and showing this application's GUI.

        javax.swing.SwingUtilities.invokeLater(new Runnable() {

            public void run() {

                createAndShowGUI();

            }

        });
    }

}
