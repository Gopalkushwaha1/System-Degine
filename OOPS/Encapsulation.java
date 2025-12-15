class SportCar {
	private String brand ; 
	private String model ; 
	private boolean isEngineOn = false ; 
	private int currentSpeed = 0 ; 
	private int currentGear = 0 ; 
	private String tyreCompany ; 

	public SportCar(String brand , String model ){
		this.brand = brand ; 
		this.model = model ; 
	}

	public int getSpeed(){
		return currentSpeed ; 
	}
	public String getTyreCompany() {
		return tyreCompany ; 
	}
	public void setTyreCompany(String tyreCompany) {
		this.tyreCompany = tyreCompany ; 
	}

	public void startEngine(){
		isEngineOn = true ; 
		System.out.println(brand + " " + model + " " + " : Engine starts with a roar! "  ) ; 
	}

	public void shiftGear(int gear) {
		if(!isEngineOn ) {
			System.out.println(brand + " " + model + " " +" : Engine is off! Cannot shift Gear " ) ; 
			return ; 
		}
		this.currentGear = gear ; 
		System.out.println(brand + " " + model + " " + " : Shifted to gear " + currentGear ) ;
	}

	public void accelerate() {
		if(!isEngineOn ) {
			System.out.println(brand + " " + model + " " +" : Engine is off! Cannot shift Gear " ) ; 
			return ; 
		}
		currentSpeed += 20 ; 
		System.out.println(brand + " " + model + " " + " : Accelerateing to " + currentSpeed + " km/h " ) ; 
	}

	public void brak() {
		if(!isEngineOn ) {
			System.out.println(brand + " " + model + " " +" : Engine is off! Cannot shift Gear " ) ; 
			return ; 
		}
		currentSpeed -= 20 ; 
		System.out.println(brand + " " + model + " " + " : Accelerateing to " + currentSpeed + " km/h " ) ; 
	}

	public void stopEngine() {
		isEngineOn = false ; 
		currentGear = 0 ; 
		currentSpeed = 0 ; 
		System.out.println(brand + " " + model + " " + " : Engine turned off . " ) ;  
	}
}

public class Encapsulation {
	public static void main(String[] args ) {
		SportCar myCar = new SportCar("Ford" , "Mustang") ; 

		myCar.startEngine() ; 
		myCar.shiftGear(3) ; 
		myCar.accelerate() ; 
		myCar.shiftGear(2) ; 
		myCar.accelerate() ; 
		myCar.brak() ; 
		myCar.stopEngine() ; 


	}
}