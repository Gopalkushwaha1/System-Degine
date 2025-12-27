import java.util.* ; 
import java.io.FileWriter;
import java.io.IOException;

class document {
	List<String> list  ; 
	String viewDocument ;  
	
	document() {
		list = new ArrayList<>() ; 
		viewDocument = "" ; 
	}
	void addImg(String img ) {
		list.add(img) ;  
	}
	void addTxt(String img ) {
		list.add(img) ;  
	}
		
			
	String display(){
		System.out.println("Below is you docemnt " ) ; 
		if(viewDocument.isEmpty()){
			StringBuilder sb = new StringBuilder(); 
			for ( String str : list ) {
				if(str.endsWith(".jpg") || str.endsWith(".png")){
					sb.append("[ Image ").append(str).append( " ]\n") ;  
				}
				else {
					sb.append(str).append("\n") ; 
				}
			}
			viewDocument = sb.toString() ;  
		}
		return viewDocument ; 
	}
	void saveToFile(){
		try {
			FileWriter doc = new FileWriter("Document.txt") ; 
			doc.write(viewDocument) ; 
			doc.close();
			System.out.println("Document save Document.txt");
		} catch (IOException e ) {
				System.out.println("Error .. While saving data .");
		}
	}

}
class doc {
	public static void main(String[] args ) {
		System.out.println("Welcome to document .....") ; 
		document d1 = new document() ; 
		d1.addTxt("Gopal Kushwaha is here ") ; 
		d1.addImg("mypic.jpg" ) ; 
		System.out.println(d1.display() );
		d1.saveToFile(); 
	}
}