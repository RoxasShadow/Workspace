import javax.swing.JFrame;

public class Snake extends JFrame {
	public Snake() {
		super("Snake");
		this.setSize(300, 300);
		this.setFocusable(true);
		getContentPane().add(new Canvas(this));
	}
	
	public static void main(String[] args) {
		new Snake().show();
	}
}
