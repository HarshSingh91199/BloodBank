
package bloodbank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


public class search2 extends javax.swing.JFrame {

    search i= new search();
    String w=i.y;

    public search2()
    {
       initComponents();
       if(w.equals("r1"))
       {
           l1.setText("Enter No");
           t0.setVisible(true);
           dd1.setVisible(false);
           jp1.setVisible(false);
       
       }
       else if(w.equals("r2"))
       {
           l1.setText("Enter Name");
           t0.setVisible(true);
           dd1.setVisible(false);
           jp1.setVisible(false);
          
       }
       else if(w.equals("r3"))
       {
           l1.setText("Enter Group No");
           t0.setVisible(false);
           dd1.setVisible(true);
          jp1.setVisible(false);
       
           
       }
        else
       {
           l1.setText("Enter Date");
           jp1.setVisible(true);
           t0.setVisible(false);
           dd1.setVisible(false);
           
       }
        setLocationRelativeTo(null);
    }
void no() 
{   String r;
     if(w.equals("r1")){
     r=t0.getText();
     }
     else if(w.equals("r2")){
         r=t0.getText();
     }
     else if(w.equals("r3")){
          r = dd1.getSelectedItem().toString();
     }
     else
       {
         java.util.Date oDate =   jp1.getDate();        
         DateFormat oDateFormat = new SimpleDateFormat("dd-MM-YYYY");
         r = oDateFormat.format(oDate);
       }

try
{
Class.forName("com.mysql.cj.jdbc.Driver");
             System.out.println("hiii8");
 Connection cn= DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodbank","root","root");
DefaultTableModel d1=(DefaultTableModel)table.getModel();
String sn = null;
String k=null;
if(w.equals("r1"))
{
  
  sn="select * from newdonor where Donor_id="+r;
  
  }
  else if(w.equals("r2"))
     {
            
             sn="select * from newdonor where Donor_name='"+r+"'"; 
          }
   else if(w.equals("r3"))
          {
             sn="select * from newdonor where Blood_grp='"+r+"'"; 
          }
  else if(w.equals("r4"))
          {
             sn="select * from newdonor where Join_date='"+r+"'"; 
          }

PreparedStatement smt=cn.prepareStatement(sn);
ResultSet rs=smt.executeQuery();
while(rs.next())
{
    
String a1=rs.getString(1);
String a2=rs.getString(2);
String a3=rs.getString(3);
String a4=rs.getString(4);
String a5=rs.getString(5);
String a6=rs.getString(6);
String a7=rs.getString(7);
String a8=rs.getString(8);
String a9=rs.getString(9);

Object pc[]={a1,a2,a3,a4,a5,a6,a7,a8,a9};
d1.addRow(pc);

}      
}
catch(Exception e)
{
System.out.println(e);
}

}
    

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        l1 = new javax.swing.JLabel();
        t0 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        dd1 = new javax.swing.JComboBox();
        jp1 = new org.jdesktop.swingx.JXDatePicker();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Donor_ID", "Name", "Blood Group", "Gender", "Date", "Country", "City", "Mobile", "Age"
            }
        ));
        table.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setViewportView(table);

        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        l1.setText("Enter name to search");

        jButton2.setText("Cancel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        dd1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "A+", "B+", "AB+", "O+", "A-", "B-", "AB-", "O-" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 848, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(155, 155, 155)
                        .addComponent(l1)
                        .addGap(18, 18, 18)
                        .addComponent(t0, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jp1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dd1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addGap(82, 82, 82)
                        .addComponent(jButton2)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(l1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(t0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(dd1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jp1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 97, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
this.no(); 

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       first obj=new first();
        obj.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(search2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(search2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(search2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(search2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new search2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox dd1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private org.jdesktop.swingx.JXDatePicker jp1;
    private javax.swing.JLabel l1;
    private javax.swing.JTextField t0;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables

    private Object getSelectedItem() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
