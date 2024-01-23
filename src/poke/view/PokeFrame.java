package poke.view;

import poke.controller.Controller;
import javax.swing.JFrame;

public class PokeFrame extends JFrame
{
	private Controller app;
	
	public PokeFrame(Controller app)
	{
		super();
		this.app = app;
		
		setupFrame();
	}
	
	private void setupFrame()
	{
		setSize(1024, 768);
		setTitle("Pokemon Madness");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
	}
}
