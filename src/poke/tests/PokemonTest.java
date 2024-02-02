package poke.tests;

/**
 * Project imports
 */
import poke.model.monsters.*;
import java.util.ArrayList;
import java.io.File;
/**
 * Reflection imports
 */
import java.lang.reflect.*;

/**
 * Testing imports
 */
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PokemonTest
{
	private ArrayList<String> pokemonNames;
	private ArrayList<String> typeNames;

	@BeforeEach
	public void setUp() throws Exception
	{
		pokemonNames = new ArrayList<String>();
		typeNames = new ArrayList<String>();

		File folder = new File("src/poke/model/monsters");

		for (File current : folder.listFiles())
		{
			if (current.isFile() && !current.getName().equals("Pokemon.java"))
			{
				String className = current.getName().substring(0, current.getName().lastIndexOf("."));
				pokemonNames.add(className);
			}
		}

		folder = new File("src/poke/model/types");

		for (File current : folder.listFiles())
		{
			if (current.isFile())
			{
				String typeName = current.getName().substring(0, current.getName().lastIndexOf("."));
				typeNames.add(typeName);
			}
		}

	}

	@AfterEach
	public void tearDown() throws Exception
	{
		pokemonNames.clear();
		typeNames.clear();
	}

	@Test
	void testPokemonExist()
	{
		assertTrue(pokemonNames.size() > 5, "You need at least 6 different Pokemon");
		for (String pokemonName : pokemonNames)
		{
			try 
			{
				Class tested = Class.forName("poke.model.monsters." + pokemonName);

				try
				{
					Object temp = tested.newInstance();
					assertTrue(temp instanceof Pokemon);
					
					Constructor [] constructors = tested.getDeclaredConstructors();
					assertTrue(constructors.length == 3, "Each Pokemon needs 3 constructors. " + pokemonName + " does not have this");
				}
				catch (InstantiationException | IllegalAccessException e)
				{
					fail("File " + pokemonName + " does not have a zero parameter constructor!");
				}
			}
			catch(ClassNotFoundException error)
			{
				fail("File " + pokemonName + " is not a Java class");
			}
		}
	}

	@Test
	void testPokemonTypesExist()
	{
		for (String type : typeNames)
		{
			try
			{
				Class tested = Class.forName("poke.model.types." + type);
				assertTrue(tested.isInterface(), type + " should be a Java interface");
				Method [] methods = tested.getDeclaredMethods();
				assertTrue(methods.length > 0, "Each Type needs at least 1 method, " + type + " has only " + methods.length);
			}
			catch(ClassNotFoundException error)
			{
				fail("File " + type + " is not a Java interface");
			}
		}
	}

	@Test
	void testPokemonTypesImplemented()
	{
		boolean hasMultiple = false;
		for (String className : pokemonNames)
		{
			try 
			{
				Class tested = Class.forName("poke.model.monsters." + className);

				Object temp = tested.newInstance();
				if (temp instanceof Pokemon)
				{
					Pokemon castAsPokemon = (Pokemon) temp;
					
					String [] types = castAsPokemon.getTypes();
					assertTrue(types.length > 0, "Each Pokemon must implement at least one type " + className +" does not");
					if (types.length > 1)
					{
						hasMultiple = true;
					}
				}
				
				
			}
			catch(InstantiationException | IllegalAccessException | ClassNotFoundException error)
			{
				fail("File " + className + " is not a Java class");
			}
		}
		assertTrue(hasMultiple, "At least one Pokemon must have more than one type");
	}

}
