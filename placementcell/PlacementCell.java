package placementcell;

import java.sql.Connection;
import java.sql.DriverManager;

public class PlacementCell {
    Connection db;
PlacementCell()
{
    try
    {
    db=DriverManager.getConnection("jdbc:mysql://localhost/dbPlacementCell","root","");
    }
    catch(Exception e)
    {
        System.out.println(e.getMessage());
    }
}
}