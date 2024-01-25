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
}
