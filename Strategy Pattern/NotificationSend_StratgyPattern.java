interface Notification {
	void send() ; 
}

class Email implements Notification {
	@Override 
	public void send(){
		System.out.println("Send Notification :: via Email") ; 
	}
}

class SMS implements Notification {
	@Override 
	public void send(){
		System.out.println("Send Notification :: via SMS ") ; 
	}
}

class Facebook implements Notification {
	@Override 
	public void send() {
		System.out.println("Send Notification :: via FaceBook " ) ; 
	}
}

class Instagram implements Notification {
	@Override 
	public void send() {
		System.out.println("Send Notification :: via Instagram " ) ; 
	}
}


class NotificationSystem {
	Notification notification ; 
	
	void run(Notification notification){
		notification.send() ; 
	}
}

class NotificationSend_StratgyPattern {
	public static void main(String[] args ) {
		System.out.println("Welcome to Notification System.........") ; 

		Email email = new Email() ; 
		SMS sms = new SMS() ; 
		Facebook facebook = new Facebook() ; 
		Instagram instagram = new Instagram() ; 

		NotificationSystem notificationSystem = new NotificationSystem() ; 

		notificationSystem.run(sms) ;
		notificationSystem.run(instagram) ;  
	}
}