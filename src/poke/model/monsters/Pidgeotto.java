package poke.model.monsters;

public class Pidgeotto extends Pidgey
{
	public Pidgeotto()
	{
		super(17, "Pidgeotto");
		setup(130, false);
	}
	
	public Pidgeotto(String name)
	{
		super(17, name);
		setup(130, false);
	}
	
	public Pidgeotto(int number, String name)
	{
		super(number, name);
		setup(130, false);
	}
	
	@Override
	public int flyAttack()
	{
		int attack = super.flyAttack() + 15;
		
		return attack;
	}
}
