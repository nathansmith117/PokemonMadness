package poke.model.monsters;

import poke.model.types.Fire;

public class Vulpix extends Pokemon implements Fire
{
	public Vulpix()
	{
		super(37, "Vulpix");
		setup(110, false);
	}
	
	public Vulpix(String name)
	{
		super(37, name);
		setup(110, false);
	}
	
	public Vulpix(int number, String name)
	{
		super(number, name);
		setup(110, false);
	}
	
	public int fartFire()
	{
		int smellySmellyFart = 25;
		
		return smellySmellyFart;
	}
}
