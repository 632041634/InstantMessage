package InstantMessageClient;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class RegisterSuccess extends JFrame{
Font f1=new Font("consolas", Font.PLAIN, 14);
	
    public RegisterSuccess() {
   	 this.setBounds(490,280,300,180);
   	 this.setResizable(false);
   	 this.setTitle("提示");
   	 this.setLayout(null);
   	 createDisplay();
   	 this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    }
    
    public void createDisplay () {
    	JLabel success = new JLabel("注册成功！");
    	success.setBounds(95, 50, 200, 30);
    	success.setFont(new Font("consolas", Font.PLAIN, 24));
    	this.add(success);
    	JButton jb_Login=new JButton("登录");   
   	    jb_Login.setFont(f1);     
   	    jb_Login.setBounds(110, 90, 65, 21);
   	    this.add(jb_Login);
   	    ButtonActions act_login = new ButtonActions(1);
   	    jb_Login.addActionListener(act_login);
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
   					 LoginGUI Denglu = new LoginGUI();
   					 Denglu.setTitle("登录");
   					 Denglu.setVisible(true);
   				 }
   			 });
   		 }
   		 if (Stat == 0){
   			
   			 }
   		 }
		}
    
}
