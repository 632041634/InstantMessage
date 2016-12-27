package InstantMessageClient;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.*;

public class InquirySuccess extends JFrame {
	Font f1=new Font("consolas", Font.PLAIN, 14);
	 private JTextField input = new JTextField(24);
	 
	
 	
     public InquirySuccess(String username,String nickname) {
  	 this.setBounds(490,280,300,180);
  	 this.setResizable(false);
  	 this.setTitle("查询成功");
  	 this.setLayout(null);
  	 this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
  	 
  	 JLabel FriendUserName = new JLabel("好友用户名："+username);
	 FriendUserName.setFont(f1);
	 FriendUserName.setBounds(50, 40, 200, 24);
	 this.add(FriendUserName);
	 
	 JLabel FriendNickName = new JLabel("好友   昵称："+nickname);
	 FriendNickName.setFont(f1);
	 FriendNickName.setBounds(50, 60, 200, 24);
	 this.add(FriendNickName);
	 
	 JButton jb_confirmadd= new JButton("确认添加");
	 jb_confirmadd.setBounds(90,120,100,24);
	 this.add(jb_confirmadd);
	 
     
    
   }
   
     
     private class ButtonActions implements ActionListener {
    	 private int Stat;
    	 
    	 public ButtonActions(int n) {
    		 Stat = n;
    	 }
		
		public void actionPerformed(ActionEvent e) {
			if (Stat == 1) {
   			 EventQueue.invokeLater(new Runnable() {
   				 public void run() {
   					 
   				 }
   				
   						
   			 });
			
		}
    	 
     }
     
    	
    
}
}
