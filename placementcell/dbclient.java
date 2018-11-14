package placementcell;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class dbclient {

    double hra, ta, da, sal, netsal;

    public dbclient() {
        try {
            Socket c = new Socket("127.0.0.1", 4021);
            Scanner s1 = new Scanner(System.in);
            System.out.println("sal,ta,da,hra");
            sal = s1.nextDouble();
            ta = s1.nextDouble();
            da = s1.nextDouble();
            hra = s1.nextDouble();

            DataInputStream f = new DataInputStream(c.getInputStream());
            DataOutputStream to = new DataOutputStream(c.getOutputStream());

            to.writeDouble(sal);
            to.writeDouble(hra);
            to.writeDouble(ta);
            to.writeDouble(da);

            f.close();
            to.close();
            c.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public static void main(String args[]) {
        new dbclient();
    }
}
