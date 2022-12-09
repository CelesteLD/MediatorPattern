package es.ull.patrones.users;

import es.ull.patrones.mediators.IMediator;

import javax.swing.*;

public abstract class User {

    public IMediator mediator;
    private String name;

    public User(IMediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
    }

    public String toString() {
        return "#" + this.name;
    }

    public abstract void registerNotify(User user);
    public abstract void cancelRegisterNotify(User user);
    public abstract void sendMessage(User userFinal, String message, JTextArea result);
    public abstract void sendMessage(String message, JTextArea result);
    public abstract void messageNotify(String sender, String message, JTextArea result);

}
