import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

/* TODO: lol => o => *o* */
public class Impiccato {
	private int life;
   	private String[] db;
   	
   	public Impiccato() {
   		db = loadDb("db.txt");
   		life = 3;
   	}
   	
   	public void start() {
		String phrase = db[(int)(Math.random()*db.length)];
		for(int i=0, count=phrase.length(); i<count; ++i)
			System.out.print("*");
		System.out.print("\n");
		ArrayList<String> foundChars = new ArrayList<String>(); // char is primitive and not supported :(
   		boolean end = false;
   		Scanner scanner = new Scanner(System.in);
   		while(!end) {
   			char in = scanner.next().charAt(0);
   			int found = Impiccato.countOccurrences(phrase, in);
   			if(found == 0) {
   				--life;
   				System.out.println("Fail.");
   				if(life == 0) {
   					System.out.println("Game over.");
   					end = true;
   				}
   				else
   					System.out.println(life+" lifes remain.");
   			}
   			else {
   				System.out.println("You have found a char.");
   				foundChars.add(new String(new char[] {in}));
   				if(foundChars.size() == Impiccato.removeDuplicates(phrase).length()) {
   					System.out.println("You win! => "+phrase);
   					end = true;
   				}
   			}	
   		}
   	}
   	
	private static int countOccurrences(String str, char find) {
		int count = 0;
		for(int i=0, len=str.length(); i<len; ++i)
		if(str.charAt(i) == find)
			++count;
		return count;
	}
   	
	private static String removeDuplicates(String str) {
		StringBuilder clean = new StringBuilder();
		for(int i=0, count=str.length(); i<count; ++i) {
			String si = str.substring(i, i+1);
			if(clean.indexOf(si) == -1)
				clean.append(si);
		}
		return clean.toString();
	}
   	
      	private String[] loadDb(String path) {
   		ArrayList<String> db = new ArrayList<String>();
   		try {
   			BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(path))));
   			String line;
   			while((line = reader.readLine()) != null)
   				db.add(line);
   		}
   		catch(IOException e) {
   			System.out.println("Error reading the db.");
   		}
   		return db.toArray(new String[db.size()]);
   	}
   	
   	public static void main(String[] args) {
   		new Impiccato().start();
   	}
}
