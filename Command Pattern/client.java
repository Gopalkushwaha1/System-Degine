interface Command {
	void execute() ; 
	void undo() ; 
}

class TV {
	void turnOn() {
		System.out.println("TV on .........Enjoy............") ; 
	}
	void turnOff() {
		System.out.println("TV off ............Came back again......") ; 
	}
}

class TurnOnTVCommand implements Command {
	private TV tv ; 

	TurnOnTVCommand(TV tv ) {
		this.tv = tv ; 
	}
	public void execute() {
		tv.turnOn() ; 
	}
	public void undo() {
		tv.turnOff() ; 
	}

} 

class TurnOffTVCommand implements Command {
	private TV tv ; 

	TurnOffTVCommand(TV tv ) {
		this.tv = tv ; 
	} 
	public void execute() {
		tv.turnOff() ; 
	}
	public void undo() {
		tv.turnOn() ; 
	}
}

class RemoteControl {
	private Command command ; 
	private Command lastCommand ; 

	void setCommand(Command command){
		this.command = command ; 
	}

	void pressButton(){
		command.execute() ; 
		lastCommand = command ; 
	}
	void pressUndo() {
		if(lastCommand != null ) {
			lastCommand.undo() ; 
		}
	}
}

public class client {
	public static void main(String[] args ) {
		System.out.println(".....................Welcome to Command Pattern ............") ; 
	

		TV tv = new TV() ; 
		Command turnOn = new TurnOnTVCommand(tv) ; 
		Command turnOff = new TurnOffTVCommand(tv) ; 

		RemoteControl remote = new RemoteControl() ; 
		remote.setCommand(turnOn) ; 
		remote.pressButton() ; 
		remote.pressUndo() ; 

		remote.setCommand(turnOff) ; 
		remote.pressButton() ; 
		remote.pressUndo() ; 
	}
}