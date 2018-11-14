package placementcell;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

public class ques extends javax.swing.JFrame {
    public ques() {
        initComponents();
        getdata();
    }
    void getdata()
    {
        try
        {
            PlacementCell obj1=new PlacementCell();
            String q="select * from tbquestion";
            PreparedStatement pst=obj1.db.prepareStatement(q);
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
            .addGap(0, 457, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 333, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ques().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
