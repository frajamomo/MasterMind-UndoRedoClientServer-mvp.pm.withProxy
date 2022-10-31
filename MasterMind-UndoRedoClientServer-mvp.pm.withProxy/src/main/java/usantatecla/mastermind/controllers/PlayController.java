package usantatecla.mastermind.controllers;

import usantatecla.mastermind.models.ProposedCombination;
import usantatecla.mastermind.models.Result;
import usantatecla.mastermind.models.Session;

public abstract class PlayController extends AcceptorController {

    public PlayController(Session session) {
        super(session);
    }

    @Override
    public void accept(ControllerVisitor controllerVisitor) {
        controllerVisitor.visit(this);
    }

    public abstract void undo();

    public abstract void redo();
    
    public abstract boolean undoable();

    public abstract boolean redoable();

    public abstract boolean isWinner();

    public abstract boolean isLooser();

    public abstract int getAttempts();

    public abstract ProposedCombination getProposedCombination(int i);

    public abstract Result getResult(int i);

    public abstract void addProposedCombination(ProposedCombination proposedCombination);

    public abstract void continueState();
}