package InstantMessageClient;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.tree.*;

public class  FriendList extends JFrame {
	DefaultMutableTreeNode top = new DefaultMutableTreeNode("我的好友");  
	DefaultMutableTreeNode second = new DefaultMutableTreeNode("黑名单"); 
	 public FriendList( ) throws FileNotFoundException {
	   	 this.setBounds(490,150,300,500);
	   	 this.setResizable(false);
	   	 this.setTitle("好友列表");
	   	 this.setLayout(new BorderLayout());
	   	 this.getContentPane().setBackground(Color.white);
	   	 
	   	 JTree whitetree = new JTree(top);
		 this.add(new JScrollPane(whitetree));
		 top.add(second);
		 
		 this.add(whitetree,BorderLayout.CENTER);
	   	 createMenu();
	   	 this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	   	
	    }
	 public  void createDisplay (String username) throws IOException {
			String STR;
			FileReader fr = new FileReader("/Users/chenjiayi/Documents/workspace/InstantMessage/FriendList.txt");
	 		BufferedReader bfr = new BufferedReader(fr);
	 		while((STR=bfr.readLine())!=null){
				String[] ss = STR.split("--split__");
				if(ss[0].contentEquals(username)){
					for(int i = 1;i <ss.length;i++){
						top.add(new DefaultMutableTreeNode(ss[i]));;
					}
				}
				
			}
	 		
			 
		 }
	 
	 
	 
	 
	 
	 
	 public void createMenu() {
		    JMenuBar main = new JMenuBar();
			this.setJMenuBar(main);
			JMenu fileMenu = new JMenu("添加好友");
			main.add(fileMenu);
			
			JMenuItem newMenuItem = new JMenuItem("查询");
			fileMenu.add(newMenuItem);
			newMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					EventQueue.invokeLater(new Runnable() {
		   				 public void run() {
		   					 Inquiry inquiry = new Inquiry();
		   					 inquiry.setTitle("查询好友");
		   					 inquiry.setVisible(true);
		   				 }
		   			 });
				}
			});
			
			
		
			
	 }
	 
	 
	 
}
     
 
   
