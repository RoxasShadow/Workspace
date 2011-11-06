/**
	LoaderObserver.java
	(C) Giovanni Capuano 2011
*/
import java.util.Observable;
import java.util.Observer;
import javax.swing.*;
import java.awt.Container;

public class LoaderObserver extends JFrame implements Observer {
	private JProgressBar loader;
	private JLabel label1;
	private JLabel label2;

	public LoaderObserver() {
		super("Loader - Project G - Development version");
		setVisible(true);
		setFocusable(true);
		setDefaultCloseOperation(0);
		initComponents();
	}

	private void initComponents() {
		JPanel JPanel = new JPanel();
		loader = new JProgressBar();
		label1 = new JLabel();
		label2 = new JLabel();
		loader.setMaximum(60);

		GroupLayout localGroupLayout1 = new GroupLayout(getContentPane());
		GroupLayout localGroupLayout2 = new GroupLayout(JPanel);
		JPanel.setLayout(localGroupLayout2);
		localGroupLayout2.setHorizontalGroup(localGroupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, localGroupLayout2.createSequentialGroup().addContainerGap().addGroup(localGroupLayout2.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(label1, GroupLayout.Alignment.LEADING, -1, 352, 32767).addComponent(label2, GroupLayout.Alignment.LEADING, -1, 352, 32767).addComponent(loader, GroupLayout.Alignment.LEADING, -1, 352, 32767)).addContainerGap()));
		localGroupLayout2.setVerticalGroup(localGroupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(localGroupLayout2.createSequentialGroup().addContainerGap().addComponent(loader, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(label1).addComponent(label2).addContainerGap(-1, 32767)));
		getContentPane().setLayout(localGroupLayout1);
		localGroupLayout1.setHorizontalGroup(localGroupLayout1.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, localGroupLayout1.createSequentialGroup().addContainerGap().addComponent(JPanel, -1, -1, 32767).addContainerGap()));
		localGroupLayout1.setVerticalGroup(localGroupLayout1.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, localGroupLayout1.createSequentialGroup().addContainerGap().addComponent(JPanel, -1, -1, 32767).addContainerGap()));
		pack();
	}

	public void update(Observable observable, Object object) {
		LoaderState LoaderState = (LoaderState)object;
		if(LoaderState.code == 4) {
			label1.setText("Exception: "+LoaderState.msg);
			label2.setText("");
			try {
				Thread.sleep(300);
			}
			catch (Exception e) {}
			super.dispose();
		}
		else if((LoaderState.code == 0) || (LoaderState.code == 5)) {
			label1.setText((String)LoaderState.msg);
			label2.setText("");
		}
		else if(LoaderState.code == 3) {
			label1.setText(LoaderState.msg+" Starting...");
			label2.setText("");
			if(loader.getValue() == loader.getMaximum()) {
				try {
					Thread.sleep(300);
				}
				catch (Exception e) {}
				super.dispose();
			}
		}
		if(LoaderState.module) {
			label1.setText("Loading module `"+LoaderState.msg+"` ("+LoaderState.n+" of "+LoaderState.total+")");
			loader.setValue(loader.getValue() + 10);
		}
		else
			label2.setText("Loading resource `"+LoaderState.msg+"`");
		pack();
	}
}
