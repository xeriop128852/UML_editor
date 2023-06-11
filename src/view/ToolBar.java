package view;

import javax.swing.JToolBar;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import mode.Mode;
import mode.createLineMode;
import mode.createObjMode;
import mode.selectMode;

@SuppressWarnings("serial")
public class ToolBar extends JToolBar{

	private Canvas canvas;
	Button button = null;
	Mode mode ;
	
	public ToolBar() {
		canvas = Canvas.getInstance();

		String buttonName[] = {"Select", "AssociationLine", "GeneralizationLine", "CompositionLine", "Class", "UseCase"};
		Mode mode[] = {new selectMode(), new createLineMode("association"), new createLineMode("generalization"),  new createLineMode("composition"),
						new createObjMode("class"), new createObjMode("usecase")};
		this.setFloatable( false );
		int btn_num = buttonName.length;
		this.setLayout(new GridLayout(btn_num, 1));
		
		for(int i = 0; i < btn_num; i++) {
			Button button = new Button(buttonName[i], mode[i]);
			add(button);
		}
		
	}

	
	private class Button extends JButton {
		protected Mode mode;
		
		public Button(String name, Mode mode) {
			String imageURL = "img/" + name + ".png";

			setIcon(new ImageIcon(imageURL));
			setToolTipText(name);
			setFocusPainted(false);
			setBackground(Color.LIGHT_GRAY);
			setBorderPainted(false);
			this.mode = mode;
			addActionListener(new Listener());
			
		}
		
		class Listener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				if(button != null)
					button.setBackground(Color.LIGHT_GRAY);
				button = (Button) e.getSource();
				button.setBackground(Color.black);
				canvas.setCurrentMode(mode);
				canvas.resetCurrentMode();
				canvas.reset();
				canvas.repaint();
			}
		}
	}
}


