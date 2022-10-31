package usantatecla.mastermind.distributed.dispatchers;

import usantatecla.mastermind.controllers.PlayController;

public class IsLooserDispatcher extends Dispatcher {

	public IsLooserDispatcher(PlayController playController) {
		super(playController);
	}

	@Override
	public void dispatch() {
        this.tcpip.send(((PlayController)this.acceptorController).isLooser());
	}
}