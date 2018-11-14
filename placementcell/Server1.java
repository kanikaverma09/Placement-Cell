package placementcell;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;


    public class Server1 {
        
    double area;
    Server1()
    {
        try
        {
            ServerSocket s1=new ServerSocket(4021);
            System.out.println("Server started");
            
                Socket s2=s1.accept();
                System.out.println("Local port number of socket"+s2.getLocalPort());
                DataInputStream d=new DataInputStream(s2.getInputStream());
                DataOutputStream o=new DataOutputStream(s2.getOutputStream());
                
                double radius=d.readDouble();
                area=3.14*radius*radius;
                o.writeDouble(area);
                d.close();
                o.close();
                s2.close();
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    public static  void main(String a[])
    {
        new Server1();
    }
}