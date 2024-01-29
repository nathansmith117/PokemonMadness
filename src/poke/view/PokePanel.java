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
	
	private SpringLayout layout;
	
	private JPanel fieldPanel;
	private JTextField nameField;
	private JTextField healthField;
	private JTextField numberField;
	private JTextArea typesArea;
	private JCheckBox evolveBox;
	private JScrollPane typesPane;
	
	private JLabel imageLabel;
	private ImageIcon pokemonImage;
	private JComboBox<String> pokedexSelector;
	
	public PokePanel(Controller app)
	{
		super();
		this.app = app;
		
		this.layout = new SpringLayout();
		
		this.fieldPanel = new JPanel(new GridLayout(0, 1));
		
		this.healthField = new JTextField("Health");
		this.nameField = new JTextField("Name");
		this.numberField = new JTextField("Number");
		
		this.evolveBox = new JCheckBox("Pokemon can evolve?", false);
		
		this.typesArea = new JTextArea(20, 20);
		this.typesPane = new JScrollPane();
		
		this.imageLabel = new JLabel("image");
		this.pokemonImage = new ImageIcon();
		this.pokedexSelector = new JComboBox<String>();
		
		
		setupPanel();
		setupListeners();
		setupLayout();
	}
	
	private void setupPanel()
	{
		setBackground(Color.GREEN);
		setLayout(layout);
		
		//component settings
		numberField.setEnabled(false);
		typesArea.setEnabled(false);
		typesPane.setViewportView(typesArea);
		typesPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		typesPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		//fieldPanel work
		fieldPanel.add(healthField);
		fieldPanel.add(nameField);
		fieldPanel.add(numberField);
		fieldPanel.add(evolveBox);
		fieldPanel.add(typesPane);
		
		// PokePanel stuff
		this.add(fieldPanel);
		this.add(imageLabel);
		this.add(pokedexSelector);
	}
	
	private void setupListeners()
	{
		
	}
	
	private void setupLayout()
	{
		layout.putConstraint(SpringLayout.WEST, fieldPanel, -250, SpringLayout.EAST, this);
		layout.putConstraint(SpringLayout.EAST, fieldPanel, -25, SpringLayout.EAST, this);
		layout.putConstraint(SpringLayout.NORTH, fieldPanel, 25, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.SOUTH, fieldPanel, -25, SpringLayout.SOUTH, this);
		
		layout.putConstraint(SpringLayout.NORTH, imageLabel, 150, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, imageLabel, 150, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.EAST, imageLabel, -100, SpringLayout.WEST, fieldPanel);
		
		layout.putConstraint(SpringLayout.WEST, pokedexSelector, 150, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.EAST, pokedexSelector, -150, SpringLayout.WEST, fieldPanel);
		layout.putConstraint(SpringLayout.SOUTH, pokedexSelector, -150, SpringLayout.SOUTH, this);
	}
}
