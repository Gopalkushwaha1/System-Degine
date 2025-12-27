import java.util.* ; 
import java.io.FileWriter ; 
import java.io.IOException ; 

interface DocumentElement {
	String render() ; 
}

class TextElement implements DocumentElement {
	private String text ; 
	
	TextElement(String text ) {
		this.text = text ; 
	}

	@Override 
	public String render() {
		return text ; 
	}
}

class ImageElement implements DocumentElement {
	private String imagepath ; 

	ImageElement(String imagepath ) {
		this.imagepath = imagepath ; 
	}

	@Override
	public String render() {
		return "[Imgage: " + imagepath + "]" ; 
	}
}

class NewLineElement implements DocumentElement {
	@Override 
	public String render() {
		return "\n" ; 
	}
}

class TabSpaceElement implements DocumentElement {
	@Override 
	public String render(){
		return "\t" ; 
	}
}


class DocumentEditor {
	private Document document ; 
	private Persistance storage ; 
	private String renderedDocument = "";

	DocumentEditor(Document document , Persistance storage ) {
		this.document = document ; 
		this.storage = storage ; 
	}

	public void addText(String text) {
		document.addElement(new TextElement(text)) ;
		renderedDocument = "";
 
	}
	public void addImage(String imagePath ){
		document.addElement(new ImageElement(imagePath)) ; 
		renderedDocument = "";

	}
	public void addNewLine(){
		document.addElement(new NewLineElement()) ; 
		renderedDocument = "";

	}
	public void addTabSpace(){
		document.addElement(new TabSpaceElement()) ; 
		renderedDocument = "";

	}

	public String renderDocument(){
		if(renderedDocument.isEmpty() ) {
			renderedDocument = document.render() ; 
		}
		return renderedDocument ; 
	}

	public void saveDocument(){
		String content = renderDocument() ; 
		storage.save(content);
	}
}


class Document {
	private List<DocumentElement> documentElement = new ArrayList<>() ; 
	
	public void addElement(DocumentElement element) {
		documentElement.add(element) ; 
	}

	public String render(){
		StringBuilder sb = new StringBuilder() ; 
		for (DocumentElement element  : documentElement ) {
			sb.append(element.render()) ; 
		}
		return sb.toString();
	}
}




interface Persistance {
	void save(String data ) ; 
}

class FileStorage implements Persistance {
	@Override
	public void save(String data) {
		try {
			FileWriter writer = new FileWriter("Document.txt") ; 
			writer.write(data) ; 
			writer.close() ; 
			System.out.println("File Save ....Enojy your work") ; 
		} catch (IOException e ) {
			System.out.println("Error to save the file ... Try again " ) ; 
		}
	}
}
class DataBase implements Persistance {
	@Override 
	public void save(String data) {
		try (FileWriter writer = new FileWriter("Documnt.txt")) { 
			writer.write(data) ; 
			System.out.println("File Save .... Enojy your work ." ) ; 
		} catch (IOException e ) {
			System.out.println("Error to save the file .... Try after sometime " ) ; 
		}
	}
}

public class Good_LLD_DocumentEditor {
	public static void main(String[] args ) {
		Document document = new Document() ; 
		Persistance persistance = new FileStorage() ; 

		DocumentEditor editor = new DocumentEditor(document , persistance) ; 

		System.out.println("Welcome to Document Editor") ; 
		editor.addText("My name is Gopal Kushwaha") ; 
		editor.addNewLine() ; 
		editor.addText("How are you..?") ; 
		editor.addTabSpace() ; 
		editor.addText("I am fine ");

		editor.addImage("gopal.jpg");

		System.out.println(editor.renderDocument()) ; 
		editor.saveDocument() ; 
	}
}
	