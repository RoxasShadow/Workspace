import java.util.Scanner; // Importo lo Scanner
public class ChiSei{
	public static void main(String[] args){
		Scanner lettore = new Scanner(System.in); // Creo un oggetto Scanner
		System.out.println("Chi sei?");
		String nome = lettore.next(); // Prelevo il nome
		System.out.println("Ciao "+nome+"!");
	}
}
