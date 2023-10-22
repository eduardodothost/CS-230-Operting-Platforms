package com.gamingroom;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple class to hold information about a game
 * 
 * <p>
 * Notice the overloaded constructor that requires
 * an id and name to be passed when creating.
 * Also note that no mutators (setters) defined so
 * these values cannot be changed once a game is
 * created.
 * 
 * </p>
 * Follows the same iterator pattern as GameService does for adding a Game.
 * In order to store a unique Team within teams we iterate over the container
 * to check if the Team name is unique or not before adding it to the teams container.
 * </p>
 * 
 * @author coce@snhu.edu
 *
 */
public class Game extends Entity{
	// 
	long id;
	String name;
	//teams holds Team objects, eaach having a unique Team name
	private static List<Team> teams = new ArrayList<Team>();
	private static long nextTeamId = 1;
	/**
	 * Hide the default constructor to prevent creating empty instances.
	 */
	private Game() {	

	}

	/**
	 * Constructor with an identifier and name
	 */
	public Game(long id, String name) {
		this();
		this.id = id;
		this.name = name;
	}
/**
 * 
 * @param name
 * @return unique Team
 * @see getTeam(String name): Team
 */
	public Team addTeam(String name) {

		// a local team instance
		Team team = null;
		
		// Use iterator to look for existing team with same name
		// if found, simply return the existing instance
		team = this.getTeam(name);
		
		// if not found, make a new team instance and add to list of teams
		if (team == null) {
			team = new Team(nextTeamId++, name);
			teams.add(team);
		}

		// return the new/existing team instance to the caller
		return team;
	}

	/**
	 * Returns the Team instance at the specified index.
	 * <p>
	 * Scope is package/local for testing purposes.
	 * </p>
	 * @param index index position in the list to return
	 * @return requested Team instance
	 */
	Team getTeam(int index) {
		return teams.get(index);
	}
	
	/**
	 * Returns the Team instance with the specified id.
	 * 
	 * @param id unique identifier of team to search for
	 * @return requested Team instance
	 */
	public Team getTeam(long id) {

		// a local game instance
		Team team = null;

		// Use iterator to look for existing team with same id
		// if found, simply assign that instance to the local variable
		for(Team slice: teams) {
			if(slice.getId()==id) team = slice;
		}
		return team;
	}

	/**
	 * Returns the Team instance with the specified name.
	 * 
	 * @param name unique name of Team to search for
	 * @return requested Team instance
	 */
	public Team getTeam(String name) {

		// a local game instance
		Team team = null;
		// iterate over Teams as Team slice, returning slice if slice name equals name
		for(Team slice: teams) {
			if(slice.getName().equalsIgnoreCase(name)) team = slice;
		}
		
		return team;
	}

	/**
	 * Returns the number of teams currently active
	 * 
	 * @return the number of teams currently active
	 */
	public int getTeamCount() {
		return teams.size();
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
		
		return "Game [id=" + id + ", name=" + name + "]";
	}

}
