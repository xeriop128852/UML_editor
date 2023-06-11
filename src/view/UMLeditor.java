package view;


import java.awt.HeadlessException;
import java.awt.BorderLayout;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class UMLeditor extends JFrame {
	private Canvas canvas;
	private MenuBar menubar;
	private ToolBar toolbar;
	
	public UMLeditor() throws HeadlessException {
		
		canvas = Canvas.getInstance(); 
		menubar = new MenuBar();
		toolbar = new ToolBar();
		
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(menubar, BorderLayout.NORTH);
		getContentPane().add(toolbar, BorderLayout.WEST);
		getContentPane().add(canvas, BorderLayout.CENTER);
	}

	public static void main(String[] args) {
		UMLeditor mainWindow = new UMLeditor();
		mainWindow.setTitle("UML Editor");
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWindow.setSize(1200, 700);
		mainWindow.setLocationRelativeTo(null);
		mainWindow.setVisible(true);
	}

}
