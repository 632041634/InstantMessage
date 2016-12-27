package InstantMessageClient;


import java.net.*;
import java.util.*;
import java.awt.*; 
import javax.swing.*; 
import java.awt.event.*;
import java.io.*;


public class ChatUI extends JFrame {  
        static JPanel p1 = new JPanel(), p2 = new JPanel(); 
        TextArea OutPut = new TextArea("", 20, 18, TextArea.SCROLLBARS_BOTH), 
        InPut = new TextArea("", 20, 18, TextArea.SCROLLBARS_VERTICAL_ONLY); 
        JButton jb_biaoqing = new JButton("表情"); 
        JButton jb_ziti = new JButton("字体"); 
        JButton jb_ziticolor = new JButton("字体颜色"); 
        JButton jb_jilu = new JButton("聊天记录"); 
        JButton jb_fasong = new JButton("发送");

         
        

         JButton siliao = new JButton("私聊"); 
         JButton qunliao = new JButton("群聊"); 
  

         public ChatUI() {  
         super("聊天"); 

         setResizable(false); 
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 


         Container cc = getContentPane(); 
         setBounds(370, 150, 600, 510); 
         cc.setLayout(new BorderLayout()); 
         OutPut.setBackground(Color.white); 
         OutPut.setForeground(Color.BLACK); 
         OutPut.setBounds(4, 0, 420, 250); 
         OutPut.setFont(new Font("楷体", Font.PLAIN, 14)); 
         OutPut.setEditable(false);

         p1.setLayout(null); 
         p1.setBackground(new Color(220, 220, 220)); 
         p1.add(OutPut); 
         jb_biaoqing.setBounds(4, 254, 60, 30); 
         p1.add(jb_biaoqing); 
         jb_ziti.setBounds(65, 254, 60, 30); 
         p1.add(jb_ziti); 
         jb_ziticolor.setBounds(126, 254, 90, 30); 
         p1.add(jb_ziticolor); 
         InPut.setFont(new Font("楷体", Font.PLAIN, 14)); 
         InPut.setBackground(Color.white); 
         InPut.setForeground(Color.BLACK); 
         InPut.setBounds(4, 290, 420, 125); 
         p1.add(InPut); 
         jb_jilu.setBounds(4, 420, 120, 30); 
         p1.add(jb_jilu); 
         jb_fasong.setBounds(360, 420, 60, 30); 
         ButtonActions act_fasong = new ButtonActions(1);
         jb_fasong.addActionListener(act_fasong);
         p1.add(jb_fasong); 
         cc.add(p1, "Center");

         
         p2.setLayout(new GridLayout(10, 1, 1, 10)); 
         
         p2.add(siliao); 
         p2.add(qunliao); 
         cc.add(p2, "East"); 
         setVisible(true); 
  }
         
         private class ButtonActions implements ActionListener {
        	 private int Stat;
        	 
        	 public ButtonActions(int n) {
        		 Stat = n;
        	 }
        	 public void actionPerformed(ActionEvent e) {
        		 if(Stat == 1){
        			 String input = InPut.getText();
        			 try {
    					Socket s = new Socket("127.0.0.1" , 8000) ;
     					
     					OutputStream os = s.getOutputStream();
     					OutputStreamWriter osw = new OutputStreamWriter(os);
     					PrintWriter pw = new PrintWriter(osw,true);
     					pw.println("S&R"+"--split__"+input);
     					pw.flush();
     					
     					InputStream is = s.getInputStream() ;
     	                InputStreamReader isr = new InputStreamReader(is) ;
     	                BufferedReader br = new BufferedReader(isr) ;
     	                String back = br.readLine() ;
     	                
     	                if(back != null) {
     	                  Calendar rightNow = Calendar.getInstance(); 
     	                  int hour = rightNow.get(Calendar.HOUR_OF_DAY); 
     	                  int year = rightNow.get(Calendar.YEAR); 
     	                  int month = rightNow.get(Calendar.MONTH) + 1; 
     	                  int day = rightNow.get(Calendar.DATE); 
     	                  int minute = rightNow.get(Calendar.MINUTE); 
     	                  int second = rightNow.get(Calendar.SECOND);

     	                  String date = year+"-"+month+"-"+day+" "+hour+":"+minute+":"+second+"\n";

     	                  String blank_space = "";
     	                  OutPut.append(date+input+"\n");
     	                  InPut.replaceRange(blank_space, 0, input.length());
     	                }else {
                            
                          }
     	                
     				} catch (Exception e2) {
     					e2.printStackTrace();
     				}
        		 }
        	 }
         }
}
