package edu.mtc.egr283.project04;

import java.util.Scanner;

import edu.mtc.egr283.sll.SLL;

/**
 * Class for handling activity at the level of the Catalogue.
 * This class has an <code>SLL</code> of
 * <code>Game</code> data and an index list for sorting,
 * methods to access, the two <code>SLL</code>,
 * methods to read and to <code>toString</code>, and a
 * simple bubblesort. method for sorting the list.
 * @author Jacob Vaught
 * @version 1.00 02.25.2021
 * Copyright(c) 2010 Jacob C. Vaught. All rights reserved.
 *
 */

public class GameCatalogue {

	private SLL<Integer> index;
	private SLL<Game> games;

	/**
	 * Constructor.
	 * Initialize the <code>SLL</code> variables.
	 */
	public GameCatalogue() {
		this.games = new SLL<Game>();
		this.index = new SLL<Integer>();
	}// Ending bracket of the constructor

	/**
	 * Adds A Game to The catalogue/catalog
	 * @param Game <code>newGame</code>
	 */
	public void addGame(Game newGame) {
		this.index.addAtHead(games.size());
		this.games.addAtHead(newGame);
	}//ending bracket of addGame

	/**
	 * Method to get an individual <code>Game</code>.
	 * @param indexOfGameToGet subscript of <code>Game</code> to return
	 * @return the <code>Game</code>
	 */
	public Game getGame(int indexOfGameToGet) {
		Game temp;
		temp = this.games.getDataAtPosition(this.index.getDataAtPosition(indexOfGameToGet));
		return temp;
	}// Ending bracket of method getGame

	/**
	 * Method to get the size of the <code>SLL</code> of data.
	 * We are going to call this an accessor, although it is actually
	 * generating derived data. One of its other purposes is to make
	 * sure that the size of the data list and the size of the index
	 * list are the same.
	 * @return the size of the SLL
	 */
	public int getSize() {
		if (this.games.size()!=this.index.size()) {
			System.out.println("ERROR: unequal list sizes " + this.games.size() + ", " + this.index.size());
			System.exit(1);
		}// Ending bracket of if(size)
		return this.games.size();
	}// Ending bracket of method getSize

	/**
	 * Method to find a record in the flat file.
	 * This is a linear search.
	 * @param <code>searchString</code> the name of the game to look up the record of
	 * @return the found <code>Game</code>, or null if not found
	 */
	public Game findGame(String searchString) {
		Game temp = null;
		for(int i = 0; i < this.getSize(); ++i) {
			if(this.games.getDataAtPosition(this.index.getDataAtPosition(i)).compareName(searchString)) {
				temp = this.games.getDataAtPosition(this.index.getDataAtPosition(i));
				break;
			}// Ending bracket of if
		}// Ending bracket of for loop
		return temp;
	}// Ending bracket of method findGame

	/**
	 * Method to read the file from an input <code>Scanner</code> 
	 * This reads the entire file. As we read and store the records,
	 * also store the subscripts in the index.
	 * @param inFile the <code>Scanner</code> from which to read
	 */
	public void readFile(Scanner inFile) {
		int subscript = this.games.size();
		Game temp = null;
		while(inFile.hasNext()) {
			temp = new Game();
			temp.readGame(inFile);
			this.games.addAtHead(temp);
			this.index.addAtHead(Integer.valueOf(subscript));
			++subscript;
		}// Ending bracket of while(inFile)
	}// Ending bracket of method readFile

	/**
	 * Removes A Game from The catalogue/catalog
	 * @param String <code>gameName</code>
	 */
	public void removeGame(String gameName) {
		for(int i = 0; i < this.getSize(); ++i) {
			if(this.games.getDataAtPosition(this.index.getDataAtPosition(i)).compareName(gameName)) {
				this.games.remove(index.getDataAtPosition(i));
				//int temp = index.getDataAtPosition(i);
				this.index.remove(i);
				this.reWriteIndex();
				//this.shiftIndex(temp);
				break;
			}// Ending bracket of if
		}// Ending bracket of for loop
	}//ending bracket of addGame

	/**
	 * Method to sort a file.
	 * This is, embarrassingly enough, simply a bubblesort.,
	 * but it works and is useful for demonstration purposes.
	 * Note the we sort keys and the adjust the index but do not
	 * actually move records around in the list.
	 */
	public void sortCatalogue() {
		int tempIndex; 
		for(int length = this.getSize(); length > 1; --length) {
			for(int i = 0; i < length - 1; ++i) {
				if(this.games.getDataAtPosition(this.index.getDataAtPosition(i)).compareTo(this.games.getDataAtPosition(this.index.getDataAtPosition(i+1))) > 0) {
					tempIndex = this.index.getDataAtPosition(i);
					this.index.setData( this.index.getDataAtPosition(i+1), i);
					this.index.setData(tempIndex, (i+1));
				}// Ending bracket of if
			}// Ending bracket of INNER for loop
		}// Ending bracket of OUTER for loop
	}// Ending bracket of method sortFile

	//NOT USED
//	/**
//	 * Shifts all data in SLL index to match games SLL
//	 * USED ONLY in removeGame
//	 * @param int <code>indexOfDataRemoved</code>
//	 */
//	private void shiftIndex(int removedDataIndex) {
//
//		for(int i = 0; i < index.size(); ++i) {
//			if(this.index.getDataAtPosition(i) > removedDataIndex) {
//				this.index.setData(this.index.getDataAtPosition(i) - 1, i);
//			}// Ending bracket of if
//		}// End of for loop
//	}// Ending bracket of method shiftIndexData

	/**
	 * Recreates whole index SLL, USED ONLY in removeGame
	 */
	private void reWriteIndex() {
		this.index= new SLL<Integer>();
		for(int i = games.size()-1; i >= 0; --i) {
			index.addAtHead(i);
		}// End of for loop
	}// Ending bracket of method shiftIndexData


	/**
	 * Usual <code>toString</code> method.
	 * ©return the <code>String</code> value of the file.
	 */
	public String toString() {
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < this.getSize(); ++i) {
			if(this.games.getDataAtPosition(this.index.getDataAtPosition(i))!=null) {
				sb.append(this.games.getDataAtPosition(this.index.getDataAtPosition(i)).toString()+"\n");
			}
		}// Ending bracket of for loop
		return sb.toString();
	}// Ending bracket of method toString

}//ending bracket of class GameCatalogue