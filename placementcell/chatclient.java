package placementcell;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class chatclient {
    
     String result;

    public chatclient() {
        try
        {
            Socket c=new Socket("127.0.0.1",4012);
            Scanner s1=new Scanner(System.in);
              DataInputStream f;
              DataOutputStream to;
              String msg;
              System.out.println("enter Message");
            do
            {
            System.out.println("Client :"); 
            msg=s1.nextLine();
            f =new DataInputStream(c.getInputStream());
            to =new DataOutputStream(c.getOutputStream());
            to.writeUTF(msg);
            
            result=f.readUTF();
            System.out.println("Server Replied : "+result);
            }
            while(!result.equals("stop"));
            f.close();
            to.close();
            c.close();
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }         
    public static void main(String[] args) {
        new chatclient();
    }
}

