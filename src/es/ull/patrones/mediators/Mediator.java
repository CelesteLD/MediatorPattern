package es.ull.patrones.mediators;

import es.ull.patrones.users.User;

import javax.swing.*;
import java.util.ArrayList;

public class Mediator implements IMediator {
    ArrayList<User> users = new ArrayList<>();

    public Mediator() { }
    @Override
    public void register(User user) {
        users.add(user);
        for (int i = 0; i < users.size(); ++i) {
            if (users.get(i) != user) {
                users.get(i).registerNotify(user);
            }
        }
    }

    @Override
    public void cancelRegister(User user) {
        users.remove(user);
        for (int i = 0; i < users.size(); ++i) {
            if (users.get(i) != user) {
                users.get(i).cancelRegisterNotify(user);
            }
        }
    }

    @Override
    public void sendMessage(User sender, User userFinal, String message, JTextArea result) {
        if (users.contains(sender)) {
            userFinal.messageNotify(sender.toString(), message, result);
        } else {
            System.out.println("User not register");
        }
    }

    @Override
    public void sendMessage(User sender, String message, JTextArea result) {
        if (users.contains(sender)) {
            for (int i = 0 ; i < users.size(); ++i) {
                if (sender != users.get(i)) {
                    users.get(i).messageNotify(sender.toString(), message, result);
                }
            }
        }
    }
}
