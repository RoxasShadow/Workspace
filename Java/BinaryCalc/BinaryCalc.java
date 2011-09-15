import java.util.Scanner;
import java.util.InputMismatchException;

public class BinaryCalc {
	public static void main(String[] args) {
		Binary bin = new Binary();
		Scanner input = new Scanner(System.in);
		System.out.println("What you want to do?\n[0] Decimal => Binary\n[1] Binary => Decimal");
		try {
			switch(input.nextInt()) {
				case 0:
					System.out.println("Wich decimal you want to converts in binary?");
					int decimal = input.nextInt();
					System.out.println(decimal+" in binary = 0b"+bin.decimalToBinary(decimal));
					break;
				case 1:
					System.out.println("Wich binary you want to converts in decimal?");
					String binary = input.next();
					System.out.println(binary+" in decimal = 0d"+bin.binaryToDecimal(binary));
			}
		}
		catch(NumberFormatException e) { // An algebric error.
			System.out.println("An error was occurred during the conversion.");
		}
		catch(InputMismatchException e) { // Requested an Integer by Scanner but given a String.
			System.out.println("Integer number required.");
		}
	}
}
