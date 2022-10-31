package usantatecla.mastermind.views;

import usantatecla.mastermind.controllers.PlayController;
import usantatecla.utils.Menu;

public class PlayMenu extends Menu{

    PlayMenu(PlayController playController){
        this.addCommand(new ProposeCombinationCommand(playController));
        this.addCommand(new UndoCommand(playController));
        this.addCommand(new RedoCommand(playController));
    }
}
