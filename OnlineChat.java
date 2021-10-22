package ru.alexanna.lesson_4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OnlineChat {
    private final JFrame mainFrame;
    private final JTextArea textArea;
    private final JTextField textField;


    public OnlineChat() {
        mainFrame = new JFrame();
        mainFrame.setTitle("Online Chat");
        mainFrame.setBounds(new Rectangle(400, 500));
        mainFrame.setLocationByPlatform(true);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel topPanel = new JPanel();
        topPanel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        topPanel.setLayout(new BorderLayout());
        textArea = new JTextArea();
        textArea.setBorder(BorderFactory.createEtchedBorder());
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        topPanel.add(textArea, BorderLayout.CENTER);
        mainFrame.add(topPanel, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        bottomPanel.setLayout(new BorderLayout());
        textField = new JTextField();
        textField.addActionListener(addTextToTextArea());
        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(addTextToTextArea());
        bottomPanel.add(textField, BorderLayout.CENTER);
        bottomPanel.add(submitButton, BorderLayout.EAST);
        mainFrame.add(bottomPanel, BorderLayout.SOUTH);

        mainFrame.setVisible(true);
    }

    private ActionListener addTextToTextArea() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!textField.getText().isBlank()) {
                    textArea.append(textField.getText() + "\n");
                }
                textField.setText("");
            }
        };
    }
}
