package es.ull.patrones.gui;

import es.ull.patrones.mediators.IMediator;
import es.ull.patrones.users.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GroupGUI extends JFrame {

    JLabel text = new JLabel();
    JTextField message = new JTextField();
    JTextArea result = new JTextArea();
    JButton send = new JButton("Send");
    JButton random = new JButton();
    IMediator mediator;
    User sender;

    ArrayList<String> randomMessages = new ArrayList<>();

    public GroupGUI (IMediator mediator, User sender) {
        this.mediator = mediator;
        this.sender = sender;

        setRandomMessages();
        setLocationRelativeTo(this);
        setTitle("Group Chat");
        setContentPane(createGUI());
        setBounds(700, 200,600, 500);
        setVisible(true);
    }

    public JPanel createGUI() {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(74, 143, 225));
        panel.add(setTextField());
        panel.add(setButtonSend());
        panel.add(setRandomAnswer());
        panel.add(setTextArea());
        panel.add(setLabelChat());
        panel.setVisible(true);
        return panel;
    }

    public JButton setRandomAnswer() {
        random.setFont(new Font("Georgia", Font.PLAIN, 12));
        random.setText(sender.toString() + " send a random message");
        random.setVisible(true);
        random.setBackground(new Color(89, 127, 172 ));
        random.setBounds(290, 350, 250, 30);
        random.addActionListener(new ActionListener() {
            int i = 0;
            @Override
            public void actionPerformed(ActionEvent e) {
                if (i > 3) i = 0;
                sender.sendMessage(randomMessages.get(i),result);
                i++;
            }
        });
        return random;
    }

    public JTextField setTextField() {
        message.setVisible(true);
        message.setColumns(100);
        message.setFont(new Font("Georgia", Font.PLAIN, 12));
        message.setBounds(40,400,400, 50);
        return message;
    }

    public JButton setButtonSend() {
        send.setVisible(true);
        send.setBounds(450, 400, 100,50);
        send.setFont(new Font("Georgia", Font.PLAIN, 15));
        send.setBackground(new Color(190, 218, 252));
        send.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sender.sendMessage(message.getText(), result);
                message.setText(null);
            }
        });
        return send;
    }

    public JTextArea setTextArea() {
        result.setFont(new Font("Georgia", Font.PLAIN, 12));
        result.setVisible(true);
        result.setBackground(new Color(145, 184, 231));
        result.setBounds(40, 80, 500, 300);
        return result;
    }

    public JLabel setLabelChat() {
        text.setVisible(true);
        text.setText(sender.toString() + " Device");
        text.setFont(new Font("Georgia", Font.BOLD, 20));
        text.setBounds(200, 0, 300, 100);
        return text;
    }

    public void setRandomMessages() {
        randomMessages.add("Hello");
        randomMessages.add("How are you?");
        randomMessages.add("Nice too");
        randomMessages.add("Thanks");
    }
}
