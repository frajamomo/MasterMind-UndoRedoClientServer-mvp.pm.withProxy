package usantatecla.mastermind.distributed.dispatchers;

import usantatecla.mastermind.controllers.PlayController;
import usantatecla.mastermind.models.ProposedCombination;

public class GetProposedCombinationDispatcher extends Dispatcher {

	public GetProposedCombinationDispatcher(PlayController playController) {
		super(playController);
	}

	@Override
	public void dispatch() {
		int index = this.tcpip.receiveInt();
		ProposedCombination proposedCombination = ((PlayController)this.acceptorController).getProposedCombination(index);
		this.tcpip.send(proposedCombination.toString());
	}
}
