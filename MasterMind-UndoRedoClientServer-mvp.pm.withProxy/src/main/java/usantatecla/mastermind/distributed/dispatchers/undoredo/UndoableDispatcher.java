package usantatecla.mastermind.distributed.dispatchers.undoredo;

import usantatecla.mastermind.controllers.PlayController;
import usantatecla.mastermind.distributed.dispatchers.Dispatcher;

public class UndoableDispatcher extends Dispatcher {

    public UndoableDispatcher(PlayController playController) {
        super(playController);
    }

    @Override
    public void dispatch() {
        this.tcpip.send(((PlayController)this.acceptorController).undoable());
    }
}