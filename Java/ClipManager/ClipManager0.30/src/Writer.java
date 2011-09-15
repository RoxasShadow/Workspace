import java.util.ArrayList; 
class Writer {
	private ArrayList<Text> elenco; 
	
	Writer() {
		elenco = new ArrayList<Text>();
	}
	
	public void newText(Text text) {
		elenco.add(text); // Aggiunge il testo all'elenco
	}
	
	public String getText(int id) {
		for(Text text:elenco) {
			if(text.getId() == id) {
				return text.getText(); // Ritorna il testo se corrisponde all'id inserito
			}
		}
		return "Text not found.";
	}
	
	public void cleanText() {
		for(Text text:elenco) {
			elenco.remove(text); // Rimuove tutti i testi
		}
	}
	
	public int countText() {
		int count = 0;
		for(Text text:elenco) {
			count++; // Ad ogni testo aumenta count di 1 e lo ritorna
		}
		return count;
	}
}
