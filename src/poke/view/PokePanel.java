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
import javax.swing.DefaultComboBoxModel;

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
	private JButton updateButton;
	private JButton saveButton;
	
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
		this.updateButton = new JButton("Update");
		this.saveButton = new JButton("Save");
		
		setupDropDown();
		setupPanel();
		setupListeners();
		setupLayout();
		
		// Fix annoying little thingy.
		updatePokemonScreen();
	}
	
	private void updateDisplay(String name)
	{
		String path = "/poke/view/images/";
		String defaultName = "Error";
		String extension = ".png";
		
		try
		{
			pokemonImage = new ImageIcon(getClass().getResource(path + name + extension));
		}
		catch (NullPointerException error)
		{
			pokemonImage = new ImageIcon(getClass().getResource(path + defaultName + extension));
		}
		
		imageLabel.setIcon(pokemonImage);
		repaint();
	}
	
	private void collectInput()
	{
		String name = nameField.getText();
		String health = healthField.getText();
		boolean evolve = evolveBox.isSelected();
		int selectedPokemonIndex = pokedexSelector.getSelectedIndex();
		
		if (app.validateNumber(health))
		{
			int healthValue = Integer.parseInt(health);
			
			app.updateCurrentPokemon(name, selectedPokemonIndex, healthValue, evolve);
		}
	}
	
	private void setupDropDown()
	{
		String [] pokeData = app.buildPokedexText();
		DefaultComboBoxModel<String> pokeModel = new DefaultComboBoxModel<String>(pokeData);
		pokedexSelector.setModel(pokeModel);
	}
	
	private void updateFields(int index)
	{
		String[] data = app.getPokemonData(index);
		
		nameField.setText(data[0]);
		boolean evolve = Boolean.parseBoolean(data[1]);
		evolveBox.setSelected(evolve);
		healthField.setText(data[2]);
		numberField.setText(data[3]);
		typesArea.setText(data[4]);
	}
	
	private void updatePokemonScreen()
	{
		String name = pokedexSelector.getSelectedItem().toString();
		int nameStart = name.indexOf(": ") + 2;
		name = name.substring(nameStart);
		
		imageLabel.setText("This is: " + name);
		updateDisplay(name);
		updateFields(pokedexSelector.getSelectedIndex());
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
		imageLabel.setVerticalTextPosition(JLabel.BOTTOM);
		imageLabel.setHorizontalTextPosition(JLabel.CENTER);
		
		//fieldPanel work
		fieldPanel.add(healthField);
		fieldPanel.add(nameField);
		fieldPanel.add(numberField);
		fieldPanel.add(evolveBox);
		fieldPanel.add(typesPane);
		fieldPanel.add(updateButton);
		fieldPanel.add(saveButton);
		
		// PokePanel stuff
		this.add(fieldPanel);
		this.add(imageLabel);
		this.add(pokedexSelector);
		
		updateDisplay("");
	}
	
	private void setupListeners()
	{
		updateButton.addActionListener(click -> collectInput());
		pokedexSelector.addActionListener(select -> updatePokemonScreen());
		saveButton.addActionListener(click -> app.save());
	}
	
	private void setupLayout()
	{
		layout.putConstraint(SpringLayout.WEST, fieldPanel, -250, SpringLayout.EAST, this);
		layout.putConstraint(SpringLayout.EAST, fieldPanel, -25, SpringLayout.EAST, this);
		layout.putConstraint(SpringLayout.NORTH, fieldPanel, 25, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.SOUTH, fieldPanel, -25, SpringLayout.SOUTH, this);
		
		layout.putConstraint(SpringLayout.NORTH, imageLabel, 150, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, imageLabel, 250, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.EAST, imageLabel, -50, SpringLayout.WEST, fieldPanel);
		
		layout.putConstraint(SpringLayout.WEST, pokedexSelector, 150, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.EAST, pokedexSelector, -150, SpringLayout.WEST, fieldPanel);
		layout.putConstraint(SpringLayout.SOUTH, pokedexSelector, -150, SpringLayout.SOUTH, this);
	}
}
