class Singalton {
	int id ;
	String name ; 

	private static Singalton instance ; 

	private Singalton() {
		System.out.println("Singalton object is created .....") ; 
	}
	public static Singalton getObject(){
		if(instance == null ) {
			return instance = new Singalton() ; 
		} else {
			return instance ; 
		}
	}

}

class SingaltonPatternThreadSafe {
	public static void main(String[] args){
		System.out.println("Welcome to Singalthon Pattern thread safe.....") ; 
	
		Singalton s1 = Singalton.getObject() ; 
		Singalton s2 = Singalton.getObject() ; 

		System.out.println(s1==s2) ; 
	}
}