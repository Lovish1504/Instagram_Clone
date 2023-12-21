
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.StringTokenizer;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
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
public class UserAddPost extends javax.swing.JFrame {

    /**
     * Creates new form UserAddPost
     */
    File f;
    String user;
    BufferedImage img, changedimg;
    Image resizedImage;
    JFileChooser chooser = new JFileChooser();

    public UserAddPost(String username) {
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
        user = username;
        // System.out.println("username--->");
        showpost();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    }

    void showpost() {

        //send unirest get request on a resource getallposts
        //with username
        //receive response
        try {
            HttpResponse<String> res = Unirest.get(Global.ipAddress + "getallpost")
                    .queryString("username", user)
                    .asString();
            if (res.getStatus() == 200)//server working correctly
            {

                String response = res.getBody();
                System.out.println("Response is -------->" + response);
                if (response.equals("SUCCESS")) {
                    JOptionPane.showMessageDialog(rootPane, "Post Added Successfully");
                } else {
                    System.out.println("Response is ---->" + response);
                    StringTokenizer st = new StringTokenizer(response, "~~");
                    int count = st.countTokens();
                    mainPanel.setPreferredSize(new Dimension(800, count * 250));
                    AddPostPanelDesign obj[] = new AddPostPanelDesign[count];
                    int x = 10, y = 10;
                    mainPanel.removeAll();
                    for (int i = 0; i < count; i++) {
                        String userinfo = st.nextToken();
                        StringTokenizer st2 = new StringTokenizer(userinfo, ";;");
                        String caption = st2.nextToken();
                        String photo = st2.nextToken();
                        String postid = st2.nextToken();
                        String date_time = st2.nextToken();

                        System.out.println("caption------>" + caption);
                        System.out.println("photo------>" + photo);
                        System.out.println("date_time------>" + date_time);

                        obj[i] = new AddPostPanelDesign();
                        obj[i].jcaption.setText(caption);
                        obj[i].jphoto.setText(photo);
                        obj[i].date_time.setText(date_time);
                        try {
                            URL url = new URL(Global.ipAddress + "GetResource/" + photo);
                            //System.out.println("Path of Image Stored in server side--------------" + url);
                            BufferedImage img = ImageIO.read(url);
                            Image resizedimage = img.getScaledInstance(obj[i].jphoto.getWidth(), obj[i].jphoto.getHeight(), Image.SCALE_SMOOTH);
                            obj[i].jphoto.setIcon(new ImageIcon(resizedimage));

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        obj[i].jaddstory.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                //your code goes here
                                UserAddStory obj = new UserAddStory(postid);
                                obj.setVisible(true);

                            }
                            //public void 
                        });
                        obj[i].setBounds(x, y, 700, 200);
                        mainPanel.add(obj[i]);
                        y += 230;

                    }
                    mainPanel.repaint();
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

        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jcaption = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        mainPanel = new javax.swing.JPanel();
        jblur = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jbrighter = new javax.swing.JButton();
        jdarker = new javax.swing.JButton();
        jgrayscale = new javax.swing.JButton();
        jphoto = new javax.swing.JLabel();
        jhefe = new javax.swing.JButton();
        jlofi = new javax.swing.JButton();
        jnashville = new javax.swing.JButton();
        jnofilter = new javax.swing.JButton();
        jwalden = new javax.swing.JButton();
        photolb = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 51, 51));
        jLabel2.setText("Add Post Here!");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(160, 20, 260, 60);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        jLabel1.setText("Photo");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(50, 150, 80, 30);

        jButton1.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        jButton1.setText("Browse");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(32, 220, 90, 30);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        jLabel3.setText("Caption");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(70, 510, 80, 30);

        jcaption.setColumns(20);
        jcaption.setRows(5);
        jScrollPane1.setViewportView(jcaption);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(200, 480, 234, 86);

        jButton2.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        jButton2.setText("Add Post");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(230, 590, 110, 40);

        mainPanel.setBackground(new java.awt.Color(102, 255, 255));
        mainPanel.setLayout(null);
        jScrollPane2.setViewportView(mainPanel);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(470, 20, 470, 610);

        jblur.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jblur.setForeground(new java.awt.Color(255, 0, 0));
        jblur.setText("Blur ");
        jblur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jblurActionPerformed(evt);
            }
        });
        getContentPane().add(jblur);
        jblur.setBounds(60, 310, 100, 30);

        jButton3.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jButton3.setText("Save Changes");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(60, 430, 150, 40);

        jbrighter.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jbrighter.setForeground(new java.awt.Color(255, 0, 0));
        jbrighter.setText("Brighter");
        jbrighter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbrighterActionPerformed(evt);
            }
        });
        getContentPane().add(jbrighter);
        jbrighter.setBounds(200, 310, 100, 30);

        jdarker.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jdarker.setForeground(new java.awt.Color(255, 0, 0));
        jdarker.setText("Darker ");
        jdarker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jdarkerActionPerformed(evt);
            }
        });
        getContentPane().add(jdarker);
        jdarker.setBounds(340, 310, 100, 30);

        jgrayscale.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jgrayscale.setForeground(new java.awt.Color(255, 0, 0));
        jgrayscale.setText("Gray Scale ");
        jgrayscale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jgrayscaleActionPerformed(evt);
            }
        });
        getContentPane().add(jgrayscale);
        jgrayscale.setBounds(60, 350, 100, 30);
        getContentPane().add(jphoto);
        jphoto.setBounds(180, 100, 260, 190);

        jhefe.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jhefe.setForeground(new java.awt.Color(255, 0, 0));
        jhefe.setText("Hefe ");
        jhefe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jhefeActionPerformed(evt);
            }
        });
        getContentPane().add(jhefe);
        jhefe.setBounds(340, 350, 100, 30);

        jlofi.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jlofi.setForeground(new java.awt.Color(255, 0, 0));
        jlofi.setText("LoFi");
        jlofi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jlofiActionPerformed(evt);
            }
        });
        getContentPane().add(jlofi);
        jlofi.setBounds(60, 390, 100, 30);

        jnashville.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jnashville.setForeground(new java.awt.Color(255, 0, 0));
        jnashville.setText("Nashville");
        jnashville.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jnashvilleActionPerformed(evt);
            }
        });
        getContentPane().add(jnashville);
        jnashville.setBounds(200, 390, 100, 30);

        jnofilter.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jnofilter.setForeground(new java.awt.Color(255, 0, 0));
        jnofilter.setText("No Filter");
        jnofilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jnofilterActionPerformed(evt);
            }
        });
        getContentPane().add(jnofilter);
        jnofilter.setBounds(340, 390, 100, 30);

        jwalden.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jwalden.setForeground(new java.awt.Color(255, 0, 0));
        jwalden.setText("Walden");
        jwalden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jwaldenActionPerformed(evt);
            }
        });
        getContentPane().add(jwalden);
        jwalden.setBounds(200, 350, 100, 30);

        photolb.setText("jLabel4");
        getContentPane().add(photolb);
        photolb.setBounds(20, 30, 38, 16);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
//        get caption get photo
//check if empty
//else
        //unirest send post request with caption photo username on resource UserAddPost

        String photo = jphoto.getText();
        String caption = jcaption.getText();
        if (caption.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "All fieds are required.");
        } else if (f == null) {
            JOptionPane.showMessageDialog(rootPane, "All fieds are required.");
        } else {
            try {
                HttpResponse<String> res = Unirest.post(Global.ipAddress + "useraddpost")
                        .queryString("username", user)
                        .queryString("caption", caption)
                        .field("photo", f)
                        .asString();
                if (res.getStatus() == 200) {
                    String response = res.getBody();
                    System.out.println("response is---->" + response);
                    if (response.equals("SUCCESS")) {
                        JOptionPane.showMessageDialog(this, "Add Post successfully!");

                    } else {
                        JOptionPane.showMessageDialog(this, "Add Post Fails! /n An Error Occured ");
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int ans = chooser.showOpenDialog(this);
        if (ans == JFileChooser.APPROVE_OPTION) {
            f = chooser.getSelectedFile();
            try {
                //-------- step2
                img = ImageIO.read(f);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            ImageIcon icon = new ImageIcon(f.getPath());
            Image resizedImage = icon.getImage().getScaledInstance(jphoto.getWidth(), jphoto.getHeight(), Image.SCALE_AREA_AVERAGING);
            jphoto.setIcon(new ImageIcon(resizedImage));

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jgrayscaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jgrayscaleActionPerformed
        new Thread(new Runnable() {
            public void run() {
                GrayscaleFilter obj = new GrayscaleFilter();
                BufferedImage grayimg = obj.filter(img);
                resizedImage = grayimg.getScaledInstance(jphoto.getWidth(), jphoto.getHeight(), Image.SCALE_SMOOTH);
                changedimg = imageToBufferedImage(resizedImage);
                jphoto.setIcon(new ImageIcon(changedimg));
                repaint();
            }
        }).start();        // TODO add your handling code here:
    }//GEN-LAST:event_jgrayscaleActionPerformed

    private void jblurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jblurActionPerformed
        new Thread(new Runnable() {
            public void run() {
                BlurFilter obj = new BlurFilter();
                BufferedImage grayimg = obj.filter(img);
                resizedImage = grayimg.getScaledInstance(jphoto.getWidth(), jphoto.getHeight(), Image.SCALE_SMOOTH);
                changedimg = imageToBufferedImage(resizedImage);
                jphoto.setIcon(new ImageIcon(changedimg));
                repaint();
            }
        }).start();        // TODO add your handling code here:
    }//GEN-LAST:event_jblurActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        int ans = chooser.showSaveDialog(this);
        if (ans == JFileChooser.APPROVE_OPTION) {
            f = chooser.getSelectedFile();
            try {
                ImageIO.write(changedimg, "jpg", f);
                JOptionPane.showMessageDialog(this, "File saved successfully !");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jbrighterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbrighterActionPerformed
        new Thread(new Runnable() {
            public void run() {
                BrighterFilter obj = new BrighterFilter();
                BufferedImage grayimg = obj.filter(img);
                resizedImage = grayimg.getScaledInstance(jphoto.getWidth(), jphoto.getHeight(), Image.SCALE_SMOOTH);
                changedimg = imageToBufferedImage(resizedImage);
                jphoto.setIcon(new ImageIcon(changedimg));
                repaint();
            }
        }).start();          // TODO add your handling code here:
    }//GEN-LAST:event_jbrighterActionPerformed

    private void jdarkerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jdarkerActionPerformed
        new Thread(new Runnable() {
            public void run() {
                DarkerFilter obj = new DarkerFilter();
                BufferedImage grayimg = obj.filter(img);
                resizedImage = grayimg.getScaledInstance(jphoto.getWidth(), jphoto.getHeight(), Image.SCALE_SMOOTH);
                changedimg = imageToBufferedImage(resizedImage);
                jphoto.setIcon(new ImageIcon(changedimg));
                repaint();
            }
        }).start();          // TODO add your handling code here:
    }//GEN-LAST:event_jdarkerActionPerformed

    private void jhefeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jhefeActionPerformed
        new Thread(new Runnable() {
            public void run() {
                HefeFilter obj = new HefeFilter();
                BufferedImage grayimg = obj.filter(img);
                resizedImage = grayimg.getScaledInstance(jphoto.getWidth(), jphoto.getHeight(), Image.SCALE_SMOOTH);
                changedimg = imageToBufferedImage(resizedImage);
                jphoto.setIcon(new ImageIcon(changedimg));
                repaint();
            }
        }).start();          // TODO add your handling code here:
    }//GEN-LAST:event_jhefeActionPerformed

    private void jlofiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jlofiActionPerformed
        new Thread(new Runnable() {
            public void run() {
                LoFiFilter obj = new LoFiFilter();
                BufferedImage grayimg = obj.filter(img);
                resizedImage = grayimg.getScaledInstance(jphoto.getWidth(), jphoto.getHeight(), Image.SCALE_SMOOTH);
                changedimg = imageToBufferedImage(resizedImage);
                jphoto.setIcon(new ImageIcon(changedimg));
                repaint();
            }
        }).start();          // TODO add your handling code here:
    }//GEN-LAST:event_jlofiActionPerformed

    private void jnashvilleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jnashvilleActionPerformed
        new Thread(new Runnable() {
            public void run() {
                NashvilleFilter obj = new NashvilleFilter();
                BufferedImage grayimg = obj.filter(img);
                resizedImage = grayimg.getScaledInstance(jphoto.getWidth(), jphoto.getHeight(), Image.SCALE_SMOOTH);
                changedimg = imageToBufferedImage(resizedImage);
                jphoto.setIcon(new ImageIcon(changedimg));
                repaint();
            }
        }).start();          // TODO add your handling code here:
    }//GEN-LAST:event_jnashvilleActionPerformed

    private void jwaldenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jwaldenActionPerformed
        new Thread(new Runnable() {
            public void run() {
                WaldenFilter obj = new WaldenFilter();
                BufferedImage grayimg = obj.filter(img);
                resizedImage = grayimg.getScaledInstance(jphoto.getWidth(), jphoto.getHeight(), Image.SCALE_SMOOTH);
                changedimg = imageToBufferedImage(resizedImage);
                jphoto.setIcon(new ImageIcon(changedimg));
                repaint();
            }
        }).start();          // TODO add your handling code here:
    }//GEN-LAST:event_jwaldenActionPerformed

    private void jnofilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jnofilterActionPerformed
        new Thread(new Runnable() {
            public void run() {
                NoFilter obj = new NoFilter();
                BufferedImage grayimg = obj.filter(img);
                resizedImage = grayimg.getScaledInstance(jphoto.getWidth(), jphoto.getHeight(), Image.SCALE_SMOOTH);
                changedimg = imageToBufferedImage(resizedImage);
                jphoto.setIcon(new ImageIcon(changedimg));
                repaint();
            }
        }).start();          // TODO add your handling code here:
    }//GEN-LAST:event_jnofilterActionPerformed
    public static BufferedImage imageToBufferedImage(Image im) {
        BufferedImage bi = new BufferedImage(im.getWidth(null), im.getHeight(null), BufferedImage.TYPE_INT_RGB);
        Graphics bg = bi.getGraphics();
        bg.drawImage(im, 0, 0, null);
        bg.dispose();
        return bi;
    }

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
            java.util.logging.Logger.getLogger(UserAddPost.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserAddPost.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserAddPost.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserAddPost.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserAddPost("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jblur;
    private javax.swing.JButton jbrighter;
    private javax.swing.JTextArea jcaption;
    private javax.swing.JButton jdarker;
    private javax.swing.JButton jgrayscale;
    private javax.swing.JButton jhefe;
    private javax.swing.JButton jlofi;
    private javax.swing.JButton jnashville;
    private javax.swing.JButton jnofilter;
    private javax.swing.JLabel jphoto;
    private javax.swing.JButton jwalden;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel photolb;
    // End of variables declaration//GEN-END:variables
}
