package placementcell;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;


public class dbinfclient {
    
    String fn,ln,em,add;
    Double con;
    
    dbinfclient()
    {
        try
        {
        Scanner s1=new Scanner(System.in);
        Socket c=new Socket("127.0.0.1", 4021);
        System.out.println("enter first,last name,email,contact,address");
        fn=s1.next();
        ln=s1.next();
        em=s1.next();
        con=s1.nextDouble();
        add=s1.next();
        
        DataInputStream in=new DataInputStream(c.getInputStream());
        DataOutputStream ou=new DataOutputStream(c.getOutputStream());
        
        ou.writeUTF(fn);
        ou.writeUTF(ln);
        ou.writeUTF(em);
        ou.writeDouble(con);
        ou.writeUTF(add);
        
        in.close();
        ou.close();
        c.close();
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    public static void main(String[] args) {
        new dbinfclient();
    }
}
