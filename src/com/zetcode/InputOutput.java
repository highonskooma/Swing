package com.zetcode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class InputOutput extends JFrame {
    JLabel label;
    JButton button;
    JTextField tf;

    public InputOutput() {
        setLayout(new FlowLayout());

        label = new JLabel("Enter text");
        add(label);

        tf = new JTextField(10);
        add(tf);

        button = new JButton("Write to file");
        add(button);

        event e = new event();
        button.addActionListener(e);
    }

    public class event implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                String text = tf.getText();
                FileWriter stream = new FileWriter("output.txt");
                BufferedWriter out = new BufferedWriter(stream);
                out.write(text);
                out.close();
            } catch(Exception ex) {
                System.out.println("Exception thrown.\n");
            }
        }
    }

    public static void main(String[] args) {
        InputOutput gui = new InputOutput();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setSize(300,100);
        gui.setTitle("Writer");
        gui.setVisible(true);
    }
}
