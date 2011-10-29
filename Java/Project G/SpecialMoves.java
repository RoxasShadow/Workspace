/**
	SpecialMoves.java
	(C) Giovanni Capuano 2011
*/
import java.io.File;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

/* Provvede al parsing del database delle mosse speciali (pre-evoluzioni, uovo, tutor...) dei Pokémon sottoforma di Map. */
public class SpecialMoves {
	public Map<String, ArrayList<Integer>> moves;
	
	/* Ritorna il database con le mosse. */
	public Map<String, ArrayList<Integer>> getMoves() {
		return moves;
	}
	
	/**
	Ottiene il file dbPath e inserisce nella mappa associativa il numero nazionale del Pokémon e un arraylist di interi con gli id delle mosse che impara.
	moves -> id
		   valori -> 54
		   	     9
		   	     ...
	*/
	public SpecialMoves(String dbPath) throws ResourceNotFound {
		try {
			ArrayList<Integer> values;
			moves = new HashMap<String, ArrayList<Integer>>();
			File file = new File(dbPath);
			URL url = file.toURI().toURL();
			BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
			String line;
			String[] split;
			int i, count;
			while((line = reader.readLine()) != null) {
				values = new ArrayList<Integer>();
				split = line.split("\\,");
				for(i=1, count=split.length; i<count; ++i)
					values.add(Integer.parseInt(split[i]));
				moves.put(split[0], values);
			}
			reader.close();
				
		}
		catch(IOException e) {
			throw new ResourceNotFound();
		}
	}
}
