package placementcell;

import java.net.Socket;
import java.util.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;

public class chatserver {
    
     String msg;
     chatserver()
    {
        try
        {
            Socket s2=null;
            ServerSocket s1=new ServerSocket(4012);
            System.out.println("Server s started");
            DataInputStream d=null;
            DataOutputStream o=null;
            s2=s1.accept();
            System.out.println("Local port s "+s2.getLocalPort());
            d=new DataInputStream(s2.getInputStream());
            Scanner s11=new Scanner(System.in);
            String r;
            o=new DataOutputStream(s2.getOutputStream());
            do
            {
               msg=d.readUTF();
               System.out.println("Client Said :"+msg);
               System.out.println("Server :");
               
               r=s11.nextLine();
               o.writeUTF(r);
            }
            while(!msg.equals("stop"));
            
             d.close();
                o.close();
                s2.close(); 
        }
        catch(Exception e)
        {
           // System.out.println("dd"+e.getMessage());
            e.printStackTrace();
        }
    }   
    public static void main(String[] args) {
        new chatserver();
    }
}
