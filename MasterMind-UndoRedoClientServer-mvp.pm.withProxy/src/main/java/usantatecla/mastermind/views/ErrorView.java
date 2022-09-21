package usantatecla.mastermind.views;

import usantatecla.mastermind.models.Error;
import usantatecla.utils.Console;

class ErrorView extends Console {

	public static final String[] MESSAGES = {
		"Repeated colors",
		"Wrong colors, they must be: " + ColorView.allInitials(), 
		"Wrong proposed combination length" 
	};

	protected Error error;

	ErrorView(Error error) {
		this.error = error;
	}
	
	public void writeln() {
		Console.instance().writeln(ErrorView.MESSAGES[this.error.ordinal()]);
	}

}
