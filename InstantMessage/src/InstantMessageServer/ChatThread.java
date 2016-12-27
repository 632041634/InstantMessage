package InstantMessageServer;

import java.net.*;
import java.util.HashMap;
import java.io.*;


public class ChatThread implements Runnable {
    private Socket client;
    
    public ChatThread(Socket client) {
    	this.client = client;
    }
    public void run () {
        try{
    		String STR;
    		HashMap<String,String> check = new HashMap<String,String>();
    		HashMap<String,String> find = new HashMap<String,String>();
            FileReader fr = new FileReader("/Users/chenjiayi/Documents/workspace/InstantMessage/UserList.txt");
    		BufferedReader bfr = new BufferedReader(fr);
    			while((STR=bfr.readLine())!=null){
    				String[] ss = STR.split("--split__");
    				check.put(ss[0],ss[1]);
    				find.put(ss[0], ss[2]);
    			}
    		
    		
    	
    			
    				InputStream is = client.getInputStream();
    				InputStreamReader isr = new InputStreamReader(is);
    				BufferedReader br = new BufferedReader(isr);
    				String str = br.readLine();
    				
    				String prompt = str.split("--split__")[0];
    			
    		        
    				OutputStream os = client.getOutputStream() ;
     		        OutputStreamWriter osw = new OutputStreamWriter(os) ;
     		        PrintWriter pw = new PrintWriter(osw , true) ;
     		        
     		        
    		        if(prompt.contentEquals("Login")){
    		        	String username = str.split("--split__")[1];
    		        	if(check.containsKey(username)){
    		        		String password = str.split("--split__")[2];
    		        		if(password.contentEquals(check.get(username))){
    		        			pw.println("ok");
    		        		}else{
    		        			pw.println("err");
    		        		}
    		        	}else {
    		        		pw.println("err");
    		        	}
    		        }else {
    		        	if(prompt.contentEquals("Register")) {
    		        	  String username = str.split("--split__")[1];
    		        	  if(check.containsKey(username)){
    		        		  pw.println("err1");
    		        	  }else {
    		        		  String password1 = str.split("--split__")[2];
    		        		  String password2 = str.split("--split__")[4];
    		        		  if(password1.contentEquals(password2)){
    		        			  pw.println("ok");
    		        		  }else {
    		        			  pw.println("err2");
    		        		  }
    		        	  }
    		        		
    		        	}else {
    		        		if(prompt.contentEquals("S&R")){
    		        			String send_message = str.split("--split__")[1];
        		        		pw.println(send_message);
    		        		}
    		        	}
    		        }
    		        
    		        if(prompt.contentEquals("AF")){
    	               String friendusername = str.split("--split__")[1];
    		        	if(find.containsKey(friendusername)){
    		        		pw.println(friendusername+"--split__"+find.get(friendusername));
    		        	}
    		        }
    		        
    		       
        }catch(IOException e){
        	e.printStackTrace();
        }
        
       
    }
}
