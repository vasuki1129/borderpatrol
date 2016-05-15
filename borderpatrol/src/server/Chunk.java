package server;

import java.util.ArrayList;

import util.FloatCoord;

public class Chunk {
	
	ArrayList<Agent> users = new ArrayList<Agent>();
	ArrayList<Entity> entities = new ArrayList<Entity>();
	Tile[][] tiles;
	
	public Chunk(){
		tiles = new Tile[128][128];
	}
	

	public void addAgent(String username,FloatCoord position){
		
	}
	
	public void addEntity(String id,FloatCoord position, int quantity){
		
	}
	
	
}
