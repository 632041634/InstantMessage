package InstantMessageClient;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class Inquiry extends JFrame{
     Font f1=new Font("consolas", Font.PLAIN, 14);
	 private JTextField input = new JTextField(24);
     public Inquiry() {
   	 this.setBounds(490,280,300,180);
   	 this.setResizable(false);
   	 this.setTitle("查询");
   	 this.setLayout(null);
   	 createDisplay();
   	 this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    }
    
    public void createDisplay () {
    	JLabel FriendUserName = new JLabel("请输入好友的用户名：");
    	FriendUserName.setFont(f1);
    	FriendUserName.setBounds(70, 30, 200, 24);
    	
    	input.setBounds(50,65,200,24);
    	JButton jb_inquiry = new JButton("查询");
    	jb_inquiry.setFont(f1);     
   	    jb_inquiry.setBounds(105, 95, 65, 21);
   	    ButtonActions act_inquiry = new ButtonActions(1);
   	    jb_inquiry.addActionListener(act_inquiry);
   	    this.add(jb_inquiry);
    	this.add(FriendUserName);
    	this.add(input);
    }
    
    
    private class ButtonActions implements ActionListener {
   	 private int Stat;
   	 
   	 public ButtonActions(int n) {
   		 Stat = n;
   	 }
   	 
   	 public void actionPerformed(ActionEvent e) {
   		 if (Stat == 1) {
   			 String InPut = input.getText();
   			 try{
   				Socket s = new Socket("127.0.0.1" , 8000) ;
				
   				OutputStream os = s.getOutputStream();
			    OutputStreamWriter osw = new OutputStreamWriter(os);
			    
			    PrintWriter pw = new PrintWriter(osw,true);
			    pw.println("AF"+"--split__"+InPut);
			    pw.flush();
					
			    InputStream is = s.getInputStream() ;
	            InputStreamReader isr = new InputStreamReader(is) ;
	            BufferedReader br = new BufferedReader(isr) ;
	            String back = br.readLine() ;
                
                if(back != null){
                	String un = back.split("--split__")[0];
                	String nn = back.split("--split__")[1];
                	InquirySuccess IS = new InquirySuccess(un,nn);
                	IS.setVisible(true);
                }
   			 }catch (Exception e1){
   				 e1.printStackTrace();
   			 }
   		 
   		 }
   	 }
    }
}
