package poke.view;

import poke.controller.Controller;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.SpringLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

import java.awt.Color;
import java.awt.GridLayout;

public class PokePanel extends JPanel
{
	private Controller app;
	
	public PokePanel(Controller app)
	{
		super();
		this.app = app;
		
		setupPanel();
		setupListeners();
		setupLayout();
	}
	
	private void setupPanel()
	{
		
	}
	
	private void setupListeners()
	{
		
	}
	
	private void setupLayout()
	{
		
	}
}
