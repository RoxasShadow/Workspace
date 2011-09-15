import java.awt.datatransfer.*;
import java.awt.*;
class ClipboardManager implements ClipboardOwner {
	public void toClipboard(String text) {
		SecurityManager sm = System.getSecurityManager();
		if (sm != null) {
			try {
				sm.checkSystemClipboardAccess();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		Toolkit tk = Toolkit.getDefaultToolkit();
		StringSelection st = new StringSelection(text);
		Clipboard cp = tk.getSystemClipboard();
		cp.setContents(st, this);
	}

	public void lostOwnership(Clipboard clip, Transferable tr) { 
	       // Gli appunti sono stati sovrascritti da un programma esterno
	}
}
