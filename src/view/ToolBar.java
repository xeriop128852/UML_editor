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

import mode.Mode;
import mode.createLineMode;
import mode.createObjMode;
import mode.selectMode;

public class ToolBar extends JToolBar{

	private Canvas canvas;
	JButton button = null;
	Mode mode ;
	
	public ToolBar() {
		canvas = Canvas.getInstance();

		String button[] = {"Select", "AssociationLine", "GeneralizationLine", "CompositionLine", "Class", "UseCase"};
		Mode mode[] = {new selectMode(), new createLineMode("association"), new createLineMode("generalization"),  new createLineMode("composition"),
						new createObjMode("class"), new createObjMode("usecase")};
		this.setFloatable( false );
		int btn_num = button.length;
		this.setLayout(new GridLayout(btn_num, 1));
		
		for(int i = 0; i < btn_num; i++) {
			addButton(button[i], mode[i]);
		}
		
		
	}

	protected void addButton(String name, Mode mode) {
		String imageURL = "img/" + name + ".png";
		
		JButton button = new JButton();
		button.setIcon(new ImageIcon(imageURL));
		button.setToolTipText(name);
		button.setFocusPainted(false);
		button.setBackground(Color.LIGHT_GRAY);
		button.setBorderPainted(false);
		this.mode = mode;
		button.addActionListener(new Listener());
		
		if (imageURL != null) { button.setIcon(new ImageIcon(imageURL));
		} else { System.err.println("Resource not found: " + imageURL); }
		
		add(button);
	}

	
	class Listener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(button != null)
				button.setBackground(Color.LIGHT_GRAY);
			button = (JButton) e.getSource();
			button.setBackground(Color.black);
			canvas.setCurrentMode(mode);
			canvas.resetCurrentMode();
			canvas.reset();
			canvas.repaint();
		}
	}
}


