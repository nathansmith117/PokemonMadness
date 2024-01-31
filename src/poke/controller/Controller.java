package poke.controller;

import poke.model.*;
import poke.model.monsters.Meowth;
import poke.model.monsters.Orel;
import poke.model.monsters.Pidgeotto;
import poke.model.monsters.Pidgey;
import poke.model.monsters.Pokemon;
import poke.model.monsters.Vulpix;
import poke.model.monsters.Xavier;
import poke.view.PokeFrame;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class Controller
{
	private ArrayList<Pokemon> pokedex;
	private String dataFile;
	private PokeFrame window;
	
	public Controller()
	{
		this.pokedex = new ArrayList<Pokemon>();
		this.dataFile = "";
		
		createPokedex();
		
		this.window = new PokeFrame(this);
	}
	
	public void start()
	{
		
	}
	
	private void createPokedex()
	{
		pokedex.add(new Meowth());
		pokedex.add(new Orel());
		pokedex.add(new Vulpix());
		pokedex.add(new Pidgey());
		pokedex.add(new Pidgeotto());
		pokedex.add(new Xavier());
		pokedex.add(new Meowth("cat cat"));
		pokedex.add(new Xavier(101, "Worse thing you can imagine"));
		pokedex.add(new Pidgey("Flying rat"));
		pokedex.add(new Pidgeotto("Flying dog sized rat"));
	}
	
	public void updateCurrentPokemon(String name, int index, int health, boolean canEvolve)
	{
		Pokemon current = pokedex.get(index);
		current.setName(name);
		current.setHealth(health);
		current.setCanEvolve(canEvolve);
	}
	
	public boolean validateNumber(String text)
	{
		boolean isValid = false;
		
		try
		{
			Integer.parseInt(text);
			isValid = true;
		}
		catch (NumberFormatException error)
		{
			JOptionPane.showMessageDialog(window, "Use a valid number");
		}
		
		return isValid;
	}
	
	public String[] buildPokedexText()
	{
		String[] pokemonNames = new String[pokedex.size()];
		
		for (int index = 0; index < pokemonNames.length; index++)
		{
			pokemonNames[index] = index + ": " + pokedex.get(index).getClass().getSimpleName();
		}
		
		return pokemonNames;
	}
	
	public String[] getPokemonData(int index)
	{
		String[] currentPokemonInfo = new String[5];
		
		Pokemon currentPokemon = pokedex.get(index);
		
		currentPokemonInfo[0] = currentPokemon.getName();
		currentPokemonInfo[1] = currentPokemon.isCanEvolve() + "";
		currentPokemonInfo[2] = currentPokemon.getHealth() + "";
		currentPokemonInfo[3] = currentPokemon.getPokedexNumber() + "";
		
		String types = "";
		
		for (String type : currentPokemon.getTypes())
		{
			types += type + "\n";
		}
		
		currentPokemonInfo[4] = types;
		
		return currentPokemonInfo;
	}
	
	public PokeFrame getWindow()
	{
		return window;
	}
}
