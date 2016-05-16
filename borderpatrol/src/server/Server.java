package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {

	
	double tick;
	boolean powerOn = true;
	public Thread serverThread;
	public ArrayList<Thread> playerThreads;
	
	public PlayerRegistry playerList;
	public MapHandler mapHandler;
	
	public static void main(String[] args) throws InterruptedException{
		new Server().start();
		
	}
	
	
	
	
	private class ServerManager implements Runnable{
		public void run() {
			
			playerList = new PlayerRegistry();
			playerList.loadList();
			
			
			while (powerOn){
				
				
				
				try {
					serverThread.sleep(25);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	
	private class PlayerManager implements Runnable{

		private Socket socket;
		private int clientNumber;
		
		public PlayerManager(Socket sock, int clientNum){
			socket = sock;
			clientNumber = clientNum;
		}
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			
			while(!socket.isClosed()){
				
				//PSEUDO
				//Send a request to the PlayerRegistry using the clientNumber
				//PlayerRegistry will send a CharStatPacket for each player
				//Visible on screen
				
				server.networking.CharStatPacket[] statPackets = playerList.proximity(clientNumber, 30);
				
				//Next, send a request to MapHandler using the curChunk value of
				//the CharStatPacket. This will return a RenderPacket.
				mapHandler.lookup(statPackets);
				
				
				//Finally, bundle the two packets into a netPacket, and send it to the
				//client
				
			}
		}
		
	}
	
	
	public void start() {
		int clientNum = 0;
		serverThread = new Thread(new ServerManager());
		serverThread.start();
		playerThreads  = new ArrayList<Thread>();
		ServerSocket listener = null;
		try {
			listener = new ServerSocket(9098);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		while(true){
			
			try {
				playerThreads.add(new Thread(new PlayerManager(listener.accept(),clientNum)));
				clientNum++;
				System.out.println("Client Connected! There are now: "+clientNum);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		
	}
}
