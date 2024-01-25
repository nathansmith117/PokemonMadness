package poke.model.monsters;

public class Pidgeotto extends Pidgey
{
	public Pidgeotto()
	{
		super(17, "Pidgeotto");
	}
	
	public Pidgeotto(String name)
	{
		super(17, name);
	}
	
	public Pidgeotto(int number, String name)
	{
		super(number, name);
	}
	
	@Override
	public int flyAttack()
	{
		int attack = super.flyAttack() + 15;
		
		return attack;
	}
}
