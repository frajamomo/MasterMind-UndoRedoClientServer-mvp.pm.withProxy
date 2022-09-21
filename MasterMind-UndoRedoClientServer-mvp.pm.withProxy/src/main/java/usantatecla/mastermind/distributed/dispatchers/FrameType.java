package usantatecla.mastermind.distributed.dispatchers;

public enum FrameType { 
	START,
	STATE,
	UNDO, 
	REDO, 
	UNDOABLE, 
	REDOABLE,
	CLOSE,
	CONTINUE_STATE,
	NEW_GAME, 
	IS_WINNER, 
	IS_LOOSER, 
	GET_ATTEMPTS, 
	GET_PROPOSED_COMBINATION, 
	GET_RESULT, 
	ADD_COMBINATION; 

	public static FrameType parser(String string) {
		for(FrameType frameType : FrameType.values()) {
			if (frameType.name().equals(string)) {
				return frameType;
			}
		}
		return null;
	}
}

