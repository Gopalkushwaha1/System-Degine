interface Car {
	void startEngine() ; 
	void shiftGear(int gear) ; 
	void accelerate() ; 
	void brak();
	void stopEngine();
}

class SportCar implements Car {
	String brand ; 
	String model ; 
	boolean isEngineOn = false ; 
	int currentSpeed = 0 ; 
	int currentGear = 0 ; 

	public SportCar(String brand , String model ){
		this.brand = brand ; 
		this.model = model ; 
	}

	@Override 
	public void startEngine(){
		isEngineOn = true ; 
		System.out.println(brand + " " + model + " " + " : Engine starts with a roar! "  ) ; 
	}

	@Override 
	public void shiftGear(int gear) {
		if(!isEngineOn ) {
			System.out.println(brand + " " + model + " " +" : Engine is off! Cannot shift Gear " ) ; 
			return ; 
		}
		this.currentGear = gear ; 
		System.out.println(brand + " " + model + " " + " : Shifted to gear " + currentGear ) ;
	}

	@Override 
	public void accelerate() {
		if(!isEngineOn ) {
			System.out.println(brand + " " + model + " " +" : Engine is off! Cannot shift Gear " ) ; 
			return ; 
		}
		currentSpeed += 20 ; 
		System.out.println(brand + " " + model + " " + " : Accelerateing to " + currentSpeed + " km/h " ) ; 
	}

	@Override 
	public void brak() {
		if(!isEngineOn ) {
			System.out.println(brand + " " + model + " " +" : Engine is off! Cannot shift Gear " ) ; 
			return ; 
		}
		currentSpeed -= 20 ; 
		System.out.println(brand + " " + model + " " + " : Accelerateing to " + currentSpeed + " km/h " ) ; 
	}

	@Override 
	public void stopEngine() {
		isEngineOn = false ; 
		currentGear = 0 ; 
		currentSpeed = 0 ; 
		System.out.println(brand + " " + model + " " + " : Engine turned off . " ) ;  
	}
}

public class Abstraction {
	public static void main(String[] args ) {
		Car myCar = new SportCar("Ford" , "Mustang") ; 

		myCar.startEngine() ; 
		myCar.shiftGear(3) ; 
		myCar.accelerate() ; 
		myCar.shiftGear(2) ; 
		myCar.accelerate() ; 
		myCar.brak() ; 
		myCar.stopEngine() ; 
	}
}