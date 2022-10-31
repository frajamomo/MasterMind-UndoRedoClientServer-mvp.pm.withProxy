package usantatecla.mastermind.distributed.dispatchers.undoredo;

import usantatecla.mastermind.controllers.PlayController;
import usantatecla.mastermind.distributed.dispatchers.Dispatcher;

public class RedoableDispatcher extends Dispatcher {

    public RedoableDispatcher(PlayController playController) {
        super(playController);
    }

    @Override
    public void dispatch() {
        this.tcpip.send(((PlayController)this.acceptorController).redoable());
    }
}

