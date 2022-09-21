package usantatecla.mastermind.distributed.dispatchers;

import usantatecla.mastermind.controllers.PlayController;

public class GetResultDispatcher extends Dispatcher {

	public GetResultDispatcher(PlayController playController) {
		super(playController);
	}

	@Override
	public void dispatch() {
        int index = this.tcpip.receiveInt();
        this.tcpip.send(((PlayController)this.acceptorController).getResult(index).getBlacks());
        this.tcpip.send(((PlayController)this.acceptorController).getResult(index).getWhites());
	}

}
