package poke.model.monsters;

import poke.model.types.Normal;

public class Meowth extends Pokemon implements Normal
{
	public Meowth()
	{
		super(52, "Meowth");
	}
	
	public Meowth(String name)
	{
		super(52, name);
	}
	
	public Meowth(int number, String name)
	{
		super(number, name);
	}
	
	public int kickThemInTheNuts()
	{
		int attack = 20;
		
		return attack;
	}
}
