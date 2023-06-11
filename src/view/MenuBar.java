package view;

import javax.swing.JMenuBar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import shape.Group;
import shape.Shape;

@SuppressWarnings("serial")
public class MenuBar extends JMenuBar {
	private Canvas canvas;
	JMenu menu;
	JMenuItem mi, mntmUngroup;
	
	public MenuBar() {
		canvas = Canvas.getInstance();
		
		
		
		menu = new JMenu("File");
		add(menu);

		menu = new JMenu("Edit");
		add(menu);
		
		
		mi = new JMenuItem("Group");
		menu.add(mi);
		mi.addActionListener(new GroupObjectListener());
		
		
		mntmUngroup = new JMenuItem("Ungroup");
		mntmUngroup.setEnabled(false);
		menu.add(mntmUngroup);
		mntmUngroup.addActionListener(new UngroupObjectListener());
		
		
		mi = new JMenuItem("Change object name");
		menu.add(mi);
		mi.addActionListener(new ChangeNameListener());
	}
	
		
		
		class GroupObjectListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				List<Shape> shapesInGroup = canvas.getshapesInGroup();
				if(shapesInGroup.size() < 2){
					JOptionPane.showMessageDialog(new JFrame(),"Please select two or more object for grouping.","Warning",JOptionPane.WARNING_MESSAGE);
				}
				else{
					canvas.Group(shapesInGroup);
//					canvas.Group();
					mntmUngroup.setEnabled(true);
				}
				canvas.reset();
			}
		}
		
		class UngroupObjectListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				if(!(canvas.getSelectedObj() instanceof Group)){
					JOptionPane.showMessageDialog(new JFrame(),"Please select group.","Error",JOptionPane.ERROR_MESSAGE); 
				}
				else{
					canvas.UnGroup(canvas.getSelectedObj());
				}
				List<Shape> shapesInGroup = canvas.getshapesInGroup();
				if(shapesInGroup.size() == 0)
					mntmUngroup.setEnabled(false);
				canvas.reset();
			}
		}
		
		class ChangeNameListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				String inputValue = JOptionPane.showInputDialog(new JFrame(), "Please input object name", "Change Object Name", 
						JOptionPane.OK_CANCEL_OPTION); 
				canvas.changeObjName(inputValue);
				canvas.reset();
			}
		}
}
