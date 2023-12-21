
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
public class UserMyFollowing extends javax.swing.JFrame {

    /**
     * Creates new form UserMyFollowing
     */
    String user;

    public UserMyFollowing(String username) {
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

        jheading.setText(user + " Following");
        jScrollPane1.setSize(500, 400);
        Myfollowing();
    }

    public void Myfollowing() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {

                    HttpResponse<String> res = Unirest.get(Global.ipAddress + "userfollowing")
                            .queryString("username", user)
                            .asString();
                    if (res.getStatus() == 200) {
                        String response = res.getBody();

                        StringTokenizer st = new StringTokenizer(response, "~~");

                        int count = st.countTokens();
                        //int obj[]=new int[count];
                        int x = 10, y = 10;
                        UserMyFollowingPanelDesign obj[] = new UserMyFollowingPanelDesign[count];

                        mainPanel.removeAll();
                        mainPanel.repaint();
                        for (int i = 0; i < count; i++) {
                            final int a = i;
                            String userInfo = st.nextToken();
                            StringTokenizer st2 = new StringTokenizer(userInfo, ";;");
                            String username = st2.nextToken();
                            String photo = st2.nextToken();
                            String email = st2.nextToken();
                            String followerid = st2.nextToken();

                            System.out.println("useranme---->" + username);
                            System.out.println("photo---->" + photo);
                            System.out.println("email--->" + email);
                            System.out.println("followerid--->" + followerid);

                            obj[i] = new UserMyFollowingPanelDesign();

                            obj[i].jusername.setText(username);
                            obj[i].jphoto.setText(photo);
                            obj[i].jemail.setText(email);
                            try {
                            URL url = new URL(Global.ipAddress + "GetResource/" + photo);
                            //System.out.println("Path of Image Stored in server side--------------" + url);
                            BufferedImage img = ImageIO.read(url);
                            Image resizedimage = img.getScaledInstance(obj[i].jphoto.getWidth(), obj[i].jphoto.getHeight(), Image.SCALE_SMOOTH);
                            obj[i].jphoto.setIcon(new ImageIcon(resizedimage));

                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                            obj[i].jfollowing.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    try {
                                        HttpResponse<String> res = Unirest.get(Global.ipAddress + "removefollowing")
                                                .queryString("followerid", followerid)
                                                .asString();

                                        if (res.getStatus() == 200) {
                                            String response = res.getBody();
                                            if (response.equals("SUCCESS")) {
                                                Myfollowing();
                                                //JOptionPane.showMessageDialog(rootPane, "Follow Successfully");
                                                //obj[a].jfollowing.setText("Following");

                                            } else {
                                                JOptionPane.showMessageDialog(rootPane, "Unfollow Successfully");
                                                //obj[a].jfollowing.setText("Follow");
                                            }
                                        }

                                    } catch (Exception ex) {
                                        ex.printStackTrace();
                                    }

                                }
                            });
                            obj[i].setBounds(x, y, 450, 130);
                            mainPanel.add(obj[i]);
                            y += 150;
                            mainPanel.repaint();
                            obj[i].repaint();

                        }
                        mainPanel.setPreferredSize(new Dimension(450, count * 150));

                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }).start();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jheading = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        mainPanel = new javax.swing.JPanel();
        photolb = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        getContentPane().add(jheading);
        jheading.setBounds(200, 20, 120, 50);

        mainPanel.setBackground(new java.awt.Color(102, 255, 255));
        mainPanel.setLayout(null);
        jScrollPane1.setViewportView(mainPanel);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(100, 120, 450, 250);

        photolb.setText("jLabel1");
        getContentPane().add(photolb);
        photolb.setBounds(20, 30, 38, 16);

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(UserMyFollowing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserMyFollowing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserMyFollowing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserMyFollowing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserMyFollowing("").setVisible(true);
            }
        });

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jheading;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel photolb;
    // End of variables declaration//GEN-END:variables
}
