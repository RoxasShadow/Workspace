import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class keysComb extends JFrame {
  
    
  JTextArea ta = new JTextArea("Premi CTRL+TAB");
  
  public keysComb() {
    this.getContentPane().add(ta);
    this.setSize(410, 410);
    this.setVisible(true);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    KeyStroke ctrlTab = KeyStroke.getKeyStroke("ctrl 1" );
    Set set = new HashSet(ta.getFocusTraversalKeys( KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS) );
    set.remove(ctrlTab);
    ta.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, set);
    
    Action writeAction = new AbstractAction() {
      public void actionPerformed(ActionEvent ae) {
        System.out.println(1);
      }
    };

    ta.getInputMap().put(ctrlTab, writeAction);
  }

  public static void main (String[] args) {
    keysComb kc = new keysComb();
  }
}

