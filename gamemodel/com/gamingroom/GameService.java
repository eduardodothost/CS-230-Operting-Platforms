package com.gamingroom;

import java.util.ArrayList;
import java.util.List;


/**
 * A singleton service for the Game container
 * 
 * @author coce@snhu.edu
 */
public class GameService {

	/**
	 * A list of the active Game object
	 */
	private static List<Game> games = new ArrayList<Game>();

	/*
	 * Holds the next Game object identifier
	 */
	private static long nextGameId = 1;

	// FIXME: Add missing pieces to turn this class a singleton 
	/**
	 * In order to give the GameService class a singleton pattern we must
	 * add a private GameSerivice instance and constructor within the GameService class 
	 * so that the only way to get a GameService is to call on the GameService method that returns the
	 * aforementioned class bound instance.
	 */
	// Add private GameSerice instance to be returned by getGameSerice
	private static GameService GameServiceInstance = new GameService();
	/**
	 * The private constructor enables a unique instantiation 
	 * of a GameService object from within GameService. Allowing the
	 * object to only be returned by it's Object of Origin
	 * IE the singleton pattern.
	 */
	/**
	 * @return a unique GameService instance
	 * @see Game
	 */
	private GameService(){}
	
	public static GameService getGameServiceInstance() {
		return GameServiceInstance;
	}
	
	/**
	 * Constructs a new Game object within GameService if 
	 * the object is instantiated with a unique name.
	 * 
	 * @param name the unique name of the game
	 * @return the game instance (new or existing)
	 * @see getGame(String name): Game
	 */
	public Game addGame(String name) {

		// a local game instance
		Game game = null;
		
		// FIXME: Use iterator to look for existing Game object with same name --
		// if found, simply return the existing instance.
		game = this.getGame(name);
		
		// if not found, make a new game instance and add to the list of Game objects
		if (game == null) {
			game = new Game(nextGameId++, name);
			games.add(game);
		}

		// return the new/existing game instance to the caller
		return game;
	}

	/**
	 * Returns the game instance at the specified index.
	 * <p>
	 * Scope is package/local for testing purposes.
	 * </p>
	 * @param index index position in the list to return
	 * @return requested game instance
	 */
	Game getGame(int index) {
		return games.get(index);
	}
	
	/**
	 * Returns the game instance with the specified id.
	 * 
	 * @param id unique identifier of game to search for
	 * @return requested game instance
	 */
	public Game getGame(long id) {

		// a local Game instance
		Game game = null;

		// FIXME: Use iterator to look for existing game with same id
		// if found, simply assign that instance to the local variable
		for(Game slice: games) {
			if(slice.getId()==id) game = slice;
		}
		return game;
	}

	/**
	 * Returns the game instance with the specified name.
	 * 
	 * @param name unique name of game to search for
	 * @return requested game instance
	 */
	public Game getGame(String name) {

		// a local game instance
		Game game = null;
		// FIXME: Use iterator to look for existing game with same name
		// if found, simply assign that instance to the local variable
		//We use an enhanced for loop to traverse each Game contained in our ArrayList, games and
		//set our local game value to the target name we want to access and return via getGame.
		for(Game slice: games) {
			if(slice.getName().equalsIgnoreCase(name)) game = slice;
		}
		
		return game;
	}

	/**
	 * Returns the number of Game objects currently active
	 * 
	 * @return the number of Game objects currently active
	 */
	public int getGameCount() {
		return games.size();
	}
}
