package usantatecla.mastermind.views;

import usantatecla.mastermind.controllers.PlayController;

public class RedoCommand extends Command{

    RedoCommand(PlayController playController) {
        super(MessageView.REDO_COMMAND.getMessage(), playController);
    }

    @Override
    protected void execute() {
        this.playController.redo();
        new GameView(this.playController);
    }

    @Override
    protected boolean isActive() {
        return this.playController.redoable();
    }
    
}
