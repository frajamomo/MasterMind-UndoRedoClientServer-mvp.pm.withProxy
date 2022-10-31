package usantatecla.utils;

import java.util.ArrayList;

public abstract class Menu extends Console {

    private static final String OPTION = "----- Choose one option -----";

    private ArrayList<Command> commandList;

    public Menu() {
        this.commandList = new ArrayList<Command>();
    }

    public void execute() {
        ArrayList<Command> commands = new ArrayList<Command>();
        populateWithActiveCommands(commands);
        int option = getOptionFromUser(commands);
        commands.get(option).execute();
    }

    private void populateWithActiveCommands(ArrayList<Command> commands) {
        for (int i = 0; i < this.commandList.size(); i++) {
            if (this.commandList.get(i).isActive()) {
                commands.add(this.commandList.get(i));
            }
        }
    }

    private int getOptionFromUser(ArrayList<Command> commands) {
        boolean error;
        int option;
        do {
            error = false;
            Console.instance().writeln();
            Console.instance().writeln(Menu.OPTION);
            for (int i = 0; i < commands.size(); i++) {
                Console.instance().writeln((i + 1) + ") " + commands.get(i).getTitle());
            }
            option = Console.instance().readInt("") - 1;
            if (!new ClosedInterval(0, commands.size()-1).includes(option)) {
                error = true;
            } 				
        } while (error);
        return option;
    }

    protected void addCommand(Command command) {
        this.commandList.add(command);
    }

    
}
