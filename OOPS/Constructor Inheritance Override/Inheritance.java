class Car {
	String name ; 
	String model ; 
	String color ; 
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
	
	public void stop() {
		System.out.println("Base class car :: Stop " ) ;  
	}
	public void run() { 
		System.out.println("Base class car :: Run " ) ; 
	}
	public void brak() {
		System.out.println("Base class car :: Brak " ) ; 
	}
	public void accelerate() {
		System.out.println("Base class car :: Accelerate " ) ; 
	}
}
class ManualCar extends Car {
	ManualCar(String name , String model , String color ) {
		super(name , model , color ) ; 
	}
	@Override
	public void run() {
		System.out.println("Manual Car :: Car start Hat Jwo aage se ..............burrrrr " ) ;
	}
} 
class ElectricCar extends Car {
	ElectricCar(String name , String model , String color ) {
		super(name , model , color ) ; 
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

class Inheritance {
	public static void main(String[] args ) {
		Car c = new ManualCar("Ford" , "Mustang" , "Light Green") ; 
		Car c2 = new ElectricCar("Tata" , "EV" , "White") ; 
		c.display() ; 
		c2.display() ;  
	}
}