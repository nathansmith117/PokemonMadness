package poke.model.monsters;

import poke.model.types.Normal;
import poke.model.types.Holy;

public class Orel extends Pokemon implements Normal, Holy
{
	public Orel()
	{
		super(3, "Orel");
		setup(300, false);
	}
	
	public Orel(String name)
	{
		super(3, name);
		setup(300, false);
	}
	
	public Orel(int number, String name)
	{
		super(number, name);
		setup(300, false);
	}
	
	public int kickThemInTheNuts()
	{
		int attack = 40;
		
		return attack;
	}
	
	public void getBlessingFromGod(int loyaltyToGod)
	{
		this.setHealth(this.getHealth() + 25);
	}
}
