package User;

import java.io.*;
import java.util.*;

public class Users {
	 String username;
	 String password;
	 String nickname;
	 File UserList = new File("/Users/chenjiayi/Documents/workspace/InstantMessage","UserList.txt");
     public Users(String un , String pwd,String nn) throws IOException   {
    	 username = un;
    	 password = pwd;
    	 nickname = nn;
         addInformation();
     }
     void addInformation () throws IOException  {
    	 String s = username+"--split__"+password+"--split__"+nickname+"\n";
    	 FileWriter out = new FileWriter(".//UserList.txt",true);
    	 out.write(s);
    	 out.close();
     }

     
}
