package usantatecla.mastermind.distributed.dispatchers;

import usantatecla.mastermind.controllers.PlayController;

public class ContinueStateDispatcher extends Dispatcher {

    public ContinueStateDispatcher(PlayController playController) {
		super(playController);
	}

	@Override
	public void dispatch() {
		((PlayController)this.acceptorController).continueState();
	}
    
}