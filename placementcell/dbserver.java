package placementcell;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class dbserver {
    
     double sal,netsal,hra,ta,da;
      dbserver()
    {
        try
        {
            ServerSocket s1=new ServerSocket(4021);
            System.out.println("Server started");
            
                Socket s2=s1.accept();
                System.out.println("Local port number of socket"+s2.getLocalPort());
                DataInputStream d=new DataInputStream(s2.getInputStream());
                DataOutputStream o=new DataOutputStream(s2.getOutputStream());
                
                sal=d.readDouble();
                hra=d.readDouble();
                ta=d.readDouble();
                da=d.readDouble();
                
                netsal=netsal=(sal+(sal*ta/100)+(sal*da/100)+sal*hra/100);
          
                String q="insert into empsal(hra,ta,da,netsal)values(?,?,?,?)";
           PlacementCell obj1=new PlacementCell();
           PreparedStatement pst=obj1.db.prepareStatement(q);
           pst.setDouble(1,hra);
           pst.setDouble(2,ta);
           pst.setDouble(3,da);
           pst.setDouble(4,netsal);
           pst.executeUpdate();
                
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
        new dbserver();
    }
}