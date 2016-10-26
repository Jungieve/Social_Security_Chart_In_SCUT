package org.scut.mychart.util;

import java.io.IOException;
import java.io.InputStream;

import com.trilead.ssh2.ChannelCondition;
import com.trilead.ssh2.Connection;
import com.trilead.ssh2.Session;

public class RemoteShellTool {
	private Connection conn;  
    private String ipAddr;  
    private String charset = "utf-8";  
    private String userName;  
    private String password; 
    
    public RemoteShellTool(String ip, String uname, String upassword) {
    	this.ipAddr = ip;
    	this.userName = uname;
    	this.password = upassword;
    }
    
    public boolean login() throws IOException {  
        conn = new Connection(ipAddr);  
        conn.connect(); // 连接  
        return conn.authenticateWithPassword(userName, password); // 认证  
    }
    
    public String exec(String cmds) {  
        InputStream in = null;  
        InputStream err = null;  
        String result = "";  
        Session session = null;
        try {  
            if (this.login()) {  
                session = conn.openSession(); // 打开一个会话  
                session.execCommand(cmds);
                in = session.getStdout();  
                err = session.getStderr();
                result = this.processStdout(in, this.charset); 
 //               System.out.println(this.processStdout(err, this.charset));
                session.waitForCondition(ChannelCondition.CLOSED | ChannelCondition.EOF | ChannelCondition.EXIT_STATUS, 1000 * 5 * 60);
                
//                System.out.println(session.getExitStatus());
                
            }  
        } catch (Exception e1) {  
            e1.printStackTrace();  
        } finally {
        	session.close();  
            conn.close(); 
        }
        return result;  
    }  
    
    public String processStdout(InputStream in, String charset) {  
        
        byte[] buf = new byte[1024];  
        StringBuffer sb = new StringBuffer();  
        String res = "";
        try {  
            while (in.read(buf) != -1) {  
//                sb.append(new String(buf, charset));  
                res = new String(buf, charset);
            }  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
        return res;  
    } 
    
    public static void main(String[] args) {
		RemoteShellTool tool = new RemoteShellTool("125.216.242.175", "root", "scut123!@#");
		
//		String result = tool.exec("sh /home/scut/recommend.sh 1500003");
		
//		String[] arr = result.split(",");
//		
//		System.out.println(arr[9]);
		
		System.out.println(tool.exec("sh /home/scut/recommend.sh 1500003"));
//		tool = new RemoteShellTool("125.216.242.175", "root", "scut123!@#");
//		System.out.println(tool.exec("cat /home/scut/data.txt"));
	}
}
