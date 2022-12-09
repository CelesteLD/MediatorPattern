package es.ull.patrones.gui;

import es.ull.patrones.mediators.IMediator;
import es.ull.patrones.mediators.Mediator;
import es.ull.patrones.users.UserConcrete;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DialogGroup extends JDialog {

    JButton bt1 = new JButton("Andrea");
    JButton bt2 = new JButton("Daniel");
    JButton bt3 = new JButton("Ana");

    JLabel text, text2;
    IMediator mediator = new Mediator();
    UserConcrete andrea = new UserConcrete(mediator, "Andrea");
    UserConcrete daniel = new UserConcrete(mediator, "Daniel");
    UserConcrete ana = new UserConcrete(mediator, "Ana");
    UserConcrete celeste = new UserConcrete(mediator, "Celeste");

    public DialogGroup() {
        setTitle("Select users");
        setLocation(850,300);
        setLayout(null);
        setSize(300, 300);
        addButtons();
        text = setLabel("Select the users to see ", 55, 30, 15, 300);
        text2 = setLabel("the group conversation", 55, 55, 15, 300);
        add(text);
        add(text2);
        setVisible(true);
    }

    public void addButtons() {
        ArrayList<JButton> buttons = new ArrayList<>();
        buttons.add(bt1); buttons.add(bt2); buttons.add(bt3);

        for (int i = 0; i < buttons.size(); ++i) {
            buttons.get(i).setBackground(new Color(86, 187, 197));
            buttons.get(i).setFont(new Font("Georgia", Font.PLAIN, 15));
        }

        bt1.setBounds(100, 100, 100, 30);
        bt2.setBounds(100, 150, 100, 30);
        bt3.setBounds(100, 200, 100, 30);
        add(bt1);
        add(bt2);
        add(bt3);

        bt1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GroupGUI groupGUI = new GroupGUI(mediator, andrea);
            }
        });

        bt2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GroupGUI groupGUI = new GroupGUI(mediator, daniel);
            }
        });

        bt3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GroupGUI groupGUI = new GroupGUI(mediator, ana);
            }
        });
    }

    public JLabel setLabel(String text, int x, int y,int width, int height) {
        JLabel label = new JLabel();
        label.setText(text);
        label.setVisible(true);
        label.setBounds(x, y, height, width);
        label.setFont(new Font("Georgia", Font.BOLD, 14));
        return label;
    }
}
