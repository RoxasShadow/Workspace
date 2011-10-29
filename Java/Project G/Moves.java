/**
	Moves.java
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

/* Provvede al parsing del database delle mosse sottoforma di Map. */
public class Moves {
	public Map<String, Map<String, String>> moves;
	public Map<Integer, Map<String, String>> movesInt;
	
	/* Ritorna il database con le mosse ordinate per nome. */
	public Map<String, Map<String, String>> getMoves() {
		return moves;
	}
	
	/* Ritorna il database con le mosse ordinate per nome. */
	public Map<String, Map<String, String>> getMovesByName() {
		return moves;
	}
	
	/* Ritorna il database con le mosse ordinate per id. */
	public Map<Integer, Map<String, String>> getMovesById() {
		return movesInt;
	}
	
	/**
	Ottiene il file dbPath e per ogni tag <move>, inserisce nella mappa associativa il nome della mossa e un'altra mappa con i dati ad esso relativi.
	moves -> nome
		   valori -> description
		   	     accuracy
		   	     ...
	*/
	public Moves(String dbPath) throws ResourceNotFound {
		try {
			Map<String, String> values;
			moves = new HashMap<String, Map<String, String>>();
			movesInt = new HashMap<Integer, Map<String, String>>();
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(new File(dbPath));
			doc.getDocumentElement().normalize();
			NodeList nodeLst = doc.getElementsByTagName("move");
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
						
					fstNmElmntLst = fstElmnt.getElementsByTagName("description");
					fstNmElmnt = (Element) fstNmElmntLst.item(0);
					fstNm = fstNmElmnt.getChildNodes();
					values.put("description", (fstNm.item(0)).getNodeValue());
						
					fstNmElmntLst = fstElmnt.getElementsByTagName("effect");
					fstNmElmnt = (Element) fstNmElmntLst.item(0);
					fstNm = fstNmElmnt.getChildNodes();
					values.put("effect", (fstNm.item(0)).getNodeValue());
						
					fstNmElmntLst = fstElmnt.getElementsByTagName("power");
					fstNmElmnt = (Element) fstNmElmntLst.item(0);
					fstNm = fstNmElmnt.getChildNodes();
					values.put("power", (fstNm.item(0)).getNodeValue());
						
					fstNmElmntLst = fstElmnt.getElementsByTagName("type");
					fstNmElmnt = (Element) fstNmElmntLst.item(0);
					fstNm = fstNmElmnt.getChildNodes();
					values.put("type", (fstNm.item(0)).getNodeValue());
						
					fstNmElmntLst = fstElmnt.getElementsByTagName("accuracy");
					fstNmElmnt = (Element) fstNmElmntLst.item(0);
					fstNm = fstNmElmnt.getChildNodes();
					values.put("accuracy", (fstNm.item(0)).getNodeValue());
						
					fstNmElmntLst = fstElmnt.getElementsByTagName("pp");
					fstNmElmnt = (Element) fstNmElmntLst.item(0);
					fstNm = fstNmElmnt.getChildNodes();
					values.put("pp", (fstNm.item(0)).getNodeValue());
						
					fstNmElmntLst = fstElmnt.getElementsByTagName("effectaccuracy");
					fstNmElmnt = (Element) fstNmElmntLst.item(0);
					fstNm = fstNmElmnt.getChildNodes();
					values.put("effectaccuracy", (fstNm.item(0)).getNodeValue());
						
					fstNmElmntLst = fstElmnt.getElementsByTagName("whoaffect");
					fstNmElmnt = (Element) fstNmElmntLst.item(0);
					fstNm = fstNmElmnt.getChildNodes();
					values.put("whoaffect", (fstNm.item(0)).getNodeValue());
						
					fstNmElmntLst = fstElmnt.getElementsByTagName("priority");
					fstNmElmnt = (Element) fstNmElmntLst.item(0);
					fstNm = fstNmElmnt.getChildNodes();
					values.put("priority", (fstNm.item(0)).getNodeValue());
						
					fstNmElmntLst = fstElmnt.getElementsByTagName("physical");
					fstNmElmnt = (Element) fstNmElmntLst.item(0);
					fstNm = fstNmElmnt.getChildNodes();
					values.put("physical", (fstNm.item(0)).getNodeValue());
						
					fstNmElmntLst = fstElmnt.getElementsByTagName("damagetype");
					fstNmElmnt = (Element) fstNmElmntLst.item(0);
					fstNm = fstNmElmnt.getChildNodes();
					values.put("damagetype", (fstNm.item(0)).getNodeValue());
						
					moves.put(name, values);
					movesInt.put(i, values);
				}
			}
		}
		catch(Exception e) {
			throw new ResourceNotFound();
		}
	}
}
