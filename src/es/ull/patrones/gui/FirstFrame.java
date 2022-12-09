package es.ull.patrones.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FirstFrame extends JFrame {

    JPanel firstPanel = new JPanel();
    JButton oneTo = new JButton();
    JButton group = new JButton();
    JLabel textTop = new JLabel();
    JLabel image = new JLabel();

    public FirstFrame() {
        setLocationRelativeTo(this);
        setTitle("Application");
        setBounds(700, 200,600, 500);
        setContentPane(setFirstPanel());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public JPanel setFirstPanel() {
        firstPanel.setVisible(true);
        firstPanel.setBackground(new Color(173, 216, 230));
        firstPanel.setLayout(null);
        oneTo = setButton("Conversation of one user to other simultaneous", 120, 300, 30, 350);
        oneTo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Dialog dialog = new Dialog();
            }
        });
        firstPanel.add(oneTo);
        group = setButton("Conversation of a group of users", 120, 350, 30, 350);
        group.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DialogGroup dialogGroup = new DialogGroup();
            }
        });
        firstPanel.add(group);
        textTop = setLabel("Choose the option you want", 110, 20, 50, 500);
        firstPanel.add(textTop);
        image = setLabelsImage("chat.jpg", 170, 100);
        firstPanel.add(image);
        return firstPanel;
    }

    public JButton setButton(String text, int x, int y, int width, int height) {
        JButton button = new JButton();
        button.setText(text);
        button.setFont(new Font("Georgia", Font.PLAIN, 15));
        button.setBounds(x, y, height, width);
        button.setBackground(new Color(31, 148, 245));
        button.setVisible(true);
        return button;
    }

    public JLabel setLabel(String text, int x, int y,int width, int height) {
        JLabel label = new JLabel();
        label.setText(text);
        label.setVisible(true);
        label.setBounds(x, y, height, width);
        label.setFont(new Font("Georgia", Font.ITALIC + Font.BOLD, 25));
        return label;
    }

    private JLabel setLabelsImage(String text, int x, int y) {
        ImageIcon image = new ImageIcon(text);
        JLabel label = new JLabel();
        label.setBounds(x, y, 250, 140);
        label.setIcon(new ImageIcon(image.getImage().getScaledInstance(label.getWidth(),label.getHeight(), Image.SCALE_DEFAULT)));
        label.setVisible(true);
        return label;
    }

}
