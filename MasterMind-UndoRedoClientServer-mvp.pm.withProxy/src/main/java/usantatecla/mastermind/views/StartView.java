package usantatecla.mastermind.views;

import usantatecla.mastermind.controllers.StartController;
import usantatecla.utils.Console;

class StartView extends Console{

    void interact(StartController startController) {
        startController.start();
        MessageView.TITLE.writeln();
        new SecretCombinationView().writeln();
    }
}

