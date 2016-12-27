package InstantMessageClient;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class AddFriends {
	String username;
	String friend_username;
	 File FriendList = new File("/Users/chenjiayi/Documents/workspace/InstantMessage","FriendList.txt");
    public AddFriends(String un , String fun) throws IOException   {
   	 username = un;
   	 friend_username = fun;
     addInformation();
    }
    void addInformation () throws IOException  {
   	 String s = username+"--split__"+friend_username+"\n";
   	 String s_ = friend_username+"--split__"+username;
   	 FileWriter out = new FileWriter(".//FriendList.txt",true);
   	 out.write(s);
   	 out.write(s_);
   	 out.close();
    }
}
