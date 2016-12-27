package InstantMessageClient;
import java.awt.*;
import javax.swing.*;
import User.Users;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.util.*;
import User.Users;
public class RegisterGUI extends JFrame{
	Font f1=new Font("consolas", Font.PLAIN, 14);
	private JTextField username=new JTextField(24);
	private JPasswordField password_1=new JPasswordField(24);    
	private JPasswordField password_2=new JPasswordField(24); 
	private JTextField nickname = new JTextField(24);
	   public RegisterGUI() {
		   this.setBounds(450,230,380,275);
	       this.setResizable(false);
	       this.setLayout(null);
	       creatButtons();
	       creatTextField();
	       Container contentPane = this.getContentPane();
	       this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	   }
	   
	   public void creatButtons() {
		     JButton jb_confirm=new JButton("确认");  
	    	 jb_confirm.setFont(f1);
	    	 jb_confirm.setForeground(Color.BLUE);   
	    	 jb_confirm.setBounds(110, 150, 65, 21);
	    	 this.add(jb_confirm);
	         JButton jb_cancel=new JButton("返回");
	         jb_cancel.setFont(f1);
	         jb_cancel.setForeground(Color.BLUE);   
	         jb_cancel.setBounds(180, 150, 65, 21);
	         this.add(jb_cancel);
	         ButtonActions act_cancel = new ButtonActions(0);
	    	 ButtonActions act_confirm = new ButtonActions(1);
	    	 jb_cancel.addActionListener(act_cancel);
	    	 jb_confirm.addActionListener(act_confirm);
	    	 
	       
	   }
	   
	   public void creatTextField() {   
		     nickname.setForeground(Color.BLACK);       
	    	 nickname.setBounds(100, 20, 170, 24);
	    	 this.add(nickname);   
	    	 username.setForeground(Color.BLACK);       
	    	 username.setBounds(100, 50, 170, 24);
	    	 this.add(username);   
	    	 password_1.setForeground(Color.BLACK);    
	    	 password_1.setBounds(100, 80, 170, 24);
	    	 this.add(password_1);
	    	 password_2.setForeground(Color.BLACK);    
	    	 password_2.setBounds(100, 110, 170, 24);
	    	 this.add(password_2);
	    	 JLabel lb_1=new JLabel("用户名");
	    	 JLabel lb_2=new JLabel("密 码");
	    	 JLabel lb_3=new JLabel("确认密码");
	    	 JLabel lb_4=new JLabel("设置昵称");
	    	 lb_1.setBounds(45, 50, 50, 24);
	    	 lb_2.setBounds(45, 80, 40, 24);
	    	 lb_3.setBounds(45, 110, 70, 24);
	    	 lb_4.setBounds(45, 20, 70, 24);
	    	 this.add(lb_1);
	    	 this.add(lb_2);
	    	 this.add(lb_3);
	    	 this.add(lb_4);
	   }
	   
	   private class ButtonActions implements ActionListener {
	    	 private int Stat;
	    	 
	    	 public ButtonActions(int n) {
	    		 Stat = n;
	    	 }
	    	 
	    	 public void actionPerformed(ActionEvent e) {
	    		 if (Stat == 1) {
	    			 String password1 = password_1.getText();
	    			 String password2 = password_2.getText();
	    			 String User_Name = username.getText();
	    			 String NickName = nickname.getText();
	    			 
	    			 try {
						Socket s = new Socket("127.0.0.1" , 8000) ;
						
						OutputStream os = s.getOutputStream();
						OutputStreamWriter osw = new OutputStreamWriter(os);
						PrintWriter pw = new PrintWriter(osw,true);
						pw.println("Register"+"--split__"+User_Name+"--split__"+password1+"--split__"+NickName+"--split__"+password2);
					
						InputStream is = s.getInputStream() ;
		                InputStreamReader isr = new InputStreamReader(is) ;
		                BufferedReader br = new BufferedReader(isr) ;
		                String back = br.readLine() ;
		                
		                if(back.contentEquals("ok")) {
		 
		                	Users user = new Users(User_Name,password1,NickName);
		                	RegisterSuccess rs = new RegisterSuccess();
			        		rs.setVisible(true);
		                }else {
	                       if(back.contentEquals("err1")){
	                    	   ErrorPage1 ep1 = new ErrorPage1();
	                    	   ep1.setVisible(true);
	                       }else {
	                    	   if(back.contentEquals("err2")){
	                    		   ErrorPage2 ep2 = new ErrorPage2();
	                    		   ep2.setVisible(true);
	                    	   }
	                       }
	                     }
					} catch (Exception e1) {
						e1.printStackTrace();
					} 
	    		 }
	    			
					 
	    			
	    		 
	    	 
	    		 if (Stat == 0){
	    		
	    		 }
	    	 }
	     }
}

