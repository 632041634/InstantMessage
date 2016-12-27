package InstantMessageClient;
import java.awt.*;
import javax.swing.*;
import java.net.*;
import java.awt.event.*;
import java.io.*;
import java.util.HashMap;

public class LoginGUI extends JFrame{
	Font f1=new Font("consolas", Font.PLAIN, 14);
	private JTextField username = new JTextField(24);
	private JPasswordField password = new JPasswordField(24);

     public LoginGUI() {
    	 this.setBounds(450,230,380,275);
    	 this.setResizable(false);
    	 this.setTitle("登陆");
    	 this.setLayout(null);
    	 createButtons();
    	 createTextField(); 
    	 Container contentPane = this.getContentPane();
    	 this.setDefaultCloseOperation(EXIT_ON_CLOSE);
 
     }
     
     private void createButtons() {
    	 RegisterGUI registerPage = new RegisterGUI();
    	 JButton jb_Register=new JButton("注册");  
    	 jb_Register.setFont(f1);
    	 jb_Register.setForeground(Color.BLUE);   
    	 jb_Register.setBounds(180, 150, 65, 21);
    	 this.add(jb_Register);
    	 JButton jb_Login=new JButton("登录");   
    	 jb_Login.setFont(f1);     
    	 jb_Login.setBounds(110, 150, 65, 21);
    	 this.add(jb_Login);
    	 ButtonActions act_login = new ButtonActions(0);
    	 ButtonActions act_register = new ButtonActions(1);
    	 jb_Login.addActionListener(act_login);
    	 jb_Register.addActionListener(act_register);
     }
     
     private void createTextField() {
    	 
    	 username.setForeground(Color.BLACK);       
    	 username.setBounds(100, 50, 170, 24);
    	 this.add(username);
    	 password.setForeground(Color.BLACK);    
    	 password.setBounds(100, 80, 170, 24);
    	 this.add(password);
    	 JLabel lb_username=new JLabel("用户名: ");
    	 JLabel lb_password=new JLabel("密 码: ");
    	 lb_username.setBounds(45, 50, 100, 25);
    	 lb_password.setBounds(45,80, 100,25);
    	 this.add(lb_username);
    	 this.add(lb_password);
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
    					 RegisterGUI registerPage = new RegisterGUI();
    					 registerPage.setTitle("注册新用户");
    					 registerPage.setVisible(true);
    				 }
    			 });
    		 }
    		 if (Stat == 0){
    			
 				try {
 					String User_Name = username.getText();
 					String User_Password = password.getText();
 					
					Socket s = new Socket("127.0.0.1" , 8000) ;
					
					OutputStream os = s.getOutputStream();
					OutputStreamWriter osw = new OutputStreamWriter(os);
					PrintWriter pw = new PrintWriter(osw,true);
					pw.println("Login"+"--split__"+User_Name+"--split__"+User_Password);
					
					InputStream is = s.getInputStream() ;
	                InputStreamReader isr = new InputStreamReader(is) ;
	                BufferedReader br = new BufferedReader(isr) ;
	                String back = br.readLine() ;
	                
	                if(back.contentEquals("ok")) {
	                	FriendList fl = new FriendList();
	                	fl.createDisplay(User_Name);
	                	fl.setTitle(User_Name+"好友列表");
		        		fl.setVisible(true);
	                }else {
                        LoginError le = new LoginError();
                        le.setVisible(true);
                     }
	                
				} catch (Exception e2) {
					e2.printStackTrace();
				}
 				} 
                
    		 
     }
     }
}
    	 
    	 
    


  
      