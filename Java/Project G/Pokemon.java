/**
	Pokemon.java
	(C) Giovanni Capuano 2011
*/
import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import java.util.Map;
import java.util.HashMap;

/* Provvede al parsing del database dei Pokémon sottoforma di Map. */
public class Pokemon {
	public Map<String, Map<String, String>> pokemon;
	public Map<Integer, Map<String, String>> pokemonId;
	
	/* Ritorna il database con i Pokèmon. */
	public Map<String, Map<String, String>> getPokemon() {
		return pokemon;
	}
	
	/* Ritorna il database con i Pokèmon. */
	public Map<String, Map<String, String>> getPokemonByName() {
		return pokemon;
	}
	
	/* Ritorna il database con i Pokèmon ordinandoli per numero. */
	public Map<Integer, Map<String, String>> getPokemonById() {
		return pokemonId;
	}
	
	/**
	Ottiene il file dbPath e per ogni tag <pokemon>, inserisce nella mappa associativa il nome del Pokémon e un'altra mappa con i dati ad esso relativi.
	pokemon -> nome
		   valori -> name
		   	     ability1
		   	     ...
	*/
	public Pokemon(String dbPath) throws ResourceNotFound {
		try {
			Map<String, String> values;
			pokemon = new HashMap<String, Map<String, String>>();
			pokemonId = new HashMap<Integer, Map<String, String>>();
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(new File(dbPath));
			doc.getDocumentElement().normalize();
			NodeList nodeLst = doc.getElementsByTagName("pokemon");
			Element fstElmnt, fstNmElmnt;
			NodeList fstNmElmntLst, fstNm;
			Node fstNode;
			String name;
			for(int i=0; i<nodeLst.getLength(); ++i) {
				values = new HashMap<String, String>();
				fstNode = nodeLst.item(i);
				if(fstNode.getNodeType() == Node.ELEMENT_NODE) {
					fstElmnt = (Element) fstNode;
						
					fstNmElmntLst = fstElmnt.getElementsByTagName("name");
					fstNmElmnt = (Element) fstNmElmntLst.item(0);
					fstNm = fstNmElmnt.getChildNodes();
					name = new String((fstNm.item(0)).getNodeValue());
					values.put("name", name);
						
					fstNmElmntLst = fstElmnt.getElementsByTagName("ability1");
					fstNmElmnt = (Element) fstNmElmntLst.item(0);
					fstNm = fstNmElmnt.getChildNodes();
					values.put("ability1", (fstNm.item(0)).getNodeValue());
						
					fstNmElmntLst = fstElmnt.getElementsByTagName("ability2");
					fstNmElmnt = (Element) fstNmElmntLst.item(0);
					fstNm = fstNmElmnt.getChildNodes();
					values.put("ability2", (fstNm.item(0)).getNodeValue());
						
					fstNmElmntLst = fstElmnt.getElementsByTagName("number");
					fstNmElmnt = (Element) fstNmElmntLst.item(0);
					fstNm = fstNmElmnt.getChildNodes();
					values.put("number", (fstNm.item(0)).getNodeValue());
						
					fstNmElmntLst = fstElmnt.getElementsByTagName("hp");
					fstNmElmnt = (Element) fstNmElmntLst.item(0);
					fstNm = fstNmElmnt.getChildNodes();
					values.put("hp", (fstNm.item(0)).getNodeValue());
						
					fstNmElmntLst = fstElmnt.getElementsByTagName("atk");
					fstNmElmnt = (Element) fstNmElmntLst.item(0);
					fstNm = fstNmElmnt.getChildNodes();
					values.put("atk", (fstNm.item(0)).getNodeValue());
						
					fstNmElmntLst = fstElmnt.getElementsByTagName("def");
					fstNmElmnt = (Element) fstNmElmntLst.item(0);
					fstNm = fstNmElmnt.getChildNodes();
					values.put("def", (fstNm.item(0)).getNodeValue());
						
					fstNmElmntLst = fstElmnt.getElementsByTagName("atksp");
					fstNmElmnt = (Element) fstNmElmntLst.item(0);
					fstNm = fstNmElmnt.getChildNodes();
					values.put("atksp", (fstNm.item(0)).getNodeValue());
					
					fstNmElmntLst = fstElmnt.getElementsByTagName("difsp");
					fstNmElmnt = (Element) fstNmElmntLst.item(0);
					fstNm = fstNmElmnt.getChildNodes();
					values.put("difsp", (fstNm.item(0)).getNodeValue());
						
					fstNmElmntLst = fstElmnt.getElementsByTagName("spe");
					fstNmElmnt = (Element) fstNmElmntLst.item(0);
					fstNm = fstNmElmnt.getChildNodes();
					values.put("spe", (fstNm.item(0)).getNodeValue());
						
					pokemon.put(name, values);
					pokemonId.put(i, values);
				}
			}
		}
		catch(Exception e) {
			throw new ResourceNotFound();
		}
	}
}
