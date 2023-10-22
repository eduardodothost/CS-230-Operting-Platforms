package com.gamingroom;
/**
 * A base class for Game, Team, and Player to extend from.
 * 
 * 
 * @author eduardo.rodrigues1@snhu.edu
 *
 */
class Entity {

	private long id;
	private String name;
	


	protected Entity(){};
	
	public Entity(long id, String name){};
	
	public long getId(){
		return id;
	};

	public String getName() {
		return name;
		
	}
	
	@Override
	public String toString() {
		return "Entity [id=" + id + ", name=" + name + "]";
	}
}
