class Singalton {
	int id ; 
	String name ; 
	private static Singalton instance ; 

	private Singalton(int id , String name ) {
		System.out.println("Singalton obj is created ......") ; 
		this.id = id ; 
		this.name = name ; 
	}

	public static Singalton getObject(int id , String name ) {
		if(instance == null ) {
			instance = new Singalton(id,name) ; 
			return instance ; 
		} else {
			return instance ; 
		}
	}
}

class SingaltonPattern {
	public static void main(String[] args) {
		System.out.println("Welcome to SingaltonPattern Degine........") ; 
		Singalton s1 = Singalton.getObject(7,"Gopal") ; 
		Singalton s2 = Singalton.getObject(7,"Gopal") ; 
		System.out.println(s1==s2) ; 
	}
}

	