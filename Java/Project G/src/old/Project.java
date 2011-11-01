/**
	Project.java
	(C) Giovanni Capuano 2011
*/
import java.util.Map;
import java.util.ArrayList;

/* UI. */
public class Project {
	private	Utils utils;
	private	Pokemon pokemon;
	private	Moves moves;
	
	public Project() {
		utils = new Utils();
		try {
			pokemon = new Pokemon(utils.getPokemonDb(), utils.getPokemonType1Db(), utils.getPokemonType2Db());
			moves = new Moves("db/moves.xml");
		}
		catch(ResourceNotFound e) {
			System.out.println("Resource not found.");
		}
	}
	
	public void preview(String moveName, String pokemonName) {
		try {
			/* Istanziazione */
			SpecialMoves levelup = new SpecialMoves("db/specialmoves/levelup.txt");
			SpecialMoves dw = new SpecialMoves("db/specialmoves/dw.txt");
			SpecialMoves egg = new SpecialMoves("db/specialmoves/egg.txt");
			SpecialMoves preevo = new SpecialMoves("db/specialmoves/preevo.txt");
			SpecialMoves special = new SpecialMoves("db/specialmoves/special.txt");
			SpecialMoves tmhm = new SpecialMoves("db/specialmoves/tmhm.txt");
			SpecialMoves tutor = new SpecialMoves("db/specialmoves/tutor.txt");
			utils.setDatabaseOnlineName("db/doom.projg");
		
			/* Ottenimento dati */
			Map<String, Map<String, String>> pokemonList = pokemon.getPokemon();
			Map<String, Map<String, String>> moveList = moves.getMovesByName();
			Map<Integer, Map<String, String>> moveListById = moves.getMovesById();
		
			Map<String, ArrayList<Integer>> levelupList = levelup.getMoves();
			Map<String, ArrayList<Integer>> dwList = dw.getMoves();
			Map<String, ArrayList<Integer>> eggList = egg.getMoves();
			Map<String, ArrayList<Integer>> preevoList = preevo.getMoves();
			Map<String, ArrayList<Integer>> specialList = special.getMoves();
			Map<String, ArrayList<Integer>> tmhmList = tmhm.getMoves();
			Map<String, ArrayList<Integer>> tutorList = tutor.getMoves();
		
			/* Prelievo selezione */
			Map<String, String> pokemonInfo = pokemonList.get(pokemonName);
			Map<String, String> moveInfo = moveList.get(moveName);
		
			ArrayList<Integer> levelupInfo = levelupList.get(pokemonInfo.get("number"));
			ArrayList<Integer> dwInfo = dwList.get(pokemonInfo.get("number"));
			ArrayList<Integer> eggInfo = eggList.get(pokemonInfo.get("number"));
			ArrayList<Integer> preevoInfo = preevoList.get(pokemonInfo.get("number"));
			ArrayList<Integer> specialInfo = specialList.get(pokemonInfo.get("number"));
			ArrayList<Integer> tmhmInfo = tmhmList.get(pokemonInfo.get("number"));
			ArrayList<Integer> tutorInfo = tutorList.get(pokemonInfo.get("number"));
		
			/* Inizializzazione online */
			boolean init = utils.initOnline();
			StringBuffer tmp;
			int i, count;
		
			/* Visualizzazione */
			if(moveInfo != null) {
				System.out.println("----------MOVE INFO----------");
				System.out.println("Name: "+moveInfo.get("name"));
				System.out.println("Description: "+moveInfo.get("description"));
				System.out.println("Power: "+moveInfo.get("power"));
				System.out.println("Accuracy: "+moveInfo.get("accuracy"));
				System.out.println("Priority: "+moveInfo.get("priority"));
				System.out.println("PP: "+moveInfo.get("pp"));
				System.out.println("Type: "+utils.getMoveType(Integer.parseInt(moveInfo.get("type")))+"");
			}
			else
				System.out.println("Move not found.");
			if(pokemonInfo != null) {
				System.out.println("----------POKÉMON INFO----------");
				System.out.println("Name: "+pokemonInfo.get("name"));
				System.out.println("Ability: "+pokemonInfo.get("ability1")+" - "+pokemonInfo.get("ability2"));
				System.out.println("Number: "+pokemonInfo.get("number"));
				System.out.println("HP: "+pokemonInfo.get("hp"));
				System.out.println("Atk: "+pokemonInfo.get("atk"));
				System.out.println("Def: "+pokemonInfo.get("def"));
				System.out.println("AtkSp: "+pokemonInfo.get("atksp"));
				System.out.println("DifSp: "+pokemonInfo.get("difsp"));
				System.out.println("Spe: "+pokemonInfo.get("spe"));
			}
			else
				System.out.println("Pokémon not found.");
			// Levelup
			if(levelupInfo != null) {
				tmp = new StringBuffer("");
				for(i=0, count=levelupInfo.size(); i<count; ++i)
					tmp.append(moveListById.get(levelupInfo.get(i)).get("name")+", ");
				System.out.println("Level up moves: "+tmp.toString().substring(0, tmp.toString().length()-2)+".");
			}
			else
				System.out.println("Level up moves: Nothing");
			// DW
			if(dwInfo != null) {
				tmp = new StringBuffer("");
				for(i=0, count=dwInfo.size(); i<count; ++i)
					tmp.append(moveListById.get(dwInfo.get(i)).get("name")+", ");
				System.out.println("Dream world moves: "+tmp.toString().substring(0, tmp.toString().length()-2)+".");
			}
			else
				System.out.println("Dream world moves: Nothing");
			// Egg
			if(eggInfo != null) {
				tmp = new StringBuffer("");
				for(i=0, count=eggInfo.size(); i<count; ++i)
					tmp.append(moveListById.get(eggInfo.get(i)).get("name")+", ");
				System.out.println("Egg moves: "+tmp.toString().substring(0, tmp.toString().length()-2)+".");
			}
			else
				System.out.println("Egg moves: Nothing");
			// Pre-evo
			if(preevoInfo != null) {
				tmp = new StringBuffer("");
				for(i=0, count=preevoInfo.size(); i<count; ++i)
					tmp.append(moveListById.get(preevoInfo.get(i)).get("name")+", ");
				System.out.println("Pre evolution moves: "+tmp.toString().substring(0, tmp.toString().length()-2)+".");
			}
			else
				System.out.println("Pre evolution moves: Nothing");
			// Special
			if(specialInfo != null) {
				tmp = new StringBuffer("");
				for(i=0, count=specialInfo.size(); i<count; ++i)
					tmp.append(moveListById.get(specialInfo.get(i)).get("name")+", ");
				System.out.println("Special moves: "+tmp.toString().substring(0, tmp.toString().length()-2)+".");
			}
			else
				System.out.println("Special moves: Nothing");
			// TM-HM
			if(tmhmInfo != null) {
				tmp = new StringBuffer("");
				for(i=0, count=tmhmInfo.size(); i<count; ++i)
					tmp.append(moveListById.get(tmhmInfo.get(i)).get("name")+", ");
				System.out.println("TM-HM moves: "+tmp.toString().substring(0, tmp.toString().length()-2)+".");
			}
			else
				System.out.println("TM-HM moves: Nothing");
			// Tutor
			if(tutorInfo != null) {
				tmp = new StringBuffer("");
				for(i=0, count=tutorInfo.size(); i<count; ++i)
					tmp.append(moveListById.get(tutorInfo.get(i)).get("name")+", ");
				System.out.println("Tutor moves: "+tmp.toString().substring(0, tmp.toString().length()-2)+".");
			}
			else
				System.out.println("Tutor moves: Nothing");
		
			/* Terminazione */
			if(!init)
				System.out.println("I cannot initialize the online database.");
			else if((init) && (utils.isOnline(pokemonName)))
				System.out.println("This Pokémon is on Doom Desire: "+utils.getOnline(pokemonName));
		}
		catch(ResourceNotFound e) {
			System.out.println("Resource not found.");
		}
		catch(NullPointerException e) {
			System.out.println("Fetching failed.");
		}
	}
	
	public static void main(String[] args) {
		try {
			Project p = new Project();
			if(args.length == 0) {
				System.out.println("Project G - Development version");
				System.out.println("java Project help for more infos.");
			}
			else if(args[0].equals("help")) {
				System.out.println("Project G - Development version");
				System.out.println("java Project [opt] [args]");
				System.out.println("\tpreview Move Pokémon -> Infos for your move and your Pokémon");
				System.out.println("\tclean -> Deletes the temp files downloaded by online server");
				System.out.println("\thiddenpower hp atk def spatk spdif spe -> Calculates the power and the type of Hidden Power.");
				System.out.println("\tgetiv statistic nature level basestatistic ev -> Calculates the IV from its statistic. (Nature: 0.9|1|1.1).");
				System.out.println("\tgethp iv level basestatistic ev -> Calculates the HP.");
				System.out.println("\tgetstat iv nature level basestatistic ev -> Calculates the statistics. (Nature: 0.9|1|1.1).");
				System.out.println("\tgetdamage level basepower (special)attack (special)defense critical stab effective -> Calculates the damage. (Stab: 1|1.5; Critical: 1|2; Effective: 0|0.25|0.5|1|2|4).");
				System.out.println("\thelp -> shows this help.");
			}
			else if((args[0].equals("preview")) && (args.length == 3))
				p.preview(args[1], args[2]);
			else if(args[0].equals("clean"))
				p.utils.cleanOnline();
			else if((args[0].equals("hiddenpower")) && (args.length == 7)) {
				int[] stats = {Integer.parseInt(args[1]), Integer.parseInt(args[2]), Integer.parseInt(args[3]), Integer.parseInt(args[4]), Integer.parseInt(args[5]), Integer.parseInt(args[6])};
				System.out.println("Power: "+p.utils.getHiddenPower(stats));
				System.out.println("Type: "+p.utils.getHiddenPowerType(stats));
			}
			else if((args[0].equals("getiv")) && (args.length == 6))
				System.out.println("IV: "+p.utils.getIV(Integer.parseInt(args[1]), Double.parseDouble(args[2]), Integer.parseInt(args[3]), Integer.parseInt(args[4]), Integer.parseInt(args[5])));
			else if((args[0].equals("gethp")) && (args.length == 5))
				System.out.println("HP: "+p.utils.getHP(Integer.parseInt(args[1]), Integer.parseInt(args[2]), Integer.parseInt(args[3]), Integer.parseInt(args[4])));
			else if((args[0].equals("getstat")) && (args.length == 6))
				System.out.println("Statistic: "+p.utils.getStat(Integer.parseInt(args[1]), Double.parseDouble(args[2]), Integer.parseInt(args[3]), Integer.parseInt(args[4]), Integer.parseInt(args[5])));
			else if((args[0].equals("getdamage")) && (args.length == 8))
				System.out.println("Damage: "+p.utils.getDamage(Integer.parseInt(args[1]), Integer.parseInt(args[2]), Integer.parseInt(args[3]), Integer.parseInt(args[4]), Integer.parseInt(args[5]), Double.parseDouble(args[6]), Double.parseDouble(args[7]), true)+"~"+p.utils.getDamage(Integer.parseInt(args[1]), Integer.parseInt(args[2]), Integer.parseInt(args[3]), Integer.parseInt(args[4]), Integer.parseInt(args[5]), Double.parseDouble(args[6]), Double.parseDouble(args[7]), false)+"%");
			else
				System.out.println("I don't mean what you want to do with me.");
		}
		catch(Exception e) {
			System.out.println("An error has occurred during the invocation of a method.");
			e.printStackTrace();
		}
	}
}
