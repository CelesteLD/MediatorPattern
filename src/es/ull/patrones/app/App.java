package es.ull.patrones.app;

import es.ull.patrones.gui.FirstFrame;
import es.ull.patrones.mediators.IMediator;
import es.ull.patrones.mediators.Mediator;
import es.ull.patrones.users.User;
import es.ull.patrones.users.UserConcrete;

public class App {

    public void run() {
        /*IMediator mediator = new Mediator();
        User celeste = new UserConcrete(mediator, "Celeste");
        User daniela = new UserConcrete(mediator, "Daniela");
        User ana = new UserConcrete(mediator, "Ana");*/

        /*celeste.sendMessage("Hola");
        daniela.sendMessage("KK");
        mediator.cancelRegister(ana);
        ana.sendMessage("Adios");*/

        FirstFrame fr = new FirstFrame();
    }
}
