package com.gamingroom;

/**
 * Application start-up program
 * 
 * @author coce@snhu.edu
 */
public class ProgramDriver {
	
	/**
	 * The one-and-only main() method
	 * 
	 * @param args command line arguments
	 */
	public static void main(String[] args) {
		
		// FIXME: obtain reference to the singleton instance
		GameService service = GameService.getGameServiceInstance(); // replace null with ???
		
		System.out.println("\nAbout to test initializing game data...");
		
		// initialize with some game data
		Game game1 = service.addGame("Game #1");
		System.out.println(game1);
		Game game2 = service.addGame("GamE #1");
		System.out.println(game2);
		Game game3 = service.addGame("gAme #1");
		System.out.println(game3);
		Game game4 = service.addGame("GAME #2");
		System.out.println(game4);
		// use another class to prove there is only one instance
		SingletonTester tester = new SingletonTester();
		/**
		 * By using the singleton pattern we can be sure that only one Game with the same name will be added to the GameService container
		 */
		tester.testSingleton();
	}
}
