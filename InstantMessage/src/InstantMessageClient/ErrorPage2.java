package InstantMessageClient;

import java.awt.*;

import javax.swing.*;

public class  ErrorPage2 extends JFrame {
Font f1=new Font("consolas", Font.PLAIN, 14);
	
    public ErrorPage2() {
   	 this.setBounds(490,280,300,180);
   	 this.setResizable(false);
   	 this.setTitle("错误信息1");
   	 this.setLayout(null);
   	 createDisplay();
   	 this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    }
    
    public void createDisplay () {
    	JLabel errorInfo_1 = new JLabel("两次输入密码不正确");
    	JLabel cue = new JLabel("请关闭本页面重新注册");
    	errorInfo_1.setBounds(80, 50, 200, 24);
    	cue.setBounds(75,70,200,24);
    	this.add(errorInfo_1);
    	this.add(cue);
    }
}
