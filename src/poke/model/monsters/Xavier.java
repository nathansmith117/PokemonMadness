package poke.model.monsters;

import poke.model.types.UnHoly;

public class Xavier extends Pokemon implements UnHoly
{
	public Xavier()
	{
		super(666, "Xavier");
		setup(250, false);
	}
	
	public Xavier(String name)
	{
		super(666, name);
		setup(250, false);
	}
	
	public Xavier(int number, String name)
	{
		super(number, name);
		setup(250, false);
	}
	
	public int killThemWithKindness()
	{
		int attack = 50;
		
		return attack;
	}
}
