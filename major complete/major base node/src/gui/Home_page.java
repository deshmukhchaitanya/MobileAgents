package gui;
import control.controller;
import java.io.*;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import network.server;

public class Home_page extends javax.swing.JFrame {
    public static int op;
    public Home_page() {
            initComponents();
           
            count_chk.setVisible(false);
            retrv_chk.setVisible(false);
            nw_task_chk.setVisible(false);
            create_task_btn.setVisible(false);
            Result_btn.setVisible(false);
            dep_btn.setVisible(false);
            Status_btn.setVisible(false);
            dep_btn.setEnabled(false);
            lgout_btn.setVisible(false);

        }
    public static int statusflg=0;
    public static int statusflg1=0;

    @Override
    public void setEnabled(boolean bln) {
        super.setEnabled(bln);
    }


    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jDialog2 = new javax.swing.JDialog();
        jFrame1 = new javax.swing.JFrame();
        jFrame2 = new javax.swing.JFrame();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lgout_btn = new javax.swing.JButton();
        Destinatn_btn = new javax.swing.JButton();
        create_task_btn = new javax.swing.JButton();
        help_btn = new javax.swing.JButton();
        dep_btn = new javax.swing.JButton();
        count_chk = new javax.swing.JRadioButton();
        retrv_chk = new javax.swing.JRadioButton();
        nw_task_chk = new javax.swing.JRadioButton();
        Result_btn = new javax.swing.JButton();
        Status_btn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDialog2Layout = new javax.swing.GroupLayout(jDialog2.getContentPane());
        jDialog2.getContentPane().setLayout(jDialog2Layout);
        jDialog2Layout.setHorizontalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog2Layout.setVerticalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrame2Layout = new javax.swing.GroupLayout(jFrame2.getContentPane());
        jFrame2.getContentPane().setLayout(jFrame2Layout);
        jFrame2Layout.setHorizontalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame2Layout.setVerticalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SDEE");

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jLabel1.setText("HOME PAGE");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 12));
        jLabel2.setText("WELCOME  USER...");

        lgout_btn.setText("Log Out");
        lgout_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lgout_btnActionPerformed(evt);
            }
        });

        Destinatn_btn.setText("Enter Destination");
        Destinatn_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Destinatn_btnActionPerformed(evt);
            }
        });

        create_task_btn.setText("Create Task");
        create_task_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                create_task_btnActionPerformed(evt);
            }
        });

        help_btn.setText("Help");
        help_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                help_btnActionPerformed(evt);
            }
        });

        dep_btn.setText("Deploy");
        dep_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dep_btnActionPerformed(evt);
            }
        });

        count_chk.setText("Count");
        count_chk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                count_chkActionPerformed(evt);
            }
        });

        retrv_chk.setText("Retrieve");
        retrv_chk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                retrv_chkActionPerformed(evt);
            }
        });

        nw_task_chk.setText("New Task");
        nw_task_chk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nw_task_chkActionPerformed(evt);
            }
        });

        Result_btn.setText("Result");
        Result_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Result_btnActionPerformed(evt);
            }
        });

        Status_btn.setText("Status");
        Status_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Status_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(288, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(create_task_btn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Destinatn_btn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(Status_btn)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(help_btn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Result_btn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(retrv_chk)
                            .addComponent(count_chk)
                            .addComponent(nw_task_chk))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(dep_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lgout_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(lgout_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(Destinatn_btn)
                        .addGap(18, 18, 18)
                        .addComponent(create_task_btn)
                        .addGap(44, 44, 44))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(retrv_chk)
                        .addComponent(dep_btn)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(count_chk)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nw_task_chk))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(Status_btn)))
                .addGap(18, 18, 18)
                .addComponent(Result_btn)
                .addGap(10, 10, 10)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(help_btn)
                .addGap(45, 45, 45))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void Destinatn_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Destinatn_btnActionPerformed
            //create_task_btn.setVisible(true);
            enters_destinatn ed=new enters_destinatn();
            ed.setVisible(true);
    }//GEN-LAST:event_Destinatn_btnActionPerformed
    public static String name;
    private void retrv_chkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_retrv_chkActionPerformed
       op=1;
       count_chk.setEnabled(false);
       nw_task_chk.setEnabled(false);
       ext ex1=new ext();
       ex1.jButton1.setEnabled(false);
       ex1.setVisible(true);
       name="Retrieve";
       retrv_chk.setEnabled(false);

    }//GEN-LAST:event_retrv_chkActionPerformed

    private void create_task_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_create_task_btnActionPerformed
            count_chk.setVisible(true);
            retrv_chk.setVisible(true);
            nw_task_chk.setVisible(true);
            dep_btn.setVisible(true);
            create_task_btn.setEnabled(false);
            
            
    }//GEN-LAST:event_create_task_btnActionPerformed

    private void dep_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dep_btnActionPerformed
            statusflg1=2;

            Status_btn.setVisible(true);
            
        try {

            // only for base part
            
            controller.forward();
            
            //Result_btn.setVisible(true);
            server.call();

        } catch (IOException ex) {
            Logger.getLogger(Home_page.class.getName()).log(Level.SEVERE, null, ex);
        }
            dep_btn.setEnabled(false);
    }//GEN-LAST:event_dep_btnActionPerformed

    public static String sname;
    private void Status_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Status_btnActionPerformed
          if(statusflg==1)
          {
              disp_status ds1=new disp_status();
              ds1.setVisible(true);
              disp_status.jLabel2.setVisible(false);
              disp_status.jLabel4.setVisible(false);
              disp_status.jLabel7.setVisible(true);
          }
          else
          {
              disp_status ds1=new disp_status();
              ds1.setVisible(true);
          }
    }//GEN-LAST:event_Status_btnActionPerformed

    private void nw_task_chkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nw_task_chkActionPerformed
       count_chk.setEnabled(false);
       retrv_chk.setEnabled(false);
       new_tsk nt=new new_tsk();
       nt.setVisible(true);
       nw_task_chk.setEnabled(false);

    }//GEN-LAST:event_nw_task_chkActionPerformed

    private void help_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_help_btnActionPerformed
          Help_pg hp=new Help_pg();
          hp.setVisible(true);


    }//GEN-LAST:event_help_btnActionPerformed
public static int flag;
    private void count_chkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_count_chkActionPerformed
       op=2;
       name="Count";
       flag=1;
       ext ex1=new ext();
       ex1.jTextField1.setEditable(false);
       ex1.jTextField1.setText("txt");
       ex1.setVisible(true);
       
       retrv_chk.setEnabled(false);
       nw_task_chk.setEnabled(false);
       count_chk.setEnabled(false);
       
       
       
    }//GEN-LAST:event_count_chkActionPerformed
    
    public static int n;
    public static int ts1[];
    public static void result() throws UnknownHostException, IOException
    {
        //no of ip
         n=enters_destinatn.r_count();
         int ts[]= new int[n];
         ts1=ts;
         System.out.println("n"+n);
         String searchText[] = new String[n];
        
        byte b[]=enters_destinatn.destIP();

        byte temp1[]=new byte[4];
        //System.arraycopy(b, 0, temp, 0,temp.length);
        int a=4;
        int b1=0;
        for(int i=0;i<n;i++)
        {
            System.arraycopy(b, b1, temp1, 0, a);
            a=+4;
            b1=+4;
            InetAddress ad1=InetAddress.getByAddress(temp1);
            //searchText[i]=new String(temp1,"UTF-8");
            searchText[i]=ad1.getHostAddress();
            //System.out.println(searchText[i]);
        }
        String fileName = "output.txt";
        //StringBuilder allows to create a string by concatinating
        /// strings efficiently.
        StringBuilder sb = new StringBuilder();
        try {
                //Create the buffered input stream, which reads
                //from a file input stream
                BufferedInputStream bIn = new BufferedInputStream(new FileInputStream(fileName));
                //Holds the position of the last byte we have read
                int pos = 0;

                //Holds #of available bytes in our stream
                //(which is the file)
                int avl = bIn.available();

                //Read as long as we have something
                while ( avl != 0 )
                {

                    //Holds the bytes which we read
                    byte[] buffer = new byte[avl];

                    //Read from the file to the buffer
                    // starting from <pos>, <avl> bytes.
                    bIn.read(buffer, pos, avl);

                    //Update the last read byte position
                    pos += avl;

                    //Create a new string from byte[] we read
                    String strTemp = new String(buffer);

                    //Append the string to the string builder
                    sb.append(strTemp);

                    //Get the next available set of bytes
                    avl = bIn.available();
                }
            }
        catch(IOException ex)
        {
        }
        //Get the concatinated string from string builder
        String fileText = sb.toString();

        int j=0;
        for(int i=0;i<n;i++)
        {
            int a1=fileText.indexOf(searchText[i]);
            String str1=fileText.substring(j, a1);
            FileWriter fstream = new FileWriter(searchText[i]+"."+ext.ext_nm);
            BufferedWriter out = new BufferedWriter(fstream);
            out.write(str1);
            int c=searchText[i].length();
            ts[i]=str1.compareTo("file not found");
            out.close();
            j=j+(a1-j)+c;
        }
        //System.out.println("enable1");
        //System.in.read();
        Result_btn.setVisible(true);
        
        
        //System.exit(1);


    }
     public static String res;
    private void Result_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Result_btnActionPerformed

      res="true";
      lgout_btn.setVisible(true);
        
      disp_res ds1=new disp_res();
      ds1.setVisible(true);

    }//GEN-LAST:event_Result_btnActionPerformed

    private void lgout_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lgout_btnActionPerformed
        // TODO add your handling code here:
    System.exit(1);
    }//GEN-LAST:event_lgout_btnActionPerformed

    
    /*public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home_page().setVisible(true);
            }
        });
    }*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton Destinatn_btn;
    public static javax.swing.JButton Result_btn;
    private javax.swing.JButton Status_btn;
    private javax.swing.JRadioButton count_chk;
    public static javax.swing.JButton create_task_btn;
    public static javax.swing.JButton dep_btn;
    private javax.swing.JButton help_btn;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JFrame jFrame2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton lgout_btn;
    private javax.swing.JRadioButton nw_task_chk;
    private javax.swing.JRadioButton retrv_chk;
    // End of variables declaration//GEN-END:variables

}
