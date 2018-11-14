package placementcell;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class test extends javax.swing.JFrame 
{
    ArrayList<csquestion> ldata=new ArrayList<>();
    int id, cid;
    public test() {
    }
     public test(int i,int c) {
        initComponents();
        id=i;
        cid=c;
        getdata();
       getContentPane().setBackground(Color.red);
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
            
            //ButtonGroup bg=new ButtonGroup();
            ButtonGroup bg=null;
            csquestion obj=new csquestion();
            while(rs.next())
            {
              
              obj.setQ1(rs.getString("qname"));
              obj.setO1(rs.getString("option1"));
              obj.setO2(rs.getString("option2"));
              obj.setO3(rs.getString("option3"));
              obj.setO4(rs.getString("option4"));
              obj.setCid(rs.getInt("cid"));
              obj.setCans(rs.getString("correctans"));
              obj.setId(rs.getInt("id"));
              obj.setUans("-1");
              ldata.add(obj);
              l1=new JLabel(rs.getString("qname"));
              bg=new ButtonGroup();
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
           op1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                   obj.setUans("a");
                }
            });
           op2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                   obj.setUans("b");
                }
            });
           op3.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                   obj.setUans("c");
                }
            });
           op4.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                   obj.setUans("d");
                }
            });
            JButton bsubmit=new JButton("submit");
            bsubmit.setBounds(x+20,y,20,h);
            add(bsubmit);
            
            bsubmit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try
                    {
                        data1();
                }
                    catch(Exception ae)
                    {
                        System.out.println(ae.getMessage());
                        JOptionPane.showMessageDialog(null,"attempt atleast one ");
                    }
            }
                void data1()
                {
                   csquestion obj2=null;
                   int cq=0,iq=0,uq=0;
                   for(int i=0;i<ldata.size();i++)
                   {
                       System.out.println(ldata.size());
                       obj2=(csquestion)ldata.get(i);
                       if(obj2.uans==obj2.cans)
                           cq++;
                       else if(obj2.uans=="-1")
                           uq++;
                       else if(  obj2.uans!=obj2.cans )
                           iq++;
                   
                   try
                   {
                       String q="insert into result(rollno,ans,createdat)values(?,?,?)";
                       PlacementCell obj1=new PlacementCell();
                       System.out.println("hello");
                       PreparedStatement pst=obj1.db.prepareStatement(q);
                       pst.setInt(1,id);
                       pst.setString(2,obj2.getUans());
                       Date d=new Date();
                       pst.setString(3,String.valueOf(d));
                       pst.executeUpdate();
                       
                   }
                   catch(Exception e)
                   {
                       System.out.println(e.getMessage());
                   }
                   }
                   try
                   {
                       String q="insert into tbresult(rno,cid,cans,ians,uans,createdate)values(?,?,?,?,?,?)";
                       PlacementCell obj1=new PlacementCell();
                       PreparedStatement pst=obj1.db.prepareStatement(q);
                       pst.setInt(1,id);
                       pst.setInt(2,cid);
                       pst.setInt(3,cq);
                       pst.setInt(4,iq);
                       pst.setInt(5,uq);
                       
                       Date f=new Date();
                       pst.setString(6,String.valueOf(f));
                       pst.executeUpdate();
                   }
                   catch(Exception e)
                   {
                       System.out.println(e.getMessage());
                   }
                }
            });
        }
        
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        button1 = new java.awt.Button();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(84, 40, 24));

        button1.setLabel("button1");
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/placementcell/download.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(441, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(124, 124, 124)
                .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(jLabel1)
                .addContainerGap(156, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed

    }//GEN-LAST:event_button1ActionPerformed
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new test().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button button1;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
