package usantatecla.mastermind.views;

import usantatecla.mastermind.controllers.PlayController;
import usantatecla.mastermind.models.ProposedCombination;

public class ProposeCombinationCommand extends Command {

    ProposeCombinationCommand(PlayController playController) {
        super(MessageView.PROPOSED_COMBINATION.getMessage(), playController);
    }

    @Override
    protected void execute() {
		ProposedCombination proposedCombination = new ProposedCombination();
		ProposedCombinationView proposedCombinationView = new ProposedCombinationView(proposedCombination);
		proposedCombinationView.read();
		
		playController.addProposedCombination(proposedCombination);
		
		MessageView.SEPARATOR.writeln();		
		MessageView.ATTEMPTS.writeln(playController.getAttempts());		
		new GameView(playController);

		new SecretCombinationView().writeln();
	}        

    @Override
	protected boolean isActive() {
		return true;
	}
}
