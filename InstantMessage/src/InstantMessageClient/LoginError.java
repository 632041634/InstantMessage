package InstantMessageClient;

import java.awt.Font;

import javax.swing.*;

public class LoginError extends JFrame{
Font f1=new Font("consolas", Font.PLAIN, 14);
	
    public LoginError() {
   	 this.setBounds(490,280,300,180);
   	 this.setResizable(false);
   	 this.setTitle("登录错误");
   	 this.setLayout(null);
   	 createDisplay();
   	 this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    }
    
    public void createDisplay () {
    	JLabel errorInfo_1 = new JLabel("用户名不存在或密码错误");
    	JLabel cue = new JLabel("请关闭本页进行注册");
    	errorInfo_1.setBounds(65, 50, 200, 24);
    	cue.setBounds(75,70,200,24);
    	this.add(errorInfo_1);
    	this.add(cue);
    }

}
