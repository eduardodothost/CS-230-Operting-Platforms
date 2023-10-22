package com.gamingroom;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple class to hold information about a team
 * <p>
 * Notice the overloaded constructor that requires
 * an id and name to be passed when creating.
 * Also note that no mutators (setters) defined so
 * these values cannot be changed once a team is
 * created.
 * </p>
 * 
 * Follows the same iterator pattern as the Game class does for it's Team container
 * -- goalkeeping any duplicate names out of the Player container
 * 
 * </p>
 * @author coce@snhu.edu
 *
 */
public class Team extends Entity{
	long id;
	String name;
	private static List<Player> players = new ArrayList<Player>();
	private static long nextPlayerId = 1;
	
	/*
	 * Constructor with an identifier and name
	 */
	public Team(long id, String name) {
		this.id = id;
		this.name = name;
	}

	/**
	 * 
	 * @param name
	 * @return unique Player
	 * @see getPlayer(String name): Player
	 */
		public Player addPlayer(String name) {

			// a local team instance
			Player player = null;
			
			// Use iterator to look for existing team with same name
			// if found, simply return the existing instance
			player = this.getPlayer(name);
			
			// if not found, make a new team instance and add to list of teams
			if (player == null) {
				player = new Player(nextPlayerId++, name);
				players.add(player);
			}

			// return the new/existing team instance to the caller
			return player;
		}
		
		/**
		 * Returns the Player instance at the specified index.
		 * <p>
		 * Scope is package/local for testing purposes.
		 * </p>
		 * @param index index position in the list to return
		 * @return requested Player instance
		 */
		Player getPlayer(int index) {
			return players.get(index);
		}
		
		/**
		 * Returns the Player instance with the specified id.
		 * 
		 * @param id unique identifier of Player to search for
		 * @return requested Player instance
		 */
		public Player getPlayer(long id) {

			// a local game instance
			Player player = null;

			// Use iterator to look for existing team with same id
			// if found, simply assign that instance to the local variable
			for(Player slice: players) {
				if(slice.getId()==id) player = slice;
			}
			return player;
		}

		/**
		 * Returns the Player instance with the specified name.
		 * 
		 * @param name unique name of Player to search for
		 * @return requested Player instance
		 */
		public Player getPlayer(String name) {

			// a local game instance
			Player player = null;
			// iterate over Teams as Team slice, returning slice if slice name equals name
			for(Player slice: players) {
				if(slice.getName().equalsIgnoreCase(name)) player = slice;
			}
			
			return player;
		}

		/**
		 * Returns the number of Player objects currently active
		 * 
		 * @return the number of Player objects currently active
		 */
		public int getTeamCount() {
			return players.size();
		}
		
	
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Team [id=" + id + ", name=" + name + "]";
	}
}
