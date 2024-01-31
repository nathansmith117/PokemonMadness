package poke.controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import poke.model.monsters.Pokemon;

public class IOController
{
	public static ArrayList<Pokemon> loadData(String dataFile, Controller app)
	{
		ArrayList<Pokemon> savedPokeList = null;
		
		return savedPokeList;
	}
	
	public static void saveData(String dataFile, ArrayList<Pokemon> pokemonList, Controller app)
	{
		try (FileOutputStream saveStream = new FileOutputStream(dataFile);
				ObjectOutputStream output = new ObjectOutputStream(saveStream))
		{
			output.writeObject(pokemonList);
		}
		catch (IOException saveError)
		{
			JOptionPane.showMessageDialog(app.getWindow(), saveError.getMessage(), "OH SMURF! Coudn't save this mf", JOptionPane.ERROR_MESSAGE);
		}
	}
}
