import java.util.ArrayList; 
class Writer {
	private ArrayList<Text> elenco; 
	
	Writer() {
		elenco = new ArrayList<Text>();
	}
	
	public void newText(Text text) {
		elenco.add(text);
	}
	
	public String getText(int id) {
		for(Text text:elenco) {
			if(text.getId() == id) {
				return text.getText();
			}
		}
		return "Text not found.";
	}
	
	public void cleanText() {
		for(Text text:elenco) {
			elenco.remove(text);
		}
	}
}
