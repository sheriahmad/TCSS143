
/*	
 *  FileName: LostPuppy.java
 *  TCSS 142 Fall 2015
 *  Assignment 3
 *  Name:	Sheheyrar Ahmad
 *  Instructor: Mr. Schuessler 
 */

import java.util.*;

/**
 * @author sahmad
 * @version Fall 2015
 */

public class LostPuppy {

	private char[][] myHidingPlaces;
	private int myFloorLocation;
	private int myRoomLocation;
	private char myWinner;
	private boolean myFound;
	private int myFloors;
	private int myRooms;

	/**
	 * @param theFloors
	 * @param theRooms
	 */

	public LostPuppy(int theFoors, int theRooms) {

		Random random = new Random();
		this.myFloors = theFoors;
		this.myRooms = theRooms;
		this.myHidingPlaces = new char[theFoors][theRooms];
		this.myFloorLocation = random.nextInt(theFoors);
		this.myRoomLocation = random.nextInt(theRooms);
		this.myWinner = ' ';
		this.myFound = false;

		for (int row = 0; row < myHidingPlaces.length; row++) {
			for (int column = 0; column < myHidingPlaces[row].length; 
					column++) {
				this.myHidingPlaces[row][column] = ' ';
			}
		}

		this.myHidingPlaces[myFloorLocation][myRoomLocation] = 'P';
	}

	// setting up methods.

	/**
	 * receives the floor and room to be searched and returns true 
	 * if the room has already been searched, false otherwise.
	 * @param theFloor is the floor being searched.
	 * @param theRoom is the room being search.
	 * @return true if the puppy is found, false otherwise.
	 */

	public boolean roomSearchedAlready(int theFloor, int theRoom) {
		return (myHidingPlaces[theFloor][theRoom] == '1'
				|| myHidingPlaces[theFloor][theRoom] == '2');
	}

	/**
	 * receives the floor and room to be searched and returns 
	 * true if the floor and room are where the puppy is lost, 
	 * false otherwise. 
	 * @param theFloor is the floor puppy is located. 
	 * @param theRoom is the room where puppy is located. 
	 * @return isRight returns true if the floor and room are 
	 * where the puppy is lost, false otherwise
	 */
	
	public boolean puppyLocation(int theFloor, int theRoom){
		boolean isRight = false; 
		if(myFloorLocation == theFloor && myRoomLocation == theRoom){
			isRight = true;
		}
		return isRight;

	}

	/*
	 * Original method that I wrote. It is showing puppy in every room after
	 * it has been found. 
	 * public boolean puppyLocation(int theFloor, int theRoom) {
	 * 		if (indicesOK(theFloor, theRoom)
	 * 		&& !roomSearchedAlready(theFloor, theRoom)
	 * 		&& myHidingPlaces[theFloor][theRoom] != 'P') {
	 * 			return false;
	 * 			} 
	 * 			else {
	 * 				return true;
	 * 			}
	 * 		}
	 */
	

	/**
	 * receives the floor and room to be searched and returns true 
	 * if the floor and room values are within the array indices 
	 * range, false otherwise
	 * @param theFloor 
	 * @param theRoom 
	 * @return  true if the floor and room values are within the array indices range, false otherwise.
	 */

	public boolean indicesOK(final int theFloor, final int theRoom){
		return theFloor >= 0 && theFloor < myHidingPlaces.length && 
				theRoom >= 0 && theRoom < myHidingPlaces[theFloor].length;
	}

	/**
	 * @return myFloors 
	 * returns number of floor in the building
	 */

	public int numberOfFloors(){
		return myFloors;
	}

	/**
	 * @return myRooms
	 * returns number of rooms on each floor. 
	 */

	public int numberOfRooms() {
		return myRooms;
	}

	/**
	 * receives the floor and room to be searched and also the 
	 * current player (as a char type) and returns true if the 
	 * puppy is found, false otherwise. If the puppy is NOT found 
	 * searchRoom also sets the myHidingPlaces array at the received 
	 * floor and room location to the received player value (a ‘1’ 
	 * or a ‘2’) OR, when found, sets the myWinner field to the current
	 * player AND sets myFound to true.
	 * 
	 * @param theFloor
	 * @param theRoom
	 * @param thePlayer 
	 * @return returns false if rooms have been searched. 
	 */

	public boolean searchRoom(int theFloor, int theRoom,char thePlayer) {
		boolean check = false;
		if (myHidingPlaces[theFloor][theRoom] == ' ') {
			myHidingPlaces[theFloor][theRoom] = thePlayer;
			check = false;
		} 

		else if (myHidingPlaces[theFloor][theRoom] == 'P') {
			this.myWinner = thePlayer;
			this.myFound = true;
			check = true;
		}

		return check;
	}

	/**
	 * displays the current hidingPlaces array and it’s contents 
	 * EXCEPT the location of the puppy which remains hidden until 
	 * he/she is found at which point toString will be called 
	 * (by the driver) and both the player who found the puppy and 
	 * a ‘P’ will be displayed in the same cell...
	 * @return build
	 */

	public String toString() {
		
		String build = " ";
		String temp = "";

		// loop that constructs the roof of the building
		for (int i = 0; i <= this.myRooms * 4 - 1; i++) {
			build += "_";
		}
		for (int i = (myHidingPlaces.length- 1);
				i >= 0; i--) {
			build += "\n";
			build += "|";
			for (int j = 0; j < myHidingPlaces[0].length; j++) {
				if (puppyLocation(i, j)) {
					if (this.myFound) {
						temp = "" + myWinner + "P" + " ";
					} 
					else {
						temp = "   ";
					}
				} 
				else {
					temp = " " + myHidingPlaces[i][j] + " ";
				}
				build += temp + "|";
			} 
			build += "\n";
			build += "|";

			// loop that constructs the bottom of the rooms
			for (int k = 0; k <= (myHidingPlaces[0].length - 1); k++) {
				build += "___|";
			}
		} 
		return build;
	}
}