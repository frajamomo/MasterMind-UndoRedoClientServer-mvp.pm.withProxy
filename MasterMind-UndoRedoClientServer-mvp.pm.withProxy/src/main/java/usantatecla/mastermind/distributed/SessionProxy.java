package usantatecla.mastermind.distributed;

import usantatecla.mastermind.distributed.dispatchers.FrameType;
import usantatecla.mastermind.models.Session;
import usantatecla.mastermind.types.StateValue;
import usantatecla.utils.TCPIP;

public class SessionProxy implements Session {
	
	private TCPIP tcpip;

	public SessionProxy(TCPIP tcpip) {
		this.tcpip = tcpip;
	}
	
	public StateValue getValueState() {
		this.tcpip.send(FrameType.STATE.name());
		return StateValue.values()[this.tcpip.receiveInt()];
	}

}