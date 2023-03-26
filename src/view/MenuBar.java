package view;

import javax.swing.JMenuBar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

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
		mi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//canvas.group();
			}	
		});
		
		
		mi = new JMenuItem("Ungroup");
		mi.setEnabled(false);
		menu.add(mi);
		mi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//canvas.ungroup();
				//mi.setEnabled(true);
			}	
		});
		
		
		mi = new JMenuItem("Change object name");
		menu.add(mi);
		mi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//canvas.changeObjectName();
			}	
		});
	}
	
}
