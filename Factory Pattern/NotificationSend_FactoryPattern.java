// C:\Users\Gopal\OneDrive\Desktop\System Degine\Factory Pattern


interface Notification {
	void send() ;
}

class SMS implements Notification {
	@Override
	public void send(){
		System.out.println("Send Notification :: via SMS ") ; 
	}
}

class Email implements Notification {
	@Override
	public void send(){
		System.out.println("Send Notification :: via Email ") ; 
	}
}

class Facebook implements Notification {
	@Override
	public void send(){
		System.out.println("Send Notification :: via Facebook ") ; 
	}
}

class Instagram implements Notification {
	@Override
	public void send(){
		System.out.println("Send Notification :: via Instagram ") ; 
	}
}


class NotificationSystem {
	public void run(Notification type) {
		type.send() ; 
	}
}

class NotificationFactory {
	public static Notification check(String str) {
		if("SMS".equalsIgnoreCase(str) ) {
			return new SMS() ; 
		} else if ("Email".equalsIgnoreCase(str)) {
			return new Email() ; 
		} else if ("Facebook".equalsIgnoreCase(str)) {
			return new Facebook() ; 
		} else if ("Instagram".equalsIgnoreCase(str) ) {
			return new Instagram() ; 
		} else {
			return null ;
		}
	}
}
		
			

class NotificationSend_FactoryPattern {
	public static void main(String[] args ) {
		System.out.println("Welcome to Notificcation System :: via Factory pattern ") ; 
		NotificationSystem notificationSystem = new NotificationSystem() ; 

		Notification n1 = NotificationFactory.check("SMS") ; 
		notificationSystem.run(n1) ;  
		 
	}
}