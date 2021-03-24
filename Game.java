package edu.mtc.egr283.project04;

import java.util.Scanner;

/****************************************************************************
 * Class for handling data in a <code>Game</code>.
 * This is the class to handle a single Game.
 * @author Jacob Vaught
 * @version 1.00 2021-02-25
 * Copyright (C) 2021 by Jacob C. Vaught. All rights reserved.
 **/
public class Game {

	private String name;
	private int minAge;
	private int maxAge;
	private int minPlayers;
	private int maxPlayers;
	private int minPlayTime;
	private int maxPlayTime;

	/*******************************************************
	 * Constructor.
	 * We create the record and assign dummy values so as not to
	 * have null values.
	 **/
	public Game() {
		setName("");
		setMinAge(0);
		setMaxAge(0);
		setMinPlayers(0);
		setMaxPlayers(0);
		setMinPlayTime(0);
		setMaxPlayTime(0);
	}//ending bracket of dEFAULT Constructor

	/*******************************************************
	 * Constructor. Used An Array instead of inputting each int individually.
	 * @param newName
	 * @param infoArray, the array that contains all data, should have a length  of 6. 
	 */
	public Game( int[] infoArray, String newName) {
		setName(newName);
		setMinAge(infoArray[0]);
		setMaxAge(infoArray[1]);
		setMinPlayers(infoArray[2]);
		setMaxPlayers(infoArray[3]);
		setMinPlayTime(infoArray[4]);
		setMaxPlayTime(infoArray[5]);
	}//ending bracket of Constructor

	/*******************************************************
	 * Accessor method to get the <code>name</code>.
	 * @return the value of <code>name</code>.
	 **/
	public String getName() {
		return this.name;
	}//ending bracket of method getName

	/*******************************************************
	 * Accessor method to get the <code>minAge</code>.
	 * @return the value of <code>minAge</code>.
	 **/
	public int getMinAge() {
		return this.minAge;		
	}//ending bracket of method getMinAge

	/*******************************************************
	 * Accessor method to get the <code>maxAge</code>.
	 * @return the value of <code>maxAge</code>.
	 **/
	public int getMaxAge() {
		return this.maxAge;	
	}//ending bracket of method getMaxAge

	/*******************************************************
	 * Accessor method to get the <code>minPlayers</code>.
	 * @return the value of <code>minPlayers</code>.
	 **/
	public int getMinPlayers() {
		return this.minPlayers;	
	}//ending bracket of method getMinPlayers

	/*******************************************************
	 * Accessor method to get the <code>maxPlayers</code>.
	 * @return the value of <code>maxPlayers</code>.
	 **/
	public int getMaxPlayers() {
		return this.maxPlayers;	
	}//ending bracket of method getMaxPlayers

	/*******************************************************
	 * Accessor method to get the <code>minPlayTime</code>.
	 * @return the value of <code>minPlayTime</code>.
	 **/
	public int getMinPlayTime() {
		return this.minPlayTime;	
	}//ending bracket of method getMinPlayTime

	/*******************************************************
	 * Accessor method to get the <code>maxPlayTime</code>.
	 * @return the value of <code>maxPlayTime</code>.
	 **/
	public int getMaxPlayTime() {
		return this.maxPlayTime;	
	}//ending bracket of method getMaxPlayTime

	/*******************************************************
	 * Mutator method to set the <code>name</code>.
	 * @param what the value of <code>name</code> to be set.
	 **/
	public void setName(String newName) {
		this.name=newName;
	}//ending bracket of method setName

	/*******************************************************
	 * Mutator method to set the <code>minAge</code>.
	 * @param what the value of <code>minAge</code> to be set.
	 **/
	public void setMinAge(int newMinAge) {
		this.minAge=newMinAge;
	}//ending bracket of method setMinAge

	/*******************************************************
	 * Mutator method to set the <code>maxAge</code>.
	 * @param what the value of <code>maxAge</code> to be set.
	 **/
	public void setMaxAge(int newMaxAge) {
		this.maxAge=newMaxAge;
	}//ending bracket of method setMaxAge

	/*******************************************************
	 * Mutator method to set the <code>minPlayers</code>.
	 * @param what the value of <code>minPlayers</code> to be set.
	 **/
	public void setMinPlayers(int newMinPlayers) {
		this.minPlayers=newMinPlayers;
	}//ending bracket of method setMinPlayers

	/*******************************************************
	 * Mutator method to set the <code>maxPlayers</code>.
	 * @param what the value of <code>maxPlayers</code> to be set.
	 **/
	public void setMaxPlayers(int newMaxPlayers) {
		this.maxPlayers=newMaxPlayers;
	}//ending bracket of method setMaxPlayers

	/*******************************************************
	 * Mutator method to set the <code>minPlayTime</code>.
	 * @param what the value of <code>minPlayTime</code> to be set.
	 **/
	public void setMinPlayTime(int newMinPlayTime) {
		this.minPlayTime=newMinPlayTime;
	}//ending bracket of method setMinPlayTime

	/*******************************************************
	 * Mutator method to set the <code>maxPlayTime</code>.
	 * @param what the value of <code>maxPlayTime</code> to be set.
	 **/
	public void setMaxPlayTime(int newMaxPlayTime) {
		this.maxPlayTime=newMaxPlayTime;
	}//ending bracket of method setMaxPlayTime

	/*******************************************************
	 * Method to compare the <code>name</code> values of Game name.
	 * @param otherName the string to compare last name against
	 * @return true or false for the comparison
	 */
	public boolean compareName(String otherName) {
		return this.getName().equalsIgnoreCase(otherName); 
	}//ending bracket of method compareName

	/*******************************************************
	 * Method to compare the <code>name</code> values of records.
	 * @param otherGame the other game to compare to
	 * Return -1, 0, or +1 depending on how the comparison goes.
	 */
	public int compareTo(Game otherGame) {
		return this.getName().compareTo(otherGame.getName());
	}//ending bracket of method compareAgeTo

	/*******************************************************
	 * Method to read the txt file from an input
	 * <code>Scanner</code> file.
	 * @param inFile is the <code>Scanner</code> to read
	 **/
	public Game readGame(Scanner inFile) {

		if(inFile.hasNext()){
			this.setMinAge(inFile.nextInt());
			this.setMaxAge(inFile.nextInt());
			this.setMinPlayers(inFile.nextInt());
			this.setMaxPlayers(inFile.nextInt());
			this.setMinPlayTime(inFile.nextInt());
			this.setMaxPlayTime(inFile.nextInt());
			this.setName(inFile.next());
		}//ending bracket of if
		return this;
	}//ending bracket of method readGame

	/*******************************************************
	 * Usual <code>toString</code> method to convert a record to a
	 * <code>String</code>.
	 * @return the <code>toString</code> value of the game.
	 **/
	public String toString(){
		return String.format("%4d %4d %4d %4d %4d %4d %-10s", this.getMinAge(), this.getMaxAge(), this.getMinPlayers(), this.getMaxPlayers(), this.getMinPlayTime(), this.getMaxPlayTime(), this.getName());
	}//ending bracket of method toString

}//ending bracket of Game Class
