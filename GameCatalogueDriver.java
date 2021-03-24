package edu.mtc.egr283.project04;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Main class for reading and printing Game Catalogue/Catalog.
 * Copyright(c) 2021 Jacob C. Vaught. All rights reserved.
 *
 * Do note that when printing a file onto the screen all underscores
 * are replaced with a space, and when setting the game Name, all spaces
 * are replaced with underscores.
 * 
 * @author JackVan20010312
 * @version 1.00 2021-02-25
 * @Due  03/03/2021
 * @Professor William Sims
 */
public class GameCatalogueDriver {

	final static String PRINT_BEFORE_USING_TOsTRING = "   Age   |# Players|Avg. Time|NAME OF THE \n"
													+ "Min |Max |Min |Max |Min |Max |GAME! (v0.1) ";

	public static void main(String[] args) {
		//not a test, just a variable for later.
		int[] testArray = {1,2,3,4,50,60};
		String testName = "Totally Fake Game";		
		Game testGame=new Game(testArray, testName.replace(" ", "_"));

		Scanner inFile= null;
		PrintWriter outFile = null;
		try {
			String inFileName="inputfile.txt";
			inFile = new Scanner(new File(inFileName));
			String outFileName= "outputfile.txt";
			outFile = new PrintWriter(new File(outFileName));
		} catch(FileNotFoundException fnfe) {
			System.out.println("ERROR opening file ");
			System.out.println(fnfe.getMessage());
			System.out.println("in" + System.getProperty("user.dir"));
			System.exit(1);
		}// Ending bracket of try-catch block

		//Constructor test
		GameCatalogue gameCatalog=new GameCatalogue();
	
		System.out.println("Added game"+testName);
		//Addgame method test
		gameCatalog.addGame(testGame);

		//getgame method test(position 0)
		System.out.println("\n\nGet game at position 0");
		System.out.println(PRINT_BEFORE_USING_TOsTRING);
		System.out.println(gameCatalog.getGame(0).toString().replace("_", " "));

		//getsize of SLL method test
		System.out.println("\n\nSingle Link List(SLL) Size is: " +gameCatalog.getSize());

		System.out.println("find game with name: "+testName);
		//findgame method test
		System.out.println(gameCatalog.findGame(testName.replace(" ", "_")).toString().replace("_", " "));

		System.out.println("\n\nRead File");
		//readfile method test
		gameCatalog.readFile(inFile);
		System.out.println(PRINT_BEFORE_USING_TOsTRING);
		System.out.println(gameCatalog.toString().replace("_", " "));

		
		System.out.println("\nRemove game with name: "+testName);
		//removegame method test
		gameCatalog.removeGame(testName.replace(" ", "_"));
		System.out.println(PRINT_BEFORE_USING_TOsTRING);
		System.out.println(gameCatalog.toString().replace("_", " "));

		
		//sortcatalogue method test
		gameCatalog.sortCatalogue();
		System.out.println("\nSorted Catalog/Catalogue");
		System.out.println(PRINT_BEFORE_USING_TOsTRING);
		System.out.println(gameCatalog.toString().replace("_", " "));

		System.out.println("Writing to output File");
		//this IS NOT required, just wanted to look at my output.
		outFile.printf(gameCatalog.toString());
		outFile.close();


	}//ending bracket of main method
}//ending bracket of Class gameCatalogueDriver