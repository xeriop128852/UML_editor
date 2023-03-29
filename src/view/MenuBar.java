package view;

import javax.swing.JMenuBar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import shape.Shape;

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
				List<Shape> shapesInGroup = canvas.getshapesInGroup();
				if(shapesInGroup.size() < 2){
					JOptionPane.showMessageDialog(new JFrame(),"Please select two or more object for grouping.","Warning",JOptionPane.WARNING_MESSAGE);
				}
				else{
					canvas.Group(shapesInGroup);
				}
				canvas.reset();
			}
		}
		
		class ChangeNameListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				String inputValue = JOptionPane.showInputDialog(new JFrame(), "Please input object name", "Change Object Name", 
						JOptionPane.OK_CANCEL_OPTION); 
				canvas.changeObjName(inputValue);
			}
		}
}
