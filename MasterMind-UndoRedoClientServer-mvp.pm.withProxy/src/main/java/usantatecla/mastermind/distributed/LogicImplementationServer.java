package usantatecla.mastermind.distributed;

import usantatecla.mastermind.controllers.implementation.LogicImplementation;
import usantatecla.mastermind.distributed.dispatchers.AddProposedCombinationDispatcher;
import usantatecla.mastermind.distributed.dispatchers.ContinueStateDispatcher;
import usantatecla.mastermind.distributed.dispatchers.DispatcherPrototype;
import usantatecla.mastermind.distributed.dispatchers.FrameType;
import usantatecla.mastermind.distributed.dispatchers.ResumeDispatcher;
import usantatecla.mastermind.distributed.dispatchers.StartDispatcher;
import usantatecla.mastermind.distributed.dispatchers.StateDispatcher;
import usantatecla.mastermind.distributed.dispatchers.undoredo.RedoDispatcher;
import usantatecla.mastermind.distributed.dispatchers.undoredo.RedoableDispatcher;
import usantatecla.mastermind.distributed.dispatchers.undoredo.UndoDispatcher;
import usantatecla.mastermind.distributed.dispatchers.undoredo.UndoableDispatcher;
import usantatecla.mastermind.distributed.dispatchers.GetResultDispatcher;
import usantatecla.mastermind.distributed.dispatchers.GetProposedCombinationDispatcher;
import usantatecla.mastermind.distributed.dispatchers.GetAttemptsDispatcher;
import usantatecla.mastermind.distributed.dispatchers.IsWinnerDispatcher;
import usantatecla.mastermind.distributed.dispatchers.IsLooserDispatcher;

public class LogicImplementationServer extends LogicImplementation {

    public void createDispatchers(DispatcherPrototype dispatcherPrototype) {
        dispatcherPrototype.add(FrameType.START, new StartDispatcher(this.startControllerImplementation));
        dispatcherPrototype.add(FrameType.STATE, new StateDispatcher(this.playControllerImplementation));
        dispatcherPrototype.add(FrameType.UNDO, new UndoDispatcher(this.playControllerImplementation));
        dispatcherPrototype.add(FrameType.REDO, new RedoDispatcher(this.playControllerImplementation));
        dispatcherPrototype.add(FrameType.UNDOABLE, new UndoableDispatcher(this.playControllerImplementation));
        dispatcherPrototype.add(FrameType.REDOABLE, new RedoableDispatcher(this.playControllerImplementation));
        dispatcherPrototype.add(FrameType.CONTINUE_STATE, new ContinueStateDispatcher(this.playControllerImplementation));
        dispatcherPrototype.add(FrameType.NEW_GAME, new ResumeDispatcher(this.resumeControllerImplementation));
        dispatcherPrototype.add(FrameType.ADD_COMBINATION, new AddProposedCombinationDispatcher(this.playControllerImplementation));
        dispatcherPrototype.add(FrameType.GET_RESULT, new GetResultDispatcher(this.playControllerImplementation));
        dispatcherPrototype.add(FrameType.GET_PROPOSED_COMBINATION, new GetProposedCombinationDispatcher(this.playControllerImplementation));
        dispatcherPrototype.add(FrameType.GET_ATTEMPTS, new GetAttemptsDispatcher(this.playControllerImplementation));
        dispatcherPrototype.add(FrameType.IS_WINNER, new IsWinnerDispatcher(this.playControllerImplementation));
        dispatcherPrototype.add(FrameType.IS_LOOSER, new IsLooserDispatcher(this.playControllerImplementation));
    }
}