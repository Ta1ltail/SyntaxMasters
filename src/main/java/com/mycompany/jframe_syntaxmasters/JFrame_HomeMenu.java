package com.mycompany.jframe_syntaxmasters;

import java.awt.GraphicsConfiguration;
import java.net.URISyntaxException;
import javax.swing.JFrame;
import javax.sound.sampled.Clip;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.AudioInputStream;
import java.net.URL;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;

public class JFrame_HomeMenu extends javax.swing.JFrame {

    public static Clip backgroundMusicClip;
    public static boolean repeatMusic = true;
    public static boolean isMusicEnabled = true;
    public static boolean isButtonSoundEnabled = true;

    public JFrame_HomeMenu(GraphicsConfiguration gc) throws URISyntaxException {
        this.setUndecorated(true);
        initComponents();

        if (backgroundMusicClip == null || !backgroundMusicClip.isRunning()) {
            playBackgroundMusic();
        }
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/output-onlinegiftools.gif")));
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 80, 460, 150));

        jButton1.setBackground(new java.awt.Color(153, 153, 255));
        jButton1.setFont(new java.awt.Font("OCR A Extended", 0, 24));
        jButton1.setForeground(new java.awt.Color(204, 0, 0));
        jButton1.setText("EXIT");
        jButton1.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(255, 51, 51), null), new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(51, 51, 255), new java.awt.Color(153, 0, 204), new java.awt.Color(204, 0, 102), new java.awt.Color(255, 0, 0))));
        jButton1.addActionListener(evt -> jButton1ActionPerformed(evt));
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 320, 220, 30));

        jButton2.setBackground(new java.awt.Color(153, 153, 255));
        jButton2.setFont(new java.awt.Font("OCR A Extended", 0, 24));
        jButton2.setForeground(new java.awt.Color(51, 255, 51));
        jButton2.setText("START");
        jButton2.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(255, 51, 51), null), new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(51, 51, 255), new java.awt.Color(153, 0, 204), new java.awt.Color(204, 0, 102), new java.awt.Color(255, 0, 0))));
        jButton2.addActionListener(evt -> jButton2ActionPerformed(evt));
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 220, 220, 30));

        jButton3.setBackground(new java.awt.Color(153, 153, 255));
        jButton3.setFont(new java.awt.Font("OCR A Extended", 0, 24));
        jButton3.setForeground(new java.awt.Color(102, 102, 255));
        jButton3.setText("SETTINGS");
        jButton3.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(255, 51, 51), null), new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(51, 51, 255), new java.awt.Color(153, 0, 204), new java.awt.Color(204, 0, 102), new java.awt.Color(255, 0, 0))));
        jButton3.addActionListener(evt -> jButton3ActionPerformed(evt));
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 270, 220, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/vecteezy_simple-gaming-screen-panel-and-overlay-design-with-offline_20919234 (3) (1).jpg")));
        jLabel2.setText("");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, 580, 350));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/c59ad2bd4ad2fbacd04017debc679ddb-ezgif.com-optimize.gif")));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -2, 860, 500));

        pack();
        setLocationRelativeTo(null);
    }

    private void playBackgroundMusic() {
        try {
            if (backgroundMusicClip == null || !backgroundMusicClip.isRunning()) {
                URL musicURL = getClass().getResource("/Sound/2-cherry-cute-bgm-271158.wav");
                if (musicURL != null) {
                    AudioInputStream audioStream = AudioSystem.getAudioInputStream(musicURL);
                    backgroundMusicClip = AudioSystem.getClip();
                    backgroundMusicClip.open(audioStream);

                    backgroundMusicClip.addLineListener(new LineListener() {
                        @Override
                        public void update(LineEvent event) {
                            if (event.getType() == LineEvent.Type.STOP && repeatMusic) {
                                if (!backgroundMusicClip.isRunning()) {
                                    backgroundMusicClip.setFramePosition(0);
                                    backgroundMusicClip.start();
                                }
                            }
                        }
                    });

                    if (isMusicEnabled) {
                        backgroundMusicClip.start();
                    }
                } else {
                    System.out.println("Music file not found.");
                }
            }
        } catch (Exception e) {
            System.err.println("Error playing background music.");
            e.printStackTrace();
        }
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        JFrame_HomePage home_Page = new JFrame_HomePage();

        home_Page.setUndecorated(true);
        home_Page.setExtendedState(JFrame.MAXIMIZED_BOTH);
        home_Page.setVisible(true);
        dispose();
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        if (backgroundMusicClip != null) {
            backgroundMusicClip.stop();
            backgroundMusicClip.close();
        }
        System.exit(0);
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        JFrame_Settings settings = new JFrame_Settings();
        settings.setVisible(true);
    }

    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
}