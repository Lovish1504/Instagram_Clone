
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.HttpResponse;
import java.awt.*;
import java.io.File;
import javax.swing.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Lovish_Arora
 */
public class UserSignUpFrame extends javax.swing.JFrame {

    /**
     * Crea
     * tes new form UserSignUpFrame
     */
    File f;
    
    public UserSignUpFrame() {
        initComponents();
        
        Dimension d = new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
        System.out.println(d);
        ImageIcon i1 = new ImageIcon("src/uploads/instapicbg.jpg");
//        Image img = i1.getImage().getScaledInstance(photolb.getWidth(), photolb.getHeight(), Image.SCALE_SMOOTH);
        Image img = i1.getImage().getScaledInstance(d.width, d.height, Image.SCALE_SMOOTH);
        photolb.setBounds(0, 0, d.width, d.height);
        ImageIcon i2 = new ImageIcon(img);
        photolb.setIcon(i2);

//        getContentPane().setBackground(Color.blue);
        setSize(d.width, d.height);
        setVisible(true);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    
        
       }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jusername = new javax.swing.JTextField();
        jemail = new javax.swing.JTextField();
        jpassword = new javax.swing.JPasswordField();
        jconfirmpass = new javax.swing.JPasswordField();
        jphone = new javax.swing.JTextField();
        jmale = new javax.swing.JRadioButton();
        jfemale = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jPhoto = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        photolb = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setBackground(new java.awt.Color(255, 204, 204));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 51));
        jLabel1.setText("Welcome To Instagram");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(200, 20, 170, 30);

        jLabel2.setBackground(new java.awt.Color(255, 204, 204));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("SIGN UP HERE!");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(230, 50, 90, 30);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel3.setText("Username");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(130, 80, 100, 30);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel4.setText("E-mail");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(130, 120, 100, 30);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel5.setText("Password");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(130, 160, 100, 30);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel6.setText("Confirm Password");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(130, 200, 100, 30);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel7.setText("Phone Number");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(130, 240, 100, 30);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel8.setText("Gender");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(130, 280, 100, 30);

        jusername.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        getContentPane().add(jusername);
        jusername.setBounds(260, 80, 200, 30);

        jemail.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jemail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jemailActionPerformed(evt);
            }
        });
        getContentPane().add(jemail);
        jemail.setBounds(260, 120, 200, 30);

        jpassword.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jpassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jpasswordActionPerformed(evt);
            }
        });
        getContentPane().add(jpassword);
        jpassword.setBounds(260, 160, 200, 30);

        jconfirmpass.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jconfirmpass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jconfirmpassActionPerformed(evt);
            }
        });
        getContentPane().add(jconfirmpass);
        jconfirmpass.setBounds(260, 200, 200, 30);

        jphone.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jphone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jphoneActionPerformed(evt);
            }
        });
        getContentPane().add(jphone);
        jphone.setBounds(260, 240, 200, 30);

        buttonGroup1.add(jmale);
        jmale.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jmale.setText("Male");
        getContentPane().add(jmale);
        jmale.setBounds(260, 280, 70, 30);

        buttonGroup1.add(jfemale);
        jfemale.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jfemale.setText("Female");
        getContentPane().add(jfemale);
        jfemale.setBounds(380, 280, 80, 30);

        jButton1.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jButton1.setText("Click here to choose Photo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(130, 330, 330, 30);
        getContentPane().add(jPhoto);
        jPhoto.setBounds(170, 370, 230, 140);

        jButton2.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jButton2.setText("Sign Up");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(310, 520, 120, 30);

        photolb.setText("jLabel9");
        getContentPane().add(photolb);
        photolb.setBounds(10, 20, 38, 16);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jemailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jemailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jemailActionPerformed

    private void jpasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jpasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jpasswordActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
     JFileChooser chooser = new JFileChooser();
     int ans= chooser.showOpenDialog(this);
     if (ans ==JFileChooser.APPROVE_OPTION){
         f = chooser.getSelectedFile();
         ImageIcon icon =new ImageIcon(f.getPath());
         Image resizedImage=icon.getImage().getScaledInstance(jPhoto.getWidth(),jPhoto.getHeight(),Image.SCALE_AREA_AVERAGING);
         jPhoto.setIcon(new ImageIcon(resizedImage));
         
     }
       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       String username=jusername.getText();
       String email=jemail.getText();
       String password=jpassword.getText();
       String confirmpassword=jconfirmpass.getText();
       String phoneno=jphone.getText();
       String gender="";
       if(jmale.isSelected())
       {
           gender="Male";
       }
       else if(jfemale.isSelected())
               {
                   gender="Female";
               }
      if(username.equals("") || email.isEmpty() || phoneno.isEmpty() || password.isEmpty() || confirmpassword.isEmpty() || gender.isEmpty())
              {
              JOptionPane.showMessageDialog(this,"All fields are mendatory");
              }
      else if(f==null)
        {
              JOptionPane.showMessageDialog(this,"Please select a photo");
        }
      else if(email.indexOf("@")==-1)
      {
            JOptionPane.showMessageDialog(this,"Please enter a valid email address");
      }
      else if(phoneno.length()!=10)
      {
            JOptionPane.showMessageDialog(this,"Please enetr a valid phone number");
      }
      else if(!(password.equals(confirmpassword)))
      {
            JOptionPane.showMessageDialog(this,"Password and confirm password does not match");
      }
      else 
    {
        //send unirest post request to server..
        try
       {
           
           HttpResponse<String> res=Unirest.post("http://localhost:8999/usersignupframe")
                   .queryString("username",username)
                      .queryString("email",email)
                      .queryString("password",password)
                       .queryString("confirm password",confirmpassword)
                      .queryString("phone no",phoneno)
                     .queryString("gender",gender)
                   .field("photo",f)
                   .asString();
            if(res.getStatus()==200)
        {
            String response=res.getBody();
            System.out.println("response"+ response);
            if(response.equals("SUCCESS"))
            {
            JOptionPane.showMessageDialog(this,"Sign up sucess");
            }
            //UserLoginFrame obj = new UserLoginFrame(usern);
            else
            {
                JOptionPane.showMessageDialog(this,"Username already exists\nPlease sign up from a different username");
            }
        }
            }
       catch(Exception e)
       {
           e.printStackTrace();
       }
        }
       
       
       //send unirest post request to server
        
        
        
        //unirest post request to server
        
        
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jconfirmpassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jconfirmpassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jconfirmpassActionPerformed

    private void jphoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jphoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jphoneActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(UserSignUpFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserSignUpFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserSignUpFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserSignUpFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserSignUpFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jPhoto;
    private javax.swing.JPasswordField jconfirmpass;
    private javax.swing.JTextField jemail;
    private javax.swing.JRadioButton jfemale;
    private javax.swing.JRadioButton jmale;
    private javax.swing.JPasswordField jpassword;
    private javax.swing.JTextField jphone;
    private javax.swing.JTextField jusername;
    private javax.swing.JLabel photolb;
    // End of variables declaration//GEN-END:variables
}