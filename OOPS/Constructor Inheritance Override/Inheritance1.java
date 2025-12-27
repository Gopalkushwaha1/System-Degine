interface Chargeable {
	void charge();
}


abstract class Car {
	protected String name ; 
	protected String model ; 
	protected String color ; 
	int speed ; 

	Car(String name , String model , String color ) {
		this.name = name ; 
		this.model = model ; 
		this.color = color ;
		this.speed = 0 ;  
	}

	public void display() {
		System.out.println("Car Information Show start .................................");
		System.out.println("Car name  :: " + name ) ; 
		System.out.println("Car model :: " + model  ) ; 
		System.out.println("Car color :: " + color  ) ; 
		System.out.println("Car speed :: " + speed ) ; 
		System.out.println("Car Information Show end.................................");
		System.out.println();
		System.out.println();
	}
	
	public final void stop() {
		System.out.println("Base class car :: Stop " ) ;  
	}
	public abstract void run(); 
	public void brake() {
		System.out.println("Before Break speed is :: " + speed ) ;
		if (  speed <= 10 ) {
			System.out.println("After Break :: Car Stop") ; 
			speed = 0 ; 
		}
		else {
			speed -= 10 ; 
			System.out.println("Current speed is :: " + speed ) ; 
		}
	}
	public abstract void accelerate() ;
}


class ManualCar extends Car {
	ManualCar(String name , String model , String color ) {
		super(name , model , color ) ; 
	}
	@Override
	public void run() {
		System.out.println("Manual Car :: Car start Hat Jwo aage se ..............burrrrr " ) ;
	}
	@Override
	public void accelerate() {
		speed += 10 ; 
		System.out.println("Manual Car :: Speed increase to " + speed) ; 
	}
} 


class ElectricCar extends Car implements Chargeable{
	private int batteryLevel ; 
	ElectricCar(String name , String model , String color ) {
		super(name , model , color ) ; 
		this.batteryLevel = 50 ;
	}

	public void charge() {
		System.out.println("Battery Before charge :: " + batteryLevel ) ;
		System.out.println("Charging..........60....70....90...99...");
		batteryLevel = 100 ; 
		System.out.println("Battery after charge :: "  + batteryLevel); 
	}
	
	@Override 
	public void run() {
		System.out.println("Electric Car  :: Car Start hat jwo jaldi se ........siiiiiiiiii " ) ; 
	}
	@Override 
	public void accelerate() {
		speed += 20 ; 
		System.out.println("Electric Car  :: Speed Increase by ...." + speed ) ; 
	} 
}



class Inheritance1 {
	public static void main(String[] args ) {
		Car c = new ManualCar("Ford" , "Mustang" , "Light Green") ; 
		Car c2 = new ElectricCar("Tata" , "EV" , "White") ; 
		c.display() ; 
		c.run() ; 
		c.accelerate();
		c.brake() ; 
		c2.display() ;  
	}
}