package poke.model.monsters;

import poke.model.types.Normal;

public class Meowth extends Pokemon implements Normal
{
	public Meowth()
	{
		super(52, "Meowth");
		setup(100, false);
	}
	
	public Meowth(String name)
	{
		super(52, name);
		setup(100, false);
	}
	
	public Meowth(int number, String name)
	{
		super(number, name);
		setup(100, false);
	}
	
	public int kickThemInTheNuts()
	{
		int attack = 20;
		
		return attack;
	}
}
