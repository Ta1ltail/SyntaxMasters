package com.mycompany.jframe_syntaxmasters;

import javax.sound.sampled.FloatControl;

public class JFrame_Settings extends javax.swing.JFrame {

    private FloatControl volumeControl;
    private long clipPosition = 0;

    public JFrame_Settings() {
        this.setUndecorated(true);
        initComponents();

        ButtonMusic.setSelected(JFrame_HomeMenu.isMusicEnabled);
        ButtonMusic.addActionListener(e -> toggleMusic());

        MusicSlider.addChangeListener(e -> adjustMusicVolume());

        ButtonSound.setSelected(JFrame_HomeMenu.isButtonSoundEnabled);
        ButtonSound.addActionListener(e -> toggleButtonSound());
    }

    private void pauseBackgroundMusic() {
        if (JFrame_HomeMenu.backgroundMusicClip != null && JFrame_HomeMenu.backgroundMusicClip.isRunning()) {
            clipPosition = JFrame_HomeMenu.backgroundMusicClip.getFramePosition();
            JFrame_HomeMenu.backgroundMusicClip.stop();
            JFrame_HomeMenu.repeatMusic = false;
        }
    }

    private void toggleButtonSound() {
        JFrame_HomeMenu.isButtonSoundEnabled = ButtonSound.isSelected();
    }

    private void adjustMusicVolume() {
        if (JFrame_HomeMenu.backgroundMusicClip != null) {
            try {
                if (volumeControl == null) {
                    volumeControl = (FloatControl) JFrame_HomeMenu.backgroundMusicClip.getControl(FloatControl.Type.MASTER_GAIN);
                }

                float sliderValue = MusicSlider.getValue();

                float minVolume = -50.0f;
                float maxVolume = 0.0f;
                float newVolume = minVolume + (sliderValue / 100.0f) * (maxVolume - minVolume);

                float actualMinVolume = volumeControl.getMinimum();
                float actualMaxVolume = volumeControl.getMaximum();
                newVolume = Math.max(actualMinVolume, Math.min(newVolume, actualMaxVolume));

                volumeControl.setValue(newVolume);

            } catch (IllegalArgumentException e) {
                System.err.println("Volume control adjustment failed: " + e.getMessage());
            }
        }
    }

    private void toggleMusic() {
        JFrame_HomeMenu.isMusicEnabled = ButtonMusic.isSelected();

        if (ButtonMusic.isSelected()) {
            if (JFrame_HomeMenu.backgroundMusicClip != null && !JFrame_HomeMenu.backgroundMusicClip.isRunning()) {
                if (clipPosition > 0) {
                    JFrame_HomeMenu.backgroundMusicClip.setFramePosition((int) clipPosition);
                }
                JFrame_HomeMenu.repeatMusic = true;
                JFrame_HomeMenu.backgroundMusicClip.start();
            }
        } else {
            pauseBackgroundMusic();
        }
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        MusicLabel = new javax.swing.JLabel();
        SoundLabel = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        MusicSlider = new javax.swing.JSlider();
        SoundSlider = new javax.swing.JSlider();
        ButtonMusic = new javax.swing.JRadioButton();
        ButtonSound = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 0, 255));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButton1.setText("Exit");
        jButton1.addActionListener(evt -> jButton1ActionPerformed(evt));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(539, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("OCR A Extended", 0, 24));
        jLabel1.setForeground(new java.awt.Color(0, 255, 0));
        jLabel1.setText("Language ");

        MusicLabel.setFont(new java.awt.Font("OCR A Extended", 0, 24));
        MusicLabel.setForeground(new java.awt.Color(0, 255, 0));
        MusicLabel.setText("Music");

        SoundLabel.setFont(new java.awt.Font("OCR A Extended", 0, 24));
        SoundLabel.setForeground(new java.awt.Color(0, 255, 0));
        SoundLabel.setText("Sound Effect");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "English", "Tagalog" }));

        MusicSlider.setValue(100);
        SoundSlider.setValue(100);

        ButtonMusic.setSelected(true);
        ButtonMusic.addActionListener(evt -> ButtonMusicActionPerformed(evt));

        ButtonSound.setSelected(true);
        ButtonSound.addActionListener(evt -> ButtonSoundActionPerformed(evt));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(MusicLabel))
                        .addGap(79, 79, 79)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(ButtonMusic)
                                .addGap(18, 18, 18)
                                .addComponent(MusicSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(SoundLabel)
                        .addGap(34, 34, 34)
                        .addComponent(ButtonSound)
                        .addGap(18, 18, 18)
                        .addComponent(SoundSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(145, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(ButtonMusic, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(MusicLabel))
                    .addComponent(MusicSlider, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ButtonSound, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(SoundSlider, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SoundLabel))
                .addContainerGap(86, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        dispose();
    }

    private void ButtonMusicActionPerformed(java.awt.event.ActionEvent evt) {
        toggleMusic();
    }

    private void ButtonSoundActionPerformed(java.awt.event.ActionEvent evt) {
        toggleButtonSound();
    }

    private javax.swing.JRadioButton ButtonMusic;
    private javax.swing.JRadioButton ButtonSound;
    private javax.swing.JLabel MusicLabel;
    private javax.swing.JSlider MusicSlider;
    private javax.swing.JLabel SoundLabel;
    private javax.swing.JSlider SoundSlider;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
}