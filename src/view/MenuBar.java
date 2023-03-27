package view;

import javax.swing.JMenuBar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class MenuBar extends JMenuBar {
	private Canvas canvas;
	private JMenuBar menubar;
	
	public MenuBar() {
		canvas = Canvas.getInstance();
		
		JMenu menu;
		JMenuItem mi;
		
		menu = new JMenu("File");
		add(menu);

		menu = new JMenu("Edit");
		add(menu);
		
		
		mi = new JMenuItem("Group");
		menu.add(mi);
		mi.addActionListener(new GroupObjectListener());
		
		
		mi = new JMenuItem("Ungroup");
		mi.setEnabled(false);
		menu.add(mi);
		mi.addActionListener(new ChangeNameListener());
		
		
		mi = new JMenuItem("Change object name");
		menu.add(mi);
		mi.addActionListener(new ChangeNameListener());
	}
	
		class UngroupObjectListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				//canvas.removeGroup();
			}
		}
		
		class GroupObjectListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				//canvas.addGroup();
				//canvas.GroupShape();
			}
		}
		
		class ChangeNameListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				String inputValue = JOptionPane.showInputDialog(new JFrame(), "Please input a value", "Change object name", 
						JOptionPane.OK_CANCEL_OPTION); 
				canvas.changeObjName(inputValue);
			}
		}
}
