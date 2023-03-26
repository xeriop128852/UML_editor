package view;

import javax.swing.JToolBar;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ToolBar extends JToolBar{

	private Canvas canvas;
	JButton button = null;
	
	public ToolBar() {
		canvas = Canvas.getInstance();

		String button[] = {"Select", "AssociationLine", "GeneralizationLine", "CompositionLine", "Class", "UseCase"};
		String action[] = {""};
		int btn_num = button.length;
		this.setLayout(new GridLayout(btn_num, 1));
		
		for(int i = 0; i < btn_num; i++) {
			addButton(button[i], "");
		}
		
		
	}

	protected void addButton(String name, String action) {
		String imageURL = "img/" + name + ".png";
		
		JButton button = new JButton();
		button.setIcon(new ImageIcon(imageURL));
		button.setActionCommand(action);
		button.setToolTipText(name);
		button.setFocusPainted(false);
		button.setBackground(Color.BLACK);
		button.setForeground(Color.LIGHT_GRAY);
		//button.setBorderPainted(false);
		//button.addActionListener(this);
		
		if (imageURL != null) { button.setIcon(new ImageIcon(imageURL));
		} else { System.err.println("Resource not found: " + imageURL); }
		
		add(button);
	}
	
	protected void ActionListener(ActionEvent e) {
		button = (JButton) e.getSource();
		button.setBackground(Color.BLACK);
		button.setForeground(Color.LIGHT_GRAY);

		//canvas.setCurrentMode(mode);
		//canvas.reloadCurrentMode();
		//canvas.reset();
		//canvas.repaint();
	}
}


