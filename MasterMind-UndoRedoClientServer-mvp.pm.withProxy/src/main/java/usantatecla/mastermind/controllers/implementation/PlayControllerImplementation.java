package usantatecla.mastermind.controllers.implementation;

import usantatecla.mastermind.controllers.GameController;
import usantatecla.mastermind.controllers.PlayController;
import usantatecla.mastermind.controllers.RedoController;
import usantatecla.mastermind.controllers.UndoController;
import usantatecla.mastermind.models.ProposedCombination;
import usantatecla.mastermind.models.Result;
import usantatecla.mastermind.models.Session;

public class PlayControllerImplementation extends PlayController {

    private GameController gameController;

    private UndoController undoController;

	private RedoController redoController;

    public PlayControllerImplementation(Session session) {
		super(session);
		this.gameController = new GameController(this.session);
		this.undoController = new UndoController(this.session);
		this.redoController = new RedoController(this.session);
	}

	public void undo() {
		this.undoController.undo();
	}

	public void redo() {
		this.redoController.redo();
	}

	public boolean undoable(){
		return this.undoController.undoable();
	}

	public boolean redoable(){
		return this.redoController.redoable();
	}

	public boolean isWinner() {
		return this.gameController.isWinner();
	}

	public boolean isLooser() {
		return this.gameController.isLooser();
	}

	public int getAttempts() {
		return this.gameController.getAttempts();
	}

	public ProposedCombination getProposedCombination(int i) {
		return this.gameController.getProposedCombination(i);
	}

	public Result getResult(int i) {
		return this.gameController.getResult(i);
	}

	public void addProposedCombination(ProposedCombination proposedCombination) {
		this.gameController.addProposedCombination(proposedCombination);

		if (gameController.isWinner() || gameController.isLooser()) {
			gameController.continueState();
		}

	}

	public void continueState() {
		this.gameController.continueState();
	}


}
