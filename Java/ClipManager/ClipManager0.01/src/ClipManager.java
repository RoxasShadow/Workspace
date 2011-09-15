import java.util.Scanner;
class ClipManager {
	public static void main(String[] args) {
		Text text;
		Writer writer;
		ClipboardManager clipboard = new ClipboardManager();
		clipboard.getForm();
		int id, scelta;
		String string;
		Scanner scanner = new Scanner(System.in);
		writer = new Writer();
		System.out.println("Welcome in ClipManager 0.01 | Contact me, webmaster@giovannicapuano.net");
		
		do {
			System.out.println("\n--------------------------------------------------\n");
			System.out.println("[1]Create a new text");
			System.out.println("[2]Copy a text in the clipboard");
			System.out.println("[3]Clean the clipboard");
			System.out.println("[4]Quit");
			scelta = scanner.nextInt();
		
			switch(scelta) {
				case 1:
					System.out.println("\nId");
					id = scanner.nextInt();
					System.out.println("Text:");
					string = scanner.next();

					text = new Text(string, id);
					writer.newText(text);
					System.out.println("\nThe text has been successfully uploaded.");
					break;
				case 2:
					System.out.println("\nId:");
					id = scanner.nextInt();
					
					clipboard.toClipboard(writer.getText(id));
					System.out.println("\""+writer.getText(id)+"\" has been copied in the clipboard.\nType \"Ctrl\" + \"V\" for paste.");
					break;			
				case 3:
					writer.cleanText();
					break;
				case 4:
					System.out.println("\nSee you soon :)");
					System.exit(0);
				default:
					System.out.println("Type a number from 1 to 4 on the action you want to play.\n");
			}
		} while(scelta != 4);
	}
}
