package usantatecla.mastermind.distributed.dispatchers;

import usantatecla.mastermind.controllers.PlayController;

public class GetAttemptsDispatcher extends Dispatcher {

	public GetAttemptsDispatcher(PlayController playController) {
		super(playController);
	}

	@Override
	public void dispatch() {
        this.tcpip.send(((PlayController)this.acceptorController).getAttempts());
	}
}
