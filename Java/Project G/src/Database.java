/**
	Database.java
	(C) Giovanni Capuano 2011
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

public class Database extends Observable {
	private Map<String, String> abilities;
	private ArrayList<String> abilitiesbyid;
	private Map<String, Map<String, String>> moves;
	private Map<String, Map<String, String>> movesbyid;
	private ArrayList<String> natures;
	private Map<String, Map<String, String>> pokemon;
	private Map<String, Map<String, String>> pokemonbyid;
	private Map<String, Map<String, ArrayList<String>>> specialmoves;
	private ArrayList<String> types;

	public Map<String, String> getAbilities() {
		return abilities;
	}

	public ArrayList<String> getAbilitiesById() {
		return abilitiesbyid;
	}

	public Map<String, Map<String, String>> getMoves() {
		return moves;
	}

	public Map<String, Map<String, String>> getMovesById() {
		return movesbyid;
	}

	public ArrayList<String> getNatures() {
		return natures;
	}

	public Map<String, Map<String, String>> getPokemon() {
		return pokemon;
	}

	public Map<String, Map<String, String>> getPokemonById() {
		return pokemonbyid;
	}

	public Map<String, Map<String, ArrayList<String>>> getSpecialMoves() {
		return specialmoves;
	}

	public ArrayList<String> getTypes() {
		return types;
	}

	private ArrayList<String> loadResource(String path) throws IOException {
		try {
			ArrayList<String> object = new ArrayList<String>();
			BufferedReader reader = new BufferedReader(new InputStreamReader(getClass().getClassLoader().getResourceAsStream(path)));
			String line;
			while((line = reader.readLine()) != null)
				object.add(line);
			reader.close();
			changedState(new LoaderState(2, path));
			return object;
		}
		catch(IOException e) {
			throw new IOException();
		}
	}

	private Map<String, ArrayList<String>> loadResourceSplitting(String path) throws IOException {
		try {
			Map<String, ArrayList<String>> object = new HashMap<String, ArrayList<String>>();
			ArrayList<String> tmp;
			BufferedReader reader = new BufferedReader(new InputStreamReader(getClass().getClassLoader().getResourceAsStream(path)));
			String line;
			String[] split;
			while((line = reader.readLine()) != null) {
				tmp = new ArrayList<String>();
				split = line.split("\\,");
				for(int i=1, count=split.length; i<count; ++i)
					tmp.add(split[i]);
				object.put(split[0], tmp);
			}
			reader.close();
			changedState(new LoaderState(2, path));
			return object;
		}
		catch(IOException e) {
			throw new IOException();
		}
	}

	private ArrayList<String> loadResourceIgnoring(String path) throws IOException {
		try {
			ArrayList<String> object = new ArrayList<String>();
			BufferedReader reader = new BufferedReader(new InputStreamReader(getClass().getClassLoader().getResourceAsStream(path)));
			String line;
			String[] split;
			boolean ignore;
			while((line = reader.readLine()) != null) {
				split = line.split("\\,");
				ignore = false;
				for(int i=1; i<20; ++i)
					if(split[0].endsWith(""+i))
						ignore = true;
				if(ignore)
					continue;
				object.add(split[1]);
			}
			reader.close();
			changedState(new LoaderState(2, path));
			return object;
		}
		catch(IOException e) {
			throw new IOException();
		}
	}

	private void fetchAbilities() throws ResourceNotFound {
		try {
			abilities = new HashMap<String, String>();
			ArrayList<String> name = loadResource("db/abilities/name.txt");
			ArrayList<String> description = loadResource("db/abilities/description.txt");
			for(int i=0, count = name.size(); i < count; ++i)
				abilities.put(name.get(i), description.get(i));
			abilitiesbyid = loadResource("db/abilities/name.txt");
		}
		catch(IOException localIOException) {
			throw new ResourceNotFound();
		}
	}

	private void fetchMoves() throws ResourceNotFound {
		try {
			ArrayList<String> accuracy = loadResource("db/moves/accuracy.txt");
			ArrayList<String> criticalhit = loadResource("db/moves/criticalhit.txt");
			ArrayList<String> description = loadResource("db/moves/description.txt");
			ArrayList<String> effect = loadResource("db/moves/effect.txt");
			ArrayList<String> flinch = loadResource("db/moves/flinch.txt");
			ArrayList<String> healing = loadResource("db/moves/healing.txt");
			ArrayList<String> name = loadResource("db/moves/name.txt");
			ArrayList<String> power = loadResource("db/moves/power.txt");
			ArrayList<String> pp = loadResource("db/moves/pp.txt");
			ArrayList<String> priority = loadResource("db/moves/priority.txt");
			ArrayList<String> recoil = loadResource("db/moves/recoil.txt");
			ArrayList<String> type = loadResource("db/moves/type.txt");
			moves = new HashMap<String, Map<String, String>>();
			movesbyid = new HashMap<String, Map<String, String>>();

			for(int i=0, count = name.size(); i < count; ++i) {
				HashMap<String, String> value = new HashMap<String, String>();
				value.put("name", name.get(i));
				value.put("accuracy", accuracy.get(i));
				value.put("criticalhit", criticalhit.get(i));
				value.put("description", description.get(i));
				value.put("effect", effect.get(i));
				value.put("flinch", flinch.get(i));
				value.put("healing", healing.get(i));
				value.put("power", power.get(i));
				value.put("pp", pp.get(i));
				value.put("priority", priority.get(i));
				value.put("recoil", recoil.get(i));
				value.put("type", type.get(i));
				value.put("number", Integer.toString(i));
				moves.put(name.get(i), value);
				movesbyid.put(Integer.toString(i), value);
			}
		}
		catch(IOException e) {
			throw new ResourceNotFound();
		}
	}

	private void fetchNatures() throws ResourceNotFound {
		try {
			natures = loadResource("db/natures/name.txt");
		}
		catch(IOException e) {
			throw new ResourceNotFound();
		}
	}

	private void fetchPokemon() throws ResourceNotFound {
		try {
			BufferedReader reader;
			String line;
			String[] split;
			Map<String, String> values;
			boolean ignore;
			int i, count;
			
			ArrayList<String> ability1 = loadResourceIgnoring("db/pokemon/ability2.txt");
			ArrayList<String> ability2 = loadResourceIgnoring("db/pokemon/ability1.txt");
			ArrayList<String> type1 = loadResourceIgnoring("db/pokemon/type1.txt");
			ArrayList<String> type2 = loadResourceIgnoring("db/pokemon/type2.txt");
			ArrayList<String> name = new ArrayList<String>();
			ArrayList<String> number = new ArrayList<String>();
			ArrayList<String> hp = new ArrayList<String>();
			ArrayList<String> atk = new ArrayList<String>();
			ArrayList<String> def = new ArrayList<String>();
			ArrayList<String> spatk = new ArrayList<String>();
			ArrayList<String> spdef = new ArrayList<String>();
			ArrayList<String> spe = new ArrayList<String>();
			pokemon = new HashMap<String, Map<String, String>>();
			pokemonbyid = new HashMap<String, Map<String, String>>();
			
			reader = new BufferedReader(new InputStreamReader(getClass().getClassLoader().getResourceAsStream("db/pokemon/name.txt")));
			while((line = reader.readLine()) != null) {
				split = line.split("\\,");
				ignore = false;
				for(i=1; i<20; ++i)
					if(split[0].endsWith(""+i))
						ignore = true;
				if(ignore)
					continue;
				name.add(split[1]);
				number.add(split[0].replaceAll("\\:[0-9]", ""));
			}
			reader.close();
			
			reader = new BufferedReader(new InputStreamReader(getClass().getClassLoader().getResourceAsStream("db/pokemon/stats.txt")));
			while((line = reader.readLine()) != null) {
				split = line.split("\\,");
				ignore = false;
				for(i=1; i<20; ++i)
					if(split[0].endsWith(""+i))
						ignore = true;
				if(ignore)
					continue;
				hp.add(split[1]);
				atk.add(split[2]);
				def.add(split[3]);
				spatk.add(split[4]);
				spdef.add(split[5]);
				spe.add(split[6]);
			}
			reader.close();
			
			for(i=0, count=hp.size(); i<count; ++i) {
				values = new HashMap<String, String>();
				values.put("number", number.get(i));
				values.put("name", name.get(i));
				values.put("ability1", ability1.get(i));
				values.put("ability2", ability2.get(i));
				values.put("hp", hp.get(i));
				values.put("atk", atk.get(i));
				values.put("def", def.get(i));
				values.put("spatk", spatk.get(i));
				values.put("spdef", spdef.get(i));
				values.put("spe", spe.get(i));
				values.put("type1", type1.get(i));
				values.put("type2", type2.get(i));
				pokemon.put(name.get(i), values);
				pokemonbyid.put(number.get(i), values);
			}
		}
		catch(IOException e) {
			throw new ResourceNotFound();
		}
	}

	private void fetchSpecialMoves() throws ResourceNotFound {
		try {
			specialmoves = new HashMap<String, Map<String, ArrayList<String>>>();
			specialmoves.put("dw", loadResourceSplitting("db/specialmoves/dw.txt"));
			specialmoves.put("egg", loadResourceSplitting("db/specialmoves/egg.txt"));
			specialmoves.put("levelup", loadResourceSplitting("db/specialmoves/levelup.txt"));
			specialmoves.put("preevo", loadResourceSplitting("db/specialmoves/preevo.txt"));
			specialmoves.put("special", loadResourceSplitting("db/specialmoves/special.txt"));
			specialmoves.put("tmhm", loadResourceSplitting("db/specialmoves/tmhm.txt"));
			specialmoves.put("tutor", loadResourceSplitting("db/specialmoves/tutor.txt"));
		}
		catch(IOException e) {
			throw new ResourceNotFound();
		}
	}

	private void fetchTypes() throws ResourceNotFound {
		try {
			types = loadResource("db/types/name.txt");
		}
		catch(IOException e) {
			throw new ResourceNotFound();
		}
	}

	public Database() {
		changedState(new LoaderState(0, "Ready."));
	}

	public void init(Utils utils) throws ResourceNotFound {
		try {
			int i = 6;
			changedState(new LoaderState(1, "Abilities", 1, i));
			fetchAbilities();
			changedState(new LoaderState(1, "Moves", 2, i));
			fetchMoves();
			changedState(new LoaderState(1, "Natures", 3, i));
			fetchNatures();
			changedState(new LoaderState(1, "Pokémon", 4, i));
			fetchPokemon();
			changedState(new LoaderState(1, "Special moves", 5, i));
			fetchSpecialMoves();
			changedState(new LoaderState(1, "Types", 6, i));
			fetchTypes();
		}
		catch (ResourceNotFound e) {
			changedState(new LoaderState(4, e));
			throw new ResourceNotFound();
		}
		changedState(new LoaderState(5, "Initializing the online database..."));
		if(utils.initOnline())
			changedState(new LoaderState(5, "Online database has been initialized."));
		else
			changedState(new LoaderState(5, "Online database cannot be initialized."));
		changedState(new LoaderState(3, "Done."));
	}

	private void changedState(LoaderState msg) {
		setChanged();
		notifyObservers(msg);
	}
}
