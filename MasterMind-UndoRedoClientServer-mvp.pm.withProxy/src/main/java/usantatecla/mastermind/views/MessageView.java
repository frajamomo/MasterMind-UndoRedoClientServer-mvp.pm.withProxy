package usantatecla.mastermind.views;

import usantatecla.utils.Console;

public enum MessageView {
	ATTEMPTS("#attempts attempt(s): "),
	SECRET("*"),
	SEPARATOR("-------------"),
	RESUME("Do you want to continue"),
	RESULT(" --> #blacks blacks and #whites whites"),
	PROPOSED_COMBINATION("Propose a combination: "),
	TITLE("----- MASTERMIND -----"),
	WINNER("You've won!!! ;-)"),
	LOOSER("You've lost!!! :-("),
	UNDO_COMMAND("Undo previous movement"), 
	REDO_COMMAND("Redo previous movement"); 

	private String message;
	
	private MessageView(String message) {
		this.message = message;
	}

	public void write() {
		Console.instance().write(this.message);
	}

	public void writeln() {
		Console.instance().writeln(this.message);
	}

	void writeln(int attempts) {
		Console.instance().writeln(this.message.replaceAll("#attempts", "" + attempts));
	}

	void writeln(int blacks, int whites) {
		Console.instance().writeln(this.message.replaceFirst("#blacks", "" + blacks).replaceFirst("#whites", "" + whites));
	}

	public String getMessage() {
		return this.message;
	}


}
