package InstantMessageServer;

import java.io.*;
import java.net.*;
import java.util.HashMap;
import InstantMessageClient.FriendList;

public class ChatServer {
	public static void main(String[] args) throws IOException    {
		
		ServerSocket serverSocket = null;
		Socket client = null;
		while(true) {
			try{
				serverSocket = new ServerSocket(8000);
			}catch(Exception e){
				System.out.println("Error "+e);
			}
		    try{
		    	client = serverSocket.accept();
		    }catch(Exception e){
		    	System.out.println("接收请求失败!");
		    	
		    }
		    ChatThread ct = new ChatThread(client);
			Thread t = new Thread(ct);
			t.start();
		}
		
}
}
				
			

	    
		
        
			
		
	
 
	


