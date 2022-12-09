package es.ull.patrones.users;

import es.ull.patrones.mediators.IMediator;

import javax.swing.*;

public class UserConcrete extends User {

    public UserConcrete(IMediator mediator, String name) {
        super(mediator, name);
        mediator.register(this);

    }
    @Override
    public void registerNotify(User user) {
        System.out.println("New user register with name: " + user + ". Received by: --  " + this);
    }

    @Override
    public void cancelRegisterNotify(User user) {
        System.out.println("Cancel user register with name: " + user + ". Received by: --  " + this);
    }

    @Override
    public void sendMessage(User userFinal,String message, JTextArea result) {
        mediator.sendMessage(this, userFinal, message, result);
    }

    @Override
    public void sendMessage(String message, JTextArea result) {
        mediator.sendMessage(this, message, result);
    }

    @Override
    public void messageNotify(String sender, String message, JTextArea result) {
        result.setText(result.getText() + "\n    " + sender + " says: \"" + message + "\" . Received by: -- " + this);
        //System.out.println(sender + " says: \"" + message + "\" . Received from: -- " + this);
    }

}
