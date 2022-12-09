package es.ull.patrones.mediators;

import es.ull.patrones.users.User;

import javax.swing.*;

public interface IMediator {
    void register(User user);
    void cancelRegister(User user);
    void sendMessage(User sender, User userFinal, String message, JTextArea result);
    void sendMessage(User sender, String message, JTextArea result);
}
