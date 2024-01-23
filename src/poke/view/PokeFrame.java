package poke.view;

import poke.controller.Controller;
import javax.swing.JFrame;

public class PokeFrame extends JFrame
{
	private Controller app;
	private PokePanel panel;
	
	public PokeFrame(Controller app)
	{
		super();
		this.app = app;
		this.panel = new PokePanel(this.app);
		
		setupFrame();
	}
	
	private void setupFrame()
	{
		setContentPane(panel);
		
		setSize(1024, 768);
		setTitle("Pokemon Madness");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
	}
}
