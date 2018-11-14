package placementcell;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

public class onlinetest extends javax.swing.JFrame {
    int r,cid;
    public onlinetest()
    {
       initComponents();
        getdata();   
    }
    public onlinetest(int rn,int id) {
        initComponents();
        //System.out.println("r s "+rn+" id s "+id);
        r=rn;
        cid=id;
        getdata();
    }
   public void getdata()
    {
        try
        {
            PlacementCell obj1=new PlacementCell();
            //String q="select s.fname from tbstudent s,tbcompany c where s.tenth>=c.tenth and s.twelveth>=c.twelveth and s.grad>=c.grad and ename=?";
            String q="select q.qname,q.option1,q.option2,q.option3,q.option4 from tbquestion q,tbstudent s,tbcompany c where s.tenth>=c.tenth and s.twelveth>=c.twelveth and s.grad>=c.grad and rno=? and q.cid=?";
            PreparedStatement pst=obj1.db.prepareStatement(q);
            pst.setInt(1,r);
            pst.setInt(2,cid);
             ResultSet rs;
            
            rs=pst.executeQuery();
            int x=10,y=20,w=200,h=40;
            
            JLabel l1;
            JRadioButton op1=null,op2=null,op3=null,op4=null;
            ButtonGroup bg=new ButtonGroup();
           while(rs.next())
           {
              l1=new JLabel(rs.getString("qname"));
              op1=new JRadioButton(rs.getString("option1"));
              op2=new JRadioButton(rs.getString("option2"));
              op3=new JRadioButton(rs.getString("option3"));
              op4=new JRadioButton(rs.getString("option4"));
              
               //l1.setText(rs.getString("qname"));
              l1.setBounds(x,y,w,h);          
              y=y+30;
              add(l1);
              bg.add(op1);
              bg.add(op2);
              bg.add(op3);
              bg.add(op4);
              op1.setBounds(x,y,w,h);
              y=y+30;
              op2.setBounds(x,y,w,h);
              y=y+30;
              op3.setBounds(x,y,w,h);
              y=y+30;
              op4.setBounds(x,y,w,h);
              y=y+30;
              add(op1);
              add(op2);
              add(op3);
              add(op4);
           }
           
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        
        onlinetest o=new onlinetest();
        o.setVisible(true);
        };
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

