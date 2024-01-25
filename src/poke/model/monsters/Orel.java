package poke.model.monsters;

import poke.model.types.Normal;
import poke.model.types.Holy;

public class Orel extends Pokemon implements Normal, Holy
{
	public Orel()
	{
		super(3, "Orel");
	}
	
	public Orel(String name)
	{
		super(3, name);
	}
	
	public Orel(int number, String name)
	{
		super(number, name);
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
