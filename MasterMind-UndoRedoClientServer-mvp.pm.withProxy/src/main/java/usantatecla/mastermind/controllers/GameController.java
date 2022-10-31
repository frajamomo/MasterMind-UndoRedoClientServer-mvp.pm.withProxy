package usantatecla.mastermind.controllers;

import usantatecla.mastermind.models.Session;
import usantatecla.mastermind.models.SessionImplementation;
import usantatecla.mastermind.models.ProposedCombination;
import usantatecla.mastermind.models.Result;

public class GameController extends Controller{

    private SessionImplementation sessionImplementation;

    public GameController(Session session) {
        super(session);
        this.sessionImplementation = ((SessionImplementation) this.session);
    }

    public int getAttempts(){
        return this.sessionImplementation.getAttemps();
    }

    public void addProposedCombination(ProposedCombination proposedCombination) {
        this.sessionImplementation.addProposedCombination(proposedCombination);
    }

    public boolean isWinner() {
        return this.sessionImplementation.isWinner();
    }

    public boolean isLooser() {
        return this.sessionImplementation.isLooser();
    }

    public ProposedCombination getProposedCombination(int i) {
        return this.sessionImplementation.getProposedCombination(i);
    }

    public Result getResult(int i) {
        return this.sessionImplementation.getResult(i);
    }

    public void continueState() {
        this.sessionImplementation.next();
    }
}
