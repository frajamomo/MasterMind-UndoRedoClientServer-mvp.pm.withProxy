package usantatecla.mastermind.models;

import usantatecla.mastermind.types.StateValue;

public class SessionImplementation implements Session {

    private State state;

    private Game game;

    private Registry registry;

    public SessionImplementation() {
        this.state = new State();
        this.game = new Game();
        this.registry = new Registry(this.game);
    }

    public void next() {
        this.state.next();
    }

    public boolean undoable() {
        return this.registry.undoable();
    }

    public boolean redoable() {
        return this.registry.redoable();
    }

    public void undo() {
        this.registry.undo(game);
    }

    public void redo() {
        this.registry.redo(game);
    }

    public StateValue getValueState() {
        return this.state.getValueState();
    }

    public void newGame() {
        this.game.newGame();
        this.state.reset();
        this.registry.reset();
    }

    public int getAttemps() {
        return this.game.getAttempts();
    }

    public boolean isWinner() {
        return this.game.isWinner();
    }

    public boolean isLooser() {
        return this.game.isLooser();
    }

	public void addProposedCombination(ProposedCombination proposedCombination) {
        this.game.addProposedCombination(proposedCombination);
        this.registry.registry();
	}

	public ProposedCombination getProposedCombination(int i) {
		return this.game.getProposedCombination(i);
	}

	public Result getResult(int i) {
		return this.game.getResult(i);
    }

}
