/**
	TempConverter.java
	(C) Giovanni Capuano 2011
*/
import java.util.Scanner;
public class TempConverter {
	public double celsiusToFahrenheit(double celsius) {
		return celsius*1.8+32;
	}
	public double fahrenheitToCelsius(double fahrenheit) {
		return (fahrenheit-32)/1.8;
	}
	public double celsiusToKelvin(double celsius) {
		return celsius-273.15;
	}
	public double kelvinToCelsius(double kelvin) {
		return kelvin+273.15;
	}
	public double celsiusToReaumur(double celsius) {
		return celsius*0.8;
	}
	public double reaumurToCelsius(double reaumur) {
		return reaumur*1.25;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		TempConverter converter = new TempConverter();
		int choice = 0;
		double val, result = 0.0;
		System.out.println("TempConverter\n[0]Celsius => Fahrenheit\n[1]Fahrenheit => Celsius\n[2]Celsius => Kelvin\n[3]Kelvin => Celsius\n[4]Celsius => Réaumur\n[5]Réaumur => Celsius\nYour choice: ");
		choice = scanner.nextInt();
		System.out.println("Temperature to convert: ");
		val = scanner.nextDouble();
		switch(choice) {
			case 0:
				result = converter.celsiusToFahrenheit(val);
				break;
			case 1:
				result = converter.fahrenheitToCelsius(val);
				break;
			case 2:
				result = converter.celsiusToKelvin(val);
				break;
			case 3:
				result = converter.kelvinToCelsius(val);
				break;
			case 4:
				result = converter.celsiusToReaumur(val);
				break;
			case 5:
				result = converter.reaumurToCelsius(val);
				break;
			default:
				System.out.println("Invalid choice.\n");
				System.exit(0);
		}
		System.out.println("Result: "+result);
	}
}
				
