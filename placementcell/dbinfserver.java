package placementcell;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.PreparedStatement;

public class dbinfserver {
    
    String f,l,e,ad;
    Double con;
    
    dbinfserver()
    {
        try
        {
            ServerSocket ss=new ServerSocket(4021);
            Socket c1=ss.accept();
            
            System.out.println(ss.getLocalPort());   //why we use this??
            DataInputStream in=new DataInputStream(c1.getInputStream());
            DataOutputStream ou=new DataOutputStream(c1.getOutputStream());
            
            f=in.readUTF();
            l=in.readUTF();
            e=in.readUTF();
            con=in.readDouble();
            ad=in.readUTF();
            
            
            String q="insert into dbinfo(fname,lname,email,contact,address)values(?,?,?,?,?)";
            PlacementCell obj1=new PlacementCell();
            PreparedStatement pst=obj1.db.prepareStatement(q);
            pst.setString(1,f);
            pst.setString(2,l);
            pst.setString(3,e);
            pst.setDouble(4,con);
            pst.setString(5,ad);
            pst.executeUpdate();
            
            in.close();
            ou.close();
            c1.close();
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }  
    public static void main(String[] args) {   
        new dbinfserver();
    }
}