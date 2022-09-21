package usantatecla.mastermind.distributed;

import usantatecla.mastermind.controllers.PlayController;
import usantatecla.mastermind.distributed.dispatchers.FrameType;
import usantatecla.mastermind.distributed.dispatchers.TCPIP;
import usantatecla.mastermind.models.ProposedCombination;
import usantatecla.mastermind.models.Result;
import usantatecla.mastermind.models.Session;

public class PlayControllerProxy extends PlayController {

    private TCPIP tcpip;

    PlayControllerProxy(Session session, TCPIP tcpip) {
        super(session);
        this.tcpip = tcpip;
    }

    @Override
	public void undo() {
        this.tcpip.send(FrameType.UNDO.name());
	}

    @Override
	public void redo() {
        this.tcpip.send(FrameType.REDO.name());
	}

    @Override
	public boolean undoable(){
        this.tcpip.send(FrameType.UNDOABLE.name());
        return this.tcpip.receiveBoolean();
	}

    @Override
	public boolean redoable(){
        this.tcpip.send(FrameType.REDOABLE.name());
        return this.tcpip.receiveBoolean();
	}

    @Override
	public boolean isWinner() {
        this.tcpip.send(FrameType.IS_WINNER.name());
        return this.tcpip.receiveBoolean();
	}

    @Override
	public boolean isLooser() {
        this.tcpip.send(FrameType.IS_LOOSER.name());
        return this.tcpip.receiveBoolean();
	}

    @Override
	public int getAttempts() {
        this.tcpip.send(FrameType.GET_ATTEMPTS.name());
        return this.tcpip.receiveInt();
	}

    @Override
	public ProposedCombination getProposedCombination(int i) {
        this.tcpip.send(FrameType.GET_PROPOSED_COMBINATION.name());
        this.tcpip.send(i);
        String combination = this.tcpip.receiveLine();
        ProposedCombination proposedCombination = new ProposedCombination(combination);
        return proposedCombination;
	}

    @Override
	public Result getResult(int i) {
        this.tcpip.send(FrameType.GET_RESULT.name());
        this.tcpip.send(i);
        int blacks = this.tcpip.receiveInt();
        int whites = this.tcpip.receiveInt();
        return new Result(blacks, whites);
	}

    @Override
	public void addProposedCombination(ProposedCombination proposedCombination) {
        this.tcpip.send(FrameType.ADD_COMBINATION.name());
        this.tcpip.send(proposedCombination.toString());
	}

    @Override
	public void continueState() {
        this.tcpip.send(FrameType.CONTINUE_STATE.name());
	}
}