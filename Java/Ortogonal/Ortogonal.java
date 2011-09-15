import javax.swing.JFrame;

public class Ortogonal extends JFrame {
	public Ortogonal() {
		super("Ortogonal");
		this.setSize(600, 600);
		getContentPane().add(new Canvas());
	}
	
	public static void main(String[] args) {
		new Ortogonal().show();
	}
}
