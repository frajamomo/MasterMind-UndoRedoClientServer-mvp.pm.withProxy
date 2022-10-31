package usantatecla.mastermind.distributed.dispatchers.undoredo;

import usantatecla.mastermind.controllers.PlayController;
import usantatecla.mastermind.distributed.dispatchers.Dispatcher;

public class UndoDispatcher extends Dispatcher {

    public UndoDispatcher(PlayController playController) {
        super(playController);
    }

    @Override
    public void dispatch() {
        ((PlayController)this.acceptorController).undo();
    }
}

