
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.StringTokenizer;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author Lovish_Arora
 */
public class UserHomeFrame extends javax.swing.JFrame {

    /**
     * Creates new form UserHomeFrame
     */
    String user;
    int postid;

    public UserHomeFrame(String username) {
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

        user = username;
        jwelcome.setText("Welcome " + user);
        showfollowerposts();

    }

    public void showfollowerposts() {

        try {
            HttpResponse<String> res = Unirest.get("http://localhost:8999/fetchfollowingpost")
                    .queryString("username", user)
                    .asString();
            if (res.getStatus() == 200) //server working correctly
            {
                String response = res.getBody();
                System.out.println("Response is ----->" + response);
                if (response.equals("success")) {
                    JOptionPane.showMessageDialog(this, "");

                } else {
                    System.out.println("Respnse is" + response);

                    StringTokenizer st = new StringTokenizer(response, "~~");
                    int count = st.countTokens();
                    MainPanel.setPreferredSize(new Dimension(800, count * 280));
                    userhomeposts obj[] = new userhomeposts[count];
                    int x = 10, y = 10;
                    MainPanel.removeAll();
                    for (int i = 0; i < count; i++) {
                        String userinfo = st.nextToken();
                        StringTokenizer st2 = new StringTokenizer(userinfo, ";;");
                        String user = st2.nextToken();
                        int post_id = Integer.parseInt(st2.nextToken());
                        String date_time = st2.nextToken();
                        String caption = st2.nextToken();
                        String photo = st2.nextToken();
                        String status = st2.nextToken();

                        String count_like = st2.nextToken();
                        //  postid = Integer.parseInt(post_id);
                        System.out.println("caption--------" + caption);
                        System.out.println("Photo------------" + photo);

                        System.out.println("postid------------" + post_id);
                        obj[i] = new userhomeposts();
                        obj[i].jcaption.setText(caption);
                        obj[i].jphoto.setText(photo);
                        obj[i].jcount.setText(count_like);
                        obj[i].jusername.setText(user);
                        try {
                            URL url = new URL(Global.ipAddress + "GetResource/" + photo);
                            //System.out.println("Path of Image Stored in server side--------------" + url);
                            BufferedImage img = ImageIO.read(url);
                            Image resizedimage = img.getScaledInstance(obj[i].jphoto.getWidth(), obj[i].jphoto.getHeight(), Image.SCALE_SMOOTH);
                            obj[i].jphoto.setIcon(new ImageIcon(resizedimage));

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        obj[i].jlike.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {

//                            super.mouseClicked(e); //To change body of generated methods, choose Tools | Templates.
                                try {

                                    HttpResponse<String> httpResponse = Unirest.get(Global.ipAddress + "likepost")
                                            .queryString("postid", post_id)
                                            .queryString("username", user)
                                            .asString();

                                    if (httpResponse.getStatus() == 200) {
                                        String ans = httpResponse.getBody();
                                        System.out.println(ans);
                                        JOptionPane.showMessageDialog(rootPane, ans);
                                        showfollowerposts();
                                    }
                                } catch (Exception ex) {
                                    ex.printStackTrace();
                                }
                            }

                        });

                        //your code goes here 
                        obj[i].addMouseListener(new MouseAdapter() {
                            public void mouseClicked(MouseEvent e) {
//                            super.mouseClicked(e); //To change body of generated methods, choose Tools | Templates.
                                System.out.println("------------------------------postid---" + postid);
                                User_Show_Stories obj = new User_Show_Stories(post_id);
                            }

                        }
                        );

                        obj[i].setBounds(x, y, 400, 250);
                        MainPanel.add(obj[i]);
                        y += 280;
                    }
                    MainPanel.repaint();  //refresh
                    repaint();
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jwelcome = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jeditprofile = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jmyfollowers = new javax.swing.JButton();
        jmyfollowing = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        MainPanel = new javax.swing.JPanel();
        photolb = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jwelcome.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jwelcome.setForeground(new java.awt.Color(255, 51, 51));
        getContentPane().add(jwelcome);
        jwelcome.setBounds(200, 20, 260, 30);

        jButton1.setBackground(new java.awt.Color(255, 204, 204));
        jButton1.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jButton1.setText("Change Password");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(200, 60, 150, 50);

        jeditprofile.setBackground(new java.awt.Color(255, 204, 204));
        jeditprofile.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jeditprofile.setText("Edit Profile");
        jeditprofile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jeditprofileActionPerformed(evt);
            }
        });
        getContentPane().add(jeditprofile);
        jeditprofile.setBounds(200, 140, 150, 50);

        jButton2.setBackground(new java.awt.Color(255, 204, 204));
        jButton2.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jButton2.setText("Search User");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(200, 220, 150, 50);

        jmyfollowers.setBackground(new java.awt.Color(255, 204, 204));
        jmyfollowers.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jmyfollowers.setText("My Followers");
        jmyfollowers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmyfollowersActionPerformed(evt);
            }
        });
        getContentPane().add(jmyfollowers);
        jmyfollowers.setBounds(200, 300, 150, 50);

        jmyfollowing.setBackground(new java.awt.Color(255, 204, 204));
        jmyfollowing.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jmyfollowing.setText("My Following");
        jmyfollowing.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmyfollowingActionPerformed(evt);
            }
        });
        getContentPane().add(jmyfollowing);
        jmyfollowing.setBounds(200, 380, 150, 50);

        jButton3.setBackground(new java.awt.Color(255, 204, 204));
        jButton3.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jButton3.setText("Add Post");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(200, 460, 150, 50);

        MainPanel.setBackground(new java.awt.Color(153, 255, 255));
        MainPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        MainPanel.setLayout(null);
        jScrollPane1.setViewportView(MainPanel);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(390, 60, 730, 580);

        photolb.setText("jLabel1");
        getContentPane().add(photolb);
        photolb.setBounds(30, 40, 38, 16);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        UserChangePasswordFrame obj = new UserChangePasswordFrame(user);
        obj.setVisible(true);

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jeditprofileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jeditprofileActionPerformed
        // TODO add your handling code here:
        UserEditFrame obj = new UserEditFrame(user);
    }//GEN-LAST:event_jeditprofileActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        UserSearchFrame obj = new UserSearchFrame(user);
        obj.setVisible(true);

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jmyfollowersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmyfollowersActionPerformed
        // TODO add your handling code here:

        UserMyFollowers obj = new UserMyFollowers(user);
        obj.setVisible(true);


    }//GEN-LAST:event_jmyfollowersActionPerformed

    private void jmyfollowingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmyfollowingActionPerformed
        // TODO add your handling code here:
        UserMyFollowing obj = new UserMyFollowing(user);
        obj.setVisible(true);

    }//GEN-LAST:event_jmyfollowingActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        UserAddPost obj = new UserAddPost(user);
        obj.setVisible(true);

    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(UserHomeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserHomeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserHomeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserHomeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserHomeFrame("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel MainPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jeditprofile;
    private javax.swing.JButton jmyfollowers;
    private javax.swing.JButton jmyfollowing;
    private javax.swing.JLabel jwelcome;
    private javax.swing.JLabel photolb;
    // End of variables declaration//GEN-END:variables
}
