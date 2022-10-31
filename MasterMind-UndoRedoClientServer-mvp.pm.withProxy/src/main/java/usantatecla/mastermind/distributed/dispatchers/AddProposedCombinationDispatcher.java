package usantatecla.mastermind.distributed.dispatchers;

import usantatecla.mastermind.controllers.PlayController;
import usantatecla.mastermind.models.ProposedCombination;

public class AddProposedCombinationDispatcher extends Dispatcher {

    public AddProposedCombinationDispatcher(PlayController playController) {
        super(playController);
    }

    @Override
    public void dispatch() {
        String combination = this.tcpip.receiveLine();
        ProposedCombination proposedCombination = new ProposedCombination(combination);
        ((PlayController)this.acceptorController).addProposedCombination(proposedCombination);
    }
}