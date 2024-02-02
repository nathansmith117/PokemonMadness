package poke.tests;

/**
 * Project imports
 */
import poke.model.*;
import javax.swing.ImageIcon;
import java.awt.image.BufferedImage;
import java.io.File;
/**
 * Reflection imports
 */
import java.lang.reflect.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;

/**
 * Testing imports
 */

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ImageTest
{
	private ArrayList <String> classNames;
	private ArrayList <String> imageNames;
	private File modelDirectory;
	private File imagesDirectory;
	@BeforeEach
	void setUp() throws Exception
	{
		this.modelDirectory = new File ("src/poke/model/monsters");
		this.imagesDirectory = new File ("src/poke/view/images");
		this.classNames = new ArrayList<String>();
		this.imageNames = new ArrayList<String>();
		
	}

	@AfterEach
	void tearDown() throws Exception
	{
		classNames = null;
		imageNames = null;
		imagesDirectory = null;
		modelDirectory = null;
	}
	
	@Test
	void testStructure()
	{
		assertTrue(modelDirectory.exists(), "You really need a poke.model.monsters package!");
		assertTrue(imagesDirectory.exists(), "You really need a poke.view.images folder!");
		assertTrue(modelDirectory.isDirectory(), "Needs to be a folder!");
		assertTrue(imagesDirectory.isDirectory(), "Needs to be a folder!");
		File [] modelContents = modelDirectory.listFiles();
		
		for (File current : modelContents)
		{
			String name = current.getName();
			int extension = name.indexOf(".java");
			name = name.substring(0, extension);
			classNames.add(name);
		}
		
		File [] imageContents = imagesDirectory.listFiles();
		for (File current : imageContents)
		{
			String name = current.getName();
			int extension = name.indexOf(".png");
			if (!name.equals(".DS_Store"))
			{
				name = name.substring(0, extension);
				imageNames.add(name);	
			}
			
		}
		
		int matchCount = 0;
		for (String name : classNames)
		{
			if (imageNames.indexOf(name) > -1)
			{
				matchCount++;
			}
		}
		assertTrue(matchCount > 5, "At least 6 pokemon names should match image names");
		assertTrue(modelContents.length > 6, "You need to have at least 7 files in your poke.model.monsters package");
		assertTrue(imageContents.length > 5, "You need to have at least 6 files in your poke.view.images package");
		
	}

	@Test
	void testAllImages()
	{
		File [] imageContents = imagesDirectory.listFiles();
		int pictureCount = 0;
		for (File currentImageFile : imageContents)
		{
			if (!currentImageFile.getName().equals(".DS_Store"))
			{
				int hasExtension = currentImageFile.getAbsolutePath().lastIndexOf(".png");
				assertTrue(hasExtension > 0, "All image files need to have a .png extension!");
				if (hasExtension >= 3)
				{
					pictureCount++;
				}	
			}
			
		}
		
		assertTrue(pictureCount > 5, "You need at least six pictures of pokemon!");
	}

}
