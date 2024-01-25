package poke.model.monsters;

import poke.model.types.Normal;
import poke.model.types.Flying;

public class Pidgey extends Pokemon implements Normal, Flying
{
	public Pidgey()
	{
		super(16, "Pidgey");
	}
	
	public Pidgey(String name)
	{
		super(16, name);
	}
	
	public Pidgey(int number, String name)
	{
		super(number, name);
	}
	
	public int kickThemInTheNuts()
	{
		int attack = 20;
		
		return attack;
	}
	
	public int flyAttack()
	{
		int attack = 25;
		
		return attack;
	}
}
