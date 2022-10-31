package usantatecla.mastermind.distributed.dispatchers.undoredo;

import usantatecla.mastermind.controllers.PlayController;
import usantatecla.mastermind.distributed.dispatchers.Dispatcher;

public class RedoDispatcher extends Dispatcher {

    public RedoDispatcher(PlayController playController) {
        super(playController);
    }

    @Override
    public void dispatch() {
        ((PlayController)this.acceptorController).redo();
    }
}

